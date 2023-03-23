package Ej2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ej2_a {

	public static void main(String[] args) {
		String tipoOp;
		String RutaArc = "C:\\Users\\board\\Desktop\\Des. Java UTN\\Rutas\\Numeros.txt";
		
		//para ingresar desde teclado y guardar la opcion
		System.out.println("Ingrese el 0 para suma, ingrese 1 para multiplicacion");
		Scanner entrada = new Scanner(System.in);		
		int opcion = Integer.parseInt(entrada.nextLine());
		
		if (opcion == 0 ) {
			tipoOp= "Suma";				
		}else {
			tipoOp="Multi";
		}
		
		LeerArchivos(RutaArc, tipoOp);
		

	}

	public static void LeerArchivos(String Path, String TipoOp) {
		int Suma = 0;
		int multi = 1;
		String ArrayNum[] = new String[10];
		try {

			for (String linea : Files.readAllLines(Paths.get(Path))) {
				System.out.println("Los numeros en el archivo son =\n" + linea + "\n");
				ArrayNum = linea.split(" ");
			}
			for (int i = 0; i < ArrayNum.length; i++) {
				if (TipoOp == "Suma") {
					Suma += Integer.parseInt(ArrayNum[i]);
				} else {
					multi *= Integer.parseInt(ArrayNum[i]);
				}
				;
			}
			if (TipoOp == "Suma") {
				System.out.println("La suma de estos numeros es: " + Suma);
			} else {
				System.out.println("La multiplicacion de estos numeros es:" + multi);
			}
			;
		} catch (IOException e) {
			// TODO Auto-generatod caach blok
			e.printStackTrace();
		}
	}
}