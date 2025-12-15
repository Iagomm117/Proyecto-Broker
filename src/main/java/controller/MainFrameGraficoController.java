package controller;

import java.io.FileNotFoundException;
import javax.swing.JPanel;
import model.Broker;
import org.jfree.chart.ChartPanel;
import view.Grafico;
import view.MainFrame;

/**
 *
 * @author iagom
 */
public class MainFrameGraficoController {
    private final MainFrame view;
    private final Broker model;

    public MainFrameGraficoController(MainFrame view,Broker model) throws FileNotFoundException {
        this.view = view;
        this.model = model;
        pintarGrafico();
    }
    
    private void pintarGrafico() throws FileNotFoundException{
        JPanel graficaPanel = view.panelGrafico();
        Grafico grafico = new Grafico(model);
        ChartPanel panel = grafico.crearChartPanel();
        graficaPanel.setLayout(new java.awt.BorderLayout());
        graficaPanel.removeAll();
        graficaPanel.add(panel, java.awt.BorderLayout.CENTER);
        graficaPanel.revalidate();
        graficaPanel.repaint();
    }
    
}
