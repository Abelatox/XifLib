package xiflib;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe principal de la llibreria per xifrar la qual implement una interfície
 * @author Abel
 */
public class XifLib implements IXifrar{

	/**
	 * Mètode principal de la classe
	 */
	@Override
	public void xifrar(File in, File out) {
		FileReader fr; 
		try {
			fr = new FileReader(in);
			BufferedReader br = new BufferedReader(fr);
			FileWriter fw = new FileWriter(out);

			String str = "";
			while(fr.ready()) {
				str += xifra(fr.read());
			}
			
			System.out.print(str);
			fw.write(str);
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
	 * @param input
	 * @return
	 */
	private char xifra(int input) {
		double primer = 0, ultim = 127;
		if(input >= primer && input <= ultim) {
			double meitatabsoluta = (primer + (ultim - primer) / 2);
			return (char) ((meitatabsoluta - input) + (meitatabsoluta));
		}
		return (char)input;
	}
}
