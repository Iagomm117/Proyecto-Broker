/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Agente;
import view.MainFrame;

/**
 *
 * @author dam2_alu08@inf.ald
 */
public class MainFrameController {
    
    private final MainFrame view;

    public MainFrameController(MainFrame view) {
        this.view = view;
        this.view.addAgenteButtonActionListener(this.setAddAgentButtonActionListener());
    }
    
    private ActionListener setAddAgentButtonActionListener(){
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Agente agente = new Agente();
                agente.setNombre(view.getTextUsuarioTextField());
                agente.setSaldo(Double.parseDouble(view.getSaldoSpinner()));
                view.addListItem(agente.getNombre(), agente.getSaldo());
                
            }
        };
        return al;
    }
}
