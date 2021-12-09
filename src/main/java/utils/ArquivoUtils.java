package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ArquivoUtils {
    public static String getPropriedades (String propriedade) throws IOException {
        Properties propriedades = new Properties();
        propriedades.load(new FileInputStream("src/main/resources/application.properties"));
        return propriedades.getProperty(propriedade);
    }
}
