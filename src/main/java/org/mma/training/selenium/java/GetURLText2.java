package org.mma.training.selenium.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetURLText2 {
  public static void main(String[] args) {
    try {
      URL u = new URL("https://ais.usvisa-info.com/en-ca/niv/information/faqs");
      HttpURLConnection hr = (HttpURLConnection)u.openConnection();
      System.out.println("I'm here ...");
      System.out.println(hr.getResponseCode());
      if (hr.getResponseCode() == 200) {
        InputStream im = hr.getInputStream();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(im));
        FileOutputStream fo = new FileOutputStream("c://Writing//visa-ops.txt");
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
