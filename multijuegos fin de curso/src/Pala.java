import java.awt.Graphics;
public class Pala {

	private int ancho,alto,posY,posX;
	private int dificultad;
	
	

		Pala()
		 {
			ancho=1;
			alto=70;
			posY=50;
			posX=20;
			dificultad=10;
		 }
		
		 public int getPosX() {
				return posX;
			}

			public void setPosX(int posX) {
				this.posX = posX;
			}
		 
		 public void paint(Graphics g)
		 {
			 g.drawRect(posX, posY, ancho, alto);
		 }
		 
		 public void mover(char a)
		 {
			 if (a=='w')
				 posY=posY-1;
			 if (a=='s')
				 posY=posY+1;
		 }

		public int getDificultad() {
			return dificultad;
		}

		public void setDificultad(int dificultad) {
			this.dificultad = dificultad;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}
	public void moversolo(int pelotaPosY)
	{
		
		if (posY<=pelotaPosY-dificultad)
		{
			if(posY+70<=350)
				posY++;
		}
		else
		{
			if(posY>=0)
				posY--;
		}
	}
}
