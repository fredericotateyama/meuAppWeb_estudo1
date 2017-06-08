package br.com.fred.web.testes;

import java.util.List;

import br.com.fred.web.entidade.Produto;
import br.com.fred.web.persistencia.ProdutoDAO;

public class TesteProduto {

	public static void main(String[] args) {
		 testaCadastrar();
		//testaExcluir();
		//testaAtualizar();
		//testaPesquisarPorId();
		//testaPesquisarTodos();
		//testaSalvar();

}

	private static void testaSalvar() {
			Produto pd = new Produto();
			
				pd.setNomeP("Memória RAM 4gb 1333HZ");
				pd.setCategoriaP("Informática - hardware");
				pd.setValorP(380);
			
				ProdutoDAO pdDAO = new ProdutoDAO();
				pdDAO.salvar(pd);
			System.out.println("Salvo!");
		}

	private static void testaPesquisarTodos() {
		ProdutoDAO pdDAO = new ProdutoDAO();
			List<Produto> listaP = pdDAO.pesquisarTodos();
				for(Produto pd : listaP)
					System.out.println(pd);
		
	}

		private static void testaPesquisarPorId() {
			ProdutoDAO pdDAO = new ProdutoDAO();
			Produto pd = pdDAO.pesquisarPorId(5);
				
			System.out.println(pd.toString());
			}
		
					private static void testaAtualizar() {
						Produto pd = new Produto();
							pd.setIdP(2);	
							pd.setNomeP("Mouse");
							pd.setCategoriaP("informática");
							pd.setValorP(23.40);
								ProdutoDAO pdDAO = new ProdutoDAO();
								pdDAO.atualizar(pd);
								
							System.out.println("Atualizado com sucesso!");
						
					}

	private static void testaExcluir() {
		Produto pd = new Produto();
			pd.setIdP(1);
		ProdutoDAO pdDAO = new ProdutoDAO();
		pdDAO.excluirProduto(pd);
		
		System.out.println("Produto excluído.");
	}

			private static void testaCadastrar() {
				Produto pd = new Produto();
					pd.setNomeP("Mother board Gygabyte");
					pd.setCategoriaP("informática");
					pd.setValorP(1120.00);
						ProdutoDAO pDAO = new ProdutoDAO();
						pDAO.cadastrarNovoProduto(pd);
				
				System.out.println("Produto cadastrado!");
			}

}
