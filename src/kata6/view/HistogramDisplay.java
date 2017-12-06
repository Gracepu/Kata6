package kata6.view;

import kata6.model.Histogram;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay <T> extends ApplicationFrame {

    private final Histogram<T> histogram;
    private final String nameEjeX;
    
    public HistogramDisplay(Histogram<T> histogram, String nameEjeX) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    private ChartPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
        setPreferredSize(new Dimension(500,400));
        return chartPanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Histograma JFreeChart", 
                                    "Dominios email", 
                                    "Nº de emails", dataset, 
                                    PlotOrientation.VERTICAL, false, 
                                    rootPaneCheckingEnabled, 
                                    rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataset.addValue(histogram.getKey(key), "", (Comparable) key);
        }
        return dataset;
    }
    
    public void execute() {
        setVisible(true);
    }
}
