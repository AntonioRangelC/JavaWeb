package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	private Properties propriedades = new Properties();
	public void load(String arquivo) throws IllegalArgumentException{
		try {
			if(arquivo == null) {
				throw new IllegalArgumentException ("Nao foi possivel encontrar o arquivo" + arquivo);
			}
			InputStream str = this.getClass().getClassLoader().getResourceAsStream(arquivo);
			if(str == null) {
				throw new FileNotFoundException(
						"Nao foi possivel encontrar o arquivo " + arquivo);
				
			}
			propriedades.load(str);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	public String getValue(String chave) {
		return (String) propriedades.get(chave);
	}
}
