import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
	@SuppressWarnings("deprecation")
	public Parser(String[] urls, String begin, String end) throws IOException {
		for(String urli : urls) {
			URL url = new URL(urli);
			InputStream is = url.openStream();
			BufferedReader dis = new BufferedReader(new InputStreamReader(is));
			String line;
            StringBuffer pageBuffer = new StringBuffer();
			while ((line = dis.readLine()) != null) {
		        pageBuffer.append(line);
		    }
			String webpage = pageBuffer.toString();
			is.close();
			
			String pattern = begin + "(.*?)" + end;
			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(webpage);
			while (m.find()) {
			  System.out.println(m.group(1));
			}
		}
	}
}
