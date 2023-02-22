package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utilities {
	private static Utilities instance;
	private Utilities() {
	}
	public static Utilities getInstance() {
		if(instance==null) {
			instance=new Utilities();
		}
		return instance;
	}
	public String readPropertyFile(String key) throws IOException {
		FileInputStream stream=new FileInputStream(new File("C:\\Users\\ayyappan.g\\eclipse-workspace\\AllIndex\\src\\test\\resources\\config.properties"));
		Properties properties=new Properties();
		properties.load(stream);
		return properties.getProperty(key);
	}

}
