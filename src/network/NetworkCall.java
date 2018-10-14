/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Network;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Visak
 */
public class NetworkCall {
    
    //Server Url
    public static final String MAIN_URL = "http://exiox.com/restaurant/api/v1/";
    //Method
    public static final int POST = 1;
    public static final int GET = 2;
    public static final int PUT = 3;
    public static final int DELETE = 4;
    //APIs
    public static final String USER_DETAILS = "userDetails";
    public static final String VALIDATE_USER = "validateUser";
    
    private String url;
    private int type;
    private JSONObject params = null;
    

    public NetworkCall(int type, String url, JSONObject params) throws Exception {
        this.type = type;
        this.url = MAIN_URL + url;
        this.params = params;
    }
    
    public HttpURLConnection callMethod() throws Exception{
        
        HttpURLConnection httpUrlConnection = null;
        switch(type){
            case POST:
                httpUrlConnection = callPost(url, params);
                break;
            case GET:
                break;
            case PUT:
                break;
            case DELETE:
                break;
        }
        return httpUrlConnection;
    }
    
    private HttpURLConnection callPost(String url, JSONObject params) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        //add request header
        con.setRequestMethod("POST");
        con.setConnectTimeout(5000);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setRequestProperty("Accept", "application/json");
        //String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
        // Send post request
        con.setDoInput(true);
        con.setDoOutput(true);
        /*DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();*/
        //System.out.println("Post parameters : " + urlParameters);
        if(params != null) {
            setParams(con, params);
        }
        
        return con;
    }
    
    private void setParams(HttpURLConnection con, JSONObject parent) throws IOException {
        OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());
        wr.write(parent.toString());
        wr.flush();
        wr.close();
    }
    
    public int getResponseCode(HttpURLConnection con) throws IOException {
        System.out.println("Response Code : " + con.getResponseCode());
        return con.getResponseCode();
    }
    
    public String getResponseString(HttpURLConnection con) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //print result
        System.out.println("Response Data : " + response.toString());
        return response.toString();
    }
    
    private void callJsonParser(String response) throws ParseException {
        
        JSONParser parse = new JSONParser();
        JSONObject jobj = (JSONObject) parse.parse(response.toString());
        //JSONArray jsonarr_1 = (JSONArray) jobj.get(“results”);
    }
}
