package model;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import util.Conexion;

public class UsuarioDao {

	//definir variables necesarias pra realizar operaciones sibre la bd
	UsuarioVo uvo = new UsuarioVo();
	Contrasena contra=new Contrasena();
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	
	//metodos
	public List listarRoles() throws SQLException {
		List <UsuarioVo> roles = new ArrayList <>();
		sql = "SELECT * FROM usuario;";
		//sql = "SELECT * FROM usuario";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			//para recorrer el resulset (los datos)
			while(rs.next()) {
				UsuarioVo r= new UsuarioVo();
				 r.setIDusuario(rs.getInt("IDusuario"));
				 r.setCorreo(rs.getString("correo"));
				 r.setContrasena(rs.getString("contrasena"));
				 r.setEstado(rs.getBoolean("estado"));
				 r.setCargo(rs.getString("cargo"));
				
				roles.add(r);
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
		return roles;
	}
	
	
	
	//metodo registro
	public int registrar(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, r.getContrasena());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro un usuario");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el rol"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}

	public int registrarProf(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, contra.getPassword());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro un usuario");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el rol"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}


	public int registrarDatos(UsuarioVo r) throws SQLException {
		sql="INSERT INTO usuario(correo,contrasena,estado,cargo) VALUES(?,?,?,?)";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setString(1, r.getCorreo());
			ps.setString(2, r.getContrasena());
			ps.setBoolean(3,r.isEstado());
			ps.setString(4, r.getCargo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se registro una afectada");
		} catch (Exception e) {
			// TODO: handle exception

			System.out.println("error al registrar el afec"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}
		
		

public int eliminar(int id) throws SQLException {
	sql="DELETE FROM usuario WHERE IDusuario="+id;
	
	try {
		con= Conexion.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia
		ps.close();
		System.out.println("Se eliminó un rol");
		
	}catch(Exception e) {
		System.out.println("Error al eliminar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public int changeEstado(UsuarioVo r) throws SQLException {
	sql="UPDATE usuario SET estado=? WHERE IDusuario="+r.getIDusuario();
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		ps.setBoolean(1, r.isEstado());
		
		System.out.println(ps);
		ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
		ps.close();
		System.out.println("se cambio el estado de un rol");
		
	} catch (Exception e) {
		// TODO: handle exception
		
		System.out.println("error al cambiar el estado del rol"+e.getMessage());
	}
	finally {
		
		con.close();
	}
	return row;//retorna cantidad de filas afectadas
}


public UsuarioVo consultaId(int id) throws SQLException {
	UsuarioVo r= new UsuarioVo();
	sql = "SELECT *from usuario WHERE IDusuario="+id;
	
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSetes una sentencia de consulta por eso es query
		
		while(rs.next()) {
		
			r.setIDusuario(rs.getInt("IDusuario"));
			r.setCorreo(rs.getString("correo"));
			r.setContrasena(rs.getString("contrasena"));
			r.setEstado(rs.getBoolean("estado"));
			r.setCargo(rs.getString("cargo"));
			
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
	return r;
}



public int edit(UsuarioVo r) throws SQLException {
	sql="UPDATE usuario SET correo=?, contrasena=?, estado=?, cargo=? WHERE IDusuario="+r.getIDusuario();
	
	try {
		con= Conexion.conectar(); //Abriendo la conexión a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getCorreo());
		ps.setString(2, r.getContrasena());
		ps.setBoolean(3,r.isEstado());
		ps.setString(4, r.getCargo());
		System.out.println(ps);
		ps.executeUpdate();//Ejeución de la sentencia
		ps.close();
		System.out.println("Se cambió el rol");
		
	}catch(Exception e) {
		System.out.println("Error al cambiar el rol" +e.getMessage());
	}
	finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

public UsuarioVo validarUsuario(String correo,String passw) throws SQLException {
	UsuarioVo u=new UsuarioVo();
	sql="SELECT IDusuario,correo,contrasena,estado,cargo FROM usuario WHERE correo=? and contrasena=?;";
	try {
		con= Conexion.conectar();
		ps=con.prepareStatement(sql);
		ps.setString(1, correo);
		ps.setString(2, passw);
		rs=ps.executeQuery();
		while(rs.next()) {
			u.setIDusuario(rs.getInt(1));
			u.setCorreo(rs.getString(2));
			u.setContrasena(getMD5(rs.getString(3)));
//			u.setContrasena(rs.getString(3));
			u.setEstado(rs.getBoolean(4));
			u.setCargo(rs.getString(5));
		}
		ps.close();
		System.out.println("Se encontró el Usuario");
	}catch(Exception e) {
		System.out.println("Se encontró el Usuario"+e.getMessage());
	}finally {
		con.close();
	}
	return u;
}


public int changePassword(UsuarioVo us) throws SQLException {
	sql="UPDATE usuario SET contrasena=? WHERE IDusuario="+us.getIDusuario();
	
	try {
	con=c.conectar();
	ps=con.prepareStatement(sql);
	ps.setString(1, us.getContrasena());
	System.out.println(ps);
	ps.executeUpdate();
	ps.close();
}catch (Exception e) {
	System.out.println("Error al cambiar la contraseña"+e.getMessage());
}
	finally {
		con.close();
}
	return row;
}


public int changeCorreo(UsuarioVo us) throws SQLException {
	sql="UPDATE usuario SET correo=? WHERE IDusuario="+us.getIDusuario();
	
	try {
	con= Conexion.conectar();
	ps=con.prepareStatement(sql);
	ps.setString(1, us.getCorreo());
	System.out.println(ps);
	ps.executeUpdate();
	ps.close();
}catch (Exception e) {
	System.out.println("Error al cambiar el correo"+e.getMessage());
}
	finally {
		con.close();
}
	return row;
}



public int validarCorreo(String correo) throws SQLException {
	UsuarioVo u=new UsuarioVo();
	int total=0;
	sql="SELECT COUNT(*) AS cantidad from usuario WHERE correo=?";
	try {
		con= Conexion.conectar();
		ps=con.prepareStatement(sql);
		ps.setString(1, correo);
		rs=ps.executeQuery();
		while(rs.next()) {
			total=rs.getInt("cantidad");
			
		}
		ps.close();
		System.out.println("Se encontró el total de registros  coinciden"+total);
	}catch(Exception e) {
		System.out.println("Se encontró el usuario "+e.getMessage());
	}finally {
		con.close();
	}
	
	return total;
}



static String generaContrasena() {
	
	char[] mayusculas = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	char[] minusculas = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	char[] numeros = {'1','2','3','4','5','6','7','8','9','0'};
	
	StringBuilder caracteres = new StringBuilder();
	caracteres.append(mayusculas);
	caracteres.append(minusculas);
	caracteres.append(numeros);

	StringBuilder contrasena = new StringBuilder();
	
	for(int i = 0; i <= 8; i++) {
		int cantidadCaracteres = caracteres.length();
		int numeroRandom =(int)(Math.random()*cantidadCaracteres);
		
		contrasena.append(caracteres).charAt(numeroRandom);
	}
	
	return contrasena.toString();
}


	public String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] encBytes = md.digest(input.getBytes());
			BigInteger numero = new BigInteger(1, encBytes);
			String encString = numero.toString(16);
			while (encString.length() < 32) {
				encString = "0"+encString;
			}
			return encString;
		} catch (Exception e) {
			System.out.println("enctriptacion error "+e);
			throw new RuntimeException(e);
		}
	}
}


