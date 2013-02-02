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
	
	// On cree la requete http (en GET ou POST)
	public JSONObject makeHttpRequest(String url, String method, List<NameValuePair> params) {
		try {
			HttpParams httpParams = new BasicHttpParams();
			HttpConnectionParams.setConnectionTimeout(httpParams, 10000);
			HttpConnectionParams.setSoTimeout(httpParams, 10000);
			
			// Si requete GET
			if(method == "POST") {
				HttpClient httpClient = new DefaultHttpClient();
				HttpPost httpPost = new HttpPost(url);
				httpPost.setParams(httpParams);
				httpPost.setEntity(new UrlEncodedFormEntity(params));
				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();
			}
			// Si requete POST
			else if(method == "GET") {
				DefaultHttpClient httpClient = new DefaultHttpClient();
				String paramString = URLEncodedUtils.format(params, "utf8");
				url += "?" + paramString;
				HttpGet httpGet = new HttpGet(url);
				httpGet.setParams(httpParams);
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
			Log.e("Erreur du buffer (BufferedReader)", "Erreur de conversion de la reponse." + e.toString());
		}
		
		// On va parser les donnees pour les inserer dans la base de donnees
		try {
			jObj = new JSONObject(json);
		}
		catch (JSONException e) {
			Log.e("Erreur du parseur (JSONParser)", "Erreur lors du parsage des donnees." +e.toString());
		}
		return jObj;
	}

}
