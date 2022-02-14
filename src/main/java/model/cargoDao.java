package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Conexion;

public class cargoDao {

	
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
		List <cargoVo> cargo = new ArrayList<>();
		sql = "SELECT cargo, IDprofesional, numeroDocumento, nombre, apellido  From cargo JOIN profesional on profesional.IDprofesional = cargo.IDcargo;";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				cargoVo ca = new cargoVo();
				
				
				ca.setCargo(rs.getString(1));
				ca.setProCa(new profesionalVo());
				ca.getProCa().setIDprofesional(rs.getInt(2));
				ca.getProCa().setNumeroDocumento(rs.getString(3));
				ca.getProCa().setNombre(rs.getString(4));
				ca.getProCa().setApellido(rs.getString(5));
				
				
				
				
				
				// asi no se hace u.setDescripcionRol(rs.getString(10));
				//otra forma de hacerlo
				//r.setIdRol(rs.getInt("idRol"));
			
				cargo.add(ca);
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
		return cargo;	
	
}

	public List listarCargos() throws SQLException {
		List <cargoVo> cargo = new ArrayList<>();
		sql = "SELECT * from cargo;";
		
		try {
			con= Conexion.conectar();//abriendo la conexion a la bd
			ps= con.prepareStatement(sql);//preparar sentencia
			rs = ps.executeQuery();//ejecucion de la sentencia y guardar el resultado en el resulSet
			while(rs.next()) {
				cargoVo car = new cargoVo();
				
				
				car.setCargo(rs.getString("cargo"));
				
				
				// asi no se hace u.setDescripcionRol(rs.getString(10));
				//otra forma de hacerlo
				//r.setIdRol(rs.getInt("idRol"));
			
				cargo.add(car);
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
		return cargo;	
	
}

	
	
}

	
