import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Main extends JFrame {
private MenuSelector menu=null;
private MainInvaders inva=null;
private MainPong pong=null;
private MainTiros tiros=null;
private int exixto=0;

private Timer tim;
	private JPanel contentPane;
	private MainSnake a;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		menu=new MenuSelector();
		contentPane.add(menu);
		tim=new Timer(100, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				comprobarClicks();
				System.out.println(exixto);
				if(inva!=null)
				{
					if(inva.volverAlmenu()==1)
					{
						inva.dispose();
						setVisible(true);
						inva=null;						
						exixto=0;
					}
				}
				if(tiros!=null)
				{
					if(tiros.getAlMenu()==1)
					{
						tiros.dispose();
						setVisible(true);
						tiros=null;						
						exixto=0;
					}
				}
				if(a!=null)
				{
					if(a.getSalir()==1)
					{
						a.dispose();
						setVisible(true);
						tiros=null;						
						exixto=0;
					}
				}
				
			}
		});	
		
		tim.start();
	}

	public void comprobarClicks()
	{
		if(menu.getClickPon()==1)
		{
			pong=new MainPong();
			this.setVisible(false);
			menu.setClickPon(0);
		}
		if(menu.getClickInva()==1)
		{
			inva=new MainInvaders();
			this.setVisible(false);
			menu.setClickInva(0);
		}
		if(menu.getClickSer()==1)
		{
			a=new MainSnake();
			this.setVisible(false);
			menu.setClickSer(0);
		}
		if(menu.getClickTi()==1)
		{
			tiros=new MainTiros();
			this.setVisible(false);
			menu.setClickTi(0);
		}
		
	}
}
