import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;


public class Pieza {
private int posX,posY=100,alto=15,ancho=15,tip=0;
private Rectangle re;
private Image img;
private int i=0;
private String dirSerp;
	Pieza()
	{
		re=new Rectangle();
		re.setBounds(posX,posY,alto,ancho);
		dirSerp="i";
	}
	public String getDirSerp() {
		return dirSerp;
	}
	public void setDirSerp(String dirSerp) {
		this.dirSerp = dirSerp;
	}
	public int getTip() {
		return tip;
	}
	public void setTip(int tip) {
		this.tip = tip;
	}
	public void mover(int direccion)//0 izquierda, 1 derecha,2 arriba,3 abajo
	{
		if (direccion==0)
			posX-=17;
		if (direccion==1)
			posX+=17;
		if(direccion==2)
			posY-=17;
		if (direccion==3)
			posY+=17;
		
		re.setBounds(posX,posY, ancho+2, alto+2);
	}
	public void pintar(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(posX,posY,alto,ancho);
		
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
	public Boolean colisionSerpiente(ArrayList<Pieza> piezas)
	{
		if(!piezas.isEmpty())
		{
			for(Pieza r:piezas)
			{
				if(r!=this)
					if(r.getPosX()==posX && r.getPosY()==posY)
						return true;
			}
		}
		return false;
	}
	public Rectangle getRe() {
		return re;
	}
	public void setRe(Rectangle re) {
		this.re = re;
	}
}
