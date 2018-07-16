import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.Timer;


public class LienzoTiros extends Canvas {

private Timer tim;
private MainTiros l;
private Image fondo,image;
private Pistola pistola;
private Reloj r;
private Cursor cursor;
private int dispara=0;
private ArrayList<MaloTiros> arrayMalo = new ArrayList<MaloTiros>();
private Timer timer,timi;
private int ratonPosX=0,ratonPosY=0,pausaSi=0,encima=0,finJuego=0,alMenu=0;
private PausaInvaders pausa,fin;


	LienzoTiros(MainTiros m)
	{
		fin=new PausaInvaders(1);
		l=m;
		pausa=new PausaInvaders(0);
		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
				if(pausaSi==0 && finJuego==0)
				{
					if (e.getKeyChar()=='p' || e.getKeyChar()=='P')
					{
						pausaSi=1;
						l.setBounds(0, 0, 1000, 800);
						r.paroTimer();
					}
				}
				
			}
		});
			
			
			
		
		timer= new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pausaSi==0)
				{
				MaloTiros m=new MaloTiros(arrayMalo);
				arrayMalo.add(m);
				}
			}
		});
		timi=new Timer(50,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				requestFocus();
				if (pausaSi==0)
				desapareceEnemigo();
			}
		});
		timi.start();
		timer.start();
		Point hotSpot = new Point(0, 0);
		image=Toolkit.getDefaultToolkit().getImage("imagenesPistola/cursor.png");
		Cursor cursor =  Toolkit.getDefaultToolkit().createCustomCursor(image, hotSpot, "un_nombre");
		setCursor(cursor);
		pistola=new Pistola();
		r=new Reloj();
		fondo=Toolkit.getDefaultToolkit().getImage("imagenesPistola/fondo.png");
		tim=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (pausaSi==0 && finJuego==0)
				dispara();
				
				finJuego();
				repaint();
			}
		});
		tim.start();
		addMouseListener(new MouseAdapter() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				dispara=0;
				
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				if(pausaSi==0 && finJuego==0)
				{
					dispara=1;
					desapareceEnemigo();
					pistola.activaTimer();
					comprobarMuerte();
				}
				
			}
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(pausaSi==1 || finJuego==1)
				{
					
					if(pausaSi==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							l.setBounds(0, 0, 800, 600);
							pausaSi=0;
							r.activaTimer();						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						
						System.exit(ABORT);
								
					}
					if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
					{
						
						alMenu=1;
								
					}
					if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
					{
						
						if(finJuego==1)
							finJuego=0;
						reiniciarPartida();
						
					}
				}
			}
		}); 
		
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				pistola.setPosX(e.getX());
				ratonPosX=e.getX();
				ratonPosY=e.getY();
				if(pausaSi==1 || finJuego==1)
				{
					encima=0;
					if(pausaSi==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							encima=1;
							System.out.println(encima);
						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						encima=3;
						System.out.println(encima);
					}
					if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
					{
						encima=4;
					}
					if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
					{
						encima=2;
					}
				}
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				pistola.setPosX(arg0.getX());
			}
		});
		
	}
	public int getAlMenu() {
		return alMenu;
	}
	public void setAlMenu(int alMenu) {
		this.alMenu = alMenu;
	}
	public void comprobarMuerte()
	{
		for(int cont=0;cont<arrayMalo.size();cont++)
		{
			if(ratonPosX>=arrayMalo.get(cont).getPosX() && ratonPosX<=arrayMalo.get(cont).getPosX()+50 && ratonPosY>=arrayMalo.get(cont).getPosY() && ratonPosY<=arrayMalo.get(cont).getPosY()+70)
			{
				arrayMalo.remove(cont);
				r.setPuntos(r.getPuntos()+10);
				r.setPunt("puntos: "+r.getPuntos());
				
			}
		}
	}
	public void parotimers()
	{
		tim.stop();
		timer.stop();
		timi.stop();
	}
	public void reiniciarPartida()
	{
		if (pausaSi==1)
		{
			l.setBounds(0, 0, 800, 600);
			pausaSi=0;
			arrayMalo.removeAll(arrayMalo);
		r=new Reloj();
		}
	}
	public void dispara()
	{
		if(dispara==1)
			System.out.println("ola");
	}
	public void paint(Graphics g)
	{
		
		BufferedImage imagen = new BufferedImage (getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
		if(pausaSi==0 && finJuego==0)
		{
		imagen.getGraphics().drawImage(fondo,0,0,780,600,null);
		for(MaloTiros m:arrayMalo)
			m.paint(imagen.getGraphics());
		pistola.paint(imagen.getGraphics());
		r.paint(imagen.getGraphics());
		}
		if(pausaSi==1)
			pausa.paint(imagen.getGraphics(),encima);
		if (finJuego==1)
			fin.paint(imagen.getGraphics(),encima);
		
		g.drawImage(imagen,0,0,this);
		
	}
	public void update (Graphics g)
	{
		paint(g);
	
	}
	public void desapareceEnemigo()
	{
		for(int cont=0;cont<arrayMalo.size();cont++)
			if (arrayMalo.get(cont).getMuerto()==1)
				arrayMalo.remove(cont);				
	}
	public void finJuego()
	{
		if(r.getCont()<=0)
		{
		finJuego=1;
		l.setBounds(0, 0, 1000, 800);
		}
	}
	
}