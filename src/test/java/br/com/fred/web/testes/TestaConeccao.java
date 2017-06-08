package br.com.fred.web.testes;

import br.com.fred.web.persistencia.ConnectionFactory;

public class TestaConeccao {

	public static void main(String[] args) {
		ConnectionFactory  conector = new ConnectionFactory();
		conector.getConnection();
	 System.out.println("Conexão aberta!");
	}

}
