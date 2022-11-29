import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PutMethodExample {

	public void putMethod() throws IOException {
		URL url = new URL("http://dummy.restapiexample.com/api/v1/update/9644");
		HttpURLConnection connection=(HttpURLConnection)url.openConnection();
		connection.setRequestMethod("PUT");
		connection.setRequestProperty("Content-Type", "application/json");
		connection.setDoOutput(true);
		
		String jsonBody="{\"name\":\"Jagan\",\"salary\":\"14000000\",\"age\":\"30\"}";
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
		PutMethodExample putExample= new PutMethodExample();
		putExample.putMethod();

	}

}
