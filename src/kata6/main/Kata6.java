package kata6.main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.view.HistogramDisplay;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramBuilder;
import kata6.view.MailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        
        Kata6 kata = new Kata6();
        kata.execute();
    }
    
    private List<Mail> listMail;
    private List<Person> people;
    private HistogramBuilder<Mail> builder;
    private Histogram<Character> letters;
    private Histogram<String> domains;
    private HistogramBuilder<Person> builderPerson;
    Histogram<Character> gender;
    
    
    private void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }
    
    private void input() throws IOException, ClassNotFoundException, SQLException {
        String nameFile = "C:\\Users\\Graciela\\Documents\\NetBeansProjects\\Kata6\\src\\emails.txt";
        listMail = MailListReader.read(nameFile);
        people = DataBaseList.read();
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
        builderPerson = new HistogramBuilder(people);
        gender = builderPerson.build(new Attribute<Person, Character>() {
                                @Override
                                public Character get(Person item) {
                                    return item.getGender();
                                }
                            });
    }
    
    private void output() {
        HistogramDisplay histoDisplay = new HistogramDisplay(domains, "Dominios");
        histoDisplay.execute();
        HistogramDisplay histoDisplay2 = new HistogramDisplay(letters, "Primer Caracter");
        histoDisplay2.execute();
        HistogramDisplay histoDisplay3 = new HistogramDisplay(gender,"Gender");
        histoDisplay3.execute();
    }
}
