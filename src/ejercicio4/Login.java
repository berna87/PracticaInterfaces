package ejercicio4;

public class Login {
	private String nombreSitio;
	private String descripSitio;
	private String urlAcceso;
	private String usuario;
	private String  passwd;
	private String info;
	public Login(String nombreSitio, String descripSitio, String urlAcceso,
			String usuario, String passwd, String info) {
		super();
		this.nombreSitio = nombreSitio;
		this.descripSitio = descripSitio;
		this.urlAcceso = urlAcceso;
		this.usuario = usuario;
		this.passwd = passwd;
		this.info = info;
	}
	public String getNombreSitio() {
		return nombreSitio;
	}
	public void setNombreSitio(String nombreSitio) {
		this.nombreSitio = nombreSitio;
	}
	public String getDescripSitio() {
		return descripSitio;
	}
	public void setDescripSitio(String descripSitio) {
		this.descripSitio = descripSitio;
	}
	public String getUrlAcceso() {
		return urlAcceso;
	}
	public void setUrlAcceso(String urlAcceso) {
		this.urlAcceso = urlAcceso;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
}
