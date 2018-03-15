package databaselayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Anime;

public class DatabaseAccess {
	private Connection conn;
	ArrayList<Anime> aniList = new ArrayList<Anime>();
	
	
	public void openConnection() {
		try {
			System.out.println("Loading JDBC Driver...");
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("JDBC Driver loaded");
		} catch(ClassNotFoundException e) {
			System.out.println("failed to load JDBC Driver");
			System.exit(0);
		}
		
		String databaseName ="MyAnimeList";
		String connectionString ="jdbc:sqlservver://localhost:1443;"+
		"instanceName=SQLEXPRESS;"+
		"databaseName="+databaseName +";"+"integratedSecurity=true;";
		
		
		try {
			System.out.println("Connecting to database....");
			System.out.println(connectionString);
			conn= DriverManager.getConnection(connectionString);
			
			if(conn !=null)
				System.out.println("connected to database");
			else 
				System.out.println("failed to connect to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
