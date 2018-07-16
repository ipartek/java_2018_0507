import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class Pistola {
private Image [] imagenes;
private int posX=300,posY=380,ancho=100,alto=100,contImg=0;
private Timer tim;

	Pistola()
	{
		imagenes=new Image [6];
		for (int cont=0;cont<6;cont++)
			imagenes[cont]=Toolkit.getDefaultToolkit().getImage("imagenesPistola/p"+cont+".png");
				
		tim= new Timer(100,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				contImg++;
				if(contImg==5)
				{
					tim.stop();
					contImg=0;
				}
			}
		});
	}
	public void paint(Graphics g)
	{
		g.drawImage(imagenes[contImg],posX,posY,ancho,alto,null);
	}
	
	public void activaTimer()
	{
		tim.start();
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
}
