import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class Marciano {
	private Image [] [] arrayImagenes;
	private int ancho,alto,posX,posY,tipoMarciano,estado,movimiento,a,imagenes,delayTimer,contMalos,puntos=0;//estado 0 izquierda, 1 derecha;
	private Timer tim,timer;
	private int explosion=0;
	private int crearBala=0,velocidadTimer=400;//cuando el malo crea bala //0 no ay bala 
	private Bala b;
	private int balaSi=0,naveMuerto=0,quienDispara=-1;//quiendispara:0yono,1yosi;//0 bala n funcionamiento, 1 bala borrada
	
	private Nave na;
    private Explosion ex;
  // private Rectangle r;
	public int getPosX() {
		return posX;
	}
	public boolean matarMarciano(Bala a)//mato al marciano
	{
		
		if( a.getPosX()>=posX  && a.getPosX() <=posX+40 && a.getPosY()>=posY && a.getPosY()<=posY+40)
		{
			ex=new Explosion(posX,posY);
			ex.activaTimer(1);
			explosion=1;
			a.setPosY(-50);
			System.out.println(ex.getContImg());
			
			return true;
		}
		return false;
		//if(a.getPosY()<500)
			//System.out.println("sisiisis");
			
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
	public void balaFuera(Bala a)
	{
	if(a.getPosY()>500)
		System.out.println("ola");
	}
	Marciano(final Nave n)
	{
		na=n;
		balaSi=0;
		//crearRectangulo();
		contMalos=0;
		delayTimer=(int)(Math.random()*5000+5000);
		tim=new Timer(delayTimer, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(quienDispara==1)
				balaSi=1;
				
			}
		});
		tim.start();
		a=3;
		estado=0;
		movimiento=160;
		arrayImagenes=new Image [2][3];
		tipoMarciano=(int)(Math.random()*3+0);
		if(tipoMarciano==0)
			puntos=10;
		if(tipoMarciano==1)
			puntos=20;
		if(tipoMarciano==2)
			puntos=30;
		ancho=30;
		alto=30;
		posX=10;
		posY=100;
		for(int cont=0;cont<3;cont++)
		{
			imagenes=3+cont;
			arrayImagenes[0][cont]=Toolkit.getDefaultToolkit().getImage("space/m"+cont+".png");
			arrayImagenes[1][cont]=Toolkit.getDefaultToolkit().getImage("space/m"+imagenes+".png");
		}
		
	}
	/* public Rectangle getR() {
		return r;
	}
	public void setR(Rectangle r) {
		this.r = r;
	}*/
	public void quienesDisparan(Marciano a)
	 {
		Rectangle r=new Rectangle(posX,posY+alto+10,ancho,alto);
		Rectangle r2=new Rectangle(a.getPosX(),a.getPosY(),ancho,alto);
		if(r.intersects(r2))
			quienDispara=0;
		else
			 quienDispara=1;
			
	 }
	
	public int getNaveMuerto() {
		return naveMuerto;
	}
	public void setNaveMuerto(int naveMuerto) {
		this.naveMuerto = naveMuerto;
	}
	public void setBalaSi(int balaSi) {
		this.balaSi = balaSi;
	}
	public int getBalaSi() {
		return balaSi;
	}
	public Bala getBala()
	{
		return b;
	}
	public void paint(Graphics g,int i)//i=estadoImagen
	{
		if(explosion==0)
		{
			g.drawImage(arrayImagenes[i][tipoMarciano],posX,posY,alto,ancho,null);
			if(contMalos!=0)
			g.drawImage(b.getImagenMalo(),b.getPosX(),b.getPosY(),2,20,null);
		}
		else
			ex.pintar(g);//cuando el marciano explota
	}
	public void paraOtroTimer()
	{
		//timer.stop();
	}
	public void activaOtroTimer()
	{
		timer.start();
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public int getQuienDispara() {
		return quienDispara;
	}
	public void pararTimerMalos()
	{
		tim.stop();
	}
	public void activaTimer()
	{
		tim.start();
	}
	public void Mover()
	{
		if(estado==0)
		{
			if (movimiento<320)
			{
				posX=posX+10;
				movimiento+=10;
			}
			if(movimiento>=320)
			{
				estado=1;
				posY+=20;
				velocidadTimer-=20;
			}
		}
		if (estado==1)
		{
			if (movimiento>0)
			{
				posX=posX-10;
				movimiento-=10;
			}
			if(movimiento<=0)
			{
				estado=0;
				posY+=20;
				velocidadTimer-=20;
			}
		}
		System.out.println(velocidadTimer +" Marciano");
	}/*
	public void crearRectangulo()
	{
		r=new Rectangle(posX,posY,ancho,alto);
	}*/
	public int getVelocidadTimer() {
		return velocidadTimer;
	}
	public void setVelocidadTimer(int velocidadTimer) {
		this.velocidadTimer = velocidadTimer;
	}
}
