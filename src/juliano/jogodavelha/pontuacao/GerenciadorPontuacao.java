package juliano.jogodavelha.pontuacao;

/**
 * Interface que gerencia a pontuação dos jogadores.
 * @author Juliano
 *
 */
public interface GerenciadorPontuacao {

	/**
	 * Retorna a pontuação de um jogador.
	 * @param nome Nome do jogador, para buscar a pontuação.
	 * @return Retorna a pontuação do respectivo jogador.
	 * @throws PontuacaoException Lança exceção se houver algum problema na busca
	 * da pontuação.
	 */
	public Integer getPontuacao(String nome) throws PontuacaoException;
	
	/**
	 * Retorna data e hora da última pontuação do jogador.
	 * @param nome Nome do jgoador.
	 * @return Retorna a data e hora.
	 */
	public String getDataPontuacao(String nome);
	
	/**
	 * Grava a pontuação do jogador, para ser recuperado eventualmente.
	 * @param nome Nome do jogador.
	 * @throws PontuacaoException Lança exceção se houver algum problema
	 * na gravação da pontuação.
	 */
	public void gravarPontuacao(String nome) throws PontuacaoException;
	
}
