package model;
import util.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@SuppressWarnings("ALL")
public class documentoDao {
    String sql;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int row;
    Conexion c = new Conexion();
    //documentoDao dao = new documentoDao();
    public int addArchivos(documentoVo docs) throws SQLException {

        sql = "insert into miscasos values (null, ?,?,?)";

        try {
            con = c.conectar();
            ps = con.prepareStatement(sql);

            ps.setString(1, docs.getNombre());
            ps.setString(2, docs.getArchivo());
            ps.setString(3,docs.getDescripcion());

            ps.executeUpdate();
            con.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

}
