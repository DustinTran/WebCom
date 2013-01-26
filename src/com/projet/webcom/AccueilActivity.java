package com.projet.webcom;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;

public class AccueilActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
		ExpandableListView  listViewPrincipal = (ExpandableListView) findViewById(R.id.expandableListView1);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.ListePrincipale, android.R.layout.simple_expandable_list_item_1);
		
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
		
		listViewPrincipal.setAdapter(adapter);
		//fichier de test commit
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_accueil, menu);
		return true;
	}

}
