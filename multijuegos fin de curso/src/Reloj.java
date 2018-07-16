import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Reloj {
	private int posX=370,posY=65,cont=60,puntos=0;
	private Image c;
	public int getCont() {
		return cont;
	}
	public void setCont(int cont) {
		this.cont = cont;
	}
	public String getTiempo() {
		return tiempo;
	}
	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	private String tiempo,punt;
	private Timer tim;
	
Reloj()
{
	c=Toolkit.getDefaultToolkit().getImage("imagenesPistola/c.png");
	puntos=0;
	tim=new Timer(100, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			cont--;
			tiempo=cont +"";
			
		}
	});
	tiempo=cont +"";
	punt="puntos: "+ puntos ;
	tim.start();
}
	public void paroTimer()
	{
		tim.stop();
	}
	public void activaTimer()
	{
		tim.start();
	}
	public void paint(Graphics g)
	{
		 g.setFont(new Font( "NI7SEG",Font.BOLD,40));
		 g.setColor(Color.black);
		 g.drawImage(c,350 ,0 ,100, 100, null);
		 
		 g.drawString(punt, 20, 50);
		 g.drawString(tiempo, posX, posY);
	}

	public String getPunt() {
		return punt;
	}

	public void setPunt(String punt) {
		this.punt = punt;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
}
