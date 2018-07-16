import java.awt.Graphics;

import java.awt.Graphics;


public class Pelota {
private int PosX=350,PosY=10,cont=-1,contpeloteo=0,contaux=1,pelotaMoviendo=0;//0quieta,1moviendose; //Posición de la pelota 
	
	private int DirX=PosX % 10 +1; //Dirección de la pelota 
	private int DirY=PosY % 10 +1; //Dirección de la pelota 
	private int radioPelota=10;	 //Radio de la pelota
	private MainPong b;
	private boolean si;
	public Pelota(MainPong a)
	{
		b=a;
		si=false;
	}
	public void mover(int posYPala, int posXPala,int posY2,int posX2) 
	{ 
		if (pelotaMoviendo==1)
			{
					PosX+=DirX; 
					PosY+=DirY; 
					if(contpeloteo%5==1)
					{
						if(contaux==1)
							{
							si=true;
							contaux++;
							}
						else
							si=false;
					}
					//Controlo que cuando toca el borde, cambie de direccion 
					/*if ((PosX-radioPelota) <= 0) 
					DirX*= cont; 
					else if ((PosX+radioPelota) >= b.getWidth()-20)
					DirX*= cont; */
					
					if ((PosY-radioPelota) <= 0) 
					DirY*= cont; 
					else if ((PosY+radioPelota) >= b.getHeight()-50) 
					DirY*= cont; 
					
					if ((PosY-radioPelota) >= posYPala-10 && (PosY-radioPelota) <= posYPala+70 && (PosX+radioPelota)==posXPala+15 ) 
					{
						DirX*= cont;
						contpeloteo++;
						contaux=1;
						
					}
					if ((PosY-radioPelota) >= posY2-10 && (PosY-radioPelota) <= posY2+70 && (PosX+radioPelota)==posX2) 
					{
						DirX*= cont;
						contpeloteo++;
						contaux=1;
					}
				
			}
	} 
	public void setMovimiento(int i)
	{
		pelotaMoviendo=i;
	}
	public int getPosY() {
		return PosY;
	}
	public void setPosY(int posY) {
		PosY = posY;
	}
	public void setPosX(int posX) {
		PosX = posX;
	}
	public int getPeloteo()
	{
		return contpeloteo;
	}
	public void paint(Graphics g) 
	{ 
		g.fillOval(PosX-radioPelota, PosY-radioPelota, radioPelota*2, radioPelota*2);
	}
	public boolean acelerar()
	{
		return si;
	}
	public int getPosX() {
		// TODO Auto-generated method stub
		return PosX;
	}
}
