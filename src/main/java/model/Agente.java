package model;


/**
 *
 * @author dam2_alu08@inf.ald
 */
public class Agente {
    private long id;
    private String nombre;
    private double saldo;
    private Operacion compra;
    private Operacion venta;

    public Agente(long id, String nombre, double saldo, Operacion compra, Operacion venta) {
        this.id = id;
        this.nombre = nombre;
        this.saldo = saldo;
        this.compra = compra;
        this.venta = venta;
        
    }

    public Agente() {
    }
    

    public boolean nuevaOperacion(Agente this, String tipo, double limite, double cantidad) {
        switch (tipo) {
            case "compra":
                if (compra == null) {
                    compra = new Operacion(tipo, limite, cantidad);       
                }else{
                    System.out.println("Ya existe una operacion de compra para el agente " + getNombre());
                    return false;
                }
                break;
            case "venta":
                if(venta == null){
                    venta = new Operacion(tipo,limite,cantidad);    
                }
                else{
                    System.out.println("ya existe una operacion de venta para el agente" + getNombre());
                    return false;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Operacion getCompra() {
        return compra;
    }

    public void setCompra(Operacion compra) {
        this.compra = compra;
    }

    public Operacion getVenta() {
        return venta;
    }

    public void setVenta(Operacion venta) {
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "id= " + id + ", usuario= " + nombre + ", saldo= " + saldo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agente other = (Agente) obj;
        return this.id == other.id;
    }

}
