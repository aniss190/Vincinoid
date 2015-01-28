package org.lebtssio.vincinoid;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class FragmentConfig extends ActionBarActivity {

	private PagerAdapter mPagerAdapter;
	private int nb;
	private String nom, epreuve, heure;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_fragment_config);

		Intent intent = getIntent();
		nb = intent.getExtras().getInt("num");
		nom = intent.getExtras().getString("nom");
		heure = intent.getExtras().getString("heure");
		epreuve = intent.getExtras().getString("epreuve");

		// Création de la liste de Fragments que fera défiler le PagerAdapter
		List<Fragment> fragments = new Vector<Fragment>();

		// Ajout des Fragments dans la liste
		fragments.add(Fragment.instantiate(this, eleve0.class.getName()));
		fragments.add(Fragment.instantiate(this, eleve1.class.getName()));
		fragments.add(Fragment.instantiate(this, eleve2.class.getName()));
		fragments.add(Fragment.instantiate(this, eleve3.class.getName()));
		fragments.add(Fragment.instantiate(this, eleve4.class.getName()));
		fragments.add(Fragment.instantiate(this, eleve5.class.getName()));

		// Création de l'adapteur qui s'occupera de l'affichage de la liste de
		// fragments
		this.mPagerAdapter = new MyPagerAdapter(
				super.getSupportFragmentManager(), fragments);

		// Création du pager
		ViewPager pager = (ViewPager) super.findViewById(R.id.viewpager);
		// Affectation de l'adapteur au ViewPager
		pager.setAdapter(this.mPagerAdapter);
		pager.setCurrentItem(nb - 1);

		if (nb == 1) {
			Intent data1 = new Intent(this, eleve0.class);

			data1.putExtra("nom", nom);
			data1.putExtra("epreuve", epreuve);
			data1.putExtra("heure", heure);
			data1.putExtra("num", nb);
		} else if (nb == 2) {
			Intent data2 = new Intent(this, eleve1.class);
			data2.putExtra("nom", nom);
			data2.putExtra("epreuve", epreuve);
			data2.putExtra("heure", heure);
			data2.putExtra("num", nb);
		} else if (nb == 3) {
			Intent data3 = new Intent(this, eleve3.class);
			data3.putExtra("nom", nom);
			data3.putExtra("epreuve", epreuve);
			data3.putExtra("heure", heure);
			data3.putExtra("num", nb);
		} else if (nb == 4) {
			Intent data4 = new Intent(this, eleve3.class);
			data4.putExtra("nom", nom);
			data4.putExtra("epreuve", epreuve);
			data4.putExtra("heure", heure);
			data4.putExtra("num", nb);
		} else if (nb == 5) {
			Intent data5 = new Intent(this, eleve4.class);
			data5.putExtra("nom", nom);
			data5.putExtra("epreuve", epreuve);
			data5.putExtra("heure", heure);
			data5.putExtra("num", nb);
		} else if (nb == 6) {
			Intent data6 = new Intent(this, eleve5.class);
			data6.putExtra("nom", nom);
			data6.putExtra("epreuve", epreuve);
			data6.putExtra("heure", heure);
			data6.putExtra("num", nb);
		}

	}
}