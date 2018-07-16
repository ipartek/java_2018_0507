import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Puntos {
private Timer tim;
public int getMinutos() {
	return minutos;
}
public void setMinutos(int minutos) {
	this.minutos = minutos;
}
public int getSegundos() {
	return segundos;
}
public void setSegundos(int segundos) {
	this.segundos = segundos;
}
private int posX,posY,puntos=0,minutos=0,segundos=0,muerto=0;
private String l;
private Font f;
	Puntos()
	{
		f=new Font("Agent Orange",Font.PLAIN,40);
		
		l="Tiempo: "+minutos+":"+"0"+segundos+"";
		posX=20;
		posY=20;
		tim=new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				l="";
				segundos++;
				if(segundos==60)
				{
					minutos++;
					segundos=0;
				}
				if(segundos>=0 && segundos <=9)
					l="Tiempo: "+minutos+":"+"0"+segundos+"";
				else
					l="Tiempo: "+minutos+":"+segundos+"";	
			}
		});
		
		tim.start();
	}
	public int getMuerto() {
		return muerto;
	}
	public void setMuerto(int muerto) {
		this.muerto = muerto;
	}
	public void pinta(Graphics g,int encima)
	{
		
		posX=20;
		posY=20;
		g.setColor(Color.red);
		g.setFont( new Font("Agent Orange",Font.ROMAN_BASELINE,16));
		g.drawString("puntos: "+puntos, posX, posY);
		posX=800;
		posY=20;
		g.drawString(l, posX, posY);
		if(muerto==1)
		{
			g.setFont( new Font("Agent Orange",Font.PLAIN,40));
			g.drawString("FIN DEL JUEGO", 250, 250);
			g.drawLine(250,270 ,650, 270);
			if(encima==0)
			{
			g.drawString("RETRY?", 250, 330);
			g.drawString("MENU DE JUEGOS", 250, 410);
			g.drawString("SALIR", 250, 490);
			}
			if(encima==1)
			{
				
				g.setColor(Color.YELLOW);
				g.drawString("RETRY?", 250, 330);
				g.setColor(Color.RED);
			g.drawString("MENU DE JUEGOS", 250, 410);
			g.drawString("SALIR", 250, 490);
			}
			if(encima==2)
			{				
			g.drawString("RETRY?", 250, 330);			
			g.setColor(Color.YELLOW);
			g.drawString("MENU DE JUEGOS", 250, 410);
			g.setColor(Color.RED);
			g.drawString("SALIR", 250, 490);
			}
			if(encima==3)
			{
			g.drawString("RETRY?", 250, 330);
			g.drawString("MENU DE JUEGOS", 250, 410);
			g.setColor(Color.YELLOW);
			g.drawString("SALIR", 250, 490);
			}
		}
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}
