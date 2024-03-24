
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribirFicheros {

	public static void main(String[] args)throws IOException {

		
		Scanner input = new Scanner(System.in);		//Scanner
		// -----------------------------------------------------------------------------------
		String nombrePersona = "";
		String apellidoPersona = "";			//Datos para introducir en el fichero
		String nombreCiudad = "";
		String nacionalidadPersona = "";
		int edadPersona = 0;
		int i = 0; // variable contadora para el bucle for
		String fnombre = "";// variable para almacenar el nombre del fichero
		String fpath = "";// variable para almacenar el psth del fichero
		String opcion = ""; // variable para almacenar la opcion a introducir
		// -----------------------------------------------------------------------------------
		FileWriter fw = null; // clases de escritura
		PrintWriter pw = null;
		// -----------------------------------------------------------------------------------
		File fichero = new File("fichero.txt"); // declaracion del fichero en el que trabajaremos

		try {
			System.out.print("Introduzca el nombre del fichero donde quiere trabajar: ");
			fnombre = input.nextLine();
			System.out.print("Introduzca el path del fichero donde quiere trabajar: ");
			fpath = input.nextLine();

			if (fpath.equals(fichero.getPath())) {  //comprobaremos que la dirección es correcta al fichero creado anteriormente
				System.out.print("Introduzca A para añadir informacion al final o S para sobrescribir el fichero: ");
				opcion = input.nextLine();
			} else {
				System.err.println("El path es inexistente");
				File fichero2 = new File(fpath);
				fw = new FileWriter(fichero2);		//creamos el fichero en caso de no ser el que teníamos creado anteriormente
				fw.close();
				System.out.println("Hemos creado un nuevo fichero con la ruta introducida, por favor reinicie el programa.");
				System.exit(0);		//tras crear el fichero cerrramos el programa
			}
			if (opcion.equals("a") || opcion.equals("A") || opcion.equals("s") || opcion.equals("S")) { //en caso deutilizar una de las dos opciones válidas
				for (i = 0; i < 3; i++) {	//opto por for para obligar a que sea solo 3 personas	|	  empezamos a pedir datos al usuario

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
						fw = new FileWriter(fichero, true);		//utilizando el ,true ordenamos que respete el texto ya escrito y añada a continuacion el siguiente
						pw = new PrintWriter(fw);  //creamos el flujo de entrada de escritura en el fichero
						pw.println("Persona " + (i + 1) + "\n" + " -" + nombrePersona + "\n" + " -" + apellidoPersona
								+ "\n" + " -" + nombreCiudad + "\n" + " -" + nacionalidadPersona + "\n" + " -"
								+ edadPersona);
						pw.close();
						fw.close();
						System.out.println("\n" + "La persona " + (i + 1) + " se ha  añadido al fichero correctamente." + "\n");
					} else if (opcion.equals("s") || opcion.equals("S")) {
						fw = new FileWriter(fichero);		//al no utilizar el ,true inmediatamente sobreescribe el texto que había escrito
						pw = new PrintWriter(fw);
						pw.println("Persona " + (i + 1) + "\n" + " -" + nombrePersona + "\n" + " -" + apellidoPersona
								+ "\n" + " -" + nombreCiudad + "\n" + " -" + nacionalidadPersona + "\n" + " -"
								+ edadPersona);
						pw.close();
						fw.close();
						System.out.println("\n" + "El fichero se ha sobrescrito con la persona introducida");
						break;
					}
				}

			} else {
				System.err.println("\n" + "El valor introducido no es valido");  //en el caso de no introducir a,A o s,S nos 
			}																	//manda este mensaje y finaliza el programa
		} catch (Exception e) {
			System.err.println("se ha producido un error en el sistema"); //en caso de falla en try nos devolverá este mensaje de error

		}
	}

}
