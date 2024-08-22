package OJBusinessLogic;

public abstract class OJAlimento {
    
    protected String tipo;
    @Override
    public String toString(){
        if (tipo == null) 
                tipo = "";
            return tipo.toUpperCase();
        
    }
}

