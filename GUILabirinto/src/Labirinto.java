import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Labirinto {
	private static final char PAREDE_VERTICAL = '|';
	private static final char PAREDE_HORIZONTAL = '_';
	private static final char VAZIO = ' ';
	private static final char TAMANHO = 10;
	private static char[][] tabuleiro;
	private static final char PAREDE_INTERNA = '#';
	private static final double PROBABILIDADE = 0.3;
	private static final char INICIO = 'I';
	private static final char DESTINO = 'D';
	private static int linhaInicio;
	private static int colunaInicio;
	private static int linhaDestino;
	private static int colunaDestino;
	
	private static char CAMINHO = '.';
	private static char SEM_SAIDA = 'X';
	public static void inicializarMatriz() {
		int i, j = 0;
		for(i = 0; i < TAMANHO; i++) {
			tabuleiro[i][0] = PAREDE_VERTICAL;
			tabuleiro[i][TAMANHO - 1] = PAREDE_VERTICAL;
			tabuleiro[0][i] = PAREDE_HORIZONTAL;
			tabuleiro[TAMANHO - 1][i] = PAREDE_HORIZONTAL;
		}
		for(i = 1; i < TAMANHO - 1; i++) {
			for(j = 1; j < TAMANHO - 1; j++) {
				tabuleiro[i][j] = VAZIO;
			}	
		}
		for(i = 1; i < TAMANHO - 1; i++) {
			for(j = 1; j < TAMANHO - 1; j++) {
				if(Math.random() < PROBABILIDADE) {
					tabuleiro[i][j] = PAREDE_INTERNA;
				}else {
					tabuleiro[i][j] = VAZIO;
				}
					
			}	
		}
	}
	public static void main(String[] args) {
		int i, j = 0;
		tabuleiro = new char[TAMANHO][TAMANHO];
		inicializarMatriz();
		BufferedImage bg = null;
		BufferedImage armadilha1 = null;
//		BufferedImage armadilha2 = null;
//		BufferedImage armadilha3 = null;
//		BufferedImage armadilha4 = null;
//		BufferedImage armadilha5 = null;
//		BufferedImage armadilha6 = null;
//		BufferedImage armadilha7 = null;
//		BufferedImage armadilha8 = null;
//		BufferedImage armadilha9 = null;
//		BufferedImage armadilha10 = null;
	
		try {
			bg = ImageIO.read(new File("piso.png"));
			armadilha1 = ImageIO.read(new File("armadilha.png"));
//			armadilha2 = ImageIO.read(new File("armadilha.png"));
//			armadilha3 = ImageIO.read(new File("armadilha.png"));
//			armadilha4 = ImageIO.read(new File("armadilha.png"));
//			armadilha5 = ImageIO.read(new File("armadilha.png"));
//			armadilha6 = ImageIO.read(new File("armadilha.png"));
//			armadilha7 = ImageIO.read(new File("armadilha.png"));
//			armadilha8 = ImageIO.read(new File("armadilha.png"));
//			armadilha9 = ImageIO.read(new File("armadilha.png"));
//			armadilha10 = ImageIO.read(new File("armadilha.png"));
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		JLabel fundo = new JLabel();
		JLabel trap1 = new JLabel();
		JLabel trap2 = new JLabel();
		JLabel trap3 = new JLabel();
		JLabel trap4 = new JLabel();
		JLabel trap5 = new JLabel();
		JLabel trap6 = new JLabel();
		JLabel trap7 = new JLabel();
		JLabel trap8 = new JLabel();
		JLabel trap9 = new JLabel();
		JLabel trap10 = new JLabel();

	
//		armadilha1.setBounds(0, 0, 70, 70);
		JFrame janela = new JFrame();
		janela.setSize(700, 700);
		janela.setLayout(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		
		Image dbg = bg.getScaledInstance(janela.getWidth(),janela.getHeight(), Image.SCALE_SMOOTH);
		Image dtrap1 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		trap1.setBounds(0, 0, 70, 70);
		Image dtrap2 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		trap2.setBounds(70*1, 0, 70, 70);
//		Image dtrap3 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap4 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap5 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap6 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap7 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap8 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap9 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
//		Image dtrap10 = armadilha1.getScaledInstance(70,70, Image.SCALE_SMOOTH);
		
		ImageIcon imageicon = new ImageIcon(dbg);
		ImageIcon imageicon1 = new ImageIcon(dtrap1);
		
		ImageIcon imageicon2 = new ImageIcon(dtrap1);
		ImageIcon imageicon3 = new ImageIcon(dtrap1);
		ImageIcon imageicon4 = new ImageIcon(dtrap1);
		ImageIcon imageicon5 = new ImageIcon(dtrap1);
		ImageIcon imageicon6 = new ImageIcon(dtrap1);
		ImageIcon imageicon7 = new ImageIcon(dtrap1);
		ImageIcon imageicon8 = new ImageIcon(dtrap1);
		ImageIcon imageicon9 = new ImageIcon(dtrap1);
		ImageIcon imageicon10 = new ImageIcon(dtrap1);
	
		
		fundo.setIcon(imageicon);
		trap1.setIcon(imageicon2);
		trap2.setIcon(imageicon2);

		janela.setVisible(true);
		janela.add(trap1);
		janela.add(trap2);
		janela.add(fundo);

	}
}

