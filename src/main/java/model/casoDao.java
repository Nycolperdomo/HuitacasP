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
	//FALTA SQL
	public List listar() throws SQLException {
		List <casoVo> caso = new ArrayList<>();
		//sql = "SELECT IDcaso,fechaInicio,fechaFin,estado,tipo FROM caso JOIN tipo_asesoria on tipo_asesoria.IDasesoria = caso.IDcaso;";
		sql="SELECT * FROM caso";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				casoVo a = new casoVo();
				a.setIDcaso(rs.getInt(1));
				a.setTipoAbuso(rs.getString(2));
				a.setTipoAsesoria(rs.getString(3));
				a.setFechaInicio(rs.getString(4));
				a.setFechaFin(rs.getString(5));
				a.setUrlDocumento(rs.getString(6));
				a.setEstado(rs.getBoolean(7));

				a.setAfeCas(new afectadaVo());
				a.getAfeCas().setNombre(rs.getString(8));
				a.setProfCaso(new profesionalVo());
				a.getProfCaso().setNombre(rs.getString(9));
				caso.add(a);
				System.out.println("conexion exitosa");
			}
			ps.close();
			
		} catch (Exception e) {
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
	con= Conexion.conectar(); //Abriendo la conexi�n a la BD
	ps=con.prepareStatement(sql); //preparar sentencia
	
	System.out.println(ps);
	ps.executeUpdate();//Ejeuci�n de la sentencia	
	ps.close();
	System.out.println("Se elimin� un caso");
	
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
//sql = "SELECT * FROM caso where IDcaso="+id;
//	sql="SELECT IDcaso,tipoAbuso,tipoAsesoria,fechaInicio,fechaFin, estado,IDprofesional FROM caso where IDcaso="+id;
	sql="SELECT IDcaso,tipoAbuso,tipoAsesoria,fechaInicio,fechaFin, estado FROM caso where IDcaso="+id;


try {
	con= Conexion.conectar();//abriendo la conexion a la bd
	ps= con.prepareStatement(sql);//preparar sentencia
	rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
	
	while(rs.next()) {
		r.setIDcaso(rs.getInt("IDcaso"));
		r.setFechaInicio(rs.getString("tipoAbuso"));
		r.setFechaInicio(rs.getString("tipoAsesoria"));
		r.setFechaInicio(rs.getString("fechaInicio"));
		r.setFechaInicio(rs.getString("fechaFin"));
		//r.setFechaInicio(rs.getString("urlDocumento"));
		r.setEstado(rs.getBoolean("estado"));
		r.setAfeCas(new afectadaVo());
		//r.getAfeCas().setNombre(rs.getString("nombreAfectada"));
		//r.getProfCaso().setNombre(rs.getString("nombre"));
	//	r.getProfCaso().setIDprofesional(rs.getInt("IDprofesional"));
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
	sql="UPDATE caso SET tipoAbuso=?, tipoAsesoria=?, fechaInicio=?,fechaFin=?,estado=? WHERE IDcaso="+r.getIDcaso();
//sql="UPDATE caso SET tipoAbuso=?, tipoAsesoria=?, fechaInicio=?,fechaFin=?,estado=?,IDprofesional=? WHERE IDcaso="+r.getIDcaso();
//UPDATE caso SET tipoAbuso='', tipoAsesoria=?, fechaInicio=?,fechaFin=?,urlDocumento=?,estado=?,IDafectada=?,IDprofesional=? WHERE IDcaso=1;

try {
	con= Conexion.conectar(); //Abriendo la conexi�n a la BD
	ps=con.prepareStatement(sql); //preparar sentencia
	ps.setString(1, r.getTipoAbuso());
	ps.setString(2, r.getTipoAsesoria());
	ps.setString(3, r.getFechaInicio());
	ps.setString(4, r.getFechaFin());
	//ps.setString(5, r.getUrlDocumento());
	ps.setBoolean(5, r.isEstado());
	//ps.setString(7, r.getAfeCas().getNombre());
	//ps.setInt(6, r.getProfCaso().getIDprofesional());
	System.out.println(ps);
	ps.executeUpdate();//Ejeuci�n de la sentencia	
	ps.close();
	System.out.println("Se cambi� el caso");
	
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
//	sql="INSERT INTO caso(tipoAbuso, tipoAsesoria, fechaInicio, fechaFin, urlDocumento, estado, IDafectada, IDprofesional) VALUES (?,?,?,?,?,?,?,?);";
	sql="INSERT INTO caso (tipoAbuso,tipoAsesoria,fechaInicio,fechaFin,urlDocumento,estado,IDafectada,IDprofesional) VALUES (?,?,?,?,?,?,?,?);";
try {
	con= Conexion.conectar();//abriendo la conexion a la bd
	ps= con.prepareStatement(sql);//preparar sentencia
	ps.setString(1, r.getTipoAbuso());
	ps.setString(2, r.getTipoAsesoria());
	ps.setString(3, r.getFechaInicio());
	ps.setString(4, r.getFechaFin());
	ps.setString(5, r.getUrlDocumento());
	ps.setBoolean(6, r.isEstado());
	ps.setInt(7,r.getAfeCas().getIDafectada());
	ps.setInt(8,r.getProfCaso().getIDprofesional());
//	ps.setInt(4, r.getAseCas().getIDasesoria());
	System.out.println(ps);
	ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
	ps.close();
	System.out.println("se registro un caso");
} catch (Exception e) {

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
	//sql = "SELECT IDcaso,fechaInicio,fechaFin,estado,descripcion FROM caso JOIN tipo_abuso on tipo_abuso.IDabuso = caso.IDcaso;";
	sql="SELECT tipoAsesoria,fechaInicio,fechaFin,nombre FROM caso JOIN afectada on afectada.IDafectada = caso.IDcaso;";
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
		while(rs.next()) {
			casoVo a = new casoVo();
			a.setTipoAsesoria(rs.getString(1));
			a.setFechaInicio(rs.getString(2));
			a.setFechaFin(rs.getString(3));
			a.setAfeCas(new afectadaVo());
			a.getAfeCas().setNombre(rs.getString(4));

/*
			a.setAbuCas(new tipoAbusoVo());
			a.getAbuCas().setDescripcion(rs.getString(5));*/
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
