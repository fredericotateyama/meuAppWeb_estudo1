package br.com.fred.web.entidade;

import java.util.Calendar;
import java.util.Date;

public class Contato {

	private Integer id;
	private String nome;
	private String endereco;
	private String email;
	
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
			
		
			@Override
				public String toString() {
				  return "Contato [id=" + id + ", nome=" + nome + ", endereco=" + endereco + ", email=" + email + "]";
				}
				
				
		
}
