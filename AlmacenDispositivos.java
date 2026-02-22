import java.util.HashMap;;

public class AlmacenDispositivos {
	private Dispositivo[] inventario;
	private int contador;
	private HashMap<String, Dispositivo> indicePorCodigo = new HashMap<>();

	public AlmacenDispositivos() {
		super();
		this.inventario = new Dispositivo[30];
		this.contador = 0;
	}

	public boolean altaDispositivo(Dispositivo dispositivoNuevo) {
		boolean existeDispositivo = this.indicePorCodigo.containsKey(dispositivoNuevo.obtenerCodigo());
		if (contador >= 30 || existeDispositivo) {
			String mensajeError = "No se ha podido dar de alta el dispositivo porque ";
			mensajeError = (existeDispositivo) ? mensajeError + "el dispositivo ya existe."
					: mensajeError + " se ha alcanzado el maximo de dispositivos.";
			System.out.println(mensajeError);
			return false;
		} else {
			this.indicePorCodigo.put(dispositivoNuevo.obtenerCodigo(), dispositivoNuevo);
			this.inventario[this.contador] = dispositivoNuevo;
			this.contador = this.contador + 1;
			System.out.println("Dispositivo dato de alta correctamente.");
			return true;
		}
	}

	public Dispositivo buscarPorCodigo(String CodigoDispositivo) {
		Dispositivo dispositivo = null;
		dispositivo = this.indicePorCodigo.get(CodigoDispositivo);
		return dispositivo;

	}

	public void listarDispositivos() {
		int contador = 1;
		for (Dispositivo dispositivo : inventario) {
			if (dispositivo != null) {
				System.out.println(".....Dispostivo almacenado Nº " + contador + ".....");
				System.out.println(dispositivo.toString());
				contador = contador + 1;
			}

		}

	}

	public double mediaGlobalConsumo() {
		double mediaConsumo = 0.0;
		for (Dispositivo dispositivo : inventario) {
			if (dispositivo != null) {
				mediaConsumo = mediaConsumo + dispositivo.mediaConsumo();
			}

		}

		return mediaConsumo / this.indicePorCodigo.size();

	}

	public Dispositivo dispositivoMasUsado() {
		// Creamos un dispositivo vacio.
		Dispositivo dispositivoMasUsado = new Dispositivo();
		for (Dispositivo dispositivo : inventario) {

			if (dispositivo != null) {
				if ((dispositivoMasUsado.totalHorasUso() < dispositivo.totalHorasUso())) {
					dispositivoMasUsado = dispositivo;
				}
			}
		}

		return dispositivoMasUsado;
	}

	public boolean comprobarSiExisteDispositivo(String codigoDispositivo) {
		return this.indicePorCodigo.containsKey(codigoDispositivo);
	}

	public void registrarSesionUso(String CodigoDispositivo, SesionUso sesion) {
		this.indicePorCodigo.get(CodigoDispositivo).registrarSesion(sesion);
		System.out.println("Sesion del dispostivo registrada correctamente.");

	}

	public int obtenerTotalDispositivos() {
		return this.contador;
	}

}
