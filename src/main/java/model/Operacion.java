package model;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Operacion implements Runnable {

    private String tipo;
    private double umbral; //Precio en el cual se quiera comprar o vender
    private double cantidad;
    private Thread hiloEjecutor;

    public Operacion(String tipo, double umbral, double cantidad) {
        setTipo(tipo);
        this.umbral = umbral;
        this.cantidad = cantidad;
        hiloEjecutor = new Thread(this);
        hiloEjecutor.start();
        
    }

    @Override
    public void run() {
        //BUCLE
            //Comprobar precio del broker
                //SI = PEDIR EL LOCK SUMAR O RESTAR, LIBERAR EL LOCK
                //NO = SE DUERME
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equalsIgnoreCase("compra") || tipo.equalsIgnoreCase("venta")) {
            this.tipo = tipo;
        }

    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getUmbral() {
        return umbral;
    }

    public void setUmbral(double umbral) {
        this.umbral = umbral;
    }

}
