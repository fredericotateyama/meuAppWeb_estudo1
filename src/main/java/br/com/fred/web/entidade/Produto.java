package br.com.fred.web.entidade;

public class Produto {

	private Integer idP;
	private String nomeP;
	private String categoriaP;
	private double valorP;
	
	
		public Integer getIdP() {
			return idP;
		}
		public void setIdP(Integer idP) {
			this.idP = idP;
		}
		public String getNomeP() {
			return nomeP;
		}
		public void setNomeP(String nomeP) {
			this.nomeP = nomeP;
		}
		public String getCategoriaP() {
			return categoriaP;
		}
		public void setCategoriaP(String categoriaP) {
			this.categoriaP = categoriaP;
		}
		public double getValorP() {
			return valorP;
		}
		public void setValorP(double valorP) {
			this.valorP = valorP;
		}
		
		@Override
			public String toString() {
				return "Produto [idP=" + idP + ", nomeP=" + nomeP + ", categoriaP=" + categoriaP + ", valorP=" + valorP
					+ "]";
		}
		
	
	
}
