package model;

import java.io.InputStream;
import java.util.Properties;

import connexion.openerp.api.ConnexionOpenErp;

public class Connexion {
	public static void connexion(){
//		ConnexionOpenErp.host = "127.0.0.1";
//		ConnexionOpenErp.port = 8069;
//		ConnexionOpenErp.db = "demo";
//		ConnexionOpenErp.user = "admin";
//		ConnexionOpenErp.pass = "admin";
		try{
		Properties prop = new Properties();
        InputStream in = Connexion.class.getResourceAsStream("/connexion.properties");
        prop.load(in);
        ConnexionOpenErp.host = prop.getProperty("host");
		ConnexionOpenErp.port = Integer.valueOf(prop.getProperty("port"));
		ConnexionOpenErp.db = prop.getProperty("db");
		ConnexionOpenErp.user = prop.getProperty("user");
		ConnexionOpenErp.pass = prop.getProperty("pass");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
