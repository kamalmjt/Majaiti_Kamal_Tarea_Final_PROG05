import java.util.Scanner;

public class Principal {

	private static AlmacenDispositivos dispositivos = new AlmacenDispositivos();
	private static Scanner sc = new Scanner(System.in);

	// metodo principal
	public static void main(String[] args) {
		Principal.inicio();
	}

	// Clase estatica que implementa el menú Inicio.
	private static void inicio() {

		System.out.println("1. Dar de alta un dispositivo.");
		System.out.println("2. Registrar sesión de uso en un dispositivo.");
		System.out.println("3. Mostrar información de un dispositivo.");
		System.out.println("4. Listar todos los dispositivos.");
		System.out.println("5. Mostrar estadisticas globales.");
		System.out.println("6. Salir.");
		System.out.print("Elige una opcion (1-6):");
		int opcion = Principal.leerInteger();

		switch (opcion) {

		case 1:
			Principal.altaDispositivo();
			Principal.inicio();
			break;

		case 2:
			Principal.registrarSesionDispositivo();
			Principal.inicio();
			break;

		case 3:
			Principal.mostrarInformacionDispositivo();
			Principal.inicio();
			break;

		case 4:
			Principal.mostrarTodosLosDispositivos();
			Principal.inicio();
			break;
		case 5:
			Principal.mostrarEstatisticasGlobales();
			Principal.inicio();
			break;

		// Salir.
		case 6:
			System.out.println("Saliendo del programa....");
			// Volvemos al metodo main y fin.
			System.exit(0);

		default:
			System.out.println("Opcion no valida...");
			Principal.pausarInteracion();
			Principal.inicio();

		}
	}

	private static void mostrarTodosLosDispositivos() {
		System.out.println(" ............ Listado de Dispositivos ............");
		if (dispositivos.obtenerTotalDispositivos() != 0) {
			dispositivos.listarDispositivos();
		} else {
			System.out.println("Actualmente no hay ningun dispositivo registrado en el sistema.");
		}
		Principal.pausarInteracion();
		Principal.inicio();

	}

	public static int leerInteger() {
		int numObtenido = 0;
		try {
			numObtenido = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Error al intentar leer el valor numerico.\nError: " + e);
		}

		return numObtenido;
	}

	private static void altaDispositivo() {
		System.out.println("............ Alta de nuevo dispositivo ............");
		System.out.print("Dime el codigo de dispositivo:");
		String codigo = Principal.validarDato("codigo", sc.nextLine());

		// Comprobar si existe el dispositivo para evitar seguir pidiendo datos....
		if (dispositivos.comprobarSiExisteDispositivo(codigo)) {
			System.out.println("El dispositivo que intentas dar de alta ya existe, intentalo de nuevo.");
			Principal.pausarInteracion();
			Principal.altaDispositivo();
		}
		// Si no existe continuamos con el proceso de alta.
		System.out.print("Dime el nombre del dispositivo:");
		String nombre = Principal.validarDato("nombre", sc.nextLine());

		System.out.print("Dime el tipo de dispositivo:");
		String tipo = Principal.validarDato("tipo", sc.nextLine());
		Dispositivo dispositivoNuevo = new Dispositivo(codigo, nombre, tipo);
		boolean altaDispositivo = dispositivos.altaDispositivo(dispositivoNuevo);

		if (!altaDispositivo) {
			System.out.println("Hubo un error al intentar dar de alta el dispositivo, intentalo de nuevo.");
		}
		Principal.pausarInteracion();
		Principal.inicio();

	};

	private static void registrarSesionDispositivo() {

		System.out.println("............ Registrar sesión de dispositivo ............");
		System.out.print("Dime el codigo de dispositivo (no vacio): ");
		String codigo = Principal.validarDato("codigo", sc.nextLine());

		// Comprobar si existe el dispositivo para evitar seguir pidiendo datos....
		if (dispositivos.comprobarSiExisteDispositivo(codigo)) {
			double horasUso = 0;
			double consumoBateria = 0;
			double temperaturaMaxima = 0;
			horasUso = obtenerValorDouble("Las horas de uso introducidas no son validas",
					"Dime las horas de uso (> 0): ", horasUso);
			consumoBateria = obtenerValorDouble("El consumo de bateria introducido no es valido.",
					"Dime el % de consumo de bateria realizado (> 0): ", consumoBateria);
			temperaturaMaxima = obtenerValorDouble("La temperatura del dispositivo alcanzada, no es valida.",
					"Dime la temperatura maxima del dispositivo (> 0º): ", temperaturaMaxima);
			SesionUso sesionDispositivo = new SesionUso(horasUso, consumoBateria, temperaturaMaxima);
			dispositivos.registrarSesionUso(codigo, sesionDispositivo);
		} else {
			System.out.println(
					"El dispositivo con el que intentas registrar una sesion de uso no existe, intentalo de nuevo.");
		}
		Principal.pausarInteracion();
		Principal.inicio();

	}

	private static void mostrarInformacionDispositivo() {
		System.out.println("............ Mostrar Informacion de dispositivo ............");
		System.out.print("Dime el codigo de dispositivo (no vacio): ");
		String codigo = Principal.validarDato("codigo", sc.nextLine());

		// Comprobar si existe el dispositivo para evitar seguir pidiendo datos....
		if (dispositivos.comprobarSiExisteDispositivo(codigo)) {
			Dispositivo dispositivo = dispositivos.buscarPorCodigo(codigo);
			System.out.println(dispositivo.toString());
		} else {
			System.out.println(
					"El dispositivo con el que intentas registrar una sesion de uso no existe, intentalo de nuevo.");
		}
		Principal.pausarInteracion();
		Principal.inicio();

	}

	private static void mostrarEstatisticasGlobales() {
		System.out.println("............ Mostrar estadisticas globales ............");
		if (dispositivos.obtenerTotalDispositivos() != 0) {
			System.out.println("Media de consumo global: " + dispositivos.mediaGlobalConsumo());
			Dispositivo dispositivoVacio = new Dispositivo();
			Dispositivo dispositivoMasUsado = dispositivos.dispositivoMasUsado();
			if (!dispositivoMasUsado.compararHorasUso(dispositivoVacio)) {
				System.out.println("Datos del dispositivo mas usado:" + dispositivos.dispositivoMasUsado().toString());
			} else {
				System.out.println("Actualmente no se ha realizado el uso de ningun dispositivo.");
			}

		} else {
			System.out.println("Actualmente no hay ningun dispositivo registrado en el sistema.");
		}
		Principal.pausarInteracion();

	}

	public static String validarDato(String complementoMensaje, String datoDispositivo) {

		while (Utilidades.validarStringNumerosYLetrasInsensibleMayus(datoDispositivo) == false) {
			System.out.println("El " + complementoMensaje + " de dispositivo introducido no es valido.");
			System.out.print("Dime un " + complementoMensaje + " de dispositivo valido [a-zA-Z0-9]: ");
			datoDispositivo = sc.nextLine();
		}
		return datoDispositivo;
	}

	public static void pausarInteracion() {
		System.out.print("Pulsa intro para continuar....");
		sc.nextLine();
	}

	public static double leerDouble() {
		double numObtenido = 0;
		try {
			numObtenido = Double.parseDouble(sc.nextLine());
		} catch (Exception e) {
			System.out.println("Error al intentar leer el valor numerico.\nError: " + e);
		}

		return numObtenido;
	}

	public static double obtenerValorDouble(String mensajeError, String MensajePedirDato, Double datoDouble) {

		System.out.print(MensajePedirDato);
		datoDouble = Principal.leerDouble();

		while (Utilidades.validarDouble(datoDouble) == false) {
			System.out.println(mensajeError);
			System.out.print(MensajePedirDato);
			datoDouble = Principal.leerDouble();
		}
		return datoDouble;
	}

}
