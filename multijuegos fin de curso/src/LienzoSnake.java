import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
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


public class LienzoSnake extends Canvas
{
	public int getSalir() {
		return salir;
	}
	public void setSalir(int salir) {
		this.salir = salir;
	}
	private int posX=300,posY=100,contp=1,reiniciar=0,salir=0,paus=0;
	private Pieza p,piezaSerpiente;
	private ArrayList<Pieza> arrayPiezas;
	private int muerto=0,encima=0;//0 vivo, 1 muerto
	private int [] arrayTeclas;
	private Timer tim,timi,ti;
	private Comida com;
	private ArrayList<Rectangle>arrayRect=new ArrayList<Rectangle>();
	private Puntos punt;
	private PausaInvaders pausa;
	public void parotimers()
	{
		ti.stop();
		timi.stop();
	}
	LienzoSnake()
	{
		pausa=new PausaInvaders(0);
		ti=new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		ti.start();
		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				encima=0;
				if(muerto==1 && paus==0)
				{
					if(e.getX()>=249 && e.getX()<=455 && e.getY()>=296&&e.getY()<=335)
					{
						encima=1;
					}
					if(e.getX()>=252 && e.getX()<=716 && e.getY()>=379&&e.getY()<=418)
					{
						encima=2;
					}
					if(e.getX()>=253 && e.getX()<=411 && e.getY()>=457&&e.getY()<=495)
					{
						encima=3;
					}
				}
				if(muerto==0 && paus==1)
				{
					if(paus==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							encima=1;
						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						
						encima=3;
								
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
				if(muerto==1 && paus==0)
				{
					if(e.getX()>=249 && e.getX()<=455 && e.getY()>=296&&e.getY()<=335)
					{
						if(muerto==1)
							muerto=0;
						
						reiniciar();
					}
					if(e.getX()>=252 && e.getX()<=716 && e.getY()>=379&&e.getY()<=418)
					{
						salir=1;
					}
					if(e.getX()>=253 && e.getX()<=411 && e.getY()>=457&&e.getY()<=495)
					{
						System.exit(ABORT);
					}
				}
				if(muerto==0 && paus==1)
				{
					if(paus==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							timi.start();
							paus=0;
						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						
						System.exit(ABORT);
								
					}
					if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
					{
						
						salir=1;
								
					}
					if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
					{
						paus=0;
						if(muerto==1)
							muerto=0;
						reiniciar();
						
					}
				}
				
			}
			
		});
		punt=new Puntos();
		requestFocus();
		com=new Comida();
		arrayPiezas=new ArrayList<Pieza>();
		arrayTeclas=new int [4];
		piezaSerpiente=new Pieza();
		
		for(int cont=0;cont<10;cont++,posX+=17)
			{
			p=new Pieza();
			p.setPosX(posX);
			arrayPiezas.add(p);
			}
		arrayTeclas[0]=1;
	timi=new Timer(200,new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			requestFocus();
		crearRectangulos();
		if(com.colision(arrayPiezas.get(0).getPosX(),arrayPiezas.get(0).getPosY()))
		{
			com=new Comida();
			piezaSerpiente=new Pieza();
			arrayPiezas.add(piezaSerpiente);
			punt.setPuntos(punt.getPuntos()+9);
		}
		if(!arrayRect.isEmpty())
			if(arrayPiezas.get(0).colisionSerpiente(arrayPiezas))
				muerto=1;
		isMuerto();
		moverSerpiente();	
		colisionParedes();
		repaint();
		
		
		}
	});
	timi.start();

		addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e)
			{
				if (e.getKeyChar()=='p' || e.getKeyChar()=='P')
				{
					paus=1;
					timi.stop();
				}
				if(paus==0)
				{
					if(arrayTeclas[1]==0)
					{
						if(e.getKeyCode()==KeyEvent.VK_LEFT)
						{
							arrayPiezas.get(0).setDirSerp("i");
							contp=1;
							arrayTeclas[0]=1;
							arrayTeclas[1]=0;
							arrayTeclas[2]=0;
							arrayTeclas[3]=0;
						}
					}
					if(arrayTeclas[0]==0)
					{
						if(e.getKeyCode()==KeyEvent.VK_RIGHT)
						{
							arrayPiezas.get(0).setDirSerp("d");
							contp=1;
							arrayTeclas[1]=1;
							arrayTeclas[0]=0;
							arrayTeclas[2]=0;
							arrayTeclas[3]=0;
						}
					}
					if(arrayTeclas[3]==0)
					{
						if(e.getKeyCode()==KeyEvent.VK_UP)
						{
							arrayPiezas.get(0).setDirSerp("ar");
							contp=1;
							arrayTeclas[2]=1;
							arrayTeclas[1]=0;
							arrayTeclas[0]=0;
							arrayTeclas[3]=0;
						}
					}
					if(arrayTeclas[2]==0)
					{
						if(e.getKeyCode()==KeyEvent.VK_DOWN)
						{
							arrayPiezas.get(0).setDirSerp("ab");
							contp=1;
							arrayTeclas[3]=1;
							arrayTeclas[1]=0;
							arrayTeclas[2]=0;
							arrayTeclas[0]=0;
						}
					}
				}
			}
		});
	}
	public void reiniciar()
	{
		reiniciar=1;
		if(reiniciar==1)
		{
			punt.setPuntos(0);
			reiniciar=0;
			arrayPiezas.clear();
			for(int cont=0,posX=300;cont<10;cont++,posX+=17)
			{
				p=new Pieza();
				p.setPosX(posX);
				arrayPiezas.add(p);
			}
			muerto=0;
			punt.setMinutos(0);
			punt.setSegundos(0);
			punt.setMuerto(0);
			com=new Comida();
			timi.start();
			arrayTeclas[0]=1;
			arrayTeclas[1]=0;
			arrayTeclas[2]=0;
			arrayTeclas[3]=0;
			paus=0;
		}
	}
	public void colisionParedes()
	{
		if (arrayPiezas.get(0).getPosX()<=10)
			muerto=1;
		if (arrayPiezas.get(0).getPosX()+15>=960)
			muerto=1;
		if (arrayPiezas.get(0).getPosY()<=40)
			muerto=1;
		if (arrayPiezas.get(0).getPosX()+15>=760)
			muerto=1;
	}
	public void isMuerto()
	{
		if(muerto==1)
		{
			timi.stop();
			punt.setMuerto(1);
		}
	}
	public void moverSerpiente()
	{
		moverPiezas();
		if(arrayTeclas[0]==1)
			arrayPiezas.get(0).mover(0);
		if(arrayTeclas[1]==1)
			arrayPiezas.get(0).mover(1);
		if(arrayTeclas[2]==1)
			arrayPiezas.get(0).mover(2);
		if(arrayTeclas[3]==1)
			arrayPiezas.get(0).mover(3);
		
	}
	public void paint(Graphics g)
	{
		BufferedImage imagen = new BufferedImage (1000, 800,BufferedImage.TYPE_USHORT_555_RGB);
		Pieza p;
		if(paus==0)
		{
		com.paint(imagen.getGraphics());
		for(int cont=0;cont<arrayPiezas.size();cont++)	
		{
			p=arrayPiezas.get(cont);
			p.pintar(imagen.getGraphics());
		}
		punt.pinta(imagen.getGraphics(),encima);
		}
		else
			pausa.paint(imagen.getGraphics(),encima);
		g.drawImage(imagen,0,0,this);
		
	}
	public void moverPiezas()
	{		
			for(int cont=arrayPiezas.size()-1;cont>=1;cont--)
			{
				arrayPiezas.get(cont).setPosX(arrayPiezas.get(cont-1).getPosX());
				arrayPiezas.get(cont).setPosY(arrayPiezas.get(cont-1).getPosY());
			}
		
		
	}
	
	public void update (Graphics g)
	{
		paint(g);
	}
	public void crearRectangulos()
	{
		Rectangle r=new Rectangle();
		arrayRect.clear();
		for(int cont=0;cont<arrayPiezas.size();cont++)
		{
			r.setBounds(arrayPiezas.get(cont).getPosX(), arrayPiezas.get(cont).getPosY(), 17, 17);
			arrayRect.add(r);
		}
	}
}
