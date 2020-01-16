package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPropertise 
{
	public static Properties userData = LoadPropertises(System.getProperty("user.dir")+"\\src\\main\\java\\propertise\\userdata.propertise");
	private static Properties LoadPropertises(String path)
	{
         Properties pro = new Properties();
         try {
			FileInputStream stream = new FileInputStream(path);
			try {
				pro.load(stream);
			} catch (IOException e) {
				System.out.println("Error occurred : " + e.getMessage());
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred : " + e.getMessage());
		}
         return pro;
	}
}
