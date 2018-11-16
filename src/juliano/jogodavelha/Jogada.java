package juliano.jogodavelha;

import java.util.Scanner;

/**
 * Classe que representa jogadas de um jogador, baseado em uma matriz. Obt�m a
 * posi��o de linha e coluna.
 * 
 * @author Juliano
 *
 */
public class Jogada {

	/**
	 * Representa a posi��o da linha na matriz.
	 */
	private int i;

	/**
	 * Representa a posi��o da coluna na matriz.
	 */
	private int j;

	/**
	 * Obt�m a posi��o da linha na matriz.
	 * 
	 * @return Retorna posi��o i.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Obt�m a posi��o da coluna na matriz.
	 * 
	 * @return Retorna a posi��o j.
	 */
	public int getJ() {
		return j;
	}

	/**
	 * Recebe as jogadas e a validam.
	 * 
	 * @param nome Representa a jogada realizada por um jogador.
	 * @throws JogadaInvalidaException
	 */
	public void parseString(String nome) throws JogadaInvalidaException {
		try (Scanner sc = new Scanner(nome)) {
			sc.useDelimiter("([\\s,])+");
			int i = 0;
			int[] pos = new int[2];

			// Recupera a posi��o das jogadas feita pela jogador.
			while (sc.hasNext()) {
				pos[i] = sc.nextInt();
				i++;
			}

			// Verifica se as posi��es das jogadas s�o v�lidas.
			if (pos[0] > 2) {
				throw new JogadaInvalidaException("Jogada inv�lida. Linha maior que o tamanho da matriz!");
			}

			if (pos[1] > 2) {
				throw new JogadaInvalidaException("Jogada inv�lida. Coluna maior que o tamanho da matriz!");
			}

			if (pos[0] < 0 || pos[1] < 0) {
				throw new JogadaInvalidaException("Jogada inv�lida. Valor negativo n�o � permitido");
			}

			// Guarda as posi��es nos seus respectivos lugares.
			this.i = pos[0];
			this.j = pos[1];

		}
	}
}
