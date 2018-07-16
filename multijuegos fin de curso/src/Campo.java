
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;


public class Campo extends Canvas {
	private int ancho,alto,posY,posX,intervaloTimer=8,estado=0,pu1=0,pu2=0,maquina,finjuego=0;//1 jugar maquina 2 jugar 1 vs 1 ;
	private int [] arrayTeclas;
	private Pelota pelota;
	private Pala p1,p2;
	private Timer timer,tim;
	Graphics pantallaVirtual;
	private String fin;
	private Image buffer;
private MainPong m;
private int pausar=0,encima=0;
private PausaInvaders pausa,finj;
	Campo(MainPong a)
	{	
		finj=new PausaInvaders(1);
		pausa=new PausaInvaders(0);
		maquina=0;
		m=a;
		arrayTeclas = new int [4];
		ancho=800;
		alto=400;
		posX=0;
		posY=0;
		p1=new Pala();
		p2=new Pala();
		p2.setPosX(750);
		pelota=new Pelota(a);
		setBounds(posX, posY, ancho, alto);
		
		tim=new Timer(8, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(maquina==1 && pausar==0 && finjuego==0)
					p1.moversolo(pelota.getPosY());	
				repaint();
				if(pausar==0 && finjuego==0)
				 m.setBounds(0,0,800,400);
			}
		});
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(maquina==2)
					if (e.getKeyCode()=='w' || e.getKeyCode()=='W' )
						arrayTeclas[0]=0;
				
				if(maquina==2)
					if (e.getKeyCode()=='s' || e.getKeyCode()=='S' )
						arrayTeclas[1]=0;
					
				if (e.getKeyCode()==KeyEvent.VK_UP)
					arrayTeclas[2]=0;
					
				if (e.getKeyCode()==KeyEvent.VK_DOWN)
					arrayTeclas[3]=0;
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()=='w' || e.getKeyCode()=='W' )
					arrayTeclas[0]=1;
					
				if (e.getKeyCode()=='s' || e.getKeyCode()=='S' )
					arrayTeclas[1]=1;
					
				if (e.getKeyCode()==KeyEvent.VK_UP)
					arrayTeclas[2]=1;
					
				if (e.getKeyCode()==KeyEvent.VK_DOWN)
					arrayTeclas[3]=1;
				if (e.getKeyCode()=='p' || e.getKeyCode()=='P' )
					if(!(estado==0) && !(estado==1) && !(estado==4))
					pausar=1;
			}
		});
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if(pausar==1 || finjuego==1)
				{
					encima=0;
					if(pausar==1)
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
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(pausar==0)
				{
					if (estado==5)
					{
						if(e.getX()>=352 && e.getX()<=434 && e.getY()>=213 && e.getY()<=220)
						{
							finjuego=0;
							estado=0;
							pu1=0;
							pu2=0;
							
						}
					}
					if (estado==1)
					{
						estado=2;
						pelota.setMovimiento(1);
					}
					if(estado==0)
					{
						if(e.getX()>=349 && e.getX()<=480 && e.getY()>=238 && e.getY()<=251)
						estado=4;
						if(e.getX()>=379 && e.getX()<=441 && e.getY()>=187 && e.getY()<=197)
						{
						maquina=2;
						estado=1;
						}
					}
					if(estado==4)
					{
						
						if(e.getX()>=350 && e.getX()<=373 && e.getY()>=191 && e.getY()<=199)
						{
							p1.setDificultad(10);
							estado=1;
							maquina=1;
						}
						if(e.getX()>=350 && e.getX()<=385 && e.getY()>=212 && e.getY()<=218)
						{
							estado=1;
							p1.setDificultad(20);
							maquina=1;
						}
						if(e.getX()>=351 && e.getX()<=381 && e.getY()>=230 && e.getY()<=239)
						{
							estado=1;
							p1.setDificultad(30);
							maquina=1;
						}
					}
				}
				else
				{
					if(pausar==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							
							//continuarPartida();
							pausar=0;
						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						
						System.exit(ABORT);
								
					}
					if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
					{
						
						//alMenu=1;
								
					}
					if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
					{
						
						if(finjuego==1)
							finjuego=0;
						reiniciar();
						pausar=0;
					}
				}
					
				}
				
					
			});
	
			timer=new Timer(intervaloTimer,new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(pausar==0  && finjuego==0)
					{
						finjuego();
						if (pu1==1)
						{
							
							finjuego=1;
						}
						if(pu2==1)
						{
							
							finjuego=2;
						}
						pelota.mover(p1.getPosY(),p1.getPosX(),p2.getPosY(),p2.getPosX());
						teclasMover();
						repaint();
					if(intervaloTimer>=4)
						if(pelota.acelerar()==true)
						{
							intervaloTimer--;
							timer.setDelay(intervaloTimer);
							timer.start();
						}
						
						if(pelota.getPosX()-10<=0)
						{
							
							estado=1;
							pelota.setPosX(300);
							pelota.setPosY(150);
							pelota.setMovimiento(0);
							pu1++;
						}
						else if ((pelota.getPosX()+10) >= m.getWidth()-20)
						{
							
							pelota.setPosX(300);
							pelota.setPosY(150);
							pelota.setMovimiento(0);
							estado=1;
							pu2++;
						}
					}
				}
			
			});
		timer.start();
		tim.start();
	
	
	}
	public void reiniciar()
	{
		finj=new PausaInvaders(1);
		pausa=new PausaInvaders(0);
		maquina=0;
		
		arrayTeclas = new int [4];
		ancho=800;
		alto=400;
		posX=0;
		posY=0;
		p1=new Pala();
		p2=new Pala();
		p2.setPosX(750);
		pelota=new Pelota(m);
		setBounds(posX, posY, ancho, alto);
		estado=0;
		m.reiniciar();
		/*pausar=0;
		pu1=0;
		pu2=0;
		estado=0;*/
	}
	public void teclasMover()
	{
		if(arrayTeclas[0]==1)
			if(p1.getPosY()>=0)
			p1.mover('w');
		if(arrayTeclas[2]==1)
			if(p2.getPosY()>=0)
			p2.mover('w');
		if(arrayTeclas[1]==1)
			if(p1.getPosY()+70<=350)
				p1.mover('s');
		if(arrayTeclas[3]==1)
			if(p2.getPosY()+70<=350)
				p2.mover('s');
	}
	public void paint(Graphics g)
	{
		BufferedImage imagen= new BufferedImage(getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
		setBackground(Color.darkGray);
		g.setColor(Color.white);
		if(pausar==0)
		{
			if(estado==0)
			{
				imagen.getGraphics().drawString("jugar 1 vs 1", 380, 200);
				imagen.getGraphics().drawString("jugar contra la maquina", 350, 250);
			}
			if (estado==1)
			{
				imagen.getGraphics().drawString("haga click para continuar con el partido", 300, 150);
				imagen.getGraphics().drawString(pu2 + " : " + pu1 , 400, 200);
			}
			if (estado==2)
			{
				imagen.getGraphics().drawString(pu2 + " : " + pu1 , 350, 20);
				imagen.getGraphics().drawLine(380, 50, 380, 300);
				pelota.paint(imagen.getGraphics());
				p1.paint(imagen.getGraphics());
				p2.paint(imagen.getGraphics());
			}
			if(estado==4)
			{
				
				imagen.getGraphics().drawString("Selecciona dificultad", 300, 150);
				imagen.getGraphics().drawString("facil", 350, 200);
				imagen.getGraphics().drawString("medio", 350, 220);
				imagen.getGraphics().drawString("Dificil", 350, 240);
			}
			if (finjuego==1 || finjuego==2 && estado==5)
			{
				finj.paint(imagen.getGraphics(),0);
				m.setBounds(0, 0, 1000, 800);
			}
			
			
		}
	  if (pausar==1)
	  {
		  m.setBounds(0,0,1000,800);
		  pausa.paint(imagen.getGraphics(),encima);
	  }
	  
	 
		g.drawImage(imagen,0,0,this);
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void finjuego()
	{
		if (finjuego==1 || finjuego==2)
		{
			//timer.stop();
			estado=5;
		}
		
	}
	
}
