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

		public List listar() throws SQLException {
			List <afectadaVo> afectada = new ArrayList<>();
			//sql = "SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,correo,estado FROM afectada JOIN usuario on usuario.IDusuario = afectada.IDafectada;";
		// "SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento FROM afectada;";
			//sql = "	SELECT IDafectada,nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,correo,estado FROM afectada JOIN usuario on usuario.IDusuario = afectada.IDafectada;";
			sql="SELECT IDafectada,nombre,apellido,correo,estado FROM afectada;";

			try {
				con= Conexion.conectar();//abriendo la conexion a la bd
				ps= con.prepareStatement(sql);//preparar sentencia
				rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
				while(rs.next()) {
					afectadaVo a = new afectadaVo();
					a.setIDafectada(rs.getInt(1));
					a.setNombre(rs.getString(2));
					a.setApellido(rs.getString(3));
					a.setCorreo(rs.getString(4));
					a.setEstado(rs.getBoolean(5));
					//a.setAfecUs(new UsuarioVo());
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
			sql = "SELECT nombre,apellido,numeroDocumento,estado FROM afectada;";
			try {
				con= Conexion.conectar();//abriendo la conexion a la bd
				ps= con.prepareStatement(sql);//preparar sentencia
				rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
				while(rs.next()) {
					afectadaVo a = new afectadaVo();
					a.setNombre(rs.getString(1));
					a.setApellido(rs.getString(2));
					//a.setTelefono(rs.getString(3));
					a.setNumeroDocumento(rs.getString(3));
					a.setEstado(rs.getBoolean(4));
				
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

	public afectadaVo validarUsuario(String correo,String passw) throws SQLException {
		afectadaVo u=new afectadaVo();
		sql="SELECT IDafectada,nombre,apellido,correo,contrasena,numeroDocumento,estado,cargo FROM afectada WHERE correo=? and contrasena=?;";
		try {
			con= Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, correo);
			ps.setString(2, passw);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setIDafectada(rs.getInt(1));
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
		}catch(Exception e) {
			System.out.println("Se encontró el Usuario"+e.getMessage());
		}finally {
			con.close();
		}
		return u;
	}
	public afectadaVo validarUsuario2(String correo) throws SQLException {
		afectadaVo u=new afectadaVo();
		sql="SELECT IDafectada,nombre,apellido,correo,contrasena,numeroDocumento,estado,cargo FROM afectada WHERE correo=? ;";
		try {
			con= Conexion.conectar();
			ps=con.prepareStatement(sql);
			ps.setString(1, correo);
		//	ps.setString(2, passw);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setIDafectada(rs.getInt(1));
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
		}catch(Exception e) {
			System.out.println("Se encontró el Usuario"+e.getMessage());
		}finally {
			con.close();
		}
		return u;
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

	/*public afectadaVo verMicaso(int id) throws SQLException{
		afectadaVo r= new afectadaVo();
		sql = "SELECT * FROM afectada where IDafectada="+id;
	}*/
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
			r.setCorreo(rs.getString("correo"));
			r.setContrasena(rs.getString("contrasena"));
			r.setNumeroDocumento(rs.getString("numeroDocumento"));
			r.setFechaNacimiento(rs.getString("fechaNacimiento"));
			r.setEstado(rs.getBoolean("estado"));
			r.setCargo(rs.getString("cargo"));
			
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

sql="UPDATE afectada SET nombre=?,apellido=?,correo=?,contrasena=?,numeroDocumento=?,fechaNacimiento=?,estado=?,cargo=? WHERE IDafectada="+r.getIDafectada();
	
	try {
		con= Conexion.conectar(); //Abriendo la conexi�n a la BD
		ps=con.prepareStatement(sql); //preparar sentencia
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getApellido());
		ps.setString(3, r.getCorreo());
		ps.setString(4,r.getContrasena());
		ps.setString(5, r.getNumeroDocumento());
		ps.setString(6, r.getFechaNacimiento());
		ps.setBoolean(7,r.isEstado());
		ps.setString(8,r.getCargo());
		//falta correo y contrase�a ps.setInt(7, p.getProUs().getIDusuario());
		//get usuario o get correo y contrase�a
		//ps.setString(7, r.getAfecUs().getCorreo());
		//ps.setString(8, r.getAfecUs().getContrasena());
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
	sql="INSERT INTO afectada(nombre,apellido,correo,contrasena,numeroDocumento,fechaNacimiento,estado,cargo) VALUES(?,?,?,?,?,?,?,?);";
	//sql="INSERT INTO afectada (nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento) VALUES(?,?,?,?,?,?)";
	//sql="INSERT INTO afectada (nombre,apellido,telefono,tipoDocumento,numeroDocumento,fechaNacimiento,IDusuario) VALUES(?,?,?,?,?,?,?,?)";
	try {
		con= Conexion.conectar();//abriendo la conexion a la bd
		ps= con.prepareStatement(sql);//preparar sentencia
		ps.setString(1, r.getNombre());
		ps.setString(2, r.getApellido());
		ps.setString(3, r.getCorreo());
		ps.setString(4, r.getContrasena());
		ps.setString(5, r.getNumeroDocumento());
		ps.setString(6, r.getFechaNacimiento());
		ps.setBoolean(7,r.isEstado());
		ps.setString(8,r.getCargo());
		//ps.setInt(7, r.getAfecUs().getIDusuario());

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

	public int validarCorreo(String correo) throws SQLException {
		afectadaVo u=new afectadaVo();
		int total=0;
		sql="SELECT COUNT(*) AS cantidad from afectada WHERE correo=?";
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
	public int changeEstado(afectadaVo r) throws SQLException {
		sql="UPDATE afectada SET estado=? WHERE IDafectada="+r.getIDafectada();
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			ps.setBoolean(1, r.isEstado());

			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia sentencias dif a consulta
			ps.close();
			System.out.println("se cambio el estado de afectada");

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error al cambiar el estado del la afectada"+e.getMessage());
		}
		finally {

			con.close();
		}
		return row;//retorna cantidad de filas afectadas
	}

	public int changePassword(afectadaVo us) throws SQLException {
		sql="UPDATE afectada SET contrasena=? WHERE IDafectada="+us.getIDafectada();

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


	public int changeCorreo(afectadaVo us) throws SQLException {
		sql="UPDATE afectada SET correo=? WHERE IDafectada="+us.getIDafectada();

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

}
