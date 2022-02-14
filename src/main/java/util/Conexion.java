package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	//definicion de atributos de la conexion
	private static final String bd = "jdbc:mysql://localhost:3307/huitacas";
	private static final String usuario ="root";
	private static final String clave ="";

	private static Connection con;
 
	//metodo de conexion 


	public static Connection conectar() {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(bd, usuario, clave);
				System.out.println("Conexion exitosa");
		}catch(Exception e) {
		System.out.println("Error en la conexion"+ e.getMessage());
			}

	return con;
		}
	}


