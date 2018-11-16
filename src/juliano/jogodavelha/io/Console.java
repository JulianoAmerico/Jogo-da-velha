package juliano.jogodavelha.io;

import java.util.Scanner;

/**
 * Classe que representa o Console.
 * @author Juliano
 *
 */
public class Console {

	/**
	 * Lê a String digitada no console.
	 * @return Retorna a String lida.
	 */
	public static String readString() {
		return scanner().next();
	}
	
	/**
	 * Lê o inteiro digitado no console.
	 * @return Retorna o inteiro lido.
	 */
	public static int readInt() {
		return scanner().nextInt();
	}
	
	/**
	 * Lê o double digitado no console.
	 * @return Retorna o double lido.
	 */
	public static double readDouble() {
		return scanner().nextDouble();
	}
	
	/*
	 * Lê os dados escritos no console.
	 */
	private static Scanner scanner() {
		Scanner sc = new Scanner(System.in);
		return sc;
	}	
}
