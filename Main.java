package Libro;

import java.net.UnknownHostException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String args[]) {

		ArrayList<Cliente> Client = new ArrayList<Cliente>();
		ArrayList<Autor> Aut = new ArrayList<Autor>();
		ArrayList<Libro> Libr = new ArrayList<Libro>();
		ArrayList<Venta> Vent = new ArrayList<Venta>();
//----------------------------------------------------------------------------------------------------------------------------	
		Aut.add(new Autor(60256147 ,"Tony Hernandez", "10/05/2010", 321404, "tonherm@gmail.com"));
		Aut.add(new Autor(60246147 ,"Lisbeth Hernandez", "10/05/2010", 178992, "lis@gmail.com"));
		Aut.add(new Autor(109478 ,"Sonia Parada", "18/07/1994", 1478, "sopaxD@gmail.com"));
//-----------------------------------------------------------------------------------------------------------------------------	
		Libr.add(new Libro(0120, "La eternidad es finita", "N/A", 45000, 500, "18/05/2020"));
		Libr.add(new Libro(0220, "Calculo en una y mas variables", "N/A", 85000, 500, "25/05/2020"));
		Libr.add(new Libro(0320, "La eternidad", "N/A", 45000, 500, "18/05/2020"));
//-----------------------------------------------------------------------------------------------------------------------------	
		Client.add(new Cliente(656147 ,"To�o Garcia", "10/05/2010", 321404, "tonherm@gmail.com"));
		Client.add(new Cliente(60247 ,"Lisbeth Hernandez", "10/05/2010", 178992, "lis@gmail.com"));
		Client.add(new Cliente(109478 ,"Aris Mata", "18/07/1994", 1478, "arisD@gmail.com"));
		
		
		try {
		// PASO 1: Conexión al Server de MongoDB Pasandole el host y el puerto
			MongoClient mongoClient = new MongoClient("localhost", 27017);

		// PASO 2: Conexión a la base de datos
			DB db = mongoClient.getDB("Libros");

		// PASO 3: Obtenemos una coleccion para trabajar con ella
			DBCollection collection = db.getCollection("Autor");
			DBCollection collection1 = db.getCollection("Libro");
			DBCollection collection2 = db.getCollection("Cliente");
			DBCollection collection3 = db.getCollection("Venta");

			
		// PASO 4: CRUD (Create-Read-Update-Delete)

			// PASO 4.1: "CREATE" -> Metemos los objetos Autor (o documentos en Mongo) en la coleccion 
			for (Autor aux : Aut) {
				collection.insert(aux.dBObjectAutor());
			}
			
			for (Libro aux2 : Libr) {
				collection1.insert(aux2.dBObjectLibro());
			}
			for (Cliente aux3 : Client) {
				collection2.insert(aux3.dBObjectCliente());
			}
			for (Venta aux4 : Vent) {
				collection3.insert(aux4.dBObjectVenta());
			}
			
//--------------------------------------------------------------------------------------------------------------------------------------------------
			// PASO 4.2.1: "READ" -> Leemos todos los documentos de la base de datos
			int numAutor = (int) collection.getCount();
			System.out.println("Numero de Codigos en la coleccion Autor: " + numAutor + "\n");
			DBCursor cursor = collection.find();
			try {
				while (cursor.hasNext()) {
					System.out.println(cursor.next().toString());
				}
			} finally {
				cursor.close();
			}
			
			int numLibro = (int) collection1.getCount();
			System.out.println("Numero de Codigos en la coleccion Libro: " + numLibro + "\n");
			DBCursor cursor1 = collection1.find();
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
			int numCliente = (int) collection2.getCount();
			System.out.println("Numero de Codigos en la coleccion Cliente: " + numCliente + "\n");
			DBCursor cursor2 = collection2.find();
			try {
				while (cursor2.hasNext()) {
					System.out.println(cursor2.next().toString());
				}
			} finally {
				cursor2.close();
			}
			
			int numVentas = (int) collection3.getCount();
			System.out.println("Numero de Codigos en la coleccion 	Ventas: " + numVentas + "\n");
			DBCursor cursor3 = collection3.find();
			try {
				while (cursor3.hasNext()) {
					System.out.println(cursor3.next().toString());
				}
			} finally {
				cursor3.close();
			}
			
			// PASO 4.2.2: "READ" -> Hacemos una Query con condiciones  y lo pasamos a un objeto Java
			System.out.println("\nLibros que valen 45000");
			DBObject query = new BasicDBObject("Lib_precio", 45000);
			cursor = collection1.find(query);
			try {
				while (cursor.hasNext()) {
					Libro Libr1 = new Libro((BasicDBObject) cursor.next());
					System.out.println(Libr1.toString());
				}
			} finally {
				cursor.close();
			}
			
		//}
//------------------------------------------------------------------------------------------------------------------------------
			// PASO 4.3: "UPDATE" -> Incrementamos el valor del libro 0220 de 85000 a 95000
			
			DBObject find = new BasicDBObject("Lib_id", 0220);
			DBObject updated = new BasicDBObject().append("$inc", new BasicDBObject().append("Lib_precio", 10000));
			collection1.update(find, updated, false, true);
			try {
				while (cursor1.hasNext()) {
					System.out.println(cursor1.next().toString());
				}
			} finally {
				cursor1.close();
			}
			
//------------------------------------------------------------------------------------------------------------------------------	
			//PASO 4.4: "DELETE" -> Borramos el cliente con codigo 60247
			DBObject findDoc = new BasicDBObject("Cli_id", 60247);
			collection.remove(findDoc);

		// PASO FINAL: Cerrar la conexion
			mongoClient.close();

		} catch (Exception ex) {
			System.out.println("Exception al conectar al server de Mongo: " + ex.getMessage());
		}

	}

}