package br.com.fred.web.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.mysqla.result.Resultset;

import br.com.fred.web.entidade.Contato;


public class ContatoDAO {

	Connection conector = ConnectionFactory.getConnection();
	
	public void adiciona(Contato contato) {
		String sql = "insert into contato(nome_contato, endereco_contato, email_contato) values(?, ?, ?)";
			try {
				PreparedStatement stmt = conector.prepareStatement(sql);
					stmt.setString(1, contato.getNome());
					stmt.setString(2, contato.getEndereco());
					stmt.setString(3, contato.getEmail());
					stmt.execute();
				stmt.close();
				} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		System.out.println("Contato adicionado com sucesso!");
	  }

	public void atualiza(Contato contato){
		String sql ="update contato set nome_contato=?, endereco_contato=?, email_contato=? where id_contato=? ";
			try {
				PreparedStatement stmt = conector.prepareStatement(sql);
				stmt.setString(1, contato.getNome());
				stmt.setString(2, contato.getEndereco());
				stmt.setString(3, contato.getEmail());
				stmt.setInt(4, contato.getId());
			stmt.execute();
			stmt.close();
			} 
		    catch (SQLException e) {
		throw new RuntimeException(e);
		}
		System.out.println("Atualizado com sucesso!");
	}
	
	public void excluir(Contato contato){
		String sql = "delete from contato where id_contato=?";
			try {
				PreparedStatement stmt = conector.prepareStatement(sql);
				  stmt.setInt(1, contato.getId());
				  stmt.execute();
				  stmt.close();
				 } 
			     catch (SQLException e) {
				 throw new RuntimeException(e);
			   }
			System.out.println("Copntato excluído com sucesso!");
	}
	
	public Contato buscarPorId(Integer id){
		//List<Contato> lista = new ArrayList<Contato>();	
			String sql = "select * from contato where id_contato=?";
				  try  {
						PreparedStatement stmt = conector.prepareStatement(sql);
						  stmt.setInt(1, id);
						    ResultSet rst = stmt.executeQuery();
						      while(rst.next()){
							    Contato contato = new Contato();
								  contato.setId(rst.getInt("id_contato"));
									contato.setNome(rst.getString("nome_contato"));
									  contato.setEndereco(rst.getString("endereco_contato"));
									    contato.setEmail(rst.getString("email_contato"));
									   return contato;
							  		  }
						           stmt.close();
							  	  } 
				  				catch (SQLException e) {
							  throw new RuntimeException(e);
							}
						  return null;
						}
	
	 public List<Contato> buscaTodos(){
		 String  sql = "Select * from contato";
		   List<Contato> lista = new ArrayList<Contato>();
		     try {
				PreparedStatement stmt = conector.prepareStatement(sql);
				  ResultSet rst = stmt.executeQuery();
				    while(rst.next()){
				    Contato contato = new Contato();
				      contato.setId(rst.getInt("id_contato"));
				       contato.setNome(rst.getString("nome_contato"));
				        contato.setEndereco(rst.getString("endereco_contato"));
				         contato.setEmail(rst.getString("email_contato"));
				       lista.add(contato);
				      stmt.close();
			         } 
				    }
		          catch (SQLException e) {
				throw new RuntimeException(e);
			  }
		    return lista;
		   }
	 
	 public void salvar(Contato contato){
	    String sql ="insert into contato(nome_contato, endereco_contato, email_contato) values(?, ?, ?)";
	      try {
			PreparedStatement stmt = conector.prepareStatement(sql);
			  if(contato.getId()!=null){
			    adiciona(contato);
			    }
			     else
			       {
		           atualiza(contato);
		          }
		        } 
	          catch (SQLException e) 
	         {
			throw new RuntimeException(e);
		   }
	        
		    
	
	  }
	 
	 
}
