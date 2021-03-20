package beans;

public class LembreteBeans {

	private String id;
	private String titulo;
	private String msg;
	


	public LembreteBeans() {
		super();
	}
	
	public LembreteBeans(String id, String titulo, String msg) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "LembreteBeans [id=" + id + ", titulo=" + titulo + ", msg=" + msg + "]";
	}
	
	


}
