package com.JavaTest.config;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.JavaTest.model.User;



public class ParseData {

static InputStream is = null;
public static JSONObject jObj = null;
public static String json = "";
public static User[] arrayOfObjects;
String url="https://my-json-server.typicode.com/typicode/demo/comments";
public ParseData() {
	
	//getJSONFromUrl(url);
	
}

public JSONObject getJSONFromUrl(String url) {

    try {
        
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);

        HttpResponse httpResponse = httpClient.execute(httpPost);
        HttpEntity httpEntity = httpResponse.getEntity();
        is = httpEntity.getContent();

    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (ClientProtocolException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                is, "iso-8859-1"), 8);
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
            System.out.println(line);
        }
        is.close();
        json = sb.toString();

    } catch (Exception e) {
       
    }

    try {
        jObj = new JSONObject(json);
    } catch (JSONException e) {
       
        System.out.println("error on parse data in jsonparser.java");
    }

    // return JSON String
    return jObj;

}
}