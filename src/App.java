

import java.io.IOException;
import java.util.List;

import javax.swing.SwingUtilities;

import OJDataAccesComponent.OJHormigaDAO;
import OJDataAccesComponent.OJHormigaDTO;
import OJGUI.OJFreamMain;

public class App {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new OJFreamMain();
            }
        });
    }
}
