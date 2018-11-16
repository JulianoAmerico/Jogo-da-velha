package juliano.jogodavelha;

import juliano.jogodavelha.Jogador.Simbolo;

/**
 * Classe que representa um tabuleiro do jogo da velha.
 * @author Juliano
 *
 */
public class Tabuleiro {

	/**
	 * Tabuleiro do jogo da velha é uma matriz 3 por 3.
	 */
	private char[][] matriz = new char[3][3];
	
	/**
	 * Construtor. Ao construir a matriz, é colocado espaços em branco nas posições.
	 */
	public Tabuleiro() {
		zerar();
	}
	
	/**
	 * Insere espaços em branco nas posições da matriz
	 */
	public void zerar() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Mostra tabuleiro no Console
	 */
	public void imprimir() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				
				if(j == (matriz[0].length - 1)) {
					System.out.print(matriz[i][j]);
					continue;
				}
				
				System.out.print(matriz[i][j] + "|");
				
			}
			
			if(i >= 2) {
				continue;
			}
			
			System.out.println("\n-----");
		}
	}
	
	/**
	 * True quando todas as posições do tabuleiro forem preenchidas,
	 * caso contrário retorna false.
	 * @return
	 */
	public boolean isCompleto() {
		char simbolo = ' ';
		int contaPosPreenchidas = 0;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				simbolo = matriz[i][j];
				
				if(simbolo != ' ') {
					contaPosPreenchidas++;
				}
			}
		}
		
		if(contaPosPreenchidas ==  9) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Executa a jogada.
	 * @param jogada Jogada escolhida pelo jogador
	 * @param simbolo Símbolo que representa o jogador
	 * @return Retorna true se for uma jogada válida, caso contrário retorna false.
	 */
	public boolean efetuarJogada(Jogada jogada, Simbolo simbolo) {
		char c = matriz[jogada.getI()][jogada.getJ()];
		
		if(c == ' ') {
			matriz[jogada.getI()][jogada.getJ()] = simbolo.toString().charAt(0);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Verifica se uma sequência foi encontrada.
	 * @return Retorna true se uma sequência foi encontrada, caso ao contrário
	 * retorna false.
	 */
	public boolean isSequenciaEncontrada() {
		//X
		//Linha 0 colunas 0, 1 e 2.
		if(matriz[0][0] == 'X' && matriz[0][1] == 'X' && matriz[0][2] == 'X') {
			return true;
		}
		
		//Linha 1 colunas 0, 1 e 2.
		if(matriz[1][0] == 'X' && matriz[1][1] == 'X' && matriz[1][2] == 'X') {
			return true;			
		}
		
		//Linha 2 colunas 0, 1 e 2.
		if(matriz[2][0] == 'X' && matriz[2][1] == 'X' && matriz[2][2] == 'X') {
			return true;
		}
		
		//Coluna 0 linhas 0, 1 e 2
		if(matriz[0][0] == 'X' && matriz[1][0] == 'X' && matriz[2][0] == 'X') {
			return true;
		}
		
		//Coluna 1 linhas 0, 1 e 2
		if(matriz[0][1] == 'X' && matriz[1][1] == 'X' && matriz[2][1] == 'X') {
			return true;
		}
		
		//Coluna 2 linhas 0, 1 e 2
		if(matriz[0][2] == 'X' && matriz[1][2] == 'X' && matriz[2][2] == 'X') {
			return true;
		}
		
		//Transversal da esquerda para direita
		if(matriz[0][0] == 'X' && matriz[1][1] == 'X' && matriz[2][2] == 'X') {
			return true;
		}
		
		//Transversal da direita para esquerda
		if(matriz[0][2] == 'X' && matriz[1][1] == 'X' && matriz[2][0] == 'X') {
			return true;
		}
		
		//O
		//Linha 0 colunas 0, 1 e 2
		if(matriz[0][0] == 'O' && matriz[0][1] == 'O' && matriz[0][2] == 'O') {
			return true;
		}
		
		//Linha 1 colunas 0, 1 e 2
		if(matriz[1][0] == 'O' && matriz[1][1] == 'O' && matriz[1][2] == 'O') {
			return true;			
		}
		
		//Linha 2 colunas 0, 1 e 2
		if(matriz[2][0] == 'O' && matriz[2][1] == 'O' && matriz[2][2] == 'O') {
			return true;
		}
	
		//Coluna 0 linhas 0, 1 e 2
		if(matriz[0][0] == 'O' && matriz[1][0] == 'O' && matriz[2][0] == 'O') {
			return true;
		}
		
		//Coluna 1 linhas 0, 1 e 2
		if(matriz[0][1] == 'O' && matriz[1][1] == 'O' && matriz[2][1] == 'O') {
			return true;
		}

		//Coluna 2 linhas 0, 1 e 2
		if(matriz[0][2] == 'O' && matriz[1][2] == 'O' && matriz[2][2] == 'O') {
			return true;
		}
		
		//Transversal esquerda para direita
		if(matriz[0][0] == 'O' && matriz[1][1] == 'O' && matriz[2][2] == 'O') {
			return true;
		}

		//Transversal direita para esquerda
		if(matriz[0][2] == 'O' && matriz[1][1] == 'O' && matriz[2][0] == 'O') {
			return true;
		}
		
		return false;
	}
		
}
