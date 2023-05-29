package org.testleaf.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LearnProperties  {

	public static void main(String[] args) throws IOException   {
		// TODO Auto-generated method stub

		Properties prop=new Properties();
		
		FileInputStream fis=new FileInputStream(new File("src/main/resources/config.properties"));
				prop.load(fis);
				String Username=prop.getProperty("Username");
				System.out.println(Username);
	}

}
