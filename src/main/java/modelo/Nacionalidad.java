package modelo;


public class Nacionalidad {
    private int idNacionalidad;
    private String nombre;
    private int idPais;
    private String nombrePais;

    public Nacionalidad() {
    }

    public Nacionalidad(int idNacionalida) {
        this.idNacionalidad = idNacionalidad;
    }

    public int getIdNacionalidad() {
        return idNacionalidad;
    }

    public void setIdNacionalidad(int idNacionalidad) {
        this.idNacionalidad = idNacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }
    
    
}
