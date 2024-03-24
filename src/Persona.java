import java.io.IOException;
import java.util.Scanner;

public class Persona { // Declaro la clase persona


		//Atributos vacíos de tipo private para que no se puedan modificar fuera de esta clase
		private String nombre;
		private String apellido;
		private String ciudad;
		private String nacionalidad;
		private int edad;
		
		
		//contructor sobrecargado para darle valor a los atributos 
		
		public Persona(String nombre, String apellido, String ciudad, String nacionalidad, int edad) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.ciudad = ciudad;
			this.nacionalidad = nacionalidad;
			this.edad = edad;
		}
	
		public String infoPersona() {	// Funcion para mostrar la información por pantalla de cada perosna 
			String infor = "";
			infor += "-Nombre: " + this.nombre + "\n";
			infor += "-Apellido: " + this.apellido + "\n";
			infor += "-Ciudad: " + this.ciudad + "\n";
			infor += "-Nacionalidad: " + this.nacionalidad + "\n";
			infor += "-Edad: " + this.edad + "\n";
			return infor;
		}
		// Getters y setters

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCiudad() {
			return ciudad;
		}

		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}

		public String getNacionalidad() {
			return nacionalidad;
		}

		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		public int getEdad() {
			return edad;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

	
	public static void main(String[] args) throws IOException{ //Clase main donde trabajaremos creando objetos de la clase Persona
		
		Scanner input = new Scanner(System.in); //Scanner para almacenar los datos introducidos
		String nombrePersona = "";
		String apellidoPersona = "";
		String nombreCiudad = "";
		String nacionalidadPersona = "";
		int edadPersona = 0;
		
		
		// MENU
		
		Persona[] persona = new Persona[3]; //creo un array list para simplificar el programa con un bucle for limitandolo a 3 personas como dice el ejercicio
		try {
			
		for (int i=0 ; i < 3 ; i++) { //En este paso iremos añadiendo el numero de persona por cada vez que se aplique el bucle y 
										//crearemos un nuevo objeto persona cada vez que este se reproduzca
			
		System.out.print("Introduzca nombre de la persona a crear: ");
		nombrePersona = input.nextLine();
		System.out.print("Introduzca apellido de la persona a crear: ");
		apellidoPersona = input.nextLine();
		System.out.print("Introduzca la ciudad de la persona a crear: ");
		nombreCiudad = input.nextLine();
		System.out.print("Introduzca la nacionalidad de la persona a crear: ");
		nacionalidadPersona = input.nextLine();
		System.out.print("Introduzca la edad de la persona a crear: ");
		edadPersona = Integer.parseInt(input.nextLine());// no utilizo nextInt para no tener que vaciar el scanner después de usarlo.
		
		//Istanciamos las personas y las imprimimos llamando a la funcion infoPersona()
		persona[i] = new Persona(nombrePersona,apellidoPersona,nombreCiudad,nacionalidadPersona,edadPersona);
		System.out.println("\n" + persona[i].infoPersona());
		}
		} catch (Exception e) {
			System.out.println("El valor introducido no es valido" + "\n" + "Cerrando el programa");
		}
		
	}

}
