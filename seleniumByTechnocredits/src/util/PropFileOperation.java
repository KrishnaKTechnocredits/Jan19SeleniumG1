package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropFileOperation {

	public static Properties loadProp() throws IOException {
		String path = System.getProperty("user.dir") + File.separator + "credentials" + File.separator
				+ "credentials.properties";
		File file = new File(path);
		// File file = new File(".//credentials.properties");
		FileInputStream input = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(input);
		return prop;

	}
}
