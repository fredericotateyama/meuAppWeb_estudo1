package br.com.fred.web.testes;

import java.util.List;

import br.com.fred.web.entidade.Cliente;
import br.com.fred.web.persistencia.ClienteDAO;

public class TesteClienteDAO {

	public static void main(String[] args) {
		 //testeCadastrar();
		 //testeAtualizar();
		 //testeRemover();
		 //testaPesquisar();
		 //testaSalvar();
		  testePesquisarClPorId();
		//testePesquisarTodos();
	}	
	
public static void testeCadastrar() {
		
	Cliente cl = new Cliente();
		cl.setNomeCliente("Flávia Guimarães");
		cl.setRgCliente("00000001");
		cl.setCpfCliente("223232323");
		cl.setTelCliente("01010101010");
		
		 ClienteDAO clDAO = new ClienteDAO();
		 clDAO.cadastrarCl(cl);
		
		System.out.println("Cliente cadastrado com sucesso!");
	}


			  public static void testeAtualizar() {
					Cliente cl = new Cliente();
					
					  cl.setIdCliente(1);
					  cl.setNomeCliente("Freddy Tateyama");
					  cl.setRgCliente("1230");
					  cl.setCpfCliente("11122");
					  cl.setTelCliente("11 90");
					
					  ClienteDAO clDAO = new ClienteDAO();
					  clDAO.atualizarCl(cl);
					
					System.out.println("Atualizado com sucesso!");
				}

				private static void testeRemover() {		
					Cliente cl = new Cliente();
									
					  cl.setIdCliente(8);		
					    ClienteDAO clDAO = new ClienteDAO();
					    clDAO.removerCl(cl);
						
						System.out.println("Registro removido");
					}

	private static void testaPesquisar() {				
		Cliente cl = new Cliente();	
	  }


			private static void testaSalvar() {
				Cliente cl = new Cliente();
				
					cl.setIdCliente(1);
					cl.setNomeCliente("Frederico Tateyama");
					cl.setRgCliente("00002545636");
					cl.setCpfCliente("55555500001");
					cl.setTelCliente("11 9 0001-9990");
				
				ClienteDAO clDAO = new ClienteDAO();
			    clDAO.salvarCl(cl);	
			    
		   System.out.println("Salvo com sucesso!");
	       }

					private static void testePesquisarClPorId() {
						ClienteDAO clDAO = new ClienteDAO();
						Cliente cl = clDAO.pesquisarClPorId(7);
						
						System.out.println(cl.toString());
					}
					
		
private static void testePesquisarTodos() {
		ClienteDAO clDAO = new ClienteDAO();
		
		List<Cliente> clLista = clDAO.pesquisarClTodos();
		  for(Cliente cl: clLista){
		  System.out.println(cl);
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	