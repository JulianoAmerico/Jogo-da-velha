package juliano.jogodavelha;

import java.util.ArrayList;
import java.util.List;

import juliano.jogodavelha.Jogador.Simbolo;
import juliano.jogodavelha.io.Console;
import juliano.jogodavelha.pontuacao.GerenciadorPontuacao;
import juliano.jogodavelha.pontuacao.GerenciadorPontuacaoArquivo;
import juliano.jogodavelha.pontuacao.PontuacaoException;

/**
 * Constrói o Jogo da velha
 * 
 * @author Juliano
 *
 */
public class Jogo {

	/**
	 * Cria o tabuleiro do jogo da velha
	 */
	private Tabuleiro tabuleiro = new Tabuleiro();

	/**
	 * Contém a lista de jogadores que deve ser dois.
	 */
	private List<Jogador> jogadores = new ArrayList<>();

	/**
	 * Gerencia a pontuação dos jogadores.
	 */
	private GerenciadorPontuacao gerenciadorPontuacao;

	public void jogar() throws JogoDaVelhaException, PontuacaoException {
		// Pega a instância do gerenciador de pontuação.
		gerenciadorPontuacao = GerenciadorPontuacaoArquivo.getInstance();

		System.out.println("===================");
		System.out.println("|| JOGO DA VELHA ||");
		System.out.println("===================");
		System.out.println();

		// Jogador 1
		System.out.print("Nome do primeiro jogador: ");
		String nomeJogador1 = Console.readString();
		mostraPontuacao(nomeJogador1);
		jogadores.add(new Jogador(nomeJogador1, Simbolo.X));

		// Jogador 2
		System.out.print("\nNome do segundo jogador: ");
		String nomeJogador2 = Console.readString();
		mostraPontuacao(nomeJogador2);
		jogadores.add(new Jogador(nomeJogador2, Simbolo.O));

		tabuleiro.imprimir();

		int i = 0;

		while (true) {

			System.out.printf("\nJogador '%s': ", jogadores.get(i).getNome());

			/*
			 * Lê e efetua a jogada do jogador. O jogador está indexado, e o valor do indice
			 * determina o jogador atual.
			 */
			leEfetuaJogadas(i);

			tabuleiro.imprimir();
			System.out.println();

			if (tabuleiro.isSequenciaEncontrada()) {
				System.out.printf("\nJogador '%s' ganhou", jogadores.get(i).getNome());
				gerenciadorPontuacao.gravarPontuacao(jogadores.get(i).getNome());
				break;
			}

			if (tabuleiro.isCompleto()) {
				System.out.println("\nNão há mais jogadas, o jogo empatou!");
				break;
			}

			i++;

			// Alterna a vez dos jogadores jogarem.
			if (i == 2) {
				i = 0;
			}

		}
	}

	/**
	 * Lê a jogada feita pelo jogador e a executa no tabuleiro.
	 * 
	 * @param indiceJogador Representa o jogador, os dois jogadores são indexados.
	 * @throws JogoDaVelhaException
	 */
	private void leEfetuaJogadas(int indiceJogador) {
		String jogadaConsole = Console.readString();
		Jogador jogador = jogadores.get(indiceJogador);
		Jogada jogada = jogador.obterJogada();

		try {
			jogada.parseString(jogadaConsole);
			tabuleiro.efetuarJogada(jogada, jogador.getSimbolo());
		} catch (JogadaInvalidaException e) {
			System.err.println("\n" + e.getMessage());
		}
	}

	/**
	 * Mostra pontuação do jogador, se houver.
	 * 
	 * @param nome Nome do jogador.
	 * @throws JogoDaVelhaException
	 */
	private void mostraPontuacao(String nome) throws JogoDaVelhaException {
		try {
			Integer value = gerenciadorPontuacao.getPontuacao(nome);

			if (value != 0) {
				if (value > 1) {
					System.out.println(nome + " tem " + value + " vitórias. A última vitória foi "
							+ gerenciadorPontuacao.getDataPontuacao(nome));
				} else {
					System.out.println(nome + " tem " + value + " vitória. A última vitória foi "
							+ gerenciadorPontuacao.getDataPontuacao(nome));
				}
			}
		} catch (PontuacaoException e) {
			throw new JogoDaVelhaException("Erro no jogo da velha", e);
		}
	}

}
