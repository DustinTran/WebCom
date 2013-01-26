package com.projet.webcom;

import java.util.ArrayList;
import java.util.List;
 
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreerCompteActivity extends Activity {
 
    // Barre de progression
    private ProgressDialog progression;
    
    JSONParser jsonParser = new JSONParser();
    EditText inputNom;
    EditText inputPrenom;
    EditText inputEmail;
    EditText inputAdresse;
    EditText inputTel;
    EditText inputPasswd;
 
    // URL du webservice pour ajouter un compte utilisateur
    private static String url_ajout_user = "localhost/android/user/add_user.php";
 
    // JSON Node names
    private static final String TAG_SUCCESS = "success";
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajoutuser);
 
        // On recupere les champs
        inputNom = (EditText) findViewById(R.string.nom);
        inputPrenom = (EditText) findViewById(R.string.prenom);
        inputAdresse = (EditText) findViewById(R.string.adresse);
        inputEmail = (EditText) findViewById(R.string.adresseEmail);
        inputTel = (EditText) findViewById(R.string.Telephone);
        inputPasswd = (EditText) findViewById(R.string.password);
 
        // On lie le bouton "Enregistrer" au web service
        Button bouton = (Button) findViewById(R.id.buttonEnregistrerUser);
        bouton.setOnClickListener(new View.OnClickListener() { 
            @Override
            public void onClick(View view) {
                new CreerCompteActivity().execute();
            }
        });
    }
 
    /*
     * On ajoute l'utilisateur de maniere asynchrone
     *
     */
    class NouveauCompteActivity extends AsyncTask<String, String, String> { 
        /*
         * On affiche la barre de progression
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progression = new ProgressDialog(NouveauCompteActivity.this);
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
            JSONObject json = jsonParser.makeHttpRequest(url_ajout_user, "POST", params);
 
            // Log
            Log.d("Create Response", json.toString());
 
            // Si le compte a bien ete cree
            try {
                int success = json.getInt(TAG_SUCCESS);
 
                if (success == 1) {
                    // Si le compte a bien ete cree : il faudra creer une activite "VoirComptesActivity"
                    /*Intent i = new Intent(getApplicationContext(), VoirComptesActivity.class);
                    startActivity(i);*/
 
                    // On ferme la fenêtre d'ajout
                    finish();
                } 
                else {
                    // Si le compte n'a pas ete cree
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
}
