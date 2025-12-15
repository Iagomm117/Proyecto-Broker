/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Agente;
import model.Broker;
import model.PersistenciaDatos;
import view.MainFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class MainFrameAgentController {

    private final MainFrame view;
    private final Broker model;

    public MainFrameAgentController(MainFrame view, Broker model) {
        this.view = view;
        this.model = model;
        this.initComponents();
        this.view.addAgenteButtonActionListener(this.setAddAgentButtonActionListener());
    }
    
    private void initComponents(){
        for (int i = 0; i < model.getAgentes().getSize(); i++) {
            view.addListItemAgente(model.getAgentes().getAgente(i));
        }
        
    }

    private ActionListener setAddAgentButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Agente agente = new Agente();
                agente.setId(model.getAgentes().getSize());
                agente.setNombre(view.getTextUsuarioTextField());
                agente.setSaldo(Double.parseDouble(view.getSaldoSpinner()));
                if (model.getAgentes().getSize() > 0) {
                    for (int i = 0; i < model.getAgentes().getSize(); i++) {
                        if (model.getAgentes().getAgente(i).getNombre().trim().equals(agente.getNombre().trim())) {
                        } else {
                            if (agente.getSaldo() < 0) {
                            } else {
                                view.addListItemAgente(agente);
                                model.getAgentes().addAgente(agente);
                                PersistenciaDatos.guardarDatos(model);
                            }
                        }
                    }
                } else {
                    if (agente.getSaldo() > 0) {
                        view.addListItemAgente(agente);
                        model.getAgentes().addAgente(agente);
                        PersistenciaDatos.guardarDatos(model);
                    }
                }
            }
        };
        
        return al;
    }

}
