package br.com.teia;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fred.web.entidade.Produto;
import br.com.fred.web.persistencia.ProdutoDAO;

/**
 * Servlet implementation class BuscaProduto
 * 
 */
// O "/busca" é o endereço da servlet
@WebServlet("/busca")
public class BuscaProduto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaProduto() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		writer.println("<html><body>");
			writer.println("Resultado da busca:<br/>");
			//String filtro = "informática";
				//Produto pd = new ProdutoDAO().pesquisarPorId(null);
					//for(Produto produto : pd){
						//writer.println("Olá mundo web!!!!!!!!!!!");
						//writer.println(pd.getIdP());
					
						
			writer.println("</html></body>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
