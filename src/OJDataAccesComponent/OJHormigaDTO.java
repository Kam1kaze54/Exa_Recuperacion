package OJDataAccesComponent;

public class OJHormigaDTO {
    // Atributos
    private int idHormiga;
    private String tipoHormiga;
    private String sexo;
    private String genoAlimento;  // Nuevo campo
    private String ingestaNativa; // Nuevo campo
    private String estado;

    // Constructor actualizado
    public OJHormigaDTO(int idHormiga, String tipoHormiga, String sexo, String genoAlimento, String ingestaNativa, String estado) {
        this.idHormiga = idHormiga;
        this.tipoHormiga = tipoHormiga;
        this.sexo = sexo;
        this.genoAlimento = genoAlimento;
        this.ingestaNativa = ingestaNativa;
        this.estado = estado;
    }

    // Getters y Setters
    public int getIdHormiga() {
        return idHormiga;
    }

    public void setIdHormiga(int idHormiga) {
        this.idHormiga = idHormiga;
    }

    public String getTipoHormiga() {
        return tipoHormiga;
    }

    public void setTipoHormiga(String tipoHormiga) {
        this.tipoHormiga = tipoHormiga;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getGenoAlimento() {
        return genoAlimento;
    }

    public void setGenoAlimento(String genoAlimento) {
        this.genoAlimento = genoAlimento;
    }

    public String getIngestaNativa() {
        return ingestaNativa;
    }

    public void setIngestaNativa(String ingestaNativa) {
        this.ingestaNativa = ingestaNativa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "OJHormigaDTO{" +
                "idHormiga=" + idHormiga +
                ", tipoHormiga='" + tipoHormiga + '\'' +
                ", sexo='" + sexo + '\'' +
                ", genoAlimento='" + genoAlimento + '\'' +
                ", ingestaNativa='" + ingestaNativa + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
