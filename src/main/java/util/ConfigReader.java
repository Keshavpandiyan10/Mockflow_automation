package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties getPropertyObject() throws IOException {
		FileInputStream fp = new FileInputStream("/Users/keshavpandiyan/eclipse-workspace/Automation/Config/config.properties");
		
		Properties prop = new Properties();
		
		prop.load(fp);
		
		return prop;
	}
	
	public static String getEmail() throws IOException {
		return getPropertyObject().getProperty("email");
	}
	
	public static String getPassword() throws IOException {
		return getPropertyObject().getProperty("pass");
	}
	

}
