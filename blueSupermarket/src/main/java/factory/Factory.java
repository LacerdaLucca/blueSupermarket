package factory;

import java.sql.*;

public class Factory {
private Connection c;
	
	//construtor
	public Factory() {
		this.c=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("ERRO NO CONSTRUTOR DA CLASSE FACTORY!");
			e.printStackTrace();
		}
	}
	
	//seta uma nova conexao
	public void setConnection(String URL) {
		try {
			Connection con = DriverManager.getConnection(URL,"root","lucca");
			this.c = con;
		}catch (SQLException e){
			System.out.println("ERRO AO CONFIGURAR A CONEXAO! (method setConnection())");
			System.out.println(e.getMessage());
		}
	}
	
	public Statement getStatement() {
		try {
			return c.createStatement();
		} catch(SQLException e) {
			System.out.println("ERRO AO OBTER STATEMENT (method getStatement())");
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	
	public void closeConnection() {
		System.out.println("Fechando conexao com o banco de dados");
		try {
			this.c.close();
		}catch (SQLException e) {
			System.out.println("ERRO AO FECHAR CONEXAO COM BANCO DE DADOS (method closeConnection())");
			System.out.println(e.getMessage());
		}
		
	}
}
