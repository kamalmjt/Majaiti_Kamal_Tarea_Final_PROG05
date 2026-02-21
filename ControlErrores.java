
public class ControlErrores {

	private boolean error;
	private String mensajeError;
	
	
	public ControlErrores(boolean error, String mensajeError) {
		this.error = error;
		this.mensajeError = mensajeError;
	}
	
	public boolean isError() {
		return error;
	}
	public String getMensaje() {
		return mensajeError;
	}
	
	
	
	
	
	
	
	
}
