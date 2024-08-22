package OJBusinessLogic;

public interface IOJHormiga {
    // Método para que la hormiga coma GenoAlimento
    void comerGenoAlimento(OJGenoAlimento genoAlimento);
    
    // Método para que la hormiga coma Ingesta Nativa
    void comerIngestaNativa(OJIngestaNativa ingestaNativa);

    // Método para obtener el estado de la hormiga (viva o muerta)
    String getEstado();

    // Método para cambiar el estado de la hormiga
    void setEstado(String estado);
}
