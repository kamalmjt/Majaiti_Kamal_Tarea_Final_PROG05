import java.util.ArrayList;
import java.util.Objects;

public class Dispositivo {
	private String codigo;
	private String nombre;
	private String tipo;
	// Almacena todas las sesiones del dispositivo al que pertenece el objeto una vez instanciado.
	private ArrayList<SesionUso> sesiones;
	
	public Dispositivo(String codigo, String nombre, String tipo) {
		this.codigo=codigo;
		this.nombre=nombre;
		this.tipo=tipo;
		this.sesiones=new ArrayList<SesionUso>();
		
	}
	
	public Dispositivo() {
		this.codigo="";
		this.nombre="";
		this.tipo="";
		this.sesiones=new ArrayList<SesionUso>();
		
	}
	
	public void registrarSesion(SesionUso Sesion) {
		if (this.sesiones.add(Sesion)) {
			System.out.println("Sesion registrada correctamente.");
		} else {
			System.out.println("Error interno al registrar la sesion.");
		};
	}
	
	// Media del consumo de todas las sesiones (si no hay sesiones, devuelve 0).
	public double mediaConsumo()  {
		double mediaConsumo=0;
		double consumoTotal=0;
		if(this.sesiones.size()==0) {
			return mediaConsumo;
		} else {
			for (SesionUso sesion : this.sesiones) {
				consumoTotal=consumoTotal+sesion.getConsumo();
			}
			mediaConsumo=consumoTotal / this.sesiones.size();
			
		}
		return mediaConsumo;
	}
	
	
	public double mediaTemperatura()  {
		double mediaTemperatura=0;
		double temperaturaTotal=0;
		if(this.sesiones.size()==0) {
			return mediaTemperatura;
		} else {
			for (SesionUso sesion : this.sesiones) {
				temperaturaTotal=temperaturaTotal+sesion.getTemperaturaMax();
			}
			mediaTemperatura=temperaturaTotal / this.sesiones.size();
			
		}
		return mediaTemperatura;
	}
	
	
	public double totalHorasUso() {
		double totalHoras=0;
		
		for (SesionUso sesion : this.sesiones) {
			totalHoras=totalHoras+sesion.getHoras();
		}
		
		return totalHoras;
	}
	
	public SesionUso sesionMayorConsumo() {
		SesionUso sesionMasConsumo=new SesionUso(0,0,0);
		if(this.sesiones.size()==0) {
			return sesionMasConsumo;
		} else {
			
			for (SesionUso sesion : this.sesiones) {
					// si la sesion guardada es de menor consumo guardamos la mayor.
					if(sesionMasConsumo.getConsumo() < sesion.getConsumo()) {
						sesionMasConsumo=sesion;
					}
				}
			}
		
		return sesionMasConsumo;
			
		}
	
	
	public void mostrarSesiones() {
		for (SesionUso sesion : this.sesiones) {
			
			System.out.println(sesion.toString());

			}
		}
	
	public String obtenerTxtSesiones() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n");
		int numSesion=0;
		for (SesionUso sesion : this.sesiones) {
			numSesion=numSesion+1;
			sb.append("\t Sesion "+numSesion+"ª: " + sesion.toString()+"\n");

			}
		return sb.toString();
		}


	@Override
	// Debe mostrar: código, nombre, tipo, total horas, media consumo y media temperatura.
	public String toString() {
		return "Datos del dispositivo:\n Codigo: " + codigo + "\n Nombre: " + nombre + "\n Tipo: " + tipo 
				+ "\n  Sesiones de uso:" + this.obtenerTxtSesiones();
	}
	
	public String obtenerCodigo()  {
		return this.codigo.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo, nombre, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(codigo, other.codigo) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tipo, other.tipo);
	}


	
	public boolean compararHorasUso(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Dispositivo other = (Dispositivo) obj;
		return Objects.equals(this.totalHorasUso(), other.totalHorasUso()) ;
	}


	

	
}
