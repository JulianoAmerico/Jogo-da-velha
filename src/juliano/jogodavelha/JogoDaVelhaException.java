package juliano.jogodavelha;

@SuppressWarnings("serial")
public class JogoDaVelhaException extends Exception {

	public JogoDaVelhaException(String message) {
		super(message);
	}

	public JogoDaVelhaException(Throwable cause) {
		super(cause);
	}

	public JogoDaVelhaException(String message, Throwable cause) {
		super(message, cause);
		
	}
}
