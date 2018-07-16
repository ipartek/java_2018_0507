import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;


public class Comida {
private int posX,posY,alto,ancho;
private Image img;
	Comida()
	{
		posX=((int)(Math.random()*550+50));
		posY=((int)(Math.random()*550+50));
		img=Toolkit.getDefaultToolkit().getImage("ce.png");
		alto=30;
		ancho=30;
	}
	public void paint(Graphics g)
	{
		g.drawImage(img,posX,posY,ancho,alto,null);
	}
	public Boolean colision(int serPosX,int serPosY)
	{
		if(serPosX>=posX && serPosX<=posX+30 && serPosY>=posY && serPosY<=posY+30)
		{
			return true;
		}
		return false;
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
