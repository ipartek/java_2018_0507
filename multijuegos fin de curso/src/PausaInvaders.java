import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


public class PausaInvaders {
private Font f;
private int tipo;
	PausaInvaders(int i)
	{
		f=new Font("Agent Orange",Font.PLAIN,40);
		tipo=i;
	}
	
	public void paint(Graphics g,int encima)
	{
		if(tipo==0)
		{
		g.setFont(f);
		g.setColor(Color.BLUE);
		if(encima==0)
			{
				g.drawString("Continuar", 250, 100);
				g.drawString("Reiniciar", 250, 200);
				g.drawString("Salir", 250, 300);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if(encima==1)
			{
				g.setColor(Color.YELLOW);
				g.drawString("Continuar", 250, 100);
				g.setColor(Color.BLUE);
				g.drawString("Reiniciar", 250, 200);
				g.drawString("Salir", 250, 300);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if(encima==2)
			{
			
				g.drawString("Continuar", 250, 100);				
				g.setColor(Color.YELLOW);
				g.drawString("Reiniciar", 250, 200);
				g.setColor(Color.BLUE);
				g.drawString("Salir", 250, 300);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if(encima==3)
			{
				
				g.drawString("Continuar", 250, 100);
				
				g.drawString("Reiniciar", 250, 200);
				g.setColor(Color.YELLOW);
				g.drawString("Salir", 250, 300);
				g.setColor(Color.BLUE);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if(encima==4)
			{
			
				g.drawString("Continuar", 250, 100);
				g.drawString("Reiniciar", 250, 200);
				g.drawString("Salir", 250, 300);
				g.setColor(Color.YELLOW);
				g.drawString("Al menu de Juegos", 250, 400);
			}
		}
		if (tipo==1)
		{
			g.setColor(Color.RED);
			if (encima==0)
			{
				g.setFont(f);		
				g.drawString("Fin de juego", 250, 100);
				g.drawLine(250,115,650,115);
				g.drawString("Reiniciar", 250, 200);
				g.setColor(Color.RED);
				g.drawString("Salir", 250, 300);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if (encima==2)
			{
				g.setFont(f);
				
				g.drawString("Fin de juego", 250, 100);
				g.drawLine(250,115,650,115);
				g.setColor(Color.GREEN);
				g.drawString("Reiniciar", 250, 200);
				g.setColor(Color.RED);
				g.drawString("Salir", 250, 300);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if (encima==3)
			{
				g.setFont(f);
				g.drawString("Fin de juego", 250, 100);
				g.drawLine(250,115,650,115);
				g.drawString("Reiniciar", 250, 200);
				g.setColor(Color.GREEN);
				g.drawString("Salir", 250, 300);
				g.setColor(Color.RED);
				g.drawString("Al menu de Juegos", 250, 400);
			}
			if (encima==4)
			{
				g.setFont(f);
				g.drawString("Fin de juego", 250, 100);
				g.drawLine(250,115,650,115);
				g.drawString("Reiniciar", 250, 200);
				g.drawString("Salir", 250, 300);
				g.setColor(Color.GREEN);
				g.drawString("Al menu de Juegos", 250, 400);
			}
		
		}
	}
}
