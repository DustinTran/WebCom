package com.projet.webcom;

import android.os.Bundle;
import android.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MenuFragment extends Fragment {
	MenuItem menuAccueil;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
	}

	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menuAccueil = menu.add("Accueil");
	    super.onCreateOptionsMenu(menu, inflater);
	}

}
