package com.projet.webcom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class JSONParser {
	
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	
	// Constructeur
	public JSONParser() {
		
	}
	
	// On recupere la reponse json a partir d'une url
	// via une requete HTTP POST / GET
	public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params) {
		// Requete HTTP
		try {
			// On verifie le type de requete
			if(method == "POST") {
				HttpParams httpParams = new BasicHttpParams();
				HttpConnectionParams.setConnectionTimeout(httpParams, 15000);
				HttpConnectionParams.setSoTimeout(httpParams, 15000);
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				httpPost.setParams(httpParams);
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}
			
			else if(method == "GET") {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(params, "utf8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);
				Log.d("url", httpGet.getURI().toString());				
				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}
		}
		catch (UnsupportedEncodingException e) {
			e.printStackTrace();			
		}
		catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
			Log.d("champs", sb.toString());
		}
		catch (Exception e) {
			Log.e("Buffer Error", "Error converting result" + e.toString());
		}
		
		// On tente de parser la reponse json
		try {
			jObj = new JSONObject(json);
		}
		catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data" +e.toString());
		}
		return jObj;
	}

}
