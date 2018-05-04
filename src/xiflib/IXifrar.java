package xiflib;
import java.io.File;

/**
 * Interfície per la llibreria de xifrar
 * @author Abel i Marc
 */
public interface IXifrar {
	/**
	 * Xifra un arxiu i el guarda en un altre
	 * @param in Arxiu d'entrada
	 * @param out Arxiu xifrat
	 */
	public void xifrar(File in, File out);
	
	/**
	 * Xifra/Desxifra i retorna una String
	 * @param in String a xifrar/desxifrar
	 * @return String Xifrada/Desxifrada
	 */
	public String xifrar(String in);
}
