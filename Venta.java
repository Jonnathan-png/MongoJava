package Libro;



import com.mongodb.BasicDBObject;

public class Venta {
	private int Ven_id;
	private String Cli_nombre;
	private String Lib_nombre;
	private String Ven_fecha;
	private int Ven_cantidad;
	
	public Venta() {
	}

	public Venta(int Ven_id, String Cli_nombre, String Lib_nombre, String Ven_fecha, int Ven_cantidad) {
        this.Ven_id = Ven_id;
        this.Cli_nombre = Cli_nombre;
        this.Lib_nombre = Lib_nombre;
        this.Ven_fecha = Ven_fecha;
        this.Ven_cantidad = Ven_cantidad;
    }

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Venta(BasicDBObject dBObjectVenta) {
		
		this.Ven_id = dBObjectVenta.getInt("Ven_id");
		this.Cli_nombre = dBObjectVenta.getString("Cli_nombre");
		this.Lib_nombre =  dBObjectVenta.getString("Lib_nombre");
		this.Ven_fecha = dBObjectVenta.getString("Ven_fecha");
		this.Ven_cantidad = dBObjectVenta.getInt("Ven_cantidad");
		
		
	}

	public BasicDBObject dBObjectVenta() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectVenta = new BasicDBObject();
		dBObjectVenta.append("Ven_id", this.getVen_id());
		dBObjectVenta.append("Cli_nombre", this.getCli_nombre());
		dBObjectVenta.append("Lib_nombre", this.getLib_nombre());
		dBObjectVenta.append("Ven_fecha", this.getVen_fecha());
		dBObjectVenta.append("Ven_cantidad", this.getVen_cantidad());

		return dBObjectVenta;
	}
	
	
	public int getVen_id() {
        return Ven_id;
    }

    public void setVen_id(int Ven_id) {
        this.Ven_id = Ven_id;
    }

    public String getCli_nombre() {
        return Cli_nombre;
    }

    public void setCli_nombre(String Cli_nombre) {
        this.Cli_nombre = Cli_nombre;
    }

    public String getLib_nombre() {
        return Lib_nombre;
    }

    public void setLib_nombre(String Lib_nombre) {
        this.Lib_nombre = Lib_nombre;
    }

    public String getVen_fecha() {
        return Ven_fecha;
    }

    public void setVen_fecha(String Ven_fecha) {
        this.Ven_fecha = Ven_fecha;
    }

    public int getVen_cantidad() {
        return Ven_cantidad;
    }

    public void setVen_cantidad(int Ven_cantidad) {
        this.Ven_cantidad = Ven_cantidad;
    }
    
    @Override
	public String toString() {
		return "Codigo Venta: " + this.getVen_id() + " / Nombre Cliente: " + this.getCli_nombre() +
				" / Nombre Libro: " + this.getLib_nombre() + "/ Fecha Venta: "+ this.getVen_fecha()
				 + "/ Cantidad: "+ this.getVen_cantidad();
	}
}
