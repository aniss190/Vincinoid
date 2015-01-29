package org.lebtssio.vincinoid;

import repositories.AccountRepository;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class Eleve2 extends Fragment implements OnItemClickListener {

	private TextView tvNom,tvHeure;
	private String nom, heure;
	private int id;
	private TextView tvId;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.page,container,false);

		Intent intent = getActivity().getIntent();
		nom = intent.getExtras().getString("nom");
		heure = intent.getExtras().getString("heure");

		id = AccountRepository.getId();
		
		tvId = (TextView) view.findViewById(R.id.tvId);
		tvId.setText(""+id);
		
		if(id == 3)
		{

			tvNom = (TextView) view.findViewById(R.id.nom);
			tvNom.setText(nom);

			tvHeure = (TextView) view.findViewById(R.id.heure);
			tvHeure.setText(heure);


		}
		else
		{
			tvNom = (TextView) view.findViewById(R.id.nom);
			tvNom.setText("Eleve non enregistré");
		}
		return view;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
