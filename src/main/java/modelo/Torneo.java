package modelo;


public class Torneo {
    private int idTorneo;
    private String nombre;
    private String anio;
    private double premio;
    private int idLugarTorneo;
    private String nombreLugarTorneo;

    public Torneo() {
    }
    
    public Torneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }


    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public double getPremio() {
        return premio;
    }

    public void setPremio(double premio) {
        this.premio = premio;
    }

    public int getIdLugarTorneo() {
        return idLugarTorneo;
    }

    public void setIdLugarTorneo(int idLugarTorneo) {
        this.idLugarTorneo = idLugarTorneo;
    }

    public String getNombreLugarTorneo() {
        return nombreLugarTorneo;
    }

    public void setNombreLugarTorneo(String nombreLugarTorneo) {
        this.nombreLugarTorneo = nombreLugarTorneo;
    }

   
    
    
}
