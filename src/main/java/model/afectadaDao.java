package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class afectadaDao {
		
	afectadaVo avo = new afectadaVo();
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
			List <afectadaVo> afectada = new ArrayList<>();
			sql ="SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento FROM afectada;";
//			sql = "SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,correo,estado FROM afectada JOIN usuario on usuario.IDusuario = afectada.IDafectada;";
			try {
				con= Conexion.conectar();//abriendo la conexion a la bd
				ps= con.prepareStatement(sql);//preparar sentencia
				rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
				while(rs.next()) {
					afectadaVo a = new afectadaVo();
					a.setIDafectada(rs.getInt(1));
					a.setNombre(rs.getString(2));
					a.setApellido(rs.getString(3));
					a.setTelefono(rs.getString(4));
					a.setTipoDocumento(rs.getString(5));
					a.setNumeroDocumento(rs.getString(6));
					a.setFechaNacimiento(rs.getString(7));
					a.setAfecUs(new UsuarioVo());
					//a.getAfecUs().setCorreo(rs.getString(8));
					//a.getAfecUs().setEstado(rs.getBoolean(9));
					// asi no se hace u.setDescripcionRol(rs.getString(10));
					//otra forma de hacerlo
					//r.setIdRol(rs.getInt("idRol"));
				
					afectada.add(a);
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
			return afectada;	
		
	}
		
		public List listarReport() throws SQLException {
			List <afectadaVo> afectada = new ArrayList<>();
			sql = "SELECT nombre, apellido, telefono,numeroDocumento FROM afectada ;";
			try {
				con= Conexion.conectar();//abriendo la conexion a la bd
				ps= con.prepareStatement(sql);//preparar sentencia
				rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
				while(rs.next()) {
					afectadaVo a = new afectadaVo();
					a.setNombre(rs.getString(1));
					a.setApellido(rs.getString(2));
					a.setTelefono(rs.getString(3));
					a.setNumeroDocumento(rs.getString(4));
				
					afectada.add(a);
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
			return afectada;	
		
	}
		
		

public int eliminar(int id) throws SQLException {
	sql="DELETE FROM afectada WHERE IDafectada="+id;
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se elimin� una afectada");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar afectada" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
		


/*
public int changeEstado(afectadaVo a) throws SQLException {
	sql="UPDATE afectada SET estado=? FROM afectada WHERE IDafectada"+avo.getIDafectada();
	
	try {
		con=c.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setBoolean(1, a.getAfecUs().isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se cambio el estado de una afectada");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar estado afectada" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}
*/
public afectadaVo consultaId(int id) throws SQLException {
	afectadaVo r= new afectadaVo();
	sql = "SELECT * FROM afectada where IDafectada="+id;

	
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
		
		while(rs.next()) {
			r.setIDafectada(rs.getInt("IDafectada"));
			r.setNombre(rs.getString("nombre"));
			r.setApellido(rs.getString("apellido"));
			r.setTelefono(rs.getString("telefono"));
			r.setTipoDocumento(rs.getString("tipoDocumento"));
			r.setNumeroDocumento(rs.getString("numeroDocumento"));
			r.setFechaNacimiento(rs.getString("fechaNacimiento"));
			
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
public int edit(afectadaVo r) throws SQLException {

sql="UPDATE afectada SET nombre=?,apellido=?,telefono=?,tipoDocumento=?,numeroDocumento=?,fechaNacimiento=? WHERE IDafectada="+r.getIDafectada();
	
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
		/*ps.setString(7, r.getAfecUs().getCorreo());
		ps.setString(8, r.getAfecUs().getContrase�a());
	*/
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se cambi� la afectada");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar afectad" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int registrar(afectadaVo r) throws SQLException {
	sql="INSERT INTO afectada (nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento) VALUES(?,?,?,?,?,?)";
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getApellido());
		ps.setString(3, r.getTelefono());
		ps.setString(4, r.getTipoDocumento());
		ps.setString(5, r.getNumeroDocumento());
		ps.setString(6, r.getFechaNacimiento());
	
		System.out.println(ps);
		ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
		ps.close();
		System.out.println("se registro una afectada");
	} catch (Exception e) {

		System.out.println("error al registrar el afec"+e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//retorna cantidad de filas afectadas
}


}
