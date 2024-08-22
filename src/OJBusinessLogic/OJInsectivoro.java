package OJBusinessLogic;

public class OJInsectivoro extends OJIngestaNativa {

        private String name;
    
        public OJInsectivoro(String name) {
            this.name = name;
        }
    
        @Override
        public String toString() {
            return name;
        }
}
