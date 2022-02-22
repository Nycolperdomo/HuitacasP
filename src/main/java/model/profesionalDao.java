package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.Conexion;

public class profesionalDao {

	
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
		List <profesionalVo> profesional = new ArrayList<>();
		sql="SELECT * FROM usuario INNER JOIN profesional on usuario.IDusuario = profesional.IDusuario;";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet

			while(rs.next()) {
				profesionalVo p = new profesionalVo();
				p.setIDprofesional(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setTelefono(rs.getString(4));
				p.setTipoDocumento(rs.getString(5));
				p.setNumeroDocumento(rs.getString(6));
				p.setFechaNacimiento(rs.getString(7));
				
				p.setProUs(new UsuarioVo());
				p.getProUs().setCorreo(rs.getString(8));
				p.getProUs().setEstado(rs.getBoolean(9));
				
				// asi no se hace u.setDescripcionRol(rs.getString(10));
				//otra forma de hacerlo
				//r.setIdRol(rs.getInt("idRol"));
			
				profesional.add(p);
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
		return profesional;	
	
}

	

public int eliminar(int id) throws SQLException {
	sql="DELETE FROM profesional WHERE IDprofesional="+id;
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se elimin� un profesional");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar profesional" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
	public int validar(profesionalVo p) throws SQLException {
		sql="SELECT IDusuario from usuario WHERE correo = ?;;";

		try {
			con= Conexion.conectar(); //Abriendo la conexi�n a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			ps.setString(1, p.getCorreo());

			if(p.getCorreo()== p.getProUs().getCorreo()){


			}


			ps.setString(3, p.getTelefono());
			ps.setString(4, p.getTipoDocumento());
			ps.setString(5, p.getNumeroDocumento());
			ps.setString(6, p.getFechaNacimiento());
			//ps.setInt(7,p.getIDusuario());

			System.out.println(ps);
			ps.executeUpdate();//Ejeuci�n de la sentencia
			ps.close();
			System.out.println("Se registr� un profesinaal");

		}catch(Exception e) {
			System.out.println("Error al registrar el profesionall" +e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//Retorna cantidad de filas afectadas
	}


public int registrar(profesionalVo p) throws SQLException {
	sql="INSERT INTO profesional( nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,IDusuario) VALUES (?,?,?,?,?,?,?);";
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, p.getNombre());
		ps.setString(2, p.getApellido());
		ps.setString(3, p.getTelefono());
		ps.setString(4, p.getTipoDocumento());
		ps.setString(5, p.getNumeroDocumento());
		ps.setString(6, p.getFechaNacimiento());
		//ps.setInt(7,p.getIDusuario());
	
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se registr� un profesinaal");
		
	}catch(Exception e) {
		System.out.println("Error al registrar el profesionall" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}



public int changeEstado(profesionalVo a) throws SQLException {
	//sql="UPDATE afectada SET  FROM afectada WHERE IDafectada"+id;
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setBoolean(1, a.getProUs().isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se cambio el estado de profesional");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar estado de profesioanl" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas

}

public profesionalVo consultaId(int id) throws SQLException {
	profesionalVo r= new profesionalVo();
	sql = "SELECT * FROM profesional where IDprofesional="+id;

	
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
		
		while(rs.next()) {
		
			r.setIDprofesional(rs.getInt("IDprofesional"));
			r.setNombre(rs.getString("nombre"));
			r.setApellido(rs.getString("apellido"));
			r.setTelefono(rs.getString("telefono"));
			r.setTipoDocumento(rs.getString("tipoDocumento"));
			r.setNumeroDocumento(rs.getString("numeroDocumento"));
			r.setFechaNacimiento(rs.getString("fechaNacimiento"));
			
			r.setProUs(new UsuarioVo());
			//r.getProUs().setEstado(rs.getBoolean("estado"));
			r.getProUs().setCorreo(rs.getString("correo"));
			

			
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
public int edit(profesionalVo r) throws SQLException {
	sql="UPDATE profesional SET nombre=?,apellido=?,telefono=?,tipoDocumento=?,numeroDocumento=?,fechaNacimiento=? WHERE IDprofesional="+r.getIDprofesional();
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getApellido());
		ps.setString(3, r.getTelefono());
		ps.setString(4,r.getTipoDocumento());
		ps.setString(5, r.getNumeroDocumento());
		//falta correo y contrase�a ps.setInt(7, p.getProUs().getIDusuario());
		ps.setString(6, r.getFechaNacimiento());
		//get usuario o get correo y contrase�a
		/*ps.setString(7, r.getProUs().getCorreo());
		ps.setString(8, r.getProUs().getContrase�a());*/
		
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se cambi� el profesional");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el profesional" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}



}