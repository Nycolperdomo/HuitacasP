package model;

@SuppressWarnings("ALL")
public class documentoVo {

    String nombre;
    String archivo;
    String descripcion;


    public documentoVo() {

    }

    public documentoVo(String nombre, String archivo, String descripcion) {
        this.nombre = nombre;
        //url documento en la bd
        this.archivo = archivo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
