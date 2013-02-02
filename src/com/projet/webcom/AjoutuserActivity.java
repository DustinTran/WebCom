package com.projet.webcom;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AjoutUserActivity extends Activity {
	// Barre de progression
	private ProgressDialog progression;

	JSONParser jsonParser = new JSONParser();
	EditText inputNom;
	EditText inputPrenom;
	EditText inputEmail;
	EditText inputAdresse;
	EditText inputTel;
	EditText inputPasswd;

	// URL du webservice pour ajouter un compte utilisateur / lire
	private static String url_ajout_compte = "http://172.25.1.83:80/android/add_user.php";
	private static String url_creer_compte = "http://172.25.1.83:80/android/create_user.php";

	private static final String TAG_SUCCESS = "success";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajoutuser);

		// On recupere les champs
		inputNom = (EditText) findViewById(R.id.editTextNomUser);
		inputPrenom = (EditText) findViewById(R.id.editTextPrenomUser);
		inputAdresse = (EditText) findViewById(R.id.editTextAdresseUSer);
		inputEmail = (EditText) findViewById(R.id.editTextMail);
		inputTel = (EditText) findViewById(R.id.editTextTelUser);
		inputPasswd = (EditText) findViewById(R.id.editTextPasswordUser);

		// On lie le bouton "Enregistrer" au web service
		Button bouton = (Button) findViewById(R.id.buttonEnregistrerUser);
		bouton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				new CreerNouveauCompteActivity().execute();
			}
		});
	}
	
	// On effectue l'ajout de l'utilisateur en fond
	class CreerNouveauCompteActivity extends AsyncTask<String, String, String> { 
		/*
		 * On affiche la barre de progression
		 */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			progression = new ProgressDialog(AjoutUserActivity.this);
			progression.setMessage("Votre compte est en cours de creation...");
			progression.setIndeterminate(false);
			progression.setCancelable(true);
			progression.show();
		}

		/**
		 * On cree le compte
		 */
		protected String doInBackground(String... args) {
			String nom = inputNom.getText().toString();
			String prenom = inputPrenom.getText().toString();
			String adresse = inputAdresse.getText().toString();
			String email = inputEmail.getText().toString();
			String tel = inputTel.getText().toString();
			String passwd = inputPasswd.getText().toString();
			
			// Parametres
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("nom", nom));
			params.add(new BasicNameValuePair("prenom", prenom));
			params.add(new BasicNameValuePair("adresse", adresse));
			params.add(new BasicNameValuePair("email", email));
			params.add(new BasicNameValuePair("telephone", tel));
			params.add(new BasicNameValuePair("passwd", passwd));

			// On cree la requete http (passage de parametres en "POST"
			JSONObject json = jsonParser.makeHttpRequest(url_ajout_compte, "POST", params);

			// Log
			Log.d("Reponse JSON", json.toString());
			try {
				int success = json.getInt(TAG_SUCCESS);

				// Si le compte a bien ete cree
				if (success == 1) {
					// Si le compte a bien ete cree
					Intent intentAccueil = new Intent(getApplicationContext(), AccueilActivity.class);
                	startActivity(intentAccueil);
			
					// On ferme la fenêtre d'ajout
					finish();
				} 
				// Si le compte n'a pas ete cree
				else {
					Log.d("reponse json", json.toString());
				}
			}
			catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/*
		 * On ferme le fenêtre montrant une barre de progression
		 */
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			progression.dismiss();
		}
	}

	public boolean onCreateOptionsMenu(Menu menu)
	{
		super.onCreateOptionsMenu(menu);
		MenuItem item = menu.add("Accueil");
		item.setIcon(R.drawable.ic_menu_rechercher);
		item = menu.add("Rechercher");
		item.setIcon(R.drawable.ic_menu_accueil);
		item = menu.add("Panier");
		item.setIcon(R.drawable.ic_menu_panier);
		item = menu.add("Votre compte");
		item.setIcon(R.drawable.ic_menu_compte);
		item = menu.add("Autre");
		return true;
	}
}