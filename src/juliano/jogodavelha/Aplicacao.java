package juliano.jogodavelha;

import juliano.jogodavelha.pontuacao.PontuacaoException;

public class Aplicacao {

	public static void main(String[] args) throws PontuacaoException, JogoDaVelhaException {
		Jogo jogo = new Jogo();
		
		jogo.jogar();
	}
}
