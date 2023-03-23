package Ej3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej3 {
	static String palabra;
	static int desplazamiento;
	static int opcion;
	static String codificacion;
	static String decodificacion;
	static final char abecedario[] = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
			'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static String Codificar() {
		for (int indicePalabra = 0; indicePalabra < palabra.length(); indicePalabra++) {
			char Caracter = palabra.charAt(indicePalabra);
			for (int indiceabc = 0; indiceabc < abecedario.length; indiceabc++) {
				if (Caracter == abecedario[indiceabc] && ((indiceabc + desplazamiento) < 27)) {
					if (indicePalabra == 0) {
						palabra = abecedario[indiceabc + desplazamiento]
								+ palabra.substring(indicePalabra + 1, palabra.length());
						codificacion = palabra;
					}
					if (indicePalabra > 0 && indicePalabra < (palabra.length() - 1)) {
						palabra = palabra.substring(0, indicePalabra) + abecedario[indiceabc + desplazamiento]
								+ palabra.substring(indicePalabra + 1, palabra.length());
						codificacion = palabra;
					}
					if (indicePalabra == (palabra.length() - 1)) {
						palabra = palabra.substring(0, indicePalabra) + abecedario[indiceabc + desplazamiento];
						codificacion = palabra;
					}
				}
			}
		}
		return codificacion;
	}

	public static String Decodificar() {
		for (int indicePalabra = 0; indicePalabra < palabra.length(); indicePalabra++) {
			char Caracter = palabra.charAt(indicePalabra);
			for (int indiceabc = 0; indiceabc < abecedario.length; indiceabc++) {
				if (Caracter == abecedario[indiceabc] && ((indiceabc - desplazamiento) >= 0)) {
					if (indicePalabra == 0) {
						palabra = abecedario[indiceabc - desplazamiento]
								+ palabra.substring(indicePalabra + 1, palabra.length());
						decodificacion = palabra;
					}
					if (indicePalabra > 0 && indicePalabra < (palabra.length() - 1)) {
						palabra = palabra.substring(0, indicePalabra) + abecedario[indiceabc - desplazamiento]
								+ palabra.substring(indicePalabra + 1, palabra.length());
						decodificacion = palabra;
					}
					if (indicePalabra == palabra.length() - 1) {
						palabra = palabra.substring(0, indicePalabra) + abecedario[indiceabc - desplazamiento];
						decodificacion = palabra;
					}
				}
			}
		}
		return decodificacion;
	}

	public static void main(String[] args) {
		String PathEntrada = "C:\\Users\\board\\Desktop\\Des. Java UTN\\RutaEj4\\Entrada.txt";
		String PathCodificado = "C:\\Users\\board\\Desktop\\Des. Java UTN\\RutaEj4\\Codificado.txt";
		String PathSalida = "C:\\Users\\board\\Desktop\\Des. Java UTN\\RutaEj4\\Salida.txt";

		System.out.println("Ingrese 1 para codificar o 2 para decodificar: ");
		Scanner opc = new Scanner(System.in);
		String opcionIngresada = opc.nextLine();
		opcion = Integer.parseInt(opcionIngresada);
		
		System.out.println("Ingrese un desplazamiento: ");
		Scanner despl = new Scanner(System.in);
		String desplIngresado = despl.nextLine();
		desplazamiento = Integer.parseInt(desplIngresado);
		
		try {
			if (opcion == 1) {
				for (String linea : Files.readAllLines(Paths.get(PathEntrada))) {
					palabra = linea;
				}

				Files.writeString(Paths.get(PathCodificado), Codificar());

			} else {
				for (String linea : Files.readAllLines(Paths.get(PathCodificado))) {
					palabra = linea;
				}

				Files.writeString(Paths.get(PathSalida), Decodificar());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
