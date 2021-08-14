package util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile
{
    
    private Properties properties = new Properties();
    public void load(String arquivo) throws IllegalArgumentException {
        try {
            if (arquivo == null) {
                throw new IllegalArgumentException(
                        "Nome de arquivo inválido");
            }
            InputStream str = this.getClass().getClassLoader().getResourceAsStream(arquivo);
            if (str == null) {
                throw new FileNotFoundException(
                        "No foi possivel encontrar o arquivo '"+arquivo+"'");
            }
            properties.load(str);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getValue(String chave) {
        return (String) properties.get(chave);
    }
}
