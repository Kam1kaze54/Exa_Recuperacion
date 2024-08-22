package OJGUI;

import com.formdev.flatlaf.FlatIntelliJLaf;
import OJBusinessLogic.OJInsectivoro;
import OJBusinessLogic.OJXX;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import OJDataAccesComponent.OJHormigaDTO;
import OJDataAccesComponent.OJHormigaDAO;
import java.util.List;

public class OJFreamMain {

    private JFrame frame;
    private JPanel gridPanel;
    private int hormigaCount = 0;  // Contador para el número de hormigas
    private JPanel selectedHormigaPanel = null;  // Panel de la hormiga seleccionada
    private JComboBox<OJXX> comboBox1;
    private JComboBox<OJInsectivoro> comboBox2;

    private OJHormigaDAO hormigaDAO = new OJHormigaDAO();  // Instancia del DAO

    public OJFreamMain() {
        // Configuración del tema FlatLaf
        FlatIntelliJLaf.setup();  // Usar FlatIntelliJLaf como especificaste anteriormente

        // Creación del JFrame principal
        frame = new JFrame("EcuAnt 2K24A");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Crear el panel superior con el título y el ícono
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titleLabel = new JLabel("EcuaFauna 2K24A");
        titleLabel.setFont(new Font("Helvetica", Font.BOLD, 18));

        // Redimensionar el ícono de la esquina superior izquierda
        ImageIcon icon = new ImageIcon("Resources/png-clipart-the-ant-and-the-grasshopper-tropical-flowers-miscellaneous-ant.png");
        Image scaledIconImage = icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        titleLabel.setIcon(new ImageIcon(scaledIconImage));
        topPanel.add(titleLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        // Crear el panel central con la imagen de laboratorio y la cuadrícula
        JPanel centerPanel = new JPanel(new BorderLayout());

        // Añadir la imagen del laboratorio
        ImageIcon labIconImage = new ImageIcon("Resources/2103579.png");
        Image scaledLabIconImage = labIconImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        JLabel labIcon = new JLabel(new ImageIcon(scaledLabIconImage));
        labIcon.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(labIcon, BorderLayout.NORTH);

        JLabel titleCenterLabel = new JLabel("Hormiguero Virtual", SwingConstants.CENTER);
        titleCenterLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
        centerPanel.add(titleCenterLabel, BorderLayout.CENTER);

        // Crear un panel para mostrar los encabezados y la cuadrícula
        JPanel gridContainer = new JPanel(new BorderLayout());

        // Panel con los encabezados descriptivos
        JPanel headersPanel = new JPanel(new GridLayout(1, 6, 5, 5));

        // Añadir etiquetas descriptivas
        headersPanel.add(createHeaderLabel("Registro"));
        headersPanel.add(createHeaderLabel("Tipo de hormiga"));
        headersPanel.add(createHeaderLabel("Sexo"));
        headersPanel.add(createHeaderLabel("GenoAlimento"));
        headersPanel.add(createHeaderLabel("IngestaNativa"));
        headersPanel.add(createHeaderLabel("Estado"));

        // Añadir el panel de encabezados descriptivos al contenedor
        gridContainer.add(headersPanel, BorderLayout.NORTH);

        // Crear el panel de la cuadrícula con un JScrollPane
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridBagLayout());
        gridPanel.setBorder(BorderFactory.createTitledBorder("Hormigas"));

        JScrollPane gridScrollPane = new JScrollPane(gridPanel);
        gridScrollPane.setPreferredSize(new Dimension(750, 200));  // Limitar la altura de la cuadrícula
        gridScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        gridScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        // Añadir la cuadrícula al contenedor
        gridContainer.add(gridScrollPane, BorderLayout.CENTER);

        // Añadir el contenedor de la cuadrícula al panel central, pero moverlo más abajo
        JPanel paddedPanel = new JPanel(new BorderLayout());
        paddedPanel.add(centerPanel, BorderLayout.NORTH);
        paddedPanel.add(gridContainer, BorderLayout.SOUTH);
        frame.add(paddedPanel, BorderLayout.CENTER);

        // Crear el panel inferior que contendrá los JComboBox y los botones
        JPanel bottomPanel = new JPanel(new BorderLayout());

        // Crear el panel para los JComboBox
        JPanel comboBoxPanel = new JPanel(new GridLayout(1, 2, 5, 5));

        // Crear JComboBox con opciones de ejemplo
        OJXX[] genoAlimentoOptions = { new OJXX("GenoAlimento "), new OJXX("XX") }; // Se deben agregar más tipos si es necesario
        OJInsectivoro[] ingestaNativaOptions = { new OJInsectivoro("IngestaNativa"), new OJInsectivoro("Insectivoro ") }; // Se deben agregar más tipos si es necesario

        comboBox1 = new JComboBox<>(genoAlimentoOptions);
        comboBox2 = new JComboBox<>(ingestaNativaOptions);

        comboBoxPanel.add(comboBox1);
        comboBoxPanel.add(comboBox2);

        // Crear el panel para los botones
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        JButton btnCrear = new JButton("Crear Hormiga");
        JButton btnAlimentar = new JButton("Alimentar");
        JButton btnEliminar = new JButton("Eliminar");
        JButton btnGuardar = new JButton("Guardar");
        buttonsPanel.add(btnCrear);
        buttonsPanel.add(btnAlimentar);
        buttonsPanel.add(btnEliminar);
        buttonsPanel.add(btnGuardar);

        // Añadir ambos paneles al bottomPanel
        bottomPanel.add(comboBoxPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonsPanel, BorderLayout.SOUTH);

        // Crear un contenedor para el bottomPanel y el infoPanel
        JPanel bottomContainer = new JPanel(new BorderLayout());
        bottomContainer.add(bottomPanel, BorderLayout.CENTER);

        // Panel inferior con información
        JPanel infoPanel = new JPanel(new BorderLayout());
        JLabel programLabel = new JLabel("Programación II", SwingConstants.LEFT);
        JLabel cedulaLabel = new JLabel("Cédula: 1728160449", SwingConstants.CENTER);
        JLabel nombreLabel = new JLabel("Nombres: Justin Ortiz", SwingConstants.RIGHT);

        infoPanel.add(programLabel, BorderLayout.WEST);
        infoPanel.add(cedulaLabel, BorderLayout.CENTER);
        infoPanel.add(nombreLabel, BorderLayout.EAST);

        // Añadir el infoPanel al bottomContainer
        bottomContainer.add(infoPanel, BorderLayout.SOUTH);

        // Añadir el bottomContainer al frame
        frame.add(bottomContainer, BorderLayout.SOUTH);

        // Acción del botón "Crear Hormiga"
        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, "¿Seguro que quieres crear una hormiga larva?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    addHormigaToGrid();

                    // Restablecer los JComboBox a su estado original
                    comboBox1.setSelectedIndex(0);
                    comboBox2.setSelectedIndex(0);
                }
            }
        });

        // Acción del botón "Alimentar"
        btnAlimentar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedHormigaPanel != null) {
                    OJXX genoAlimentoSelected = (OJXX) comboBox1.getSelectedItem();
                    OJInsectivoro ingestaNativaSelected = (OJInsectivoro) comboBox2.getSelectedItem();

                    // Actualizar las etiquetas en el panel seleccionado
                    for (Component comp : selectedHormigaPanel.getComponents()) {
                        if (comp instanceof JLabel) {
                            JLabel label = (JLabel) comp;

                            // Si se selecciona un GenoAlimento, se desactiva IngestaNativa
                            if (!genoAlimentoSelected.toString().equals("GenoAlimento ") && label.getText().startsWith("GenoAlimento")) {
                                label.setText(genoAlimentoSelected.toString());
                                // Desactivar IngestaNativa
                                updateOtherLabel(selectedHormigaPanel, "IngestaNativa", "");
                            } 
                            // Si se selecciona IngestaNativa, se desactiva GenoAlimento
                            else if (!ingestaNativaSelected.toString().equals("IngestaNativa") && label.getText().startsWith("IngestaNativa")) {
                                label.setText(ingestaNativaSelected.toString());
                                // Desactivar GenoAlimento
                                updateOtherLabel(selectedHormigaPanel, "GenoAlimento", "");
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona una hormiga antes de alimentarla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Acción del botón "Eliminar"
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedHormigaPanel != null) {
                    gridPanel.remove(selectedHormigaPanel);
                    gridPanel.revalidate();
                    gridPanel.repaint();
                    selectedHormigaPanel = null;
                } else {
                    JOptionPane.showMessageDialog(frame, "Por favor, selecciona una hormiga antes de eliminarla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Acción del botón "Guardar"
        // Acción del botón "Guardar"
btnGuardar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        List<OJHormigaDTO> hormigaList = new ArrayList<>();
        
        for (Component component : gridPanel.getComponents()) {
            if (component instanceof JPanel) {
                JPanel hormigaPanel = (JPanel) component;
                OJHormigaDTO hormigaDTO = new OJHormigaDTO(0, "", "", "", "", ""); // Inicializar con valores por defecto
                
                for (Component labelComponent : hormigaPanel.getComponents()) {
                    if (labelComponent instanceof JLabel) {
                        JLabel label = (JLabel) labelComponent;
                        String text = label.getText().trim();
                        
                        if (text.matches("\\d+")) {
                            hormigaDTO.setIdHormiga(Integer.parseInt(text));
                        } else if (text.startsWith("Tipo de hormiga:")) {
                            hormigaDTO.setTipoHormiga(text.replace("Tipo de hormiga: ", "").trim());
                        } else if (text.startsWith("Sexo:")) {
                            hormigaDTO.setSexo(text.replace("Sexo: ", "").trim());
                        } else if (text.startsWith("GenoAlimento:")) {
                            hormigaDTO.setGenoAlimento(text.replace("GenoAlimento: ", "").trim());
                        } else if (text.startsWith("IngestaNativa:")) {
                            hormigaDTO.setIngestaNativa(text.replace("IngestaNativa: ", "").trim());
                        } else if (text.startsWith("Estado:")) {
                            hormigaDTO.setEstado(text.replace("Estado: ", "").trim());
                        }
                    }
                }
                hormigaList.add(hormigaDTO);
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:/Directorio Programacion II/SegundoBimestre/Examen_Recuperacion2k24A/OJEcuAnt2k24/src/OJData/OJHormiga.txt"))) {
            for (OJHormigaDTO hormiga : hormigaList) {
                // Escribir en el formato deseado
                writer.write(hormiga.getIdHormiga() + ", ");
                writer.write(hormiga.getTipoHormiga() + ", ");
                writer.write(hormiga.getSexo() + ", ");
                writer.write(hormiga.getGenoAlimento() + ", ");
                writer.write(hormiga.getIngestaNativa() + ", ");
                writer.write(hormiga.getEstado());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(frame, "Los datos se han guardado correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace(); // Imprimir el stack trace para depurar el error
            JOptionPane.showMessageDialog(frame, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
});



        frame.setVisible(true);
    }

    private JLabel createHeaderLabel(String text) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Helvetica", Font.BOLD, 14));
        return label;
    }

    private void addHormigaToGrid() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = hormigaCount;
        gbc.insets = new Insets(5, 5, 5, 5);

        JPanel hormigaPanel = new JPanel(new GridLayout(1, 6, 5, 5));
        hormigaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Añadir etiquetas descriptivas a la nueva hormiga
        JLabel registroLabel = new JLabel(String.valueOf(hormigaCount + 1));
        JLabel tipoLabel = new JLabel("Reina");
        JLabel sexoLabel = new JLabel("Hembra");
        JLabel genoAlimentoLabel = new JLabel("GenoAlimento ");
        JLabel ingestaNativaLabel = new JLabel("IngestaNativa");
        JLabel estadoLabel = new JLabel("Vivo");

        // Añadir todas las etiquetas al panel de la hormiga
        hormigaPanel.add(registroLabel);
        hormigaPanel.add(tipoLabel);
        hormigaPanel.add(sexoLabel);
        hormigaPanel.add(genoAlimentoLabel);
        hormigaPanel.add(ingestaNativaLabel);
        hormigaPanel.add(estadoLabel);

        hormigaPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (selectedHormigaPanel != null) {
                    selectedHormigaPanel.setBackground(null);  // Restablecer color original del panel anterior
                }
                selectedHormigaPanel = hormigaPanel;
                selectedHormigaPanel.setBackground(Color.LIGHT_GRAY);  // Destacar el panel seleccionado
            }
        });

        gridPanel.add(hormigaPanel, gbc);

        hormigaCount++;  // Incrementar el contador de hormigas

        // Refrescar el panel de la cuadrícula
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private void updateOtherLabel(JPanel panel, String labelText, String newValue) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (label.getText().startsWith(labelText)) {
                    label.setText(newValue);
                }
            }
        }
    }
}
