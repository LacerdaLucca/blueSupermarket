package factory;

import java.sql.*;

public class Factory {
	private Connection c;

	public Connection getC() {
		return c;
	}
	//construtor
	public Factory() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String URL = "jdbc:mysql://localhost:3306/bluesupermarket?useTimezone=true&serverTimezone=UTC&useSSL=false";
			c = DriverManager.getConnection(URL,"root","Gb2834*71");
		}catch(ClassNotFoundException e) {
			System.out.println("ERRO NO CONSTRUTOR DA CLASSE FACTORY!");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("ERRO AO CONFIGURAR A CONEXAO! (method setConnection())");
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
