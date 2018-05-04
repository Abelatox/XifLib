package xiflib;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe principal de la llibreria per xifrar la qual implementa una interfície
 * 
 * @author Abel i Marc
 */
public class XifLib implements IXifrar {

	/**
	 * Mètode principal de la classe
	 * 
	 * @param in Arxiu d'entrada
	 * @param out Arxiu de sortida
	 */
	@Override
	public void xifrar(File in, File out) {
		FileReader fr;
		try {
			fr = new FileReader(in);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(out);

			StringBuffer strBuffer = new StringBuffer("");
			while (fr.ready()) {
				strBuffer.append(xifra(fr.read()));
			}

			System.out.print(strBuffer);
			fw.write(strBuffer.toString());
			fw.flush();

			fw.close();
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Funció auxiliar per fer el xifratge d'un caràcter
	 * 
	 * @param input
	 * @return caràcter xifrat
	 */
	private char xifra(int input) {
		double primer = 0, ultim = 127;
		if (input >= primer && input <= ultim) {
			double meitatabsoluta = (primer + (ultim - primer) / 2);
			return (char) ((meitatabsoluta - input) + (meitatabsoluta));
		}
		return (char) input;
	}

	/**
	 * Funció per xifrar una string
	 * 
	 * @param in String a xifrar
	 * @return La String xifrada
	 */
	@Override
	public String xifrar(String in) {
		StringBuffer str = new StringBuffer();
		for(int i=0;i<in.length();i++) {
			str.append(xifra(in.charAt(i)));
		}
		return str.toString();
	}
}
