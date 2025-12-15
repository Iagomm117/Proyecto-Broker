package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Broker;
import model.Operacion;
import model.PersistenciaDatos;
import org.jfree.ui.action.ActionDowngrade;
import view.MainFrame;

/**
 *
 * @author iagom
 */
public class MainFrameOperationController {

    private MainFrame view;
    private Broker model;

    public MainFrameOperationController(MainFrame view, Broker model) {
        this.view = view;
        this.model = model;
        initAgentesComboBoxItems();
        this.view.addSaveButtonActionListener(this.setSaveButtonActionListener());
        this.view.addTipoComboBoxActionListener(this.setTipoComboBoxActionListener());
        view.statusSaveButton(false);
        view.statusSpinners(false);
    }

    private void initAgentesComboBoxItems() {
        for (int i = 0; i < model.getAgentes().getSize(); i++) {
            view.addItemComboBox(model.getAgentes().getAgente(i).toString());
            if (model.getAgentes().getAgente(i).getCompra() != null) {
                view.setTextCompraLabel("Ya tiene unha operacion de compra existente");
            } else if (model.getAgentes().getAgente(i).getVenta() != null) {
                view.setTextVentaLabel("Ya tiene unha operacion de venta existente");
            } else {
                view.setTextCompraLabel("");
                view.setTextVentaLabel("");
            }
        }
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
                initAgentesComboBoxItems();
            }

        };
        return al;
    }

    private ActionListener setSaveButtonActionListener() {
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (view.getTipoComboBoxSelection() == 1) {
                    for (int i = 0; i < model.getAgentes().getSize(); i++) {
                        if (model.getAgentes().getAgente(i).toString().equalsIgnoreCase(view.getAgentesComboBoxContent())) {
                            model.getAgentes().getAgente(i).setCompra(new Operacion("compra", Double.parseDouble(view.getPrecioSpinnerValue()), Double.parseDouble(view.getCantidadSpinnerValeu())));

                            break;
                        }
                    }
                } else if (view.getTipoComboBoxSelection() == 2) {
                    for (int i = 0; i < model.getAgentes().getSize(); i++) {
                        if (model.getAgentes().getAgente(i).toString().equalsIgnoreCase(view.getAgentesComboBoxContent())) {
                            model.getAgentes().getAgente(i).setCompra(new Operacion("venta", Double.parseDouble(view.getPrecioSpinnerValue()), Double.parseDouble(view.getCantidadSpinnerValeu())));
                            break;
                        }
                    }
                }
                PersistenciaDatos.guardarDatos(model);
            }
        };
        return al;
    }
}
