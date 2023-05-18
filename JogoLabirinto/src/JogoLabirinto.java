import jplay.GameImage;
import jplay.Window;
import jplay.URL;

public class JogoLabirinto {
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
//		float PROBABILIDADE = (float) 0.3;
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
	public static void imprimir() {
		int i, j;
		for(i = 0; i < TAMANHO; i++) {
			for(j = 0; j < TAMANHO; j++) {
				System.out.print(tabuleiro[i][j]);
			}
			System.out.println();
		}
		try {
			Thread.sleep(400);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static int gerarNumero(int minimo, int maximo) {
		int valor = (int) Math.round(Math.random() * (maximo - minimo) );
//		System.out.println("Minimo: "+ minimo + " Valor: " + valor);
		int coordenada = minimo + valor;
		return coordenada;
	}
	public static boolean posicaoVazia(int linha, int coluna) {
		boolean vazio = false;
		if (linha >= 0 && coluna >= 0 && linha < TAMANHO && coluna < TAMANHO) {
			vazio = (tabuleiro[linha][coluna] == VAZIO);
		}
		return vazio;
	}
	
	public static boolean tentarCaminho(int proxLinha, int proxColuna) {
		boolean achou = false;
		if (tabuleiro[proxLinha][proxColuna]== DESTINO) {
			achou = true;
		}else if (posicaoVazia(proxLinha, proxColuna)) {
			//marcar
			tabuleiro[proxLinha][proxColuna] = CAMINHO;
			imprimir();
			achou = procurarCaminho(proxLinha, proxColuna);
			if (!achou) {
				tabuleiro[proxLinha][proxColuna] = SEM_SAIDA;
				imprimir();
			}
		}
		return achou;
	}
	
	public static boolean procurarCaminho(int linhaAtual, int colunaAtual) {
		int proxLinha;
		int proxColuna;
		boolean achou = false;
		//tenta subir
		proxLinha = linhaAtual - 1;
		proxColuna = colunaAtual;
		achou = tentarCaminho(proxLinha, proxColuna);
		//tenta descer
		if (!achou) {
			proxLinha = linhaAtual + 1;
			proxColuna = colunaAtual;
			achou = tentarCaminho(proxLinha, proxColuna);
		}
		//tenta esquerda
		if (!achou) {
			proxLinha = linhaAtual;
			proxColuna = colunaAtual - 1;
			achou = tentarCaminho(proxLinha, proxColuna);
		}
		//tenta direita
		if (!achou) {
			proxLinha = linhaAtual;
			proxColuna = colunaAtual + 1;
			achou = tentarCaminho(proxLinha, proxColuna);
		}
		return achou;
	}
	
	public static void main(String[] args) {
		tabuleiro = new char[TAMANHO][TAMANHO];
		inicializarMatriz();
		linhaInicio = gerarNumero(1, TAMANHO/2 - 1);
		colunaInicio = gerarNumero(1, TAMANHO/2 - 1);
//		System.out.println("inicio");
//		System.out.println(linhaInicio + "," + colunaInicio);
		tabuleiro[linhaInicio][colunaInicio] = INICIO;
		
		linhaDestino = gerarNumero(TAMANHO/2, TAMANHO - 2);
		colunaDestino = gerarNumero(TAMANHO/2, TAMANHO - 2);
//		System.out.println("destino");
//		System.out.println(linhaDestino + "," + colunaDestino);
		tabuleiro[linhaDestino][colunaDestino] = DESTINO;
		imprimir();
		
		System.out.println("\n- procurando Solução -\n");
		boolean achou = procurarCaminho(linhaInicio, colunaInicio);
		if (achou) {
			System.out.println("ACHOU CAMINHO!");
		}else {
			System.out.println("NÃO TEM CAMINHO!");
		}
	
	}
}
