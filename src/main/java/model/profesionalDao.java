package model;

import java.math.BigInteger;
import java.security.MessageDigest;
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

	Conexion c = new Conexion();
	Contrasena contra = new Contrasena();

	//metodos

	public List listar() throws SQLException {
		List<profesionalVo> profesional = new ArrayList<>();
		//sql="SELECT * FROM usuario INNER JOIN profesional on usuario.IDusuario = profesional.IDusuario;";
		sql = "select IDprofesional,nombre,apellido,correo,estado,cargo FROM profesional;";

		try {
			con = Conexion.conectar();//abriendo la conexion a la bd
			ps = con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet

			while (rs.next()) {
				profesionalVo p = new profesionalVo();
				p.setIDprofesional(rs.getInt(1));
				p.setNombre(rs.getString(2));
				p.setApellido(rs.getString(3));
				p.setCorreo(rs.getString(4));
				p.setEstado(rs.getBoolean(5));
				p.setCargo(rs.getString(6));
				/*
				p.setProUs(new UsuarioVo());
				p.getProUs().setCorreo(rs.getString(8));
				p.getProUs().setEstado(rs.getBoolean(9));
				*/
				// asi no se hace u.setDescripcionRol(rs.getString(10));
				//otra forma de hacerlo
				//r.setIdRol(rs.getInt("idRol"));

				profesional.add(p);
				System.out.println("conexion exitosa");
			}
			ps.close();
		} catch (Exception e) {
			System.out.println("conexion no exitosa" + e.getMessage());
		} finally {
			con.close();
		}
		return profesional;

	}

	public profesionalVo validarUsuario(String correo, String passw) throws SQLException {
		profesionalVo u = new profesionalVo();
		sql = "SELECT IDprofesional,nombre,apellido,correo,contrasena,numeroDocumento,estado,cargo FROM profesional WHERE correo=? and contrasena=?;";
		try {
			con = Conexion.conectar();
			ps = con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, passw);
			rs = ps.executeQuery();
			while (rs.next()) {
				u.setIDprofesional(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setCorreo(rs.getString(4));
				//u.setContrasena(getMD5(rs.getString(3)));
				//u.setContrasena(rs.getString(3));
				u.setContrasena(rs.getString(5));
				u.setNumeroDocumento(rs.getString(6));
				u.setEstado(rs.getBoolean(7));
				u.setCargo(rs.getString(8));
			}
			ps.close();
			System.out.println("Se encontró el Usuario");
		} catch (Exception e) {
			System.out.println("Se encontró el Usuario" + e.getMessage());
		} finally {
			con.close();
		}
		return u;
	}

	public int eliminar(int id) throws SQLException {
		sql = "DELETE FROM profesional WHERE IDprofesional=" + id;

		try {
			con = Conexion.conectar(); //Abriendo la conexi�n a la BD
			ps = con.prepareStatement(sql); //preparar sentencia

			System.out.println(ps);
			ps.executeUpdate();//Ejeuci�n de la sentencia
			ps.close();
			System.out.println("Se elimin� un profesional");

		} catch (Exception e) {
			System.out.println("Error al eliminar profesional" + e.getMessage());
		} finally {
			con.close();
		}
		return row;//Retorna cantidad de filas afectadas
	}


	public profesionalVo ValidarUsuario(String correo, String passw) throws SQLException {
		profesionalVo u= new profesionalVo();
		sql="SELECT IDprofesional,nombre,apellido,correo,contrasena,numeroDocumento,estado,cargo FROM profesional WHERE correo = ? and contrasena=?;";
		try {
			con= Conexion.conectar(); //Abriendo la conexi�n a la BD
			ps=con.prepareStatement(sql); //preparar sentencia
			ps.setString(1, correo);
			ps.setString(2, passw);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setIDprofesional(rs.getInt(1));
				u.setNombre(rs.getString(2));
				u.setApellido(rs.getString(3));
				u.setCorreo(rs.getString(4));
				//u.setContrasena(getMD5(rs.getString(3)));
				//u.setContrasena(rs.getString(3));
				u.setContrasena(rs.getString(5));
				u.setNumeroDocumento(rs.getString(6));
				u.setEstado(rs.getBoolean(7));
				u.setCargo(rs.getString(8));
			}
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
		return u;//Retorna cantidad de filas afectadas
	}

public int registrar(profesionalVo p) throws SQLException {
	sql="INSERT INTO profesional( nombre,apellido,correo,contrasena,numeroDocumento,estado,cargo) VALUES (?,?,?,?,?,?,?);";
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, p.getNombre());
		ps.setString(2, p.getApellido());
		ps.setString(3, p.getCorreo());
		ps.setString(4, contra.getPassword());
		ps.setString(5, p.getNumeroDocumento());
		ps.setBoolean(6, p.isEstado());
		ps.setString(7,p.getCargo());

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
	public int changeEstado(profesionalVo r) throws SQLException {
		sql="UPDATE profesional SET estado=? WHERE IDprofesional="+r.getIDprofesional();
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setBoolean(1, r.isEstado());

			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se cambio el estado de afectada");

		} catch (Exception e) {
			System.out.println("error al cambiar el estado del la afectada"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//retorna cantidad de filas afectadas
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
			r.setCorreo(rs.getString("correo"));
			r.setContrasena(rs.getString("contrasena"));
			r.setNumeroDocumento(rs.getString("numeroDocumento"));
			r.setEstado(rs.getBoolean("estado"));
			r.setCargo(rs.getString("cargo"));
			/*
			r.setProUs(new UsuarioVo());
			//r.getProUs().setEstado(rs.getBoolean("estado"));
			r.getProUs().setCorreo(rs.getString("correo"));
			*/
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
	sql = "UPDATE profesional SET nombre=?,apellido=?,correo=?,contrasena=?,numeroDocumento=?,estado=?, cargo=? WHERE IDprofesional=" + r.getIDprofesional();

	try {
		con = Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps = con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getApellido());
		ps.setString(3, r.getCorreo());
		ps.setString(4, r.getContrasena());
		ps.setString(5, r.getNumeroDocumento());
		ps.setBoolean(6, r.isEstado());
		ps.setString(7, r.getCargo());
		//falta correo y contrase�a ps.setInt(7, p.getProUs().getIDusuario());
		//ps.setString(6, r.getFechaNacimiento());
		//get usuario o get correo y contrase�a
		/*ps.setString(7, r.getProUs().getCorreo());
		ps.setString(8, r.getProUs().getContrase�a());*/
		System.out.println(ps);
		ps.executeUpdate();//Ejeuci�n de la sentencia	
		ps.close();
		System.out.println("Se cambi� el profesional");

	} catch (Exception e) {
		System.out.println("Error al cambiar el profesional" + e.getMessage());
	} finally {
		con.close();
	}
	return row;//Retorna cantidad de filas afectadas
}

	public int changeCorreo(profesionalVo us) throws SQLException {
		sql="UPDATE profesional SET correo=? WHERE IDprofesional="+us.getIDprofesional();

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
	public int changePassword(profesionalVo us) throws SQLException {
		sql="UPDATE profesional SET contrasena=? WHERE IDprofesional="+us.getIDprofesional();

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

	public int validarCorreo(String correo) throws SQLException {
		afectadaVo u=new afectadaVo();
		int total=0;
		sql="SELECT COUNT(*) AS cantidad from profesional WHERE correo=?";
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
}
