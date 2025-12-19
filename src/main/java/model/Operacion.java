package model;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Operacion implements Runnable {

    private String tipo;
    private double umbral; //Precio en el cual se quiera comprar o vender
    private double cantidad;
    private transient Broker broker; //el transient se coloca para que no se guarde en el fichero de guardado
    private transient Agente agente;
    private boolean ejecucion;
    private transient Thread hiloEjecutor;

    public Operacion(String tipo, double umbral, double cantidad, Broker broker, Agente agente) {
        setTipo(tipo);
        this.umbral = umbral;
        this.cantidad = cantidad;
        this.broker = broker;
        this.agente = agente;
        this.ejecucion = true;
        hiloEjecutor = new Thread(this);
        hiloEjecutor.start();

    }

    @Override
    public void run() {
        while (ejecucion && !Thread.currentThread().isInterrupted()) {
            System.out.println("Realizando operacion");
            double precioBroker = broker.getPrecio();
            if (ejecutarse(precioBroker)) {
                synchronized (broker) {
                    if (getTipo().equalsIgnoreCase("Compra")) {
                        if (agente.getSaldo() >= getUmbral() * getCantidad()) {
                            agente.setCantidad(getCantidad());
                            agente.setSaldo(agente.getSaldo() - getUmbral() * getCantidad());
                            broker.addPrecio(precioBroker);
                            broker.setPrecio(precioBroker * 1.05);
                            broker.setCantidadOperacionesRealizadas(broker.getCantidadOperacionesRealizadas() + 1);
                            ejecucion = false;
                            agente.setCompra(null);
                            System.out.println("Operacion de compra realizada con exito");
                            PersistenciaDatos.guardarDatos(broker);

                        } else {
                            System.out.println("La operacion de compra no se pudo realizar");
                        }
                    } else if (getTipo().equalsIgnoreCase("Venta")) {
                        if (agente.getCantidad() > getCantidad()) {
                            agente.setSaldo(agente.getSaldo() + getUmbral() * getCantidad());
                            agente.setCantidad(agente.getCantidad() - getCantidad());
                            broker.addPrecio(precioBroker);
                            broker.setPrecio(precioBroker * 0.95);
                            broker.setCantidadOperacionesRealizadas(broker.getCantidadOperacionesRealizadas() + 1);
                            System.out.println("Operacion de venta realizada con exito");
                            agente.setVenta(null);
                            ejecucion = false;
                            PersistenciaDatos.guardarDatos(broker);
                        } else {
                            System.out.println("No se pudo realizar la operacion de venta");
                        }
                    } else {
                        Thread.currentThread().interrupt();
                    }
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    System.getLogger(Operacion.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
                }
            }
        }
        Thread.currentThread().interrupt();
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

    public boolean ejecutarse(double precioBroker) {
        if (getTipo().equalsIgnoreCase("compra")) {
            //se comprueba si vale la pena comprar
            if (precioBroker <= getUmbral()) {
                return false;
            }
            //se comprueba si vale la pena vender
        } else if (getTipo().equalsIgnoreCase("venta")) {
            if (precioBroker >= getUmbral()) {
                return false;
            }
        }
        return true;
    }

}
