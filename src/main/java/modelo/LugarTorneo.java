
package modelo;


public class LugarTorneo {
    private int idLugarTorneo;
    private String nombre;
    private int idPais;
    private String nombrePais;
    

    public LugarTorneo() {
    }

    public LugarTorneo(int idLugarTorneo) {
        this.idLugarTorneo = idLugarTorneo;
    }

    public int getIdLugarTorneo() {
        return idLugarTorneo;
    }

    public void setIdLugarTorneo(int idLugarTorneo) {
        this.idLugarTorneo = idLugarTorneo;
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
