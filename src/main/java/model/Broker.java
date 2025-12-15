package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iagom
 */
public class Broker {
    private double precio;
    private int cantidadOperacionesRealizadas;
    private ListaAgentes agentes;
    private List<Double> precios;

    public Broker(double precio, int cantidadOperacionesRealizadas, ListaAgentes agentes) {
        this.precio = precio;
        this.cantidadOperacionesRealizadas = cantidadOperacionesRealizadas;
        this.agentes = agentes;
        this.precios = new ArrayList();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidadOperacionesRealizadas() {
        return cantidadOperacionesRealizadas;
    }

    public void setCantidadOperacionesRealizadas(int cantidadOperacionesRealizadas) {
        this.cantidadOperacionesRealizadas = cantidadOperacionesRealizadas;
    }

    public ListaAgentes getAgentes() {
        return agentes;
    }

    public void setAgentes(ListaAgentes agentes) {
        this.agentes = agentes;
    }
    
    public void addPrecio(double precio){
        this.precios.add(precio);
    }

    public List<Double> getPrecios() {
        return precios;
    }

    public void setPrecios(List<Double> precios) {
        this.precios = precios;
    }
    
    
    
    
}
