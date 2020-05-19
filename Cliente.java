package Libro;


import com.mongodb.BasicDBObject;

public class Cliente {
	private int Cli_id;
	private String Cli_nombre;
	private String Cli_fecha;
	private int Cli_celular;
	private String Cli_correo;

	
	public Cliente() {
	}

	public Cliente(int Cli_id, String Cli_nombre, String Cli_fecha, int Cli_celular, String Cli_correo) {
        this.Cli_id = Cli_id;
        this.Cli_nombre = Cli_nombre;
        this.Cli_fecha = Cli_fecha;
        this.Cli_celular = Cli_celular;
        this.Cli_correo = Cli_correo;
    }

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Cliente(BasicDBObject dBObjectCliente) {
		
		this.Cli_id = dBObjectCliente.getInt("Cli_id");
		this.Cli_nombre = dBObjectCliente.getString("Cli_nombre");
		this.Cli_fecha =  dBObjectCliente.getString("Cli_fecha");
		this.Cli_celular = dBObjectCliente.getInt("Cli_celular");
		this.Cli_correo = dBObjectCliente.getString("Cli_celular");
		
		
	}

	public BasicDBObject dBObjectCliente() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectCliente = new BasicDBObject();
		dBObjectCliente.append("Aut_id", this.getCli_id());
		dBObjectCliente.append("Aut_nombre", this.getCli_nombre());
		dBObjectCliente.append("Aut_fecha", this.getCli_fecha());
		dBObjectCliente.append("Aut_celular", this.getCli_celular());
		dBObjectCliente.append("Aut_correo", this.getCli_correo());

		return dBObjectCliente;
	}
	
	
	public int getCli_id() {
        return Cli_id;
    }

    public void setCli_id(int Cli_id) {
        this.Cli_id = Cli_id;
    }

    public String getCli_nombre() {
        return Cli_nombre;
    }

    public void setCli_nombre(String Cli_nombre) {
        this.Cli_nombre = Cli_nombre;
    }

    public String getCli_fecha() {
        return Cli_fecha;
    }

    public void setCli_fecha(String Cli_fecha) {
        this.Cli_fecha = Cli_fecha;
    }

    public int getCli_celular() {
        return Cli_celular;
    }

    public void setCli_celular(int Cli_celular) {
        this.Cli_celular = Cli_celular;
    }

    public String getCli_correo() {
        return Cli_correo;
    }

    public void setCli_correo(String Cli_correo) {
        this.Cli_correo = Cli_correo;
    }
    
    @Override
	public String toString() {
		return "Codigo Cliente: " + this.getCli_id() + " / Nombre Cliente: " + this.getCli_nombre() +
				" / Fecha de Nacimiento Cliente: " + this.getCli_fecha() + "/ Celular Cliente"+ this.getCli_celular()
				 + "/ Correo del Cliente"+ this.getCli_correo();
	}
}
