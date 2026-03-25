package DESAFIO_02;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class painel extends JPanel implements MouseListener,KeyListener{
	
	private String pos;
	private Color p1Cor = Color.BLACK;
	private Color CorTri = Color.BLUE;
	private Color CorFundo1 = Color.GREEN;
	private int player1X = 50, player1Y = 50;
	private int player2X = 650, player2Y = 0;
	
	private Color Qclicado = Color.RED;
	private Color Tclidado = Color.YELLOW;
	private boolean Qselecionado = false;
	private boolean Tselecionado = false;
	
	public painel(String posicao) {
		this.pos = posicao;
		
		switch (posicao) {
		case "centro":
			this.setBackground(CorFundo1);
			this.setPreferredSize(new Dimension(800,500));
			this.addMouseListener(this);
			this.addKeyListener(this);
			this.setFocusable(true);
			break;
			
		case"sul":
			this.setBackground(Color.BLACK);
			this.setPreferredSize(new Dimension(800,100));
			break;

		}
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(getBackground());
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		if(this.pos == "centro") {
			
			//desenho p1
			g.setColor(p1Cor);
			g.fillRect(player1X, player1Y, 100, 100);
			g2.setStroke(new BasicStroke(3)); 
			g2.setColor(Color.WHITE);
			g2.drawRect(player1X,player1Y, 100, 100);
			//desenho p2
			g.setColor(CorTri);
			
			int[] px = { player2X,      player2X - 50, player2X + 50 };
			int[] py = { player2Y,      player2Y + 100, player2Y + 100 };
			
			g2.fillPolygon(px, py, 3);
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.BLACK);
			g2.drawPolygon(px, py, 3);
			
		} else {
			Font fonte = new Font("Arial", Font.PLAIN, 25);
			g2.setColor(Color.WHITE);
			g2.setFont(fonte);
			g2.drawString("Renato da Motta, Kendy Wakiyama, Gustavo Gabriel - 19/03/2026", 50, 50);
			}
		
	}
	
	
	// KEYLISTENER -----------------------------
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		/* 		   W - 87
		 * A - 65  S - 83   D - 68  */
		int cod = e.getKeyCode();
		System.out.println(cod);
		
		if(Qselecionado) {
			switch(cod) {
			case 87: //     W
				this.player1Y = this.player1Y -5;
				break;		
			case 65: //     A
				this.player1X = this.player1X -5;
				break;
			case 83: //     S
				this.player1Y = this.player1Y +5;
				break;		
			case 68: //     D
				this.player1X = this.player1X +5;
				break;		
			}
		}
		
		if(Tselecionado) {
			switch(cod) {
			case 87: //     W
				this.player2Y = this.player2Y -5;
				break;		
			case 65: //     A
				this.player2X = this.player2X -5;
				break;
			case 83: //     S
				this.player2Y = this.player2Y +5;
				break;		
			case 68: //     D
				this.player2X = this.player2X +5;
				break;		
			}
		}
		this.repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	// MOUSE LISTENER -----------------------------------------------

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

		int mx = e.getX();
		int my = e.getY();
		System.out.println("X: "+mx+" Y: " +my);
		
		if(mx >= player1X && mx <= player1X +100  && my >= player1Y && my <= player1Y +100) {
			Qselecionado = true;
			Tselecionado = false;
			p1Cor = Qclicado;
			
		} else if (clicouNoTriangulo(mx, my)) {
	        Tselecionado = true;
	        Qselecionado = false;
	        CorTri = Tclidado;
	        p1Cor = Color.BLACK;

	    } else {
	        Qselecionado = false;
	        Tselecionado = false;
	        p1Cor = Color.BLACK;
	        CorTri = Color.BLUE;
	        
	        player1X = 50; player1Y = 50;
	        player2X = 650; player2Y = 0;
	    }
		
		repaint();	
	}
	
	private boolean clicouNoTriangulo(int mx, int my) {

		if (mx < player2X - 50 || mx > player2X + 50) return false;
	    if (my < player2Y      || my > player2Y + 100) return false;

	    float proporcao = (float)(my - player2Y) / 100;
	    float largura = 50 * proporcao;

	    return mx >= player2X - largura && mx <= player2X + largura;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}

}
