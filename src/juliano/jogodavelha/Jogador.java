package juliano.jogodavelha;

/**
 * Classe que representa um Jogador
 * 
 * @author Juliano
 *
 */
public class Jogador {

	/**
	 * Um jogador pode ter um s�mbolo que pode ser X ou O.
	 * 
	 * @author Juliano
	 *
	 */
	public enum Simbolo {
	X, O;
	}

	/**
	 * Nome do jogador.
	 */
	private String nome;

	/**
	 * S�mbolo do jogador.
	 */
	private Simbolo simbolo;

	/**
	 * Representa as jogadas do jogador.
	 */
	private Jogada jogada;

	/**
	 * Construtor
	 * 
	 * @param nome    Representa o nome do jogador
	 * @param simbolo Representa o s�mbolo do jogador
	 */
	public Jogador(String nome, Simbolo simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	/**
	 * Obt�m o nome do jogador
	 * 
	 * @return Retorna o nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Obt�m o s�bolo do jogador.
	 * 
	 * @return
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}

	/**
	 * Obt�m objeto Jogada do jogador, caso n�o existir � criado um objeto jogada.
	 * 
	 * @return Retorna objeto Jogada.
	 */
	public Jogada obterJogada() {
		if (jogada == null) {
			jogada = new Jogada();
		}

		return jogada;
	}
}
