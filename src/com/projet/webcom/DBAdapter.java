package com.projet.webcom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter {
	public static final String KEY_ID_USER = "_id_user";
	public static final String KEY_NOM_USER = "nom_user";
	public static final String KEY_PRENOM_USER = "prenom_user";
	public static final String KEY_EMAIL_USER = "email_user";
	public static final String KEY_TEL_USER = "tel_user";
	public static final String KEY_NUMCB_USER = "numcb_user";
	public static final String KEY_CRYPTOCB_USER = "cryptocb_user";
	public static final String KEY_EXPCB_USER = "expcb_user";
	private static final String TAG = "DBAdapter";
	
	private static final String DATABASE_NAME = "base";
	private static final String DATABASE_TABLE = "utilisateurs";
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREATE_TABLE_USERS =
	    "create table users (_id_user integer primary key autoincrement, "
	    + "nom_user text not null, prenom_user text not null, " 
	    + "email_user text not null, tel_user text not null, "
	    + "numcb_user integer, cryptocb_user integer, expcb_user varchar);";
	    
	private final Context context;
}
