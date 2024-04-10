package traitement;


import java.sql.*;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.*;

public class JSON {
	public JSON() {
	}
	public String getAllProducts() throws JSONException {
		ArrayList<Map<String, Object>> dataList = new ArrayList<>();
		
		try {
			Class.forName("org.postgresql.Driver");
	
	        // Établissez la connexion à la base de données
	        String url = "jdbc:postgresql://localhost:5432/db";
	        String utilisateur = "postgres";
	        String motDePasse = "123456";
	        Connection connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
	
	        // Exécutez une requête SQL (par exemple, sélectionnez toutes les lignes de la table "personne")
	        Statement statement = connexion.createStatement();
	        ResultSet resultat = statement.executeQuery("SELECT * FROM products");
	        while (resultat.next()) {
	            int id = resultat.getInt("id");
	            String title = resultat.getString("title");
	            Float price = resultat.getFloat("price");
	            String descripiton = resultat.getString("description");
	            String category = resultat.getString("category");
	            String image = resultat.getString("image");
	            dataList.add(Map.of("id", id , "title", title, "price", price , "description", descripiton, "category", category , "image" , image ));
	        }
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		
//	    dataList.add(Map.of("name", "John Doe", "age", 30, "city", "New York"));
//	    dataList.add(Map.of("name", "Jane Doe", "age", 22, "city", "London"));

	    JSONArray jsonArray = new JSONArray();

	    for (Map<String, Object> data : dataList) {
	        JSONObject jsonObject = new JSONObject(data);
	        jsonArray.put(jsonObject);
	    }

	    String jsonData = jsonArray.toString();

	    return jsonData;
	}
//	public void insert() throws ClassNotFoundException, SQLException {
//		
//		
//	}
}

