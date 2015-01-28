package org.lebtssio.vincinoid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class Accueil extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_accueil);

		TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

		tabHost.setup();

		TabHost.TabSpec tabSpec = tabHost.newTabSpec("ajout");
		tabSpec.setIndicator("Ajout");
		tabSpec.setContent(R.layout.activity_ajout);
		tabHost.addTab(tabSpec);

		tabSpec = tabHost.newTabSpec("eleve");
		tabSpec.setIndicator("Eleve");
		tabSpec.setContent(R.id.tabEleve);
		tabHost.addTab(tabSpec);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.accueil, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
