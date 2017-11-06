package devLib.boot;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpExec {

    public static void main(String[] args) {
        HttpExec exec = new HttpExec();
        exec.doGet();
    }

    public void doGet() {
        String url = "http://127.0.0.1:8080/seasail/222 &";
        HttpGet get = new HttpGet(url);

        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            CloseableHttpResponse response = httpClient.execute(get);
            int status = response.getStatusLine().getStatusCode();
            System.out.println("StatusCode: " + status);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
