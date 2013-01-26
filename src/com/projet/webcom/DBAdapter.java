package com.projet.webcom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	// Donnees des utilisateurs
	public static final String KEY_ID_USER = "_id_user";
	public static final String KEY_NOM_USER = "nom_user";
	public static final String KEY_PRENOM_USER = "prenom_user";
	public static final String KEY_EMAIL_USER = "email_user";
	public static final String KEY_ADR_USER = "adr_user";
	public static final String KEY_TEL_USER = "tel_user";
	public static final String KEY_NUMCB_USER = "numcb_user";
	public static final String KEY_CRYPTOCB_USER = "cryptocb_user";
	public static final String KEY_EXPCB_USER = "expcb_user";

	// Donnees des articles
	public static final String KEY_ID_ART = "_id_art";
	public static final String KEY_NOM_ART = "nom_art";
	public static final String KEY_SHORTDESC_ART = "shortdesc_art";
	public static final String KEY_LONGDESC_ART = "longdesc_art";
	public static final String KEY_PRIX_ART = "prix_art";
	public static final String KEY_QTE_ART = "qte_art";
	public static final String KEY_ARTID_CAT = "artid_cat";

	// Donnees des photos des articles
	public static final String KEY_ID_PHOTO = "_id_photo";
	public static final String KEY_NOM_PHOTO = "nom_photo";
	public static final String KEY_ARTID_PHOTO = "artid_photo";

	// Donnees des categories
	public static final String KEY_ID_CAT = "_id_cat";
	public static final String KEY_NOM_CAT = "nom_cat";

	// Donnees des commandes
	public static final String KEY_ID_COM = "_id_com";
	public static final String KEY_NOMUSER_COM = "nomuser_com";
	public static final String KEY_PRENOMUSER_COM = "prenomuser_com";
	public static final String KEY_ADR1USER_COM = "adr1user_com";
	public static final String KEY_ADR2USER_COM = "adr2user_com";
	public static final String KEY_VILLEUSER_COM = "villeuser_com";
	public static final String KEY_CPUSER_COM = "cpuser_com";
	public static final String KEY_PAYSUSER_COM = "paysuser_com";
	public static final String KEY_TELUSER_COM = "teluser_com";
	public static final String KEY_USERID_COM = "userid_com";
	public static final String KEY_PANID_COM = "panid_com";

	// Donnees des commentaires
	public static final String KEY_ID_COMS = "_id_coms";
	public static final String KEY_TEXTE_COMS = "teluser_coms";
	public static final String KEY_ARTID_COMS = "artid_coms";
	public static final String KEY_USERID_COMS = "userid_coms";

	// Donnees des articles liés au panier
	public static final String KEY_ID_PANART = "_id_panart";
	public static final String KEY_QTEART_PANART = "qteart_panart";
	public static final String KEY_PRIXART_PANART = "artid_panart";
	public static final String KEY_ARTID_PANART = "artid_panart";

	// Donnees du panier
	public static final String KEY_ID_PAN = "_id_pan";
	public static final String KEY_PRIX_PAN = "prix_pan";

	// Donnees globales de la base
	private static final String TAG = "DBAdapter";	
	private static final String DATABASE_NAME = "base";
	private static final String DATABASE_TABLE = "utilisateurs";
	private static final int DATABASE_VERSION = 1;

	// Creation des tables
	private static final String TABLE_USERS =
			"create table if not exists users (_id_user integer primary key autoincrement, "
					+ "nom_user text not null, prenom_user text not null, " 
					+ "email_user text not null, tel_user text not null, "
					+ "numcb_user integer, cryptocb_user integer, expcb_user varchar);";

	private final Context context = null;
	private SQLiteOpenHelper DBHelper;
    private SQLiteDatabase db;

	// Ouverture de la base
	public DBAdapter open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}

	// Ouverture de la base
	public void close() {
		DBHelper.close();
	}
	
	// Inserer un utilisateur
    public long insertUser(String id, String nom, String prenom, String email, String adresse, String tel, String numcb, String cryptocb, String expcb) {
        ContentValues valeurs = new ContentValues();
        valeurs.put(KEY_ID_USER, id);
        valeurs.put(KEY_NOM_USER, nom);
        valeurs.put(KEY_PRENOM_USER, prenom);
        valeurs.put(KEY_EMAIL_USER, email);
        valeurs.put(KEY_ADR_USER, adresse);
        valeurs.put(KEY_TEL_USER, tel);
        valeurs.put(KEY_NUMCB_USER, "");
        valeurs.put(KEY_CRYPTOCB_USER, "");
        valeurs.put(KEY_EXPCB_USER, "");
        return db.insert(TABLE_USERS, null, valeurs);
    }
    // MERGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE
}