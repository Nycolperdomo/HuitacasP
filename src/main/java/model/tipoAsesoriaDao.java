package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class tipoAsesoriaDao  {

	 //defenir variables necesarias para realizar operaciones sobre la bd
	tipoAsesoriaVo tasvo = new tipoAsesoriaVo();
	
	Connection con;
	ResultSet rs;
	PreparedStatement ps;
	String sql;
	int row;
	
	Conexion c= new Conexion();
	
	//metodos
	public List listartipoAsesoria() throws SQLException {
		List <tipoAsesoriaVo> tipoAsesoria = new ArrayList <>();
		sql = "SELECT * FROM tipo_asesoria;";
		// sql = "SELECT * FROM tipo_asesoria";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs= ps.executeQuery();//ejecuion de la sentencia y guardar el resultado en el resulSet
			//para correr el resulset (los datos) 
			while(rs.next()) {
				tipoAsesoriaVo r= new tipoAsesoriaVo();
				r.setIDasesoria(rs.getInt("IDasesoria"));
				r.setTipo(rs.getString("tipo"));
				
				
				tipoAsesoria.add(r);
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
		return tipoAsesoria;
		
	}
	
	
	
	//metodo registro 
	public int registrar(tipoAsesoriaVo r) throws SQLException {
		sql="INSERT INTO tipo_asesoria(tipo) VALUES (?)";
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//prepara la sentencia 
			ps.setString(1, r.getTipo());
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia dif a consulta 
			ps.close();
			System.out.println("SE registro un nuevo tipo de asesoria");
		} catch (Exception e) {
			//TODO:handle exception
			
			System.out.println("error al registrar el nuevo tipo de asesoria");
			
		}
		finally {
			con.close();
		}
		return row;//retorna cantdad de filas afectadas
			
	}
	
	public int eliminar (int id) throws SQLException {
		sql="DELETE FROM tipo_asesoria WHERE IDasesoria="+id;
		
		try {
			con= Conexion.conectar();//abriendo la conexion
			ps=con.prepareStatement(sql);//preparando la sentencia
			
			System.out.println(ps);
			ps.executeUpdate();//ejecucion de la sentencia
			ps.close();
			System.out.println("Se elimino un tipo de asesoria ");
			
		}catch(Exception e) {
			System.out.println("Error al eliminar el tipo de asesoria");
		
	}finally {
		con.close();
	}
		return row;//retornar cantidad de filas 
	}
	
	public tipoAsesoriaVo consultaId(int id) throws SQLException{
		tipoAsesoriaVo r=new tipoAsesoriaVo();
		sql = "SELECT * FRON tipo_asesoria WHERE IDasesoria="+id;
		
		try {
			con= Conexion.conectar();// abriendo la conexion a la bd
			ps= con.prepareStatement(sql);// preparando la sentencia 
			rs= ps.executeQuery();//ejecucion de la sentencia 
			
			while(rs.next()) {
				
				r.setIDasesoria(rs.getInt("IDasesoria"));
				r.setTipo(rs.getString("tipo"));
				
				
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
	
	public int edit(tipoAsesoriaVo r) throws SQLException{
		sql= "UPDATE tipo_asesoria SET tipo=?  WHERE IDasesoria="+r.getIDasesoria();
		
		try {
			con= Conexion.conectar();// abriendo la conexion a la bd
			ps=con.prepareStatement(sql);// preparar sentencia
			ps.setString(1, r.getTipo());
			
			System.out.println(ps);
			ps.executeUpdate();
			ps.close();
			System.out.println("Se cambio el tipo de asesoria");
		}catch(Exception e) {
			System.out.println("Error al cambiar el tipo de asesoria"+e.getMessage());
		}
		finally {
			con.close();
		}
		return row;//Retornar cantidad de filas afectadas
	}
	

}



