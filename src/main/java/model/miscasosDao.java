package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class miscasosDao {
	miscasosVo avo = new miscasosVo();
	//metodos
//definir esas variables para realizar operaciones sobre la BD
	Connection con;
	//guarda el resultado de la consulta
	ResultSet rs;
	//prepara la sentencia que se va a ejecutar sql
//comentario de prueba
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	//metodos
	
	public List listar() throws SQLException {
		List <miscasosVo> micaso = new ArrayList<>();
		sql = "SELECT * FROM miscasos;";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				miscasosVo a = new miscasosVo();
				a.setIDmicaso(rs.getInt(1));
				a.setDescripcion(rs.getString(2));
				micaso.add(a);
				System.out.println("conexion exitosa");
			
			}
			
			ps.close();
			
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("conexion no exitosa"+e.getMessage());
		}
		finally {
			con.close();
		}
		return micaso;	
	
}
	public miscasosVo consultaId(int id) throws SQLException {
		miscasosVo r= new miscasosVo();
		sql = "SELECT * FROM miscasos where IDmicaso="+id;

		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
			
			while(rs.next()) {
				r.setIDmicaso(rs.getInt("IDmicaso"));
				r.setDescripcion(rs.getString("Descripcion"));
				System.out.println("consulta exitosaaa");
			
			}
		ps.close();
		}catch (Exception e) {
			System.out.println("Consulta no exitosa"+e.getMessage());
		}
		finally {
			con.close();
		}
		return r;
	}
public int edit(miscasosVo r) throws SQLException {

sql="UPDATE miscasos SET Descripcion=? WHERE IDmicaso="+r.getIDmicaso();

try {
	con= Conexion.conectar(); //Abriendo la conexión a la BD
	ps=con.prepareStatement(sql); //preparar sentencia
	ps.setString(1, r.getDescripcion());
	
	System.out.println(ps);
	ps.executeUpdate();//Ejeución de la sentencia
	ps.close();
	System.out.println("Se cambió el MYcaso");
	
}catch(Exception e) {
	System.out.println("Error al cambiar caso" +e.getMessage());
}
finally {
	con.close();
}
return row;//Retorna cantidad de filas afectadas
}


public int registrar(miscasosVo r) throws SQLException {
	sql="INSERT INTO miscasos (Descripcion) VALUES (?)";
try {
	con= Conexion.conectar();//abriendo la conexion a la bd
	ps= con.prepareStatement(sql);//preparar sentencia
	ps.setString(1, r.getDescripcion());

	
	System.out.println(ps);
	ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
	ps.close();
	System.out.println("se registro un MYcaso");
} catch (Exception e) {

	System.out.println("error al registrar un MMYcaso"+e.getMessage());
}
finally {
	con.close();
}
return row;//retorna cantidad de filas afectadas
}



}
