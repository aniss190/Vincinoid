package org.lebtssio.vincinoid;

import java.util.List;
import java.util.Vector;

import repositories.AccountRepository;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class FragmentConfig extends ActionBarActivity {

	private PagerAdapter mPagerAdapter;
	private int nb, id;
	private String nom, heure;
	
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


		// Création de la liste de Fragments que fera défiler le PagerAdapter
		List<Fragment> fragments = new Vector<Fragment>();

		// Ajout des Fragments dans la liste
		for (int i = 0; i < nb; i++) {
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
		pager.setCurrentItem(id);


		/* A changer par un Switch...

		switch (nb) {
		case 0:
			Valeurs(nom, heure, nb);
			break;
		case 1:
			Valeurs("toto", heure, nb);
			break;
		case 2:
			Valeurs("titi", heure, nb);
			break;
		case 3:
			Valeurs("tata", heure, nb);
			break;
		case 4:
			Valeurs("tutu", heure, nb);
			break;
		case 5:
			Valeurs("tyty", heure, nb);
			break;

		default:
			break;
		}
		*/
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.ajout, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_ajout) {
			Intent intent = new Intent(this, Ajout.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	public void Valeurs(String nom, String heure, int nb) {
		Intent data = null;
		id = AccountRepository.getId();

		switch (id) {
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
		data.putExtra("heure", heure);
		data.putExtra("num", nb);
	}

}