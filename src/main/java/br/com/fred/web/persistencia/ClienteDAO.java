package br.com.fred.web.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fred.web.entidade.Cliente;

public class ClienteDAO {

	private Connection  conexao = ConnectionFactory.getConnection();
	
	
	public void cadastrarCl(Cliente cl) {
		//Comando SQL
		String sql = "insert into cliente" + "(nome, rg, cpf, tel)" + "values(?, ?, ?, ?);";
			//Criando um statment
			//Com os parenteses, torna-se auto closeable
			try (PreparedStatement stmt = conexao.prepareStatement(sql)) {							
				//preenche os "?"
				stmt.setString (1, cl.getNomeCliente());
				 stmt.setString (2, cl.getRgCliente());
				  stmt.setString (3, cl.getCpfCliente());
				   stmt.setString (4, cl.getTelCliente());
				  stmt.execute();
				 } 
				catch (SQLException e) {
			  throw new RuntimeException(e);
		     }
		}

	public void atualizarCl (Cliente cl) {			
			//Comando SQL
			String sql = "update cliente set nome=?, rg=?, cpf=?, tel=? where id=?";		
				//Criando um statment
				//Com os parenteses, torna-se auto closeable
				try (PreparedStatement stmt = conexao.prepareStatement(sql)) {										
					//preenche os "?"
					stmt.setString (1, cl.getNomeCliente());
					 stmt.setString (2, cl.getRgCliente());
					  stmt.setString (3, cl.getCpfCliente());
					   stmt.setString (4, cl.getTelCliente());
					    stmt.setInt    (5, cl.getIdCliente());		
					  stmt.execute();		
					 } 
				  catch (SQLException e) {
				 throw new RuntimeException(e);
				}
			  }

			public void removerCl(Cliente cl) {			
					//Comando SQL
					String sql = "delete from cliente where id=?";
							//Criando um statment
							//Com os parenteses, torna-se auto closeable
							try (PreparedStatement stmt = conexao.prepareStatement(sql)) {							
								//preenche os "?"
								stmt.setInt    (1, cl.getIdCliente());
								stmt.execute();		
							   }
						catch (SQLException e) {	
					throw new RuntimeException(e);
				}			
			 }

			
	public void salvarCl(Cliente cl) {	
			if(cl.getIdCliente()!=null){
				atualizarCl(cl);
			 }
			 else{
				cadastrarCl(cl);
			}
		 }
	
		/**
		 * Busca de um registro no BD pelo número do ID do usuário.
		 * @param id É um inteiro que representa o número do usuário a ser buscado.
		 * @return Um objeto cliente quando encontrado ou, nulo quando não encontrado nenhum registro.
		 */
		public Cliente pesquisarClPorId(Integer id) {
			//Cliente clRetorno = null;
			String sql = "select * from cliente where id=?";
				   try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
					     stmt.setInt(1, id);
						        //Tras oresultado total da pesquisa
						        ResultSet rst = stmt.executeQuery();
						            //Posicionamentodo cursor noprimeiro registro  
								    if(rst.next()){
									Cliente cl =  new Cliente();
								cl.setIdCliente(rst.getInt("id"));
							  cl.setNomeCliente(rst.getString("nome"));
						   cl.setRgCliente(rst.getString("rg"));
					    cl.setCpfCliente(rst.getString("cpf"));
				     cl.setTelCliente(rst.getString("tel"));
			      return cl;
				 }
			   } 
		    catch (SQLException e) {
		  throw new RuntimeException(e);
	    }
    return null;
   }
		 
		/**
		 * Realiza uma busca de todos os registros da tabela de clientes.
		 * @return Uma lista de objetos referente a clientes, contendo 0 quando não existir registro,
		 * ou muitos objetos quando obter resultado.
		 */
		public List<Cliente> pesquisarClTodos() {
			//Cliente clRetorno = null;
			String sql = "select * from cliente";
				List<Cliente> clLista = new ArrayList<Cliente>();
					try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
						//Tras oresultado total da pesquisa
						ResultSet rst = stmt.executeQuery();
						//Posicionamentodo cursor noprimeiro registro  
						    while(rst.next()){
								Cliente cl =  new Cliente();
							   cl.setIdCliente(rst.getInt("id"));
							 cl.setNomeCliente(rst.getString("nome"));
						   cl.setRgCliente(rst.getString("rg"));
					      cl.setCpfCliente(rst.getString("cpf"));
					    cl.setTelCliente(rst.getString("tel"));
		            //Adicina usuário na lista
					clLista.add(cl);
					}
				} 
			catch (SQLException e) {
		throw new RuntimeException(e);
	   }
	return clLista;
   }
			



}
