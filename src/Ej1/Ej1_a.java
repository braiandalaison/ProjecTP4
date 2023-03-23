package Ej1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ej1_a {
	static Integer numeros[] = new Integer[3];
	static char orden;// a asc, b desc


	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			Scanner entrada = new Scanner(System.in);
			System.out.println("Ingrese el " + (i + 1) + "° numero: ");
			String num = entrada.nextLine();
			numeros[i] = Integer.parseInt(num);
		}

		Scanner entradaOrden = new Scanner(System.in);
		System.out.println("Ingrese a para orden ascendente " 
		+ "o b para orden descendente");
		String num = entradaOrden.nextLine();
		orden = num.charAt(0);

		System.out.println("Los numeros ingresados son: ");
		for (int i = 0; i < 3; i++) {
			System.out.println(numeros[i]);
		}
		if (orden == 'a') {
			System.out.println("El arreglo en orden ascendente es : ");
			Arrays.sort(numeros);
		} else {
			System.out.println("El arreglo en orden descendente es : ");
			Arrays.sort(numeros, Collections.reverseOrder());
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(numeros[i]);
		}

	}

}
