import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class PostMethodExample {

	public void postMethod() throws IOException {
		URL url = new URL("http://dummy.restapiexample.com/api/v1/create");
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		
		String jsonBody="{\"name\":\"Jagan\",\"salary\":\"14000000\",\"age\":\"31\"}";
		byte[] inputJson=jsonBody.getBytes();
		
		OutputStream outputStream=connection.getOutputStream();
		outputStream.write(inputJson);
		
		System.out.println("Response code :"+ connection.getResponseCode());
		System.out.println("Response code :"+ connection.getResponseMessage());
		
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
	
	public static void main(String[] args) throws IOException {
		PostMethodExample postExample= new PostMethodExample();
		postExample.postMethod();
		

	}

}
