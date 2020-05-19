package Libro;




import com.mongodb.BasicDBObject;

public class Autor {
	
	private int Aut_id;
	private String Aut_nombre;
	private String Aut_fecha;
	private int Aut_celular;
	private String Aut_correo;

	
	public Autor() {
	}

	public Autor(int Aut_id, String Aut_nombre, String Aut_fecha, int Aut_celular, String Aut_correo) {
        this.Aut_id = Aut_id;
        this.Aut_nombre = Aut_nombre;
        this.Aut_fecha = Aut_fecha;
        this.Aut_celular = Aut_celular;
        this.Aut_correo = Aut_correo;
    }

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Autor(BasicDBObject dBObjectAutor) {
		
		this.Aut_id = dBObjectAutor.getInt("Aut_id");
		this.Aut_nombre = dBObjectAutor.getString("Aut_nombre");
		this.Aut_fecha =  dBObjectAutor.getString("Aut_fecha");
		this.Aut_celular = dBObjectAutor.getInt("Aut_celular");
		this.Aut_correo = dBObjectAutor.getString("Aut_celular");
		
		
	}

	public BasicDBObject dBObjectAutor() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectAutor = new BasicDBObject();
		dBObjectAutor.append("Aut_id", this.getAut_id());
		dBObjectAutor.append("Aut_nombre", this.getAut_nombre());
		dBObjectAutor.append("Aut_fecha", this.getAut_fecha());
		dBObjectAutor.append("Aut_celular", this.getAut_celular());
		dBObjectAutor.append("Aut_correo", this.getAut_correo());

		return dBObjectAutor;
	}

	public int getAut_id() {
        return Aut_id;
    }

    public void setAut_id(int Aut_id) {
        this.Aut_id = Aut_id;
    }

    public String getAut_nombre() {
        return Aut_nombre;
    }

    public void setAut_nombre(String Aut_nombre) {
        this.Aut_nombre = Aut_nombre;
    }

    public String getAut_fecha() {
        return Aut_fecha;
    }

    public void setAut_fecha(String Aut_fecha) {
        this.Aut_fecha = Aut_fecha;
    }

    public int getAut_celular() {
        return Aut_celular;
    }

    public void setAut_celular(int Aut_celular) {
        this.Aut_celular = Aut_celular;
    }

    public String getAut_correo() {
        return Aut_correo;
    }

    public void setAut_correo(String Aut_correo) {
        this.Aut_correo = Aut_correo;
    }

	@Override
	public String toString() {
		return "Codigo Autor: " + this.getAut_id() + " / Nombre Autor: " + this.getAut_nombre() +
				" / Fecha de Nacimiento Autor: " + this.getAut_fecha() + "/ Celular Autor"+ this.getAut_celular()
				 + "/ Correo del Cliente"+ this.getAut_correo();
	}
}