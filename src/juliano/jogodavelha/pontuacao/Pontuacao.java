package juliano.jogodavelha.pontuacao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa um registro de pontuação
 * 
 * @author Juliano
 *
 */
public class Pontuacao implements Comparable<Pontuacao> {

	/**
	 * Pontuação
	 */
	private int pontuacao;

	/**
	 * Data que foi feita a pontuação
	 */
	private LocalDateTime data;

	/**
	 * Construtor.
	 * 
	 * @param pontuacao Representa a pontuação
	 * @param data      Representa a data que foi realizada a pontuação
	 */
	public Pontuacao(int pontuacao, LocalDateTime data) {
		this.pontuacao = pontuacao;
		this.data = data;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public LocalDateTime getData() {
		return data;
	}

	/**
	 * Retorna data e hora como String e formatada
	 * 
	 * @return Retorna data e hora como String
	 */
	public String getDataAsString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return data.format(dtf);
	}

	@Override
	public int compareTo(Pontuacao o) {
		if (o == null) {
			return 0;
		}

		if (this.pontuacao > o.pontuacao) {
			return -1;
		} else {
			return 1;
		}
	}

}
