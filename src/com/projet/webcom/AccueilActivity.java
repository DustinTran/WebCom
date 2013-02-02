package com.projet.webcom;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.ActionBarSherlock;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.internal.widget.ActionBarView;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;


import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

public class AccueilActivity extends SherlockActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		Button btCreerCompte = (Button) findViewById(R.id.button1);
		btCreerCompte.setOnClickListener(new Button.OnClickListener()
		{
			public void onClick(View arg0)
			{
				Intent intent = new Intent(AccueilActivity.this, AjoutUserActivity.class);
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
	
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		com.actionbarsherlock.view.MenuInflater inflater = getSupportMenuInflater();
		inflater.inflate(R.menu.activity_accueil, menu);
		return super.onCreateOptionsMenu(menu);
    }
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
         switch (item.getItemId()) {
         case R.id.accueil:
        	 return true;
         }
         return false;
     }
}