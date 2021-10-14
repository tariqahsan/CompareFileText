package org.mma.training.selenium.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetURLText {
	public static void getUrlTextFile(String url, String country, String language ) {
		try {
			// URL u = new URL("https://ais.usvisa-info.com/en-ca/niv/information/faqs");
			System.out.println("I'm here 1...");
			System.out.println(url);
			URL u = new URL(url);
			System.out.println("I'm here 2...");
//			URLConnection connection = new URL("https://www.google.com/search?q=" + query).openConnection();
//			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
//			connection.connect();

			HttpURLConnection hr = (HttpURLConnection)u.openConnection();
			hr.setRequestProperty("User-Agent", "Chrome");
			hr.connect();
			System.out.println("I'm here 3...");
			System.out.println(hr.getResponseCode());
			if (hr.getResponseCode() == 200) {
				InputStream im = hr.getInputStream();
				StringBuffer sb = new StringBuffer();
				BufferedReader br = new BufferedReader(new InputStreamReader(im));
				FileOutputStream fo = new FileOutputStream("src/main/resources/OutputTextFiles/" + country + "-" + language + ".txt");
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fo));
				String line = br.readLine();
				while (line != null) {
					System.out.println(line);
					bw.write(line);
					bw.newLine();
					line = br.readLine();
				} 
			} 
		} catch (Exception e) {
			System.out.println(e);
		} 
	}
}
