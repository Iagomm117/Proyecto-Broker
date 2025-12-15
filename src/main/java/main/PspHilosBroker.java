package main;

import controller.MainFrameAgentController;
import controller.MainFrameGraficoController;
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
        //Tener persistencia de usuarios/agentes y operaciones
        //RECUPERAR PRECIO Y LOS VALORES ANTERIORES
        
        //Mostrar PRECIO/Tiempo -> Interfaz grafica
        
        //Crear agentes que tienen operaciones de entrada y salida
        //Lectura de precio y compran o venden -> 2 tipos de hilos
        
        //Agentes con capital que puedan lanzar las operaciones de compra/venta
        //Añadir a la interfaz nuevos agentes y crear operaciones
        
        //Añadir logica de compra/venta en broker -> Propio hilo/ Si alguien compra a x precio, se baja el precio del producto, si alguien compra el producto se sube el precio
        //Se sube el precio cuando no queda cantidad y compra / sube el precio cuando se producen ventas   
        
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
        MainFrameGraficoController grafico = new MainFrameGraficoController(view);
        view.setVisible(true);
    }
}
