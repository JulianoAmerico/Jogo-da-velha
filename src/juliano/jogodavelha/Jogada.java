package juliano.jogodavelha;

import java.util.Scanner;

/**
 * Classe que representa jogadas de um jogador, baseado em uma matriz. Obtém a
 * posição de linha e coluna.
 * 
 * @author Juliano
 *
 */
public class Jogada {

	/**
	 * Representa a posição da linha na matriz.
	 */
	private int i;

	/**
	 * Representa a posição da coluna na matriz.
	 */
	private int j;

	/**
	 * Obtém a posição da linha na matriz.
	 * 
	 * @return Retorna posição i.
	 */
	public int getI() {
		return i;
	}

	/**
	 * Obtém a posição da coluna na matriz.
	 * 
	 * @return Retorna a posição j.
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

			// Recupera a posição das jogadas feita pela jogador.
			while (sc.hasNext()) {
				pos[i] = sc.nextInt();
				i++;
			}

			// Verifica se as posições das jogadas são válidas.
			if (pos[0] > 2) {
				throw new JogadaInvalidaException("Jogada inválida. Linha maior que o tamanho da matriz!");
			}

			if (pos[1] > 2) {
				throw new JogadaInvalidaException("Jogada inválida. Coluna maior que o tamanho da matriz!");
			}

			if (pos[0] < 0 || pos[1] < 0) {
				throw new JogadaInvalidaException("Jogada inválida. Valor negativo não é permitido");
			}

			// Guarda as posições nos seus respectivos lugares.
			this.i = pos[0];
			this.j = pos[1];

		}
	}
}
