import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class Bala {
	private int alto,ancho,posX,posY,eliminar,tipe,explosion,puntos=0,exTerminada=0;//eliminar 0 no,1 si
	private Image imagen,imagenMalo;
	private Timer timer;
	Bala(int posXNave,int posYNave,int tipo)//tipo 0 balas nave, 1 balas malo
	{
		tipe=tipo;
		timer=new Timer(2,new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			if(tipe==0)
			{
				moverBala();
				if(posY<=50)
				timer.stop();
			}
			if(tipe==1)
				if(posY>=900)
					timer.stop();
			}
		});
		if(tipo==1)
			if(!timer.isRunning())
				if(tipe==0)
					timer.start();
		
		imagen=Toolkit.getDefaultToolkit().getImage("space/bala.png");
		imagenMalo=Toolkit.getDefaultToolkit().getImage("space/balaMalo.png");
		alto=10;
		ancho=3;
		posX=posXNave;
		posY=posYNave-5;
		eliminar=0;
		explosion=0;
	}
	
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public void pintar(Graphics g)
	{
		if(explosion==0)
		{
			if(tipe==0)
			g.drawImage(imagen, posX,posY,ancho,alto,null);
			if(tipe==1)
				g.drawImage(imagenMalo, posX,posY,ancho,10,null);
		}
	
	}
	public int getExTerminada() {
		return exTerminada;
	}
	public void setExTerminada(int exTerminada) {
		this.exTerminada = exTerminada;
	}
	
	public void moverBala()
	{
		if(tipe==0)
		{
			if(posY>=0)
				posY--;
		}
		if(tipe==1)
		{
			if(posY<=900)
			{
				posY+=2;
				
			}
		}
	}

	public void timerBala(int i)
	{
		if (i==1)
			timer.start();
		else
			timer.stop();
	}
	public boolean nuevaBala()//detecta colsiion contra los marcianos
	{
		if(tipe==0)
		{				
					if(posY <=50)//controlar que la bala sale por arriba de la pantalla
					{
						//eliminar=0;
						return true;
					}
		}
		else
		{
		
				if(posY >=600)//controlar que la bala sale por arriba de la pantalla
				{
					
					return true;
				}
			
		}
			return false;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	

	public Image getImagenMalo() {
		return imagenMalo;
	}
	public void setImagenMalo(Image imagenMalo) {
		this.imagenMalo = imagenMalo;
	}
	public int getEliminar() {
		return eliminar;
	}
}
