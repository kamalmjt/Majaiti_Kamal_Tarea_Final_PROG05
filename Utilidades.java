import java.util.regex.Matcher;
import java.util.regex.Pattern;
// Utilidades para validar la informacion que se introduce.
public class Utilidades {
	
	// Utilidades para validar informacion que introduce el usuario.
	
	// Regex para validar codigo de dispositivo.
	public static boolean validarStringNumerosYLetrasInsensibleMayus(String string) {	
		// Evitamos espacios al principio y al final.
		string = string.trim();
		/* Explicacion breve..
		^ indica el comienzo del String.
		Luego entre corchetes va el patron de caracteres aceptados 
		es sensible a mayusculas, minusculas.
		+ Indica minimo 1 vez.
		$ indica fin de String.
		 Agrego acentos porque fallan xd: áéíóúÁÉÍÓÚñÑ
		 Fuente: https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a-una-expresi%C3%B3n-delimitadora-de-caracteres
		*/
		Pattern patronRegex=Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex=patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}
	
	
	public static boolean validarStringSoloLetras(String string) {	
		/* Explicacion breve..
		^ indica el comienzo del String.
		Luego entre corchetes va el patron de caracteres aceptados 
		es sensible a mayusculas, minusculas.
		+ Indica minimo 1 vez.
		$ indica fin de String.
		Fuente de los acentos: https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a-una-expresi%C3%B3n-delimitadora-de-caracteres
		*/
		// Evitamos espacios al principio y al final.
		string = string.trim();
		Pattern patronRegex=Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex=patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}
	
	
	public static boolean validarDouble(Double numero) {	
		return (numero>0.0)?true:false; 
	}

	
}
