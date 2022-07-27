package DAO;

import factory.Factory;
import model.Produto;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDao {
	private Connection conn= new Factory().getC();
	private PreparedStatement pst;
	public ProdutosDao(){
		updateProdutos();
	}

	public void updateProdutos() {
		//1 Checa a existencia da tabela na database
		boolean cont = checkProdutos();
		if(cont==false) {
			return;
		}
		//2 Obtem os dados atraves do arquivo csv e atualiza os valores dentro da tabela

		String line = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Estagio-Backups\\AvaliacaoIV\\blueSupermarket\\blueSupermarket\\src\\main\\java\\DAO\\Produtos.csv",Charset.forName("ISO-8859-1")));
			while((line = br.readLine())!=null) {
				String[] produto = line.split(",");
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					java.util.Date data = sdf.parse(produto[5]);
					insertProduto(Integer.parseInt(produto[0]),produto[1],produto[2],Double.parseDouble(produto[3]),Integer.parseInt(produto[4]),data);
				}catch(ArrayIndexOutOfBoundsException e) {
					insertProduto(Integer.parseInt(produto[0]),produto[1],produto[2],Double.parseDouble(produto[3]),Integer.parseInt(produto[4]),null);
				}
			}
			br.close();
		}catch(ParseException e) {
			System.out.println("Erro na conversão de datas! (method updateProdutos())");
			System.out.println(e.getMessage());
			return;
			
		}catch(IOException e) {
			System.out.println("Erro na leitura do arquivo CSV! (method updateProdutos())");
			System.out.println(e.getMessage());
			return;
		}
		System.out.println("ATUALIZAÇÃO CONCLUIDA!!");
	}
	
	private boolean checkProdutos() {
		try {
			String sql = "CREATE TABLE produtos(ID int,NOME varchar(150),DESCRICAO varchar(300),PRECO double,QUANTIDADE int, VALIDADE date,PRIMARY KEY(ID))";
			pst= conn.prepareStatement(sql);
			pst.execute();
		}catch (SQLException e) {
			String msg = e.getMessage();
			if(msg.equals("Table 'produtos' already exists")) {
				System.out.println("Tabela 'produtos' ja existe, atualizando os itens \n ");
			}else {
				System.out.println("ERRO AO CHECAR EXISTENCIA DA TABELA produtos ! (method checkProdutos())");
				System.out.println(msg);
				return false;
			}
		}
		return true;
	}
	
	public void insertProduto(int ID, String nome, String desc, double preco, int quant, java.util.Date validade) {
		java.sql.Date data = null;
		if(validade!=null) {
			data = converteData(validade);
		}
		String sql = "INSERT INTO produtos(ID,NOME,DESCRICAO,PRECO,QUANTIDADE,VALIDADE) VALUES(?,?,?,?,?,?)";
		try {
			pst= conn.prepareStatement(sql);
			pst.setInt(1, ID);
			pst.setString(2, nome);
			pst.setString(3, desc);
			pst.setDouble(4, preco);
			pst.setInt(5, quant);
			pst.setDate(6, data);
			pst.execute();
		}catch(SQLException e) {
			if(!(e.getMessage().contains("Duplicate"))){
				System.out.println("ERRO AO INSERIR PRODUTO "+nome+"! (method insertProduto())");
				System.out.println(e.getMessage());
			}
		}
	}
	
	private java.sql.Date converteData(java.util.Date data){
		return new java.sql.Date(data.getTime());
	}
	
	
	public void updateQuant(int ID, int quant){
		String sql = "UPDATE produtos SET QUANTIDADE = "+quant;
		try {
			pst= conn.prepareStatement(sql);
			pst.execute();
		}catch(SQLException e) {
			System.out.println("ERRO AO ATUALIZAR A TABELA! (method updateQuant())");
			System.out.println(e.getMessage());
		}
	}
	
	public List<Produto> getProdutos(){
		List<Produto> produtos = new ArrayList();
		String sql = "SELECT * FROM produtos";
		
		try {
			pst= conn.prepareStatement(sql);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()) {
				Produto produto = new Produto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDate(6),0);
				produtos.add(produto);
			}
			return produtos;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Produto getProdutosPorId(int id) {
		Produto produto = null;
		String sql = "SELECT * FROM produtos WHERE id = ?";

		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1,id);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()) {
				produto = new Produto(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4),rs.getInt(5),rs.getDate(6),0);
				if(!rs.next()) return produto;
			}
			return produto;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Produto> listaProdutoPorNome(String nome){
		List<Produto> produtos = new ArrayList();
		String nomeSql = "%"+nome+"%";
		String sql = "SELECT ID, NOME FROM produtos WHERE NOME LIKE ?";

		try {
			pst= conn.prepareStatement(sql);
			pst.setString(1,nomeSql);
			pst.execute();
			ResultSet rs = pst.getResultSet();
			while(rs.next()) {
				produtos.add(new Produto(rs.getInt(1),rs.getString(2)));
				if(!rs.next()) return produtos;
			}
			return produtos;
		}catch(SQLException e) {
			System.out.println("ERRO AO OBTER PRODUTO! (method getProdutos())");
			System.out.println(e.getMessage());
			return null;
		}
	}
}
