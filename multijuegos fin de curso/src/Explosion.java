import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Explosion {
private int posX,posY,contImg;
private Image [] arrayImg;
private Timer timer;

	Explosion(int x , int y)
	{
		posX=x;
		posY=y;
		arrayImg=new Image [19];
		for(int cont=0;cont<19;cont++)
		{
			arrayImg[cont]=Toolkit.getDefaultToolkit().getImage("img/e"+cont+".png");
		}
		timer=new Timer(20, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(contImg<18)
					contImg++;	
				if(contImg==19)
				{
					timer.stop();
					contImg=20;
				}
			}
		});
	}
	
	public int getContImg() {
		return contImg;
	}

	public void setContImg(int contImg) {
		this.contImg = contImg;
	}

	public void pintar(Graphics g)
	{
		if(contImg<18)
		g.drawImage(arrayImg[contImg], posX,posY,30,30,null);
	}
	public void activaTimer(int i)
	{
		if (i==1)
			timer.start();
	}
}
