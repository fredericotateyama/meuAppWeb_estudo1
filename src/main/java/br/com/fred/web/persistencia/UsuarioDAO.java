package br.com.fred.web.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.api.mysqla.result.Resultset;

import br.com.fred.web.entidade.Usuario;

public class UsuarioDAO {

	private Connection  conexao = ConnectionFactory.getConnection();
	
	
	public void cadastrarNovo(Usuario usr) {
		String sql = "insert into usuario(login_usr, senha_usr)  values(?, ?);";
		 	//Os parenteses impoem uma condição de fechamento de conexão
		 	try (PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.setString(1, usr.getLogin());
				  stmt.setString(2, usr.getSenha());
					stmt.execute();
				    } 
			 	catch (SQLException e) {						
			throw new RuntimeException(e);
			}
		}

		
	public void atualizarCadastro(Usuario usr) {
		String sql = "update usuario set senha_usr=0001 where id_usr=1";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)){
				stmt.execute();
				} 
			catch (SQLException e) {
		  throw new RuntimeException(e);
	     }
	   }


		public void excluirCadastro(Usuario usr) {
			String sql = "delete from usuario where id_usr=?";
				try (PreparedStatement stmt = conexao.prepareStatement(sql)){
					stmt.setInt(1, usr.getId());
					stmt.execute();
					} 
				catch (SQLException e) {
			  throw new RuntimeException(e);
		     }
		}

			
		public Usuario pesquisarPorId(Integer id) {
			String sql = "select * from usuario where id_usr=?";
				try (PreparedStatement stmt = conexao.prepareStatement(sql)){
					stmt.setInt(1, id);
						ResultSet rst = stmt.executeQuery();
							if(rst.next()){
						  Usuario usr = new Usuario();
						usr.setId(rst.getInt("id_usr"));
					  usr.setLogin(rst.getString("login_usr"));
				    usr.setSenha(rst.getString("senha_usr"));
			      return usr;
			     }
		       } 
		    catch (SQLException e) {
		  throw new RuntimeException(e);
		}
	return null;
   }
			

				/**
				 * Faz uma busca no BD(dentro da tabela especificada), e traz todos os registros existentes.
				 * @return Retorna uma lista(vetor) de registros encontrados no BD.
				 */
	public List<Usuario> pesquisarTodos() {
			String sql = "select * from usuario";
			  //Instancia uma lista de usuários, dentro de uma matriz 
			  List<Usuario> listaUsr = new ArrayList<Usuario>();
				  try (PreparedStatement stmt = conexao.prepareStatement(sql)){
				     ResultSet rst = stmt.executeQuery();	
				       //Enquanto houver registro continua a iteração.
				       while(rst.next()){
					     Usuario usr = new Usuario();
					       usr.setId(rst.getInt("id_usr"));
					        usr.setLogin(rst.getString("login_usr"));
					         usr.setSenha(rst.getString("senha_usr"));
					       //Adiciona o registro de usuário para o objeto(lista)
					       listaUsr.add(usr);
				         }
					   } 
				   catch (SQLException e) {
				throw new RuntimeException(e);
			   }
		    return listaUsr;
		   }


	public void salvar(Usuario usr) {
		String sql = "insert into usuario (login_usr,senha_usr) values(?,?)";
			try (PreparedStatement stmt = conexao.prepareStatement(sql)){
				//Faz uma busca no BD se exitir o registro do usuário ele atualiza, senão cadastra um novo.
				if(usr.getId()!=null){
					//Faz uma update no registro
				  atualizarCadastro(usr);
				}
				else{
			 //Cadastra um novo usuário
			 cadastrarNovo(usr);
		   }			
		 } 
	  catch (SQLException e) {
     throw new RuntimeException(e);
	}
  }

	public Usuario autenticaUsuario(Usuario usrConsulta){
		String sql ="select * from usuario where login_usr=? and senha_usr=? ";
		  try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			  stmt.setString(1, usrConsulta.getLogin());
			    stmt.setString(2, usrConsulta.getSenha());
			      ResultSet rst = stmt.executeQuery();
			        if(rst.next()){
			         Usuario usr = new Usuario();
			        usr.setId(rst.getInt("id_usr"));	
			      usr.setLogin(rst.getString("login_usr"));
			     usr.setSenha(rst.getString("senha_usr"));
			   return usr;
			  } 
		    }
	      catch (SQLException e) {
		throw new RuntimeException(e);
	   }
	 return null;
	}



}