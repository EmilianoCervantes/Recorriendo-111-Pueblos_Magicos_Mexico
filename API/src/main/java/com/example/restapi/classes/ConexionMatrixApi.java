package com.example.restapi.classes;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;



public class ConexionMatrixApi {
	private final String KEY = "AIzaSyB2vj6e3SsNUFPhGCEF9dazLKMWLAKYP3c";
	
	public float searchDistance(String pueblo1, String pueblo2) throws Exception {
		String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+pueblo1+"&destinations="+pueblo2+"&key="+KEY;
		System.out.println(url);
		URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    // optional default is GET
	    con.setRequestMethod("GET");
	    //add request header
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    int responseCode = con.getResponseCode();
	    System.out.println("\nSending 'GET' request to URL : " + url);
	    System.out.println("Response Code : " + responseCode);
	    BufferedReader in = new BufferedReader(
	            new InputStreamReader(con.getInputStream()));
	    String inputLine;
	    StringBuffer response = new StringBuffer();
	    while ((inputLine = in.readLine()) != null) {
	    	response.append(inputLine);
	    }
	    in.close();
	    //print in String
	    //System.out.println(response.destination_addresses.toString());
	    //Read JSON response and print
	    JSONObject myResponse = new JSONObject(response.toString());
	    JSONArray jsonArray = myResponse.getJSONArray("rows");
	    JSONObject object = jsonArray.getJSONObject(0);
	    JSONArray elements = object.getJSONArray("elements");
	    JSONObject object2 = elements.getJSONObject(0);
	    String status = object2.getString("status");
	    System.out.println(status);
	    if(status.equals("NOT_FOUND") || status.equals("ZERO_RESULTS")){
	    	return 0;
	    }else {
	    	JSONObject distancias = object2.getJSONObject("distance");
	    	double f = distancias.getDouble("value");
	    	f = f / 1000;
	    	return Float.parseFloat(f+"");
	    }
	    
	}
}
