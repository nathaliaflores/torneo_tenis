package modelo;

public class TorneoModalidadFase {

    private int idTmf;
    private int idTorneo;
    private int idModalidad;
    private int idFase;
    private double premioConsuelo;
    private String nombreTorneo;
    private String nombreModalidad;
    private String nombreFase;

    public TorneoModalidadFase() {
    }

    public TorneoModalidadFase(int idTmf) {
        this.idTmf = idTmf;
    }

    public int getIdTmf() {
        return idTmf;
    }

    public void setIdTmf(int idTmf) {
        this.idTmf = idTmf;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public int getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(int idModalidad) {
        this.idModalidad = idModalidad;
    }

    public int getIdFase() {
        return idFase;
    }

    public void setIdFase(int idFase) {
        this.idFase = idFase;
    }

    public double getPremioConsuelo() {
        return premioConsuelo;
    }

    public void setPremioConsuelo(double premioConsuelo) {
        this.premioConsuelo = premioConsuelo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public void setNombreModalidad(String nombreModalidad) {
        this.nombreModalidad = nombreModalidad;
    }

    public String getNombreFase() {
        return nombreFase;
    }

    public void setNombreFase(String nombreFase) {
        this.nombreFase = nombreFase;
    }

}
