package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.view.HistogramDisplay;
import kata4.model.Histogram;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListBuilder;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        
        Kata4 kata = new Kata4();
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
        String filename = "C:\\Users\\usuario\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
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
