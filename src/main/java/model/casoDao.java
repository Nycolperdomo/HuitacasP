package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class casoDao {
	casoVo avo = new casoVo();
	//metodos
//definir esas variables para realizar operaciones sobre la BD
	Connection con;
	//guarda el resultado de la consulta
	ResultSet rs;
	//prepara la sentencia que se va a ejecutar sql
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	//metodos
	
	public List listar() throws SQLException {
		List <casoVo> caso = new ArrayList<>();
		sql = "SELECT IDcaso,fechaInicio,fechaFin,estado,tipo FROM caso JOIN tipo_asesoria on tipo_asesoria.IDasesoria = caso.IDcaso;";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				casoVo a = new casoVo();
				a.setIDcaso(rs.getInt(1));
				a.setFechaInicio(rs.getString(2));
				a.setFechaFin(rs.getString(3));

				a.setEstado(rs.getBoolean(4));

				a.setAseCas(new tipoAsesoriaVo());
				a.getAseCas().setTipo(rs.getString(5));				
				caso.add(a);
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
		return caso;	
	
}
	
	

public int eliminar(int id) throws SQLException {
sql="DELETE from caso WHERE IDcaso="+id;

try {
	con= Conexion.conectar(); //Abriendo la conexión a la BD
	ps=con.prepareStatement(sql); //preparar sentencia
	
	System.out.println(ps);
	ps.executeUpdate();//Ejeución de la sentencia	
	ps.close();
	System.out.println("Se eliminó un caso");
	
}catch(Exception e) {
	System.out.println("Error al eliminar caso" +e.getMessage());
}
finally {
	con.close();
}
return row;//Retorna cantidad de filas afectadas
}
	

public casoVo consultaId(int id) throws SQLException {
casoVo r= new casoVo();
sql = "SELECT * FROM caso where IDcaso="+id;


try {
	con= Conexion.conectar();//abriendo la conexion a la bd
	ps= con.prepareStatement(sql);//preparar sentencia
	rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
	
	while(rs.next()) {
		r.setIDcaso(rs.getInt("IDcaso"));
		r.setFechaInicio(rs.getString("fechaInicio"));
		r.setFechaFin(rs.getString("fechaFin"));
		r.setEstado(rs.getBoolean("estado"));
		
		System.out.println("consulta exitosa");
	
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

public int edit(casoVo r) throws SQLException {

sql="UPDATE caso SET fechaInicio=?,fechaFin=?,estado=? WHERE IDcaso="+r.getIDcaso();

try {
	con= Conexion.conectar(); //Abriendo la conexión a la BD
	ps=con.prepareStatement(sql); //preparar sentencia
	ps.setString(1, r.getFechaInicio());
	ps.setString(2, r.getFechaFin());
	ps.setBoolean(3, r.isEstado());
	System.out.println(ps);
	ps.executeUpdate();//Ejeución de la sentencia	
	ps.close();
	System.out.println("Se cambió el caso");
	
}catch(Exception e) {
	System.out.println("Error al cambiar caso" +e.getMessage());
}
finally {
	con.close();
}
return row;//Retorna cantidad de filas afectadas
}


public int registrar(casoVo r) throws SQLException {


	//sql="INSERT INTO caso (fechaInicio,fechaFin,estado,IDasesoria) VALUES(?,?,?,?)";
	sql="INSERT INTO caso (fechaInicio,fechaFin,estado) VALUES(?,?,?)";
try {
	con= Conexion.conectar();//abriendo la conexion a la bd
	ps= con.prepareStatement(sql);//preparar sentencia
	ps.setString(1, r.getFechaInicio());
	ps.setString(2, r.getFechaFin());
	ps.setBoolean(3, r.isEstado());

//	ps.setInt(4, r.getAseCas().getIDasesoria());
	
	System.out.println(ps);
	ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
	ps.close();
	System.out.println("se registro un caso");
} catch (Exception e) {
	// TODO: handle exception

	System.out.println("error al registrar un caso"+e.getMessage());
}
finally {
	con.close();
}
return row;//retorna cantidad de filas afectadas
}

public int changeEstado(casoVo r) throws SQLException {
	sql="UPDATE caso SET estado=? WHERE IDcaso="+r.getIDcaso();
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		ps.setBoolean(1, r.isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
		ps.close();
		System.out.println("se cambio el estado de un caso");
		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("error al cambiar el estado del caso"+e.getMessage());
	}
	finally {
		
		con.close();
	}
	return row;//retorna cantidad de filas afectadas
}

public List report() throws SQLException {
	List <casoVo> caso = new ArrayList<>();
	sql = "SELECT IDcaso,fechaInicio,fechaFin,estado,descripcion FROM caso JOIN tipo_abuso on tipo_abuso.IDabuso = caso.IDcaso;";
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
		while(rs.next()) {
			casoVo a = new casoVo();
			a.setIDcaso(rs.getInt(1));
			a.setFechaInicio(rs.getString(2));
			a.setFechaFin(rs.getString(3));

			a.setEstado(rs.getBoolean(4));

			a.setAbuCas(new tipoAbusoVo());
			a.getAbuCas().setDescripcion(rs.getString(5));				
			caso.add(a);
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
	return caso;	

}


}
