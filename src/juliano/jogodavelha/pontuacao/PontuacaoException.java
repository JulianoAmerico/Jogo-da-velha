package juliano.jogodavelha.pontuacao;

@SuppressWarnings("serial")
public class PontuacaoException extends Exception {

	public PontuacaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PontuacaoException(String message) {
		super(message);
	}

	public PontuacaoException(Throwable cause) {
		super(cause);
	}	
}
