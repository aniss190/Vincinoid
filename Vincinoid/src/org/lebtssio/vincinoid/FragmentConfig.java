package org.lebtssio.vincinoid;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;

public class FragmentConfig extends ActionBarActivity {

	private PagerAdapter mPagerAdapter;
	private int nb, total;
	private String nom, epreuve, heure;

	@Override
	// Création de la liste de Fragments que fera défiler le PagerAdapter
	// Ajout des Fragments dans la liste
	// Création de l'adapteur qui s'occupera de l'affichage de la liste de
	// fragments
	// Création du pager
	// Affectation de l'adapteur au ViewPager
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_fragment_config);

		Intent intent = getIntent();
		nb = intent.getExtras().getInt("num");
		nom = intent.getExtras().getString("nom");
		heure = intent.getExtras().getString("heure");
		epreuve = intent.getExtras().getString("epreuve");

		total = 3;

		// Création de la liste de Fragments que fera défiler le PagerAdapter
		List<Fragment> fragments = new Vector<Fragment>();

		// Ajout des Fragments dans la liste
		for (int i = 0; i < total; i++) {
			String nom = "org.lebtssio.vincinoid.Eleve"+i;
			Log.i("nom fragment",nom);
			fragments.add(Fragment.instantiate(this, nom));

		}

		// Création de l'adapteur qui s'occupera de l'affichage de la liste de
		// fragments
		this.mPagerAdapter = new MyPagerAdapter(
				super.getSupportFragmentManager(), fragments);

		// Création du pager
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		// Affectation de l'adapteur au ViewPager
		pager.setAdapter(this.mPagerAdapter);
		pager.setCurrentItem(nb - 1);
		
		
// A changer par un Switch...
		if (nb == 1) { 
			Valeurs(nom, epreuve, heure, nb);
		}
		if (nb == 2) { 
			Valeurs("toto", epreuve, heure, nb);
		}
		if (nb == 3) { 
			Valeurs("titi", epreuve, heure, nb);
		}
		if (nb == 4) { 
			Valeurs("tata", epreuve, heure, nb);
		}
		if (nb == 5) { 
			Valeurs("tutu", epreuve, heure, nb);
		}
		if (nb == 6) { 
			Valeurs("tyty", epreuve, heure, nb);
		}
	}

	public void Valeurs(String nom, String epreuve, String heure, int nb) {
		Intent data = null;
		
		switch (nb) {
		case 0:
			data = new Intent(this, Eleve0.class);
			break;
		case 1:
			data = new Intent(this, Eleve1.class);
			break;
		case 2:
			data = new Intent(this, Eleve2.class);
			break;
		case 3:
			data = new Intent(this, Eleve3.class);
			break;
		case 4:
			data = new Intent(this, Eleve4.class);
			break;
		case 5:
			data = new Intent(this, Eleve5.class);
			break;

		default:
			break;
		}
		
		data.putExtra("nom", nom);
		data.putExtra("epreuve", epreuve);
		data.putExtra("heure", heure);
		data.putExtra("num", nb);
	}

}