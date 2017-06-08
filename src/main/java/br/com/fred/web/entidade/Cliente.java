package br.com.fred.web.entidade;

public class Cliente {

	private Integer    idCliente;
	private String nomeCliente;
	private String rgCliente;
	private String cpfCliente;
	private String telCliente;
		
	    public Integer getIdCliente() {
			return idCliente;
		}
		public void setIdCliente(Integer idCliente) {
			this.idCliente = idCliente;
		}
		public String getNomeCliente() {
			return nomeCliente;
		}
		public void setNomeCliente(String nomeCliente) {
			this.nomeCliente = nomeCliente;
		}
		public String getRgCliente() {
			return rgCliente;
		}
		public void setRgCliente(String rgCliente) {
			this.rgCliente = rgCliente;
		}
		public String getCpfCliente() {
			return cpfCliente;
		}
		public void setCpfCliente(String cpfCliente) {
			this.cpfCliente = cpfCliente;
		}
		public String getTelCliente() {
			return telCliente;
		}
		public void setTelCliente(String telCliente) {
			this.telCliente = telCliente;
		}
		
		
		@Override
		public String toString() {
			return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", rgCliente=" + rgCliente
					+ ", cpfCliente=" + cpfCliente + ", telCliente=" + telCliente + "]";
		}
	
		
	
}
