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
		}catch(ClassNotFoundException e) {
			System.out.println("ERRO NO CONSTRUTOR DA CLASSE FACTORY!");
			e.printStackTrace();
		}
	}
	
	//seta uma nova conexao
	public void setConnection(String URL) {
		try {
			 c = DriverManager.getConnection(URL,"root","Gb2834*71");

		}catch (SQLException e){
			System.out.println("ERRO AO CONFIGURAR A CONEXAO! (method setConnection())");
			System.out.println(e.getMessage());
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
