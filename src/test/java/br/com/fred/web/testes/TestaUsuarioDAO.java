package br.com.fred.web.testes;

import java.util.List;

import br.com.fred.web.entidade.Cliente;
import br.com.fred.web.entidade.Usuario;
import br.com.fred.web.persistencia.ClienteDAO;
import br.com.fred.web.persistencia.UsuarioDAO;

public class TestaUsuarioDAO {

	 public static void main(String[] args) {
		//testaCadastrar();
		//testaAtualizar();
		//testaExcluir();
		//testaPesquisarPorId();
		//testaPesquisarTodos();
		//testaSalvar();
		testaAutenticar();
}

	private static void testaAutenticar() {
		Usuario usr = new Usuario();
		  usr.setLogin("clash");
		   usr.setSenha("123456");
		     UsuarioDAO dao = new UsuarioDAO();
	         Usuario usrRetorno = dao.autenticaUsuario(usr);
	         
	         if(usrRetorno!= null){
	        	 System.out.println(usrRetorno);
	         }
	         else{
	        	 System.out.println("Usuario não cadastrado.");
	         }
	}

	private static void testaSalvar() {
		Usuario usr = new Usuario();
	
			usr.setLogin("Lara1900");
			usr.setSenha("1900L");
			
		UsuarioDAO usrDAO = new UsuarioDAO();
		usrDAO.salvar(usr);
		
		System.out.println("Salvo com sucesso!");
		
	}

		private static void testaPesquisarTodos() {
			UsuarioDAO usrDAO = new UsuarioDAO();
				List<Usuario> listaUsr = usrDAO.pesquisarTodos();
					for(Usuario usr : listaUsr)
				System.out.println(usr);
				}
	
						private static void testaPesquisarPorId() {
							UsuarioDAO usrDAO = new UsuarioDAO();
							Usuario usr = usrDAO.pesquisarPorId(2);
							
							System.out.println(usr.toString());
														
			}
		
							private static void testaExcluir() {
								Usuario usr = new Usuario();
								usr.setId(1);
								
								UsuarioDAO usrDAO = new UsuarioDAO();
									usrDAO.excluirCadastro(usr);
									System.out.println("Resgistro exluído");
							}
								
					private static void testaAtualizar() {
						Usuario usr = new Usuario();
						UsuarioDAO usrDAO = new UsuarioDAO();
							usrDAO.atualizarCadastro(usr);
							
							System.out.println("Atualizado com sucesso!");
					}

	private static void testaCadastrar() {
		Usuario usr = new Usuario();
			usr.setLogin("perola");
			usr.setSenha("a1fred3479");
			
			UsuarioDAO usrDAO = new UsuarioDAO();
			usrDAO.cadastrarNovo(usr);
			
			System.out.println("Usuário cadastrado com sucesso!");
		
	}

}
