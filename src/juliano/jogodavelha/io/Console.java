package juliano.jogodavelha.io;

import java.util.Scanner;

/**
 * Classe que representa o Console.
 * @author Juliano
 *
 */
public class Console {

	/**
	 * L� a String digitada no console.
	 * @return Retorna a String lida.
	 */
	public static String readString() {
		return scanner().next();
	}
	
	/**
	 * L� o inteiro digitado no console.
	 * @return Retorna o inteiro lido.
	 */
	public static int readInt() {
		return scanner().nextInt();
	}
	
	/**
	 * L� o double digitado no console.
	 * @return Retorna o double lido.
	 */
	public static double readDouble() {
		return scanner().nextDouble();
	}
	
	/*
	 * L� os dados escritos no console.
	 */
	private static Scanner scanner() {
		Scanner sc = new Scanner(System.in);
		return sc;
	}	
}
