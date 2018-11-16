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
 * Gerencia a pontua��o dos jogadores atrav�s de arquivos.
 * 
 * @author Juliano
 *
 */
public class GerenciadorPontuacaoArquivo implements GerenciadorPontuacao {

	/**
	 * Mapeia a pontua��o. A chave � o nome do jogador.
	 */
	private Map<String, Pontuacao> pontuacaoMap = new HashMap<>();

	/**
	 * Caminho do arquivo que armazena a pontuaca��o dos jogadores.
	 */
	private static final String ARQUIVO_PONTUACAO = "pontuacao.txt";

	/**
	 * Representa somente uma inst�ncia do gerenciador para toda a aplica��o.
	 */
	private static GerenciadorPontuacaoArquivo instance;

	/**
	 * Construtor. Executa a inicializa��o do gerenciador.
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
	 * Carrega as informa��es do arquivo de pontua��o. � inicializado na constru��o
	 * do objeto.
	 */
	private void inicializar() throws PontuacaoException {
		File file = new File(ARQUIVO_PONTUACAO);

		if (file.exists()) {
			try (Scanner sc = new Scanner(file)) {

				// Delimitador pode ser um espa�o ou virgula, que separa os elementos.
				sc.useDelimiter("([\\s,])+");

				/*
				 * Mapeia nome e pontua��o como chave e valor, respectivamente, para a cole��o
				 * Map. Esses dados s�o extr�idos do arquivo.
				 */
				while (sc.hasNext()) {
					String nome = sc.next();
					int pontuacao = sc.nextInt();
					String data = null;

					try {
						data = sc.next();

						// Concatena data e hora para manter o formato padr�o
						data += " " + sc.next();
					} catch (NoSuchElementException e) {
						//
					}

					// Formato padr�o
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					pontuacaoMap.put(nome, new Pontuacao(pontuacao, LocalDateTime.parse(data, formatter)));

				}

				// Termina a execu��o do m�todo
				return;

			} catch (FileNotFoundException e) {
				throw new PontuacaoException("Arquivo de pontua��o n�o encontrado", e);
			}
		}

		// Cria o arquivo de pontua��o, caso ele n�o exista.
		try {
			file.createNewFile();
		} catch (IOException e) {
			throw new PontuacaoException("Erro ao criar o arquivo de pontua��o", e);
		}
	}

	/**
	 * Se jogador tiver pontua��o, retorna a pontua��o do respectivo jogador, caso
	 * contr�rio retorna null.
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
	 * Grava as pontua��es na Cole��o map. Se o jogador j� tiver pontua��o, �
	 * incrementado a pontua��o atual, caso contr�rio cria o jogador na lista com
	 * pontua��o 1.
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

		// Salva o nome e a pontua��o dos jogadores no arquivo.
		try {
			gravarOuImprimir(new FileOutputStream(ARQUIVO_PONTUACAO));
		} catch (FileNotFoundException e) {
			throw new PontuacaoException("Erro ao gravar a pontua��o", e);
		}
	}

	/**
	 * Grava ou imprimi as pontu��es do jogador.
	 * 
	 * @param out Par�metro que determina se a pontua��o vai ser gravada no arquivo,
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
	 * Formata a string, com a primeira letra mai�scula e as restantes min�sculas
	 * 
	 * @param str String a ser formatada
	 * @return Retorna String formata
	 */
	public String primeiraLetraMaiuscula(String str) {
		return str.substring(0, 1).toUpperCase().concat(str.substring(1).toLowerCase());
	}

}
