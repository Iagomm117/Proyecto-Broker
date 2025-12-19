package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import model.Broker;
import model.Operacion;
import model.PersistenciaDatos;
import view.MainFrame;

/**
 *
 * @author iagom
 */
public class MainFrameOperationController {

    private MainFrame view;
    private Broker model;

    public MainFrameOperationController(MainFrame view, Broker model) throws FileNotFoundException {
        this.view = view;
        this.model = model;
        this.view.addVentanaChangeListener(this.initComponents());
        this.view.addSaveButtonActionListener(this.setSaveButtonActionListener());
        this.view.addTipoComboBoxActionListener(this.setTipoComboBoxActionListener());
        view.statusSaveButton(false);
        view.statusSpinners(false);
    }

    
    //metodo que permite inicializar los datos del combo box
    private void initAgentesComboBoxItems() throws FileNotFoundException {
        model = PersistenciaDatos.leerDatos();
        view.clearAgentestComboBox();
        for (int i = 0; i < model.getAgentes().getSize(); i++) {
            view.addItemComboBox(model.getAgentes().getAgente(i).toString());
        }
    }

    //metodo que permite que se generen los datos cada vez que se acceda a la pestaña
    private ChangeListener initComponents() {
        ChangeListener cl = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    initAgentesComboBoxItems();
                } catch (FileNotFoundException ex) {
                }
            }
        };
        return cl;
    }

    private ActionListener setTipoComboBoxActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTipoComboBoxSelection() == 0) {
                    view.statusSaveButton(false);
                    view.statusSpinners(false);
                } else if (view.getTipoComboBoxSelection() == 1) {
                    view.statusSaveButton(true);
                    view.statusSpinners(true);
                } else if (view.getTipoComboBoxSelection() == 2) {
                    view.statusSaveButton(true);
                    view.statusSpinners(true);

                }
            }
        };
        return al;
    }

    //metodo para poder guardar las operaciones de cada agente, revisa si tiene una hecha
    private ActionListener setSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTipoComboBoxSelection() == 1) {
                    for (int i = 0; i < model.getAgentes().getSize(); i++) {
                        if (model.getAgentes().getAgente(i).toString().equalsIgnoreCase(view.getAgentesComboBoxContent())) {
                            if (model.getAgentes().getAgente(i).getCompra() == null) {
                                model.getAgentes().getAgente(i).setCompra(new Operacion("compra", Double.parseDouble(view.getPrecioSpinnerValue()), Double.parseDouble(view.getCantidadSpinnerValeu()),model,model.getAgentes().getAgente(i)));
                                JOptionPane.showMessageDialog(view, "Operacion creada con exito");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(view, "Ya tiene unha operacion de compra existente");
                                break;
                            }

                        }
                    }
                } else if (view.getTipoComboBoxSelection() == 2) {
                    for (int i = 0; i < model.getAgentes().getSize(); i++) {
                        if (model.getAgentes().getAgente(i).toString().equalsIgnoreCase(view.getAgentesComboBoxContent())) {
                            if (model.getAgentes().getAgente(i).getVenta() == null) {
                                model.getAgentes().getAgente(i).setVenta(new Operacion("venta", Double.parseDouble(view.getPrecioSpinnerValue()), Double.parseDouble(view.getCantidadSpinnerValeu()),model,model.getAgentes().getAgente(i)));
                                JOptionPane.showMessageDialog(view, "Operacion creada con exito");
                                break;
                            } else {
                                JOptionPane.showMessageDialog(view, "Ya tiene unha operacion de venta existente");
                                break;
                            }
                        }
                    }
                }
                PersistenciaDatos.guardarDatos(model);
            }
        };
        return al;
    }
}
