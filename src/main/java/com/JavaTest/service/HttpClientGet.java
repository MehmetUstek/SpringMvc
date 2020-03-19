package com.JavaTest.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.JavaTest.model.User;

public class HttpClientGet {
	User[] arrayOfUsers;
	int i=0;
    public static void main(String[] args) throws IOException {

        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

             HttpGet request = new HttpGet("http://webcode.me");
            HttpResponse response = client.execute(request);

             BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {
                builder.append(line);
                builder.append(System.lineSeparator());
            }

            System.out.println(builder);
        }
    }
}