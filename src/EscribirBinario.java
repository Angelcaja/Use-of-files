import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.crypto.Cipher;

public class EscribirBinario {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in); // Scanner
		// -----------------------------------------------------------------------------------
		String nombrePersona = "";
		String apellidoPersona = ""; // Datos para introducir en el fichero
		String nombreCiudad = "";
		String nacionalidadPersona = "";
		int edadPersona = 0;
		int i = 0; // variable contadora para el bucle for
		String fnombre = "";// variable para almacenar el nombre del fichero
		String fpath = "";// variable para almacenar el path del fichero
		String opcion = ""; // variable para almacenar la opcion a introducir
		String lectura = ""; // lectura del fichero
		String lecturaFichero; // lectura total del buffer del fichero
		String edadPersonas ="";
		int numeroPersonas = 0;
		// -----------------------------------------------------------------------------------
		FileWriter fw = null; // clases de escritura
		PrintWriter pw = null;
		// -----------------------------------------------------------------------------------
		// -----------------------------------------------------------------------------------
		FileReader fr = null; // clases de Lectura
		BufferedReader br = null;
		// -----------------------------------------------------------------------------------
		File fichero = new File("fichero.txt"); // declaracion del fichero en el que trabajaremos
		System.out.print("- Introduzca 'E' para escribir un fichero " + "\n" + "Introduca 'L' para leer un fichero"
				+ "\n" + "Introduca 'B' para escribir un fichero binario: ");
		opcion = input.nextLine();
		try {

			if (opcion.equals("l") || opcion.equals("L")) {

				System.out.print("Introduzca el nombre del fichero donde quiere leer: ");
				fnombre = input.nextLine();
				System.out.print("Introduzca el path del fichero donde quiere leer: ");
				fpath = input.nextLine();

				if (fnombre.equals(fichero.getName()) || fpath.equals(fichero.getPath())) {
					System.out.println("¿Desea leer todo el archivo o solo un nombre concreto?");
					System.out.println(" 1 - Todo");
					System.out.println(" 2 - Nombre");
					System.out.print("Pulse: ");
					opcion = input.nextLine();
					if (opcion.equals("1") && fichero.exists()) {
						fr = new FileReader(fichero);
						br = new BufferedReader(fr);
						while (!((lecturaFichero = br.readLine()) == null)) {
							lectura += lecturaFichero + "\n";
						}
						br.close();
						fr.close();
						System.out.println("El contenido del fichero completo es: " + "\n" + lectura);

					} else if (opcion.equals("2") && fichero.exists()) {
						System.out.print("Introduzca el nombre de la persona: ");
						nombrePersona = input.nextLine();
						try {
							fr = new FileReader(fichero);
							br = new BufferedReader(fr);
							while (!((lecturaFichero = br.readLine()) == null)) {
								if (lecturaFichero.contains(nombrePersona)) {
									System.out.println(lecturaFichero);
								}
							}
							br.close();
							fr.close();
						} catch (Exception e) {
							System.err.println("se ha producido un error");
						}
					}

				} else {
					System.err.println("\n" + "El valor introducido no es valido");

				}
			}
		} catch (Exception e) {

		}
		if (opcion.equals("e") || opcion.equals("E")) {
			try {
				System.out.print("Introduzca el nombre del fichero donde quiere trabajar: ");
				fnombre = input.nextLine();
				System.out.print("Introduzca el path del fichero donde quiere trabajar: ");
				fpath = input.nextLine();

				if (fpath.equals(fichero.getPath())) {
					System.out
							.print("Introduzca A para añadir informacion al final o S para sobrescribir el fichero: ");
					opcion = input.nextLine();
				} else {
					System.err.println("El path es inexistente");
					File fichero2 = new File(fpath);
					fw = new FileWriter(fichero2);
					fw.close();
					System.out.println(
							"Hemos creado un nuevo fichero con la ruta introducida, por favor reinicie el programa.");
					System.exit(0);
				}
				if (opcion.equals("a") || opcion.equals("A") || opcion.equals("s") || opcion.equals("S")) {
					for (i = 0; i < 3; i++) {

						System.out.print("Introduzca nombre de la persona a introducir: ");
						nombrePersona = input.nextLine();
						System.out.print("Introduzca apellido de la persona a introducir: ");
						apellidoPersona = input.nextLine();
						System.out.print("Introduzca la ciudad de la persona a introducir: ");
						nombreCiudad = input.nextLine();
						System.out.print("Introduzca la nacionalidad de la persona a introducir: ");
						nacionalidadPersona = input.nextLine();
						System.out.print("Introduzca la edad de la persona a introducir: ");
						edadPersona = Integer.parseInt(input.nextLine());

						if (opcion.equals("a") || opcion.equals("A")) {
							fw = new FileWriter(fichero, true);
							pw = new PrintWriter(fw);
							pw.println(nombrePersona + "-" + " -" + apellidoPersona + "-" + " -" + nombreCiudad + "-"
									+ " -" + nacionalidadPersona + "" + " -" + edadPersona);
							pw.close();
							fw.close();
							System.out.println("\n" + "La persona " + (i + 1)
									+ " se ha  añadido al fichero correctamente." + "\n");
						} else if (opcion.equals("s") || opcion.equals("S")) {
							fw = new FileWriter(fichero);
							pw = new PrintWriter(fw);
							pw.println(nombrePersona + "-" + " -" + apellidoPersona + "-" + " -" + nombreCiudad + "-"
									+ " -" + nacionalidadPersona + "-" + " -" + edadPersona);
							pw.close();
							fw.close();
							System.out.println("\n" + "El fichero se ha sobrescrito con la persona introducida");
							break;
						}
					}

				} else {
					System.err.println("ha introducido un valor erroneo");
				}
			} catch (Exception e) {

				// TODO: handle exception
			}
		}
		if (opcion.equals("b") || opcion.equals("B")) {
			System.out.print("Introduzca el nombre del fichero donde quiere trabajar: ");
			fnombre = input.nextLine();
			System.out.print("Introduzca el path del fichero donde quiere trabajar: ");
			fpath = input.nextLine();
			if (fpath.equals(fichero.getPath())) {

				System.out.print("Introduce el numero de personas que quiere escribir (maximo 3): ");
				numeroPersonas = input.nextInt();
				 
				if ((numeroPersonas > 0) && (numeroPersonas <= 3)) {
					FileOutputStream fileout = new FileOutputStream(fichero); //crea flujo de salida hacia el fichero 
					for (int n = 0; numeroPersonas > n; n++) { //bucle para no superar el máximo de 3 personas
						
						input.nextLine();
						System.out.print("Introduzca nombre de la persona a introducir: ");
						nombrePersona = input.nextLine();
						System.out.print("Introduzca apellido de la persona a introducir: ");
						apellidoPersona = input.nextLine();
						System.out.print("Introduzca la ciudad de la persona a introducir: ");
						nombreCiudad = input.nextLine();
						System.out.print("Introduzca la nacionalidad de la persona a introducir: ");
						nacionalidadPersona = input.nextLine();
						System.out.print("Introduzca la edad de la persona a introducir: ");
						edadPersonas = input.nextLine();
						 
						 //almaceno todo en un String para inyectarlo de una unica entrada
						String todo = nombrePersona + "\n" + apellidoPersona + "\n" + nombreCiudad + "\n" + nacionalidadPersona + "\n" + edadPersonas;
						fileout.write(todo.getBytes()); //pinto dentro del fichero
						fileout.close(); 
						
						System.out.println("Se han sobrescrito los datos del fichero pulse enter para continuar.");
						
					}
					fileout.close(); //cierro el fichero
				}
			} else {
				System.err.println("El path es inexistente");
				File fichero2 = new File(fpath);
				fw = new FileWriter(fichero2);
				fw.close();
				System.out.println(
						"Hemos creado un nuevo fichero con la ruta introducida, por favor reinicie el programa.");
				System.exit(0);
			}

		}
	}
}
