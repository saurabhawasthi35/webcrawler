package com.web.crawler.serviceimpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.web.crawler.model.WebCrawler;

public class NetClientGet {
	
	
	// http://localhost:8080/RESTfulExample/json/product/get
		public static void main(String[] args) {

		  try {

			URL url = new URL("http://localhost:8080/wiproweb_crawler/rservice/accountservice/accounts/2");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			WebCrawler webCrawler = new WebCrawler();
			webCrawler.setUrl("www.wipro.com");
			
			String input = "{\"id\":2,\"name\":\"iPad 4\"}";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		 }

		}

}
