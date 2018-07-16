import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class MaloTiros {
private Image imagen;
public int getMuerto() {
	return muerto;
}
public void setMuerto(int muerto) {
	this.muerto = muerto;
}
private int ancho=50,alto=70,posY=400,posX,contMuerto=0,muerto=0;
private Timer tim,timerMuerto;
	MaloTiros(ArrayList<MaloTiros> a)
	{
		posX=(int)(Math.random()*600+50);
		for(MaloTiros m:a)
		{
			//if(m.getPosX()==posX );
				//posX=m.getPosX()-50;
		}
		imagen=Toolkit.getDefaultToolkit().getImage("imagenesPistola/malo.png");
		tim=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (posY>=320)
					posY-=10;
				
			}
		});
		timerMuerto=new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contMuerto++;
				if(contMuerto>=30)
					muerto=1;
				System.out.println(contMuerto);
			}
		});
		tim.start();
		timerMuerto.start();
	}
	public int getPosY() {
		return posY;
	}
	public void setPosY(int posY) {
		this.posY = posY;
	}
	public int getPosX() {
		return posX;
	}
	public void setPosX(int posX) {
		this.posX = posX;
	}
	public void paint(Graphics g)
	{
		if(posY<320)
		g.drawImage(imagen,posX,posY,100,100,null);
	}
	public void activaTimer()
	{
		tim.start();
	}
}