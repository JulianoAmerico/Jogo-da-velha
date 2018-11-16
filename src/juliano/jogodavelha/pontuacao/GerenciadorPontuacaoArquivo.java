package juliano.jogodavelha.pontuacao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/**
 * Gerencia a pontuação dos jogadores através de arquivos.
 * 
 * @author Juliano
 *
 */
public class GerenciadorPontuacaoArquivo implements GerenciadorPontuacao {

	/**
	 * Mapeia a pontuação. A chave é o nome do jogador.
	 */
	private Map<String, Pontuacao> pontuacaoMap = new HashMap<>();

	/**
	 * Caminho do arquivo que armazena a pontuacação dos jogadores.
	 */
	private static final String ARQUIVO_PONTUACAO = "pontuacao.txt";

	/**
	 * Representa somente uma instância do gerenciador para toda a aplicação.
	 */
	private static GerenciadorPontuacaoArquivo instance;

	/**
	 * Construtor. Executa a inicialização do gerenciador.
	 * 
	 * @throws PontuacaoException
	 */
	public GerenciadorPontuacaoArquivo() throws PontuacaoException {
		inicializar();
	}

	public static GerenciadorPontuacaoArquivo getInstance() throws PontuacaoException {
		if (instance == null) {
			instance = new GerenciadorPontuacaoArquivo();
		}

		return instance;
	}

	/**
	 * Carrega as informações do arquivo de pontuação. É inicializado na construção
	 * do objeto.
	 */
	private void inicializar() throws PontuacaoException {
		File file = new File(ARQUIVO_PONTUACAO);

		if (file.exists()) {
			try (Scanner sc = new Scanner(file)) {

				// Delimitador pode ser um espaço ou virgula, que separa os elementos.
				sc.useDelimiter("([\\s,])+");

				/*
				 * Mapeia nome e pontuação como chave e valor, respectivamente, para a coleção
				 * Map. Esses dados são extráidos do arquivo.
				 */
				while (sc.hasNext()) {
					String nome = sc.next();
					int pontuacao = sc.nextInt();
					String data = null;

					try {
						data = sc.next();

						// Concatena data e hora para manter o formato padrão
						data += " " + sc.next();
					} catch (NoSuchElementException e) {
						//
					}

					// Formato padrão
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					pontuacaoMap.put(nome, new Pontuacao(pontuacao, LocalDateTime.parse(data, formatter)));

				}

				// Termina a execução do método
				return;

			} catch (FileNotFoundException e) {
				throw new PontuacaoException("Arquivo de pontuação não encontrado", e);
			}
		}

		// Cria o arquivo de pontuação, caso ele não exista.
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new PontuacaoException("Erro ao criar o arquivo de pontuação", e);
		}
	}

	/**
	 * Se jogador tiver pontuação, retorna a pontuação do respectivo jogador, caso
	 * contrário retorna null.
	 */
	@Override
	public Integer getPontuacao(String nome) {
		// Formata o nome.
		nome = primeiraLetraMaiuscula(nome);

		if (pontuacaoMap.containsKey(nome)) {
			Pontuacao pontuacao = pontuacaoMap.get(nome);
			return pontuacao.getPontuacao();
		}

		return 0;
	}
	
	@Override
	public String getDataPontuacao(String nome) {
		nome = primeiraLetraMaiuscula(nome);
		
		if(pontuacaoMap.containsKey(nome)) {
			Pontuacao pontuacao = pontuacaoMap.get(nome);
			return pontuacao.getDataAsString();
		}
		
		return "";
	}

	/**
	 * Grava as pontuações na Coleção map. Se o jogador já tiver pontuação, é
	 * incrementado a pontuação atual, caso contrário cria o jogador na lista com
	 * pontuação 1.
	 * 
	 */
	@Override
	public void gravarPontuacao(String nome) throws PontuacaoException {
		nome = primeiraLetraMaiuscula(nome);

		Pontuacao pontuacao = null;
		LocalDateTime dataHoraAtual = LocalDateTime.now();

		Integer value = getPontuacao(nome);

		value++;

		pontuacao = new Pontuacao(value, dataHoraAtual);
		pontuacaoMap.put(nome, pontuacao);

		// Salva o nome e a pontuação dos jogadores no arquivo.
		try {
			gravarOuImprimir(new FileOutputStream(ARQUIVO_PONTUACAO));
		} catch (FileNotFoundException e) {
			throw new PontuacaoException("Erro ao gravar a pontuação", e);
		}
	}

	/**
	 * Grava ou imprimi as pontuções do jogador.
	 * 
	 * @param out Parâmetro que determina se a pontuação vai ser gravada no arquivo,
	 *            ou impresso no Console.
	 */
	public void gravarOuImprimir(OutputStream out) {
		try (PrintWriter printWriter = new PrintWriter(out)) {
			Set<Entry<String, Pontuacao>> set = pontuacaoMap.entrySet();

			for (Entry<String, Pontuacao> entry : set) {
				String nome = entry.getKey();
				Pontuacao pontuacao = entry.getValue();

				// Escreve os dados
				printWriter.println(primeiraLetraMaiuscula(nome) + ", " + pontuacao.getPontuacao() + ", "
						+ pontuacao.getDataAsString());
			}
		}
	}

	/**
	 * Formata a string, com a primeira letra maiúscula e as restantes minúsculas
	 * 
	 * @param str String a ser formatada
	 * @return Retorna String formata
	 */
	public String primeiraLetraMaiuscula(String str) {
		return str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase());
	}

}
