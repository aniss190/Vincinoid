package repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

// Classe intermédiaire le compte de l'utilisateur et l'enregistrement Android
public class AccountRepository extends Repository {

	private static int id = 0;

	// Constructeur
	public AccountRepository(Context context) {
		super(context);
	}

	// Enregistre le compte dans les SharedPreferences
	public void setAccount(String imei) {
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(Repository.context);
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.putString("IMEI",imei);	
		prefsEditor.commit();
	}

	// Supprime le compte
	public void unsetAccount() {
		SharedPreferences appSharedPrefs = PreferenceManager.getDefaultSharedPreferences(Repository.context);
		Editor prefsEditor = appSharedPrefs.edit();
		prefsEditor.remove("IMEI");
		prefsEditor.commit();
	}

	// Indique si le compte est configure ou non
	public boolean isAccountConfigured() {
		AccountRepository accRepo = new AccountRepository(Repository.context);
		String imei = accRepo.getIMEI();

		if (imei.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	// Recupere l'IMEI du compte de l'utilisateur
	public String getIMEI()	{
		SharedPreferences app = PreferenceManager.getDefaultSharedPreferences(Repository.context);
		return app.getString("IMEI", "");
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		AccountRepository.id = id;
	}
}

