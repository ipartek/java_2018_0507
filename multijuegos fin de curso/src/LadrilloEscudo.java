import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;


public class LadrilloEscudo {
private Image [] ladrillo;
private int posX=10,posY=10,ancho=15,alto=15,vida=3;
	LadrilloEscudo(int tipo,int columnaImagen)//tipo 0: 0 ladrillo normal ,1 tejado,2 interior escudo
	{
		ladrillo=new Image [4];
		
		for(int cont=0;cont<4;cont++)
		{
				if(tipo==0)
				ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/es"+cont+".png");
				if(tipo==1 && columnaImagen==0)
				{
					if(cont==3)
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/estejadoIz.png");
					else
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/es"+cont+".png");
				}
				if(tipo==2 && columnaImagen==1)
				{
					if(cont==3)
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/esInteriorIzq.png");
					else
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/es"+cont+".png");
				}
				if(tipo==2 && columnaImagen==2)
				{
					if(cont==3)
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/esInterioDe.png");
					else
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/es"+cont+".png");
				}
				if(tipo==1 && columnaImagen==3)
				{
					if(cont==3)
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/estejadoDe.png");
					else
						ladrillo[cont]=Toolkit.getDefaultToolkit().getImage("img/es"+cont+".png");
				}
			}
	}
	public boolean colision(Bala balaNave, ArrayList<Bala> a)
	{
		if(balaNave.getPosX()>=posX && balaNave.getPosX()<=posX+15 && balaNave.getPosY()>=posY && balaNave.getPosY()<=posY+10)
		{	
			balaNave.setPosX(-50);
			vida--;
			return true;
		}
		for(Bala b:a)
			if(b.getPosX()>=posX && b.getPosX()<=posX+15 && b.getPosY()>=posY && b.getPosY()<=posY+10)
			{
				a.remove(b);
				vida--;
				
				return true;
			}
		return false;
	}
	public boolean  colisionSinBalaNave( ArrayList<Bala> a)
	{
		for(Bala b:a)
			if(b.getPosX()>=posX && b.getPosX()<=posX+15 && b.getPosY()>=posY && b.getPosY()<=posY+10)
			{
				vida--;
				a.remove(b);
				return true;
			}
		return false;
	}
	public void pintar(Graphics g)
	{
		if(vida>0)
		g.drawImage(ladrillo[vida],posX,posY,ancho,alto,null);
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
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
}

