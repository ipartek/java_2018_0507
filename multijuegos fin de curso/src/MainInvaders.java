import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainInvaders extends JFrame {
	private LienzoInvaders lienzo;
	private JPanel contentPane;
	private Timer tim;
	private int exixto;

	public int getExixto() {
		return exixto;
	}
	public void setExixto(int exixto) {
		this.exixto = exixto;
	}
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
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
	}*

	/**
	 * Create the frame.
	 */
	public MainInvaders() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				lienzo.paroTimers();
			}
		});
		exixto=1;
		requestFocus();
		lienzo=new LienzoInvaders();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.add(lienzo);
	
		
	}
	public int volverAlmenu()
	{
		return lienzo.getAlMenu();
		
	}
}
