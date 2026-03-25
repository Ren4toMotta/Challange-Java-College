package DESAFIO_02;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class moldura extends JFrame {
	public moldura() {
		this.setAlwaysOnTop(true);
		this.setResizable(false);
		this.setTitle("- CAP 06 - DESAFIO 02 -");
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		painel p1 = new painel("centro");
		painel p2 = new painel("sul");
		
		this.add(p1,BorderLayout.CENTER);
		this.add(p2, BorderLayout.SOUTH);
		
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
