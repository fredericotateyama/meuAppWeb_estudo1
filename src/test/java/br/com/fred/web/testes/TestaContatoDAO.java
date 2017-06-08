package br.com.fred.web.testes;

import java.util.List;

import br.com.fred.web.entidade.Contato;
import br.com.fred.web.persistencia.ContatoDAO;

public class TestaContatoDAO {

	public static void main(String[] args) {
		//testaAdiciona();
		//testaAtualizacao();
		//testaExcluir();
		//testaBuscarPorId();
		//testaBuscarTodos();
		 testaSalvar();
		
	}
		
	

	private static void testaSalvar() {
		Contato contato = new Contato();
		  contato.setNome("Rodrigo Petrilho");
    	    contato.setEndereco("Rua Imarés");
    	      contato.setEmail("rpetrilho@gmail.com");
			ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
	}



	private static void testaBuscarTodos() {
		ContatoDAO dao = new ContatoDAO();
		  List<Contato> lista = dao.buscaTodos();
			for(Contato c : lista)
			  System.out.println(c);
				}



	private static void testaBuscarPorId() {
		ContatoDAO dao = new ContatoDAO();
		Contato contato = dao.buscarPorId(2);
		
		System.out.println(contato.toString());
		
	}



	private static void testaExcluir() {
		Contato contato = new Contato();
		contato.setId(3);
			ContatoDAO dao = new ContatoDAO();
			dao.excluir(contato);
		
	}



	private static void testaAtualizacao() {
		Contato contato = new Contato();
			contato.setId(2);
			 contato.setNome("Julia Pereira");
			  contato.setEndereco("Av Aclimação");
			   contato.setEmail("jp@gmail.com");
			
			ContatoDAO dao = new ContatoDAO();
			dao.atualiza(contato);
	}



	private static void testaAdiciona() {
			Contato contato = new Contato();
		    	contato.setNome("Rodrigo Petrilho");
		    	 contato.setEndereco("Rua Imarés");
		    	  contato.setEmail("rpetrilho@gmail.com");
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);

	}

}
