package juliano.jogodavelha;

@SuppressWarnings("serial")
public class JogadaInvalidaException extends JogoDaVelhaException {

	public JogadaInvalidaException(String message) {
		super(message);
	}

	public JogadaInvalidaException(Throwable cause) {
		super(cause);
	}

	public JogadaInvalidaException(String message, Throwable cause) {
		super(message, cause);
		
	}

}
