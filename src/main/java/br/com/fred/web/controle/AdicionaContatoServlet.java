package br.com.fred.web.controle;

import java.io.IOException;
import java.io.PrintWriter;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fred.web.entidade.Contato;
import br.com.fred.web.persistencia.ContatoDAO;


/**
 * Servlet implementation class AdicionaContatoServlet
 */
@WebServlet("/adicionacontato")
public class AdicionaContatoServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
	  throws IOException, ServletException{
		//busca o writer
		PrintWriter out = resp.getWriter();
			//Buscando parametros no request
			String nome = req.getParameter("nome");
			 String endereco = req.getParameter("endereco");
			  String email = req.getParameter("email");
			  	//Monta um objeto contato
			  	Contato contato = new Contato();
			  	  contato.setNome("Paulo da Silva");
			  	   contato.setEndereco("Av Paulista");
			  	    contato.setEmail("plm@hotmail.com");		  	 
			  	    //Salva o contato no BD
			  	    ContatoDAO dao = new ContatoDAO();
			  	   dao.adiciona(contato);
			  	 //Imprime o nome do contato que foi adicionado
			  	out.println("<html>");
			  out.println("<body>");
		    out.println("Contato:" + " "+ contato.getNome() + " " + " adicionado com sucesso");
		  out.println("</html>");
		out.println("</body>");		  	  	
	}
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionaContatoServlet() {
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
