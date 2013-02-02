package com.projet.webcom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ConnexionActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_connexion);

		Button btCreerCompte = (Button) findViewById(R.id.buttonCreateCompte);
		btCreerCompte.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent(ConnexionActivity.this, AjoutUserActivity.class);
				startActivity(intent);
			}
		});
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