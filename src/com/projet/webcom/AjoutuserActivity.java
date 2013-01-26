package com.projet.webcom;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AjoutuserActivity extends Activity {
	  
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajoutuser);
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