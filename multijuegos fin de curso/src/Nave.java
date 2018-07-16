import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


public class Nave {
private Image imagen;
private Bala b;
private int alto,ancho,posX,posY,estado,vida=3,xVida,posYVidas,balaSi=0;
	Nave()
	{
		
		estado=0;
		posX=350;
		posY=550;
		xVida=600;
		posYVidas=0;
		alto=40;
		ancho=40;
		imagen=Toolkit.getDefaultToolkit().getImage("space/nave.png");
	}
	public void pintarNave(Graphics g)
	{
		g.drawImage(imagen, posX, posY, alto, ancho, null);		
	}
	public boolean naveMuere(ArrayList <Bala> a)
	{
		for(Bala n : a)
		{
			if(n.getPosY()>=posY&& n.getPosY()<=posY+40 && n.getPosX()>=posX && n.getPosX()<=posX+40)
				return true;
			else
				return false;
		}
				
		return false;
	}
	public void dispararBala()
	{
		
		b=new Bala(posX+20,posY,0);		
		b.timerBala(1);
		balaSi=1;
	}
	public void paroBala()
	{
		b.timerBala(2);
	}
	public int getBalaSi() {
		return balaSi;
	}
	public void setBalaSi(int balaSi) {
		this.balaSi = balaSi;
	}
	public Bala getBalaNave()
	{
		return b;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
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
	public void moverIzquierda()
	{
		if(posX>=50)
		posX=posX-2;
	}
	public void moverDerecha()
	{
		if(posX+40<=780)
		posX=posX+2;
	}
}

