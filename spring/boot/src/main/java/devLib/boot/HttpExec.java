package devLib.boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpExec {

    public static void main(String[] args) throws Exception {
        HttpExec exec = new HttpExec();
        exec.doGet();
    }

    public void doGet() throws Exception {
        String url = "http://127.0.0.1:8080/seasail/222 &";
        doGet(url);

        // CloseableHttpClient httpClient = HttpClients.custom().build();
        // try {
        // HttpGet get = new HttpGet(url);
        // CloseableHttpResponse response = httpClient.execute(get);
        // int status = response.getStatusLine().getStatusCode();
        // System.out.println("StatusCode: " + status);
        // } catch (ClientProtocolException e) {
        // e.printStackTrace();
        // } catch (IOException e) {
        // e.printStackTrace();
        // }
    }

    public String doGet(String url) throws Exception {
        String result = "";
        try {
            //url = url.replaceAll(" ", "%20");// 替换URL中的空格
            URL realUrl = new URL(url);
            System.out.println("Request URL:" + realUrl);

            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            String response = "";
            while ((line = br.readLine()) != null) {
                response += line;
            }
            br.close();
            int statusCode = conn.getResponseCode();
            result = "{StatusCode=" + statusCode + ",";
            result = result + "Response=" + response + "}";
        } catch (Exception e) {
            System.out.println("发送 Get请求出现异常！" + e);
        }
        System.out.println("Request Response:" + result);
        return result;

    }
}
