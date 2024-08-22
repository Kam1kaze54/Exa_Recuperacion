package OJDataAccesComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OJHormigaDAO {

    private static final String FILE_PATH = "C:/Directorio Programacion II/SegundoBimestre/Examen_Recuperacion2k24A/OJEcuAnt2k24/src/OJData/OJHormiga.txt";

    // Método para crear una nueva hormiga y guardarla en el archivo
    public void create(OJHormigaDTO hormiga) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writeHormiga(writer, hormiga);
        } catch (IOException e) {
            System.err.println("Error al guardar los datos de la hormiga: " + e.getMessage());
            throw e;
        }
    }

    private void writeHormiga(BufferedWriter writer, OJHormigaDTO hormiga) throws IOException {
        String data = String.join(",",
                String.valueOf(hormiga.getIdHormiga()),
                hormiga.getTipoHormiga(),
                hormiga.getSexo(),
                hormiga.getGenoAlimento(),
                hormiga.getIngestaNativa(),
                hormiga.getEstado()
        );
        writer.write(data);
        writer.newLine();
        System.out.println("Datos guardados: " + data);
    }

    // Método para leer todas las hormigas guardadas en el archivo
    public List<OJHormigaDTO> readAll() throws IOException {
        List<OJHormigaDTO> hormigas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                OJHormigaDTO hormiga = parseHormiga(line);
                if (hormiga != null) {
                    hormigas.add(hormiga);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer los datos de las hormigas: " + e.getMessage());
            throw e;
        }
        return hormigas;
    }

    private OJHormigaDTO parseHormiga(String line) {
        String[] data = line.split(",");
        if (data.length == 6) {
            try {
                return new OJHormigaDTO(
                        Integer.parseInt(data[0]), // idHormiga
                        data[1], // tipoHormiga
                        data[2], // sexo
                        data[3], // genoAlimento
                        data[4], // ingestaNativa
                        data[5]  // estado
                );
            } catch (NumberFormatException e) {
                System.err.println("Error al parsear datos de hormiga: " + e.getMessage());
            }
        } else {
            System.err.println("Línea con formato incorrecto: " + line);
        }
        return null;
    }
}
