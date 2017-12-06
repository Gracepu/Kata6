package kata6.main;

import java.io.IOException;
import java.util.List;
import kata6.view.HistogramDisplay;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        
        Kata6 kata = new Kata6();
        kata.execute();
    }
    
    private List<Mail> listMail;
    private HistogramBuilder<Mail> builder;
    private Histogram<Character> letters;
    private Histogram<String> domains;
    
    
    private void execute() throws IOException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException {
        String nameFile = "C:\\Users\\Graciela\\Documents\\NetBeansProjects\\Kata6\\src\\emails.txt";
        listMail = MailListReader.read(nameFile);
    }
    
    private void process() {
        builder = new HistogramBuilder(listMail);
        domains = builder.build(new Attribute<Mail,String>() {
                                @Override
                                public String get(Mail item) {
                                    return item.getMail().split("@")[1];
                                }
                            });
        letters = builder.build(new Attribute<Mail, Character>() {
                                @Override
                                public Character get(Mail item) {
                                    return item.getMail().charAt(0);
                                }
                            });
    }
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(domains, "Dominios");
        histoDisplay.execute();
        HistogramDisplay histoDisplay2 = new HistogramDisplay(letters, "Primer Caracter");
        histoDisplay2.execute();
    }
}
