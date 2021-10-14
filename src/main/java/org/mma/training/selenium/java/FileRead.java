package org.mma.training.selenium.java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileRead {
	
	public static void main(String[] args) {
		
		fileReader("visa-ops-url-list.txt");
	}

	public static void fileReader(String urlListFile) {
		
		BufferedReader br = null;

		try
		{
			InputStream is = FileRead.class.getResourceAsStream(urlListFile);
			//BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			br = new BufferedReader(new FileReader(urlListFile));
			//br = new BufferedReader(new InputStreamReader(is));

			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				String tmp[] = line.split(",");
				String url = tmp[0];
				String country = tmp[1];
				String language = tmp[2];
				String textOutputFilePath = tmp[3];
				System.out.println(url + "\t" + country + "\t" + language + "\t" + textOutputFilePath);
				GetURLText.getUrlTextFile(url, country, language);
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		} //finally {
		//			try {
		//				br.close();
		//			} catch (IOException e) {
		//				// TODO Auto-generated catch block
		//				e.printStackTrace();
		//			}
		//		}

	}
}
