package view;

import java.io.FileNotFoundException;
import javax.swing.JComponent;
import model.Broker;
import model.PersistenciaDatos;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author iagom
 */
public class Grafico extends JComponent{
    private final Broker broker;

    public Grafico(Broker broker) throws FileNotFoundException {
        this.broker = broker;
        
    }
    public ChartPanel crearChartPanel() {
        final XYDataset dataset = createDataset();
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        chartPanel.setMouseZoomable(true, false);
        return chartPanel; 
    }
    private XYDataset createDataset( ) {
      final TimeSeries series = new TimeSeries( "Grafico de precios" );         
      Second actual = new Second( );         
      double valor = broker.getPrecio();         
      
      for (int i = 0; i < 1000; i++) {
         
         try {              
            series.add(actual, new Double( valor ) );                 
            actual = ( Second ) actual.next( ); 
         } catch ( SeriesException e ) {
         }
      }

      return new TimeSeriesCollection(series);
   }     

   private JFreeChart createChart( final XYDataset dataset ) {
      return ChartFactory.createTimeSeriesChart(             
         "Grafico precio", 
         "Segundos",              
         "Precio",              
         dataset,             
         false,              
         false,              
         false);
   }
}
