package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iagom
 */
public class ListaAgentes {
    private List<Agente> agentes;

    public ListaAgentes() {
        this.agentes = new ArrayList();
    }

    public List<Agente> getAgentes() {
        return agentes;
    }

    public void addAgente(Agente agente){
        this.agentes.add(agente);
    }
    
    public int getSize(){
        return this.agentes.size();
    }
    
    public Agente getAgente(int n){
        return (Agente) this.agentes.get(n);
    }
    
    
}
