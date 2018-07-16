import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;


public class MenuSelector extends Canvas {
	private Image img,invaders,pistolas,pong,snake,sgif,igif,tgif,pgif,c;
	private int serpiente=0,inva=0,tiros=0,pon=0;
	private int clickSer=0,clickInva=0,clickTi=0,clickPon=0;
	private Timer tim;
	MenuSelector(){
		img=Toolkit.getDefaultToolkit().getImage("fondo.jpg");		
		invaders=Toolkit.getDefaultToolkit().getImage("i.png");
		pistolas=Toolkit.getDefaultToolkit().getImage("t.png");
		snake=Toolkit.getDefaultToolkit().getImage("s.png");
		pong=Toolkit.getDefaultToolkit().getImage("p.png");
		sgif=Toolkit.getDefaultToolkit().getImage("sgif.gif");
		igif=Toolkit.getDefaultToolkit().getImage("igif.gif");
		c=Toolkit.getDefaultToolkit().getImage("c.png");
		tgif=Toolkit.getDefaultToolkit().getImage("tgif.gif");
		pgif=Toolkit.getDefaultToolkit().getImage("pgif.gif");
		tim=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		tim.start();

		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getX()>=451 && e.getX()<=528 && e.getY()>=151 && e.getY()<=227)
					serpiente=1;
				else
					serpiente=0;
				if(e.getX()>=241 && e.getX()<=331 && e.getY()>=151 && e.getY()<=227)
					inva=1;
				else
					inva=0;
				if(e.getX()>=250 && e.getX()<=328 && e.getY()>=250 && e.getY()<=330)
					tiros=1;
					else
						tiros=0;
				if(e.getX()>=441 && e.getX()<=529 && e.getY()>=251 && e.getY()<=330)
					pon=1;
					else
						pon=0;
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if(e.getX()>=441 && e.getX()<=529 && e.getY()>=251 && e.getY()<=330)
					clickPon=1;
				if(e.getX()>=451 && e.getX()<=528 && e.getY()>=151 && e.getY()<=227)
					clickSer=1;
				if(e.getX()>=241 && e.getX()<=331 && e.getY()>=151 && e.getY()<=227)
					clickInva=1;
				if(e.getX()>=250 && e.getX()<=328 && e.getY()>=250 && e.getY()<=330)
					clickTi=1;
			}
		});
		
	}
	public int getClickSer() {
		return clickSer;
	}
	public void setClickSer(int clickSer) {
		this.clickSer = clickSer;
	}
	public int getClickInva() {
		return clickInva;
	}
	public void setClickInva(int clickInva) {
		this.clickInva = clickInva;
	}
	public int getClickTi() {
		return clickTi;
	}
	public void setClickTi(int clickTi) {
		this.clickTi = clickTi;
	}
	public int getClickPon() {
		return clickPon;
	}
	public void setClickPon(int clickPon) {
		this.clickPon = clickPon;
	}
	public void paint(Graphics g)
	{
		BufferedImage imagen=new BufferedImage(800, 600,BufferedImage.TYPE_INT_RGB);
		imagen.getGraphics().drawImage(img,0,0,800,600,this);
		imagen.getGraphics().drawImage(c,250, 150, 80,80,this);
		imagen.getGraphics().drawImage(c,450, 150, 80,80,this);
		imagen.getGraphics().drawImage(c,250, 250, 80,80,this);
		imagen.getGraphics().drawImage(c,450, 250, 80,80,this);
		imagen.getGraphics().drawImage(pistolas,255,255,70,70,this);
		imagen.getGraphics().drawImage(pong,455,255,70,70,this);
		imagen.getGraphics().drawImage(invaders,255,155,70,70,this);
		imagen.getGraphics().drawImage(snake,455,155,70,70,this);
		if(tiros==1)
			imagen.getGraphics().drawImage(tgif,45,255,200,200,this);
		if(pon==1)
			imagen.getGraphics().drawImage(pgif,535,255,200,200,this);
		if(inva==1)
			imagen.getGraphics().drawImage(igif,45,155,200,200,this);
		if(serpiente==1)
			imagen.getGraphics().drawImage(sgif,535,155,200,200,this);
		imagen.getGraphics().drawString("disparos",250,245);
		imagen.getGraphics().drawString("space invaders",250,140);
		imagen.getGraphics().drawString("snake",450,145);
		imagen.getGraphics().drawString("pong",450,245);
		g.drawImage(imagen,0,0,this);		
	}
	public void update(Graphics g)
	{
		paint(g);
	}
}

