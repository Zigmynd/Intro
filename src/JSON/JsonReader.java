package JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.lang.*;

public class JsonReader {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static String readJsonFromUrl() throws IOException {
    
	System.out.println(URLEncoder.encode("http://eu.battle.net/api/wow/character/test-realm/Peratryn?fields=items"));	
	
	InputStream is = new URL("http://eu.battle.net/api/wow/character").openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      
      System.out.println(jsonText);
      return jsonText;
    } finally {
      is.close();
    }
  }

  public static void main(String[] args) throws IOException {
	  
	  readJsonFromUrl(); 
  }
}
