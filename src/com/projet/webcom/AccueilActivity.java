package com.projet.webcom;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.view.View;
>>>>>>> origin/Francois
=======
import android.view.View;
>>>>>>> origin/Francois
=======
import android.view.View;
>>>>>>> origin/Francois
=======
import android.view.View;
>>>>>>> origin/Francois
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;

public class AccueilActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);

<<<<<<< HEAD
//		ExpandableListView listViewPrincipal = (ExpandableListView) findViewById(R.id.expandableListView1);
//
//		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.ListePrincipale,
//				android.R.layout.simple_spinner_item);
//
//		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//		listViewPrincipal.setAdapter(adapter);
//
//		Spinner spinner = (Spinner) findViewById(R.id.spinner);
//		spinner.setOnItemSelectedListener(this);
//		// fichier de test commit
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
		 Button btEnregistrer = (Button) findViewById(R.id.button1);
		    btEnregistrer.setOnClickListener(new Button.OnClickListener(){
		      public void onClick(View arg0) {
		    	  Intent intent = new Intent(AccueilActivity.this, AjoutuserActivity.class);
		  		startActivity(intent);
		      }
		  });
		
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
	}

	public boolean onCreateOptionsMenu(Menu menu){
	    super.onCreateOptionsMenu(menu);
	    MenuItem item = menu.add("Accueil");
	    item.setIcon(R.drawable.ic_menu_accueil);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
	    item = menu.add("Panier");
	    item.setIcon(R.drawable.ic_menu_panier);
	    
=======
=======
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
	    item = menu.add("Rechercher");
	    item.setIcon(R.drawable.ic_menu_panier);
	    item = menu.add("Panier");
	    //item.setIcon(R.drawable.ic_menu_rechercher);
	    item = menu.add("Votre compte");
	    //item.setIcon(R.drawable.ic_menu_compte);
	    item = menu.add("Autre");
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
=======
>>>>>>> origin/Francois
	    return true;
=======
		// ExpandableListView listViewPrincipal = (ExpandableListView)
		// findViewById(R.id.expandableListView1);
		//
		// ArrayAdapter<CharSequence> adapter =
		// ArrayAdapter.createFromResource(this, R.array.ListePrincipale,
		// android.R.layout.simple_spinner_item);
		//
		// adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		//
		// listViewPrincipal.setAdapter(adapter);
		//
		// Spinner spinner = (Spinner) findViewById(R.id.spinner);
		// spinner.setOnItemSelectedListener(this);
		// // fichier de test commit
		Button btCreerCompte = (Button) findViewById(R.id.button1);
		btCreerCompte.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent(AccueilActivity.this, AjoutuserActivity.class);
				startActivity(intent);
			}
		});

		Button btConnexion = (Button) findViewById(R.id.button2);
		btConnexion.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent(AccueilActivity.this, ConnexionActivity.class);
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
>>>>>>> origin/Francois
	}

}
