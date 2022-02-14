package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class tipoAbusoDao {

	 //defenir variables necesarias para realizar operaciones sobre la bd
	tipoAbusoVo tavo = new tipoAbusoVo();
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	//metodos
	public List listartipoAbuso() throws SQLException {
		List <tipoAbusoVo> tipoAbuso = new ArrayList <>();
		sql = "SELECT * FROM tipo_abuso;";
		// sql = "SELECT * FROM tipo_abuso";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs= ps.executeQuery();//ejecuion de la sentencia y guardar el resultado en el resulSet
			//para correr el resulset (los datos) 
			while(rs.next()) {
				tipoAbusoVo r= new tipoAbusoVo();
				r.setIDabuso(rs.getInt("IDabuso"));
				r.setNombre(rs.getString("nombre"));
				r.setDescripcion(rs.getString("descripcion"));
				
				tipoAbuso.add(r);
				System.out.println("conexion exitosa");
				
				
			}
			
			ps.close();
			
		} catch (Exception e) {
			//TODO: handle exception 
			
			System.out.println("conexion no exitosa"+e.getMessage());
		}
		finally {
			con.close();
		}
		return tipoAbuso;
		
	}
	
	
	
	//metodo registro 
	public int registrar(tipoAbusoVo r) throws SQLException {
		sql="INSERT INTO tipo_abuso(nombre,descripcion) VALUES (?,?)";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//prepara la sentencia 
			ps.setString(1, r.getNombre());
			ps.setString(2, r.getDescripcion());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia dif a consulta 
			ps.close();
			System.out.println("SE registro un nuevo tipo de abuso");
		} catch (Exception e) {
			//TODO:handle exception
			
			System.out.println("error al registrar el nuevo tipo de abuso");
			
		}
		finally {
			con.close();
		}
		return row;//retorna cantdad de filas afectadas
			
	}
	
	public int eliminar (int id) throws SQLException {
		sql="DELETE FROM tipo_abuso WHERE IDabuso="+id;
		
		try {
			con= Conexion.conectar();//abriendo la conexion
			ps=con.prepareStatement(sql);//preparando la sentencia
			
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia
			ps.close();
			System.out.println("Se elimino un tipo de abuso ");
			
		}catch(Exception e) {
			System.out.println("Error al eliminar el tipo de abuso");
		
	}finally {
		con.close();
	}
		return row;//retornar cantidad de filas 
	}
	
	public tipoAbusoVo consultaId(int id) throws SQLException{
		tipoAbusoVo r=new tipoAbusoVo();
		sql = "SELECT * FRON tipo_abuso WHERE IDabuso="+id;
		
		try {
			con= Conexion.conectar();// abriendo la conexion a la bd
			ps= con.prepareStatement(sql);// preparando la sentencia 
			rs= ps.executeQuery();//ejecucion de la sentencia 
			
			while(rs.next()) {
				
				r.setIDabuso(rs.getInt("IDabuso"));
				r.setNombre(rs.getString("nombre"));
				r.setDescripcion(rs.getString("descripcion"));
				
				System.out.println("Conexion exitosa");
				
			}
			
			ps.close();
		}catch (Exception e) {
			//TODO: handle exception
			
			System.out.println("conexion no existosa"+e.getMessage());
		}
		finally {
			con.close();
		}
		return r;
	}
	
	public int edit(tipoAbusoVo r) throws SQLException{
		sql= "UPDATE tipo_abuso SET nombre=?, descripcion=? WHERE IDabuso="+r.getIDabuso();
		
		try {
			con= Conexion.conectar();// abriendo la conexion a la bd
			ps=con.prepareStatement(sql);// preparar sentencia
			ps.setString(1, r.getNombre());
			ps.setString(2, r.getDescripcion());
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se cambio el tipo de abuso");
		}catch(Exception e) {
			System.out.println("Error al cambiar el tipo de abuso");
		}
		finally {
			con.close();
		}
		return row;//Retornar cantidad de filas afectadas
	}
	

}





