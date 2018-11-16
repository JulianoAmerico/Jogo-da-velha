package juliano.jogodavelha.pontuacao;

/**
 * Interface que gerencia a pontua��o dos jogadores.
 * @author Juliano
 *
 */
public interface GerenciadorPontuacao {

	/**
	 * Retorna a pontua��o de um jogador.
	 * @param nome Nome do jogador, para buscar a pontua��o.
	 * @return Retorna a pontua��o do respectivo jogador.
	 * @throws PontuacaoException Lan�a exce��o se houver algum problema na busca
	 * da pontua��o.
	 */
	public Integer getPontuacao(String nome) throws PontuacaoException;
	
	/**
	 * Retorna data e hora da �ltima pontua��o do jogador.
	 * @param nome Nome do jgoador.
	 * @return Retorna a data e hora.
	 */
	public String getDataPontuacao(String nome);
	
	/**
	 * Grava a pontua��o do jogador, para ser recuperado eventualmente.
	 * @param nome Nome do jogador.
	 * @throws PontuacaoException Lan�a exce��o se houver algum problema
	 * na grava��o da pontua��o.
	 */
	public void gravarPontuacao(String nome) throws PontuacaoException;
	
}
