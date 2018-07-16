import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.Timer;


public class LienzoInvaders extends Canvas{
private int pausaSi=0,alto=700,ancho=800,distanciaMarcianos=160,alturaMarciano=50,imagenMarciano=0,a,pasa=0,puntos=0,posXVidas=700,PosYVidas=0,muerte=0,contMil;
private Nave nave,n;
private int eliminarBala=0,contElimMalo,conta,posYladrillo=400,posXladrillo=200,velocidadTimer=400;
private Timer timer,tim,ti;
private Marciano m;
private ArrayList<Marciano> arrayMarciano=new ArrayList<Marciano>();
private ArrayList<Bala> arrayBalasMalo=new ArrayList<Bala>();
private ArrayList<LadrilloEscudo>arrayLadrillos=new ArrayList<LadrilloEscudo>();
private LadrilloEscudo l;
private int [] arrayNumeros;
private Boolean nuevaBala=true;
private Explosion ex;
private PausaInvaders pausa,juegoFin;
private Font f=new Font("TimesRoman", Font.BOLD+Font.ITALIC, 18);
private ArrayList<Nave> arrayVidas=new ArrayList<Nave>();
private int finJuego=0,alMenu=0;
private  BufferedImage imagen;
private int encima=0;//0 ninguno 1 continuar 2 reiniciar , 3 salir , 4 menu
	LienzoInvaders()
	{
		ti=new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				repaint();
			}
		});
		ti.start();
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				
				if(pausaSi==1 || finJuego==1)
				{
					encima=0;
					if(pausaSi==1)
					{
						if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
						{
							encima=1;
							System.out.println(encima);
						}
					}
					
					if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
					{
						encima=3;
						System.out.println(encima);
					}
					if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
					{
						encima=4;
					}
					if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
					{
						encima=2;
					}
				}
				
			}
			
			@Override
			public void mouseDragged(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			if(pausaSi==1 || finJuego==1)
			{
				
				if(pausaSi==1)
				{
					if(e.getX()>=261 && e.getX()<=572 && e.getY()>=68 && e.getY()<=105)
					{
						
						continuarPartida();
						pausaSi=0;
					}
				}
				
				if(e.getX()>=265 && e.getX()<=404 && e.getY()>=265 && e.getY()<=306)
				{
					
					System.exit(ABORT);
							
				}
				if(e.getX()>=252 && e.getX()<=797 && e.getY()>=367 && e.getY()<=406)
				{
					
					alMenu=1;
							
				}
				if(e.getX()>=254 && e.getX()<=516 && e.getY()>=167 && e.getY()<=206)
				{
					
					if(finJuego==1)
						finJuego=0;
					ReiniciarPartida();
					pausaSi=0;
				}
			}
		}
	});
		pausa=new PausaInvaders(0);
		juegoFin=new PausaInvaders(1);
		crearEscudos();
			for(int cont=0;cont<3;cont++,posXVidas+=40)
			{
			n= new Nave();
			n.setPosX(posXVidas);
			n.setPosY(PosYVidas);
			arrayVidas.add(cont, n);
			}
				arrayNumeros=new int [4];
				setBounds(0, 0, ancho, alto);
				tim=new Timer(10, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						finalizarPartida();
						if(finJuego==0 && pausaSi==0)
						{
						moverTeclado();
						balaFuera();
						matoMarciano();
						crearBalasEnemigo();
						borrarBalaMalo();
						saberQueDispara();
						moverBalasEnemigos();
						comprobarMuerte();
						comprobarColisionEscudo();
						borrarLadrillos();
						nivelSuperado();
						
						timer.setDelay(velocidadTimer);
						}
						repaint();
						requestFocus();
					}
				});
				
				timer=new Timer(velocidadTimer, new ActionListener() {
				
					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						for(Marciano m : arrayMarciano)
						{
							m.Mover();					
						}
						for(Marciano m : arrayMarciano)
						{
							velocidadTimer=m.getVelocidadTimer();
							System.out.println(velocidadTimer );
						}
						
						if(imagenMarciano==0)
							imagenMarciano=1;
						else
							imagenMarciano=0;
						
						
					}
				});
				nave=new Nave();
				crearEnemigos();
				setBackground(Color.BLACK);	
				timer.start();
				tim.start();
				addKeyListener(new KeyAdapter() {
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyChar()==' ')
							arrayNumeros[0]=1;
						if(e.getKeyChar()=='a' || e.getKeyChar()=='A')
							arrayNumeros[1]=1;
						
						if(e.getKeyChar()=='d' || e.getKeyChar()=='D')					
							arrayNumeros[2]=1;
						if(e.getKeyChar()=='q'|| e.getKeyChar()=='Q' && nave.getVida()>0 && nave.getVida()<3)
							if(pausaSi==0)
							continuarPartida();
						if(e.getKeyChar()=='p' || e.getKeyChar()=='P')
						{
							pausaSi=1;
							paroTimers();
							repaint();
						}
							
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyChar()==' ')
							arrayNumeros[0]=0;
						if(e.getKeyChar()=='a' || e.getKeyChar()=='A')
							arrayNumeros[1]=0;
						
						if(e.getKeyChar()=='d' || e.getKeyChar()=='D')					
							arrayNumeros[2]=0;
						
							
					}
				});
				
	}
	public void nivelSuperado()
	{
		if(arrayMarciano.isEmpty())
		{
			crearEnemigos();
			nave.setVida(3);
			
		}
		velocidadTimer=400;
	}
	public void crearEnemigos()
	{
		alturaMarciano=50;
		distanciaMarcianos=160;
		for(int conti=0;conti<5;conti++)
		{
				for(int cont=0;cont<11;cont++)
				{
					m=new Marciano(nave);
					distanciaMarcianos=distanciaMarcianos+40;
					m.setPosX(distanciaMarcianos);
					m.setPosY(alturaMarciano);
					//m.setPosNave(nave.getPosX(), nave.getPosY());
					arrayMarciano.add(m);
					
				}
				distanciaMarcianos=160;
				alturaMarciano=alturaMarciano+40;			
		}
			
	}
	public void crearEscudos()
	{
		for(int h=0 ;h<4;h++)
		{
		for(int cont=0;cont<4;cont++)
		{
					for(int j=0;j<3;j++)
					{
						if(cont==1 && j==2 || cont==2 && j==2)
						{
							posYladrillo +=15;
						}
						else
						{
							if(j==0 && cont==0){					
							 l = new LadrilloEscudo(1,0);
							}
							if(j==1 && cont==1)
							{
								 l = new LadrilloEscudo(2,1);
							}
							if(j==1 && cont==2)
							{
								 l = new LadrilloEscudo(2,2);
							}
							if(j==0 && cont==3){					
							 l = new LadrilloEscudo(1,3);
							}
							if(j==1 && cont==0 || j==2 && cont==0 || cont==1 && j==0 || cont==2 && j == 0 || cont==3 && j==1 || cont==3 && j==2)
							{
								l = new LadrilloEscudo(0,cont);
							}
							posYladrillo +=15;
							l.setPosX(posXladrillo);				
							l.setPosY(posYladrillo);
							arrayLadrillos.add(l);
							
						}
						
						
					}
					posYladrillo-=45;
					posXladrillo+=15;
				}
		
		posXladrillo+=100;
		}
	}
	
	public void moverBalasEnemigos()
	{
		for(Bala b :arrayBalasMalo)
			b.moverBala();
	}
	public void crearBalasEnemigo()
	{
		for(Marciano m : arrayMarciano)
			if(m.getBalaSi()==1)
			{				
				Bala n=new Bala(m.getPosX()+15,m.getPosY()+30,1);
				m.setBalaSi(0);
				arrayBalasMalo.add(n);
			}
	}
	public void saberQueDispara()
	{
		for(int i=0;i<arrayMarciano.size();i++)
		{
			for(int j=0;j<arrayMarciano.size();j++)
			{
				if(i!=j)
				{
					arrayMarciano.get(i).quienesDisparan(arrayMarciano.get(j));
					if(arrayMarciano.get(i).getQuienDispara()==0)
						break;
				}
			}
		}
	}
	public void borrarBalaMalo()
	{
		for(int cont=0;cont<arrayBalasMalo.size();cont++)
			if (arrayBalasMalo.get(cont).nuevaBala())
			{				
				arrayBalasMalo.remove(cont);
			}
	}
	public void matoMarciano()
	{
								
			for(int contaux=0;contaux<arrayMarciano.size();contaux++)
			{
				if(nave.getBalaSi()==1)
				{
					if(arrayMarciano.get(contaux).matarMarciano(nave.getBalaNave()))//cuando el marciano muere
					{
						contElimMalo=contaux;
						eliminarBala=1;
						conta=1;
						nave.setBalaSi(0);
						puntos=puntos+arrayMarciano.get(contaux).getPuntos();				
					}
				}
			
		}
		if(eliminarBala==1)
		{
			nave.setBalaSi(0);
			nuevaBala=true;
			eliminarBala=0;
			
		}
		if(conta==1)
			contMil++;
		if(contMil>=39)//para controlar la explosion
		{
			arrayMarciano.get(contElimMalo).pararTimerMalos();
			arrayMarciano.remove(contElimMalo);
			contMil=0;
			conta=0;
		}
	}
	public void balaFuera()
	{
		if(nave.getBalaSi()==1)
		{
			if(nave.getBalaNave().nuevaBala())
			{
				nave.setBalaSi(0);
				nuevaBala=true;
			}
		}
		
	}
	public void comprobarColisionEscudo()
	{
		for(LadrilloEscudo l: arrayLadrillos)
		{
			if(nave.getBalaSi()==1)
			{
				if(l.colision(nave.getBalaNave(), arrayBalasMalo))
					nuevaBala=true;	
			}
			else
				l.colisionSinBalaNave(arrayBalasMalo);
			
		}
	}
	
	public void borrarLadrillos()
	{
		for(int h=0;h<arrayLadrillos.size();h++)
		{
			if(arrayLadrillos.get(h).getVida()==0)
			{
				arrayLadrillos.remove(h);
			}
		}
	}
	public void moverTeclado()
	{
		if(arrayNumeros[0]==1)
			{
				if(nuevaBala)
				{
					if(nave.getBalaSi()==1)
					nave.paroBala();
				nave.dispararBala();					
				nuevaBala=false;				 	
				}
			}
		if(arrayNumeros[1]==1)
			nave.moverIzquierda();
		if(arrayNumeros[2]==1)
			nave.moverDerecha();
	
	}
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint(Graphics g)
	{
		BufferedImage imagen = new BufferedImage (getWidth(), getHeight(),BufferedImage.TYPE_INT_RGB);
		if(finJuego==0 && pausaSi==0)
		{
			if(muerte==0)
			{
				
				for(Marciano m : arrayMarciano)
					m.paint( imagen.getGraphics(),imagenMarciano);
				if(nave.getBalaSi()==1)
				nave.getBalaNave().pintar( imagen.getGraphics());
				imagen.getGraphics().setColor(Color.BLUE);
				 imagen.getGraphics().setFont(f);
				 imagen.getGraphics().drawString("VIDAS:", 600, 30);
				 imagen.getGraphics().drawString("puntos: "+ puntos, 200, 30);
				for(int cont=0; cont<nave.getVida();cont++)
					arrayVidas.get(cont).pintarNave(imagen.getGraphics());
				for(Bala a : arrayBalasMalo)
					a.pintar(imagen.getGraphics());
				for (LadrilloEscudo a: arrayLadrillos)
					a.pintar(imagen.getGraphics());
				nave.pintarNave(imagen.getGraphics());
			}
			else
			{
				if(finJuego!=1 && pausaSi!=1)
				{
				 imagen.getGraphics().setColor(Color.GREEN);
				 imagen.getGraphics().setFont(f);
				 imagen.getGraphics().drawString("pulse 'q' para continuar",300,300);
				}
			}
		}
		else
		{
			if(finJuego==1 && pausaSi!=1)
			juegoFin.paint(imagen.getGraphics(),encima);	
			if(pausaSi==1 && finJuego!=1)
			pausa.paint(imagen.getGraphics(),encima);
		}
		 g.drawImage(imagen, 0, 0, this);
	}
	public void comprobarMuerte()
	{
		if (nave.naveMuere(arrayBalasMalo))//cuando muere la nave: 1.resto vida, 2 elimino balas reincializo valores
		{
			nave.setVida(nave.getVida()-1);
			timer.stop();
			for(Marciano m : arrayMarciano)
			{
				m.pararTimerMalos();
				m.paraOtroTimer();
			}
			arrayBalasMalo.removeAll(arrayBalasMalo);

			muerte=1;
			pasa=0;
		}
			
	}
	public void finalizarPartida()
	{
		if(nave.getVida()==0)
		{
			finJuego=1;
			paroTimers();
		}
			
	}
	public void continuarPartida()
	{
		
		timer.start();
		tim.start();
		for(Marciano m : arrayMarciano)
			m.activaTimer();
		muerte=0;
		
	}
	public void paroTimers()
	{
		tim.stop();
		timer.stop();
		if(nave.getBalaSi()==1)
			nave.paroBala();
		
	}
	public void ReiniciarPartida()
	{
		arrayMarciano.removeAll(arrayMarciano);
		arrayBalasMalo.removeAll(arrayBalasMalo);
		arrayLadrillos.removeAll(arrayLadrillos);
		arrayVidas.removeAll(arrayVidas);
		crearEnemigos();
		nave.setVida(3);
		for(int cont=0,posXVidas=700;cont<3;cont++,posXVidas+=40)
		{
		n= new Nave();
		n.setPosX(posXVidas);
		n.setPosY(PosYVidas);
		arrayVidas.add(cont, n);
		}
		
		posYladrillo=400;
		posXladrillo=200;
		crearEscudos();
		puntos=0;
		continuarPartida();
		
		
	}
	public int getAlMenu() {
		return alMenu;
	}
	public void setAlMenu(int alMenu) {
		this.alMenu = alMenu;
	}
}
