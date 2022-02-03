package br.com.recode.factory;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {

	private static final String USERNAME = "root";
	
	private static final String PASSWORD = "12192525";
	
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/crudjdbc";
	
		public static Connection createConnection() throws Exception {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			return connection;
		}
		
		public static void main(String[] args) throws Exception {
			Connection conn = createConnection();
			
			if(conn!=null) {
				System.out.println("Conexão realizada com sucesso!");
				conn.close();
			}else {
				System.out.println("Erro ao conectar!");
		}
	}
}



















