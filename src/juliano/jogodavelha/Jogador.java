package juliano.jogodavelha;

/**
 * Classe que representa um Jogador
 * 
 * @author Juliano
 *
 */
public class Jogador {

	/**
	 * Um jogador pode ter um símbolo que pode ser X ou O.
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
	 * Símbolo do jogador.
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
	 * @param simbolo Representa o símbolo do jogador
	 */
	public Jogador(String nome, Simbolo simbolo) {
		this.nome = nome;
		this.simbolo = simbolo;
	}

	/**
	 * Obtém o nome do jogador
	 * 
	 * @return Retorna o nome do jogador.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Obtém o síbolo do jogador.
	 * 
	 * @return
	 */
	public Simbolo getSimbolo() {
		return simbolo;
	}

	/**
	 * Obtém objeto Jogada do jogador, caso não existir é criado um objeto jogada.
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
