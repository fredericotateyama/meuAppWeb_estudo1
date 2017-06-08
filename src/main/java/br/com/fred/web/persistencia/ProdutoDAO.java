package br.com.fred.web.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mysql.cj.api.mysqla.result.Resultset;

import br.com.fred.web.entidade.Produto;

public class ProdutoDAO {

private Connection conexao = ConnectionFactory.getConnection();
	
	public void cadastrarNovoProduto(Produto pd) {
		String sql = "insert into produto(nome_produto, categoria_produto, valor_produto) values(?,?,?)";
			try {
				//Prepara para inserção no BD
				PreparedStatement stmt = conexao.prepareStatement(sql);
					//Configura os valores
					stmt.setString(1, pd.getNomeP());
					 stmt.setString(2, pd.getCategoriaP());
					  stmt.setDouble(3, pd.getValorP());
				    //Executa a inserção
				  stmt.execute();
				//Termina conexão
			stmt.close();
		   } 
		catch (SQLException e) {
	  throw new RuntimeException(e);
     }
    }

	public void excluirProduto(Produto pd) {
		String  sql = "delete from produto where id_produto=?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				//Seta o ID do produto para referenciar a exclusão
				stmt.setInt(1, pd.getIdP());
				stmt.execute();
			  stmt.close();
			}  
		catch (SQLException e) {
	  throw new RuntimeException(e);
	}
  }

	public void atualizar(Produto pd) {
		String sql = "update produto set nome_produto=?, categoria_produto=?, valor_produto=? where id_produto=?";
			try {
				PreparedStatement stmt = conexao.prepareStatement(sql);
				  stmt.setString(1, pd.getNomeP());
				   stmt.setString(2, pd.getCategoriaP());
				    stmt.setDouble(3, pd.getValorP());
				     stmt.setInt(4, pd.getIdP());
				   stmt.execute();
				stmt.close();
			   }     
		    catch (SQLException e) {
		  throw new RuntimeException(e);
		}	
	}

	public Produto pesquisarPorId(Integer idP) {
		String sql = "select * from produto where id_produto=?";
		try {
			PreparedStatement stmt = conexao.prepareStatement(sql);
			  stmt.setInt(1, idP);
			    ResultSet  rst = stmt.executeQuery();
				   if(rst.next()){
					  Produto pd = new Produto();
						//Parametro 'id_produto'(nome) é o que vem do BD
					    pd.setIdP(rst.getInt("id_produto"));
						 pd.setNomeP(rst.getString("nome_produto"));
						  pd.setCategoriaP(rst.getString("categoria_produto"));
						   pd.setValorP(rst.getDouble("valor_produto"));
						  return pd;
				         }
			         stmt.close();
					} 
				catch (SQLException e) {
			 throw new RuntimeException(e);
		   }
		 return null;
	   }

	public List<Produto> pesquisarTodos() {
		String sql = "select * from produto";
		 List<Produto> listaP = new ArrayList<Produto>();
		    try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			  ResultSet rst = stmt.executeQuery();
			  	while(rst.next()){
			  		Produto pd = new Produto();
			  			pd.setIdP(rst.getInt("id_produto"));
			  			 pd.setNomeP(rst.getString("nome_produto"));
			  			  pd.setCategoriaP(rst.getString("categoria_produto"));
			  			   pd.setValorP(rst.getDouble("valor_produto"));
			  			  listaP.add(pd);
			  			 }
			           } 
		            catch (SQLException e) {
			      throw new RuntimeException(e);
		         }
		        return listaP;
	          }

	public void salvar(Produto pd) {
		String sql = "insert into produto(nome_produto,categoria_produto,valor_produto) values(?,?,?)";
		try (PreparedStatement stmt = conexao.prepareStatement(sql)){
			if(pd.getIdP()!=null){
				cadastrarNovoProduto(pd);
			   }
			  else{
			atualizar(pd);
		   }
		  } 
		catch (SQLException e) {
	   throw new RuntimeException(e);
	  }
	}




}
