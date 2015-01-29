package org.lebtssio.vincinoid;

import repositories.AccountRepository;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends ActionBarActivity implements OnClickListener {

	private Button btn1;
	private EditText nom;
	private EditText heure;
	private EditText nb;
	private int id;
	
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ajout);

		btn1 = (Button) findViewById(R.id.btn1);
		btn1.setOnClickListener(this);

		nom = (EditText) findViewById(R.id.nom);
		
		heure = (EditText) findViewById(R.id.heure);

		nb = (EditText) findViewById(R.id.nb);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.eleve, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == R.id.action_eleve) {
			Intent intent = new Intent(this, Eleve0.class);
			startActivity(intent);
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) 
	{
		
		
		if(nom.getText().toString().equals("") || heure.getText().toString().equals("") 
				|| nb.getText().toString().equals("") || Integer.parseInt(nb.getText().toString()) > 6 )
		{
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Formulaire incorrect")
			.setMessage("- un ou plusieurs champs vides")
			.setCancelable(false)
			.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});
			AlertDialog alert = builder.create();
			alert.show();
		}
		else
		{
			id = AccountRepository.getId();
			id++;
			AccountRepository.setId(id);
			
			Intent intent = new Intent(this, FragmentConfig.class);
			intent.putExtra("nom", nom.getText().toString());
			intent.putExtra("heure", heure.getText().toString());
			intent.putExtra("num", Integer.parseInt(nb.getText().toString()));
			startActivityForResult(intent, 10);	
		}

	}
}