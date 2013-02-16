package com.projet.webcom;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.*;

public class AccueilActivity extends SherlockActivity
{	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
				
		// Boutons temporaires
		Button btCreerCompte = (Button) findViewById(R.id.button1);
		btCreerCompte.setOnClickListener(new Button.OnClickListener()
		{

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
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
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.menu_accueil, menu);
        return true;
	}
}