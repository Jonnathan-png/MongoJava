package Libro;



import com.mongodb.BasicDBObject;

public class Libro {
	private int Lib_id;
	private String Lib_nombre;
	private String Lib_descrip;
	private int Lib_precio;
	private int Lib_cant;
	private String Lib_fecha_Publ;
	
	public Libro() {
	}

	public Libro(int Lib_id, String Lib_nombre, String Lib_descrip, int Lib_precio, int Lib_cant, String Lib_fecha_Publ) {
        this.Lib_id = Lib_id;
        this.Lib_nombre = Lib_nombre;
        this.Lib_descrip = Lib_descrip;
        this.Lib_precio = Lib_precio;
        this.Lib_cant = Lib_cant;
        this.Lib_fecha_Publ = Lib_fecha_Publ;
    }

	// Transformo un objecto que me da MongoDB a un Objecto Java
	
	public Libro(BasicDBObject dBObjectLibro) {
		
		this.Lib_id = dBObjectLibro.getInt("Lib_id");
		this.Lib_nombre = dBObjectLibro.getString("Lib_nombre");
		this.Lib_descrip = dBObjectLibro.getString("Lib_descrip");
		this.Lib_precio =  dBObjectLibro.getInt("Lib_precio");
		this.Lib_cant = dBObjectLibro.getInt("Lib_cant");
		this.Lib_fecha_Publ = dBObjectLibro.getString("Lib_fecha_Publ");
	}
	
	
	public BasicDBObject dBObjectLibro() {

		// Creamos una instancia BasicDBObject
		BasicDBObject dBObjectLibro = new BasicDBObject();
		dBObjectLibro.append("Lib_id", this.getLib_id());
		dBObjectLibro.append("Lib_nombre", this.getLib_nombre());
		dBObjectLibro.append("Lib_descrip", this.getLib_descrip());
		dBObjectLibro.append("Lib_precio", this.getLib_precio());
		dBObjectLibro.append("Lib_cant", this.getLib_cant());
		dBObjectLibro.append("Lib_fecha_Publ", this.getLib_fecha_Publ());

		return dBObjectLibro;
	}
	
	
	public int getLib_id() {
        return Lib_id;
    }

    public void setLib_id(int Lib_id) {
        this.Lib_id = Lib_id;
    }

    public String getLib_nombre() {
        return Lib_nombre;
    }

    public void setLib_nombre(String Lib_nombre) {
        this.Lib_nombre = Lib_nombre;
    }

    public String getLib_descrip() {
        return Lib_descrip;
    }

    public void setLib_descrip(String Lib_descrip) {
        this.Lib_descrip = Lib_descrip;
    }

    public int getLib_precio() {
        return Lib_precio;
    }

    public void setLib_precio(int Lib_precio) {
        this.Lib_precio = Lib_precio;
    }

    public int getLib_cant() {
        return Lib_cant;
    }

    public void setLib_cant(int Lib_cant) {
        this.Lib_cant = Lib_cant;
    }

    public String getLib_fecha_Publ() {
        return Lib_fecha_Publ;
    }

    public void setLib_fecha_Publ(String Lib_fecha_Publ) {
        this.Lib_fecha_Publ = Lib_fecha_Publ;
    }
    
    @Override
	public String toString() {
		return "Codigo Libro: " + this.getLib_id() + " / Nombre Libro: " + this.getLib_nombre() +
				" / Descripcion: " + this.getLib_descrip() + "/ Precio: "+ this.getLib_precio()
				 + "/ Cantidad: "+ this.getLib_cant()+"/ Fecha de Publicacion: "+ this.getLib_fecha_Publ();
	}
}
