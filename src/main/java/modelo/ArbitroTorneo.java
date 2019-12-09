
package modelo;


public class ArbitroTorneo {
    private int idArbitroTorneo;
    private int idArbitro;
    private int idTorneo;
    private String nombreArbitro;
    private String nombreTorneo;

    public ArbitroTorneo() {
    }

    public ArbitroTorneo(int idArbitroTorneo) {
        this.idArbitroTorneo = idArbitroTorneo;
    }

    public int getIdArbitroTorneo() {
        return idArbitroTorneo;
    }

    public void setIdArbitroTorneo(int idArbitroTorneo) {
        this.idArbitroTorneo = idArbitroTorneo;
    }

    public int getIdArbitro() {
        return idArbitro;
    }

    public void setIdArbitro(int idArbitro) {
        this.idArbitro = idArbitro;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombreArbitro() {
        return nombreArbitro;
    }

    public void setNombreArbitro(String nombreArbitro) {
        this.nombreArbitro = nombreArbitro;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }
    
    
    
}
