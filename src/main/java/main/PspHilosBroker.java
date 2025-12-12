package main;

import controller.MainFrameController;
import view.MainFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class PspHilosBroker {

    public static void main(String[] args) {
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
        MainFrameController controller = new MainFrameController(view);
        view.setVisible(true);
    }
}
