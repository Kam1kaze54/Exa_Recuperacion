package OJBusinessLogic;

public class OJReina extends OJHormiga implements IOJHormiga {
    private String estado;
    
    public OJReina() {
        tipo = "Reina";
        estado = "Viva";  // Estado inicial de la hormiga
    }

    @Override
    public void comerGenoAlimento(OJGenoAlimento genoAlimento) {
        // Lógica para comer GenoAlimento
        System.out.println(tipo + " comiendo GenoAlimento: " + genoAlimento);
    }

    @Override
    public void comerIngestaNativa(OJIngestaNativa ingestaNativa) {
        // Lógica para comer Ingesta Nativa
        System.out.println(tipo + " comiendo Ingesta Nativa: " + ingestaNativa);
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public void setEstado(String estado) {
        this.estado = estado;
    }
}
