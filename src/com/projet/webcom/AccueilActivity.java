package com.projet.webcom;

import com.slidingmenu.lib.SlidingMenu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;

public class AccueilActivity extends Activity
{	
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);
		
        // configure the SlidingMenu
        SlidingMenu menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
        menu.setMenu(R.layout.menu_fragment);
		
		// Boutons temporaires
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
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_fragment, menu);
		super.onCreateOptionsMenu(menu);
	    return true;
	}
}