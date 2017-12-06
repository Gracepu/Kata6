package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.view.HistogramDisplay;
import kata6.model.Histogram;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListBuilder;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        
        Kata6 kata = new Kata6();
        kata.execute();
    }
    
    private List<String> mailList;
    private Histogram<String> histogram;
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        String filename = "C:\\Users\\Graciela\\Documents\\NetBeansProjects\\Kata6\\src\\emails.txt";
        mailList = MailListBuilder.read(filename);
    }
    
    private void process() {
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
