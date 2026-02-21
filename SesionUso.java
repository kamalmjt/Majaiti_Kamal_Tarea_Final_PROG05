
public class SesionUso {
	private double horas;
	private double consumo;
	private double temperaturaMax;
	
	public SesionUso(double horas, double consumo, double temperaturaMax) {
		super();
		this.horas = horas;
		this.consumo = consumo;
		this.temperaturaMax = temperaturaMax;
	}

	public double getHoras() {
		return horas;
	}

	private void setHoras(double horas) {
		this.horas = horas;
	}

	public double getConsumo() {
		return consumo;
	}

	private void setConsumo(double consumo) {
		this.consumo = consumo;
	}

	public double getTemperaturaMax() {
		return temperaturaMax;
	}

	private void setTemperaturaMax(double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}

	@Override
	public String toString() {
		// Montamos una String legible y amigable.
		StringBuilder sb= new StringBuilder();
		sb.append("\tHoras de uso: "+this.horas);
		sb.append("\tConsumo realizado: "+this.consumo+"%");
		sb.append("\tTemperatura maxima alcanzada: "+this.temperaturaMax+"º");
		return sb.toString();
	}
	
	
	
	
}
