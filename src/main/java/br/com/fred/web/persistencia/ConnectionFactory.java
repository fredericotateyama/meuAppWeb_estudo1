package br.com.fred.web.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public static Connection getConnection() {
		
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/minhaWeb", "root", "root");
			
		}
		catch(SQLException e){
		throw new RuntimeException(e);
		}
		finally{
			System.out.println("Conexão aberta!");
			System.out.println("===============");
		}
	}
	
}
