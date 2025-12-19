package main;

import controller.MainFrameAgentController;
import controller.MainFrameGraficoController;
import controller.MainFrameOperationController;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import model.Broker;
import model.ListaAgentes;
import model.PersistenciaDatos;
import view.MainFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class PspHilosBroker {

    public static void main(String[] args) throws FileNotFoundException {       
        MainFrame view = new MainFrame();
        ListaAgentes agentes = new ListaAgentes();
        Broker broker = null;
        File file = new File("broker.json");
        if(!Files.exists(file.toPath())){
             broker = new Broker(200,0,agentes);
        }
        else{
           broker = PersistenciaDatos.leerDatos(); 
        }        
        MainFrameAgentController controller = new MainFrameAgentController(view,broker);
        MainFrameGraficoController grafico = new MainFrameGraficoController(view,broker);
        MainFrameOperationController operacion = new MainFrameOperationController(view,broker);
        view.setVisible(true);
    }
}
