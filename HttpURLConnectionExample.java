import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpURLConnectionExample {
	
	public void getMethodExample() throws IOException {
		URL url= new URL("http://dummy.restapiexample.com/api/v1/employees");
		HttpURLConnection connection= (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		
		int responceCode=connection.getResponseCode();
		System.out.println("Status code is "+responceCode);
		
		String responseMessage=connection.getResponseMessage();
		System.out.println(responseMessage);

		InputStream inputStream=connection.getInputStream();
		InputStreamReader streamReader= new InputStreamReader(inputStream);
		
		BufferedReader bufferReader= new BufferedReader(streamReader);
		String line;
		StringBuffer buffer=new StringBuffer();
		while((line=bufferReader.readLine())!=null){
			buffer.append(line);
			
		}
		System.out.println(buffer);
	}
	}

	public static void main(String[] args) throws IOException {
		
		HttpURLConnectionExample connectionExample= new HttpURLConnectionExample ();
		connectionExample.getMethodExample();

	}

}
