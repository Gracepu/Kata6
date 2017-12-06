package kata6.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import kata6.model.Mail;

public class MailListReader {
    
    public static List read(String name) throws IOException, FileNotFoundException{
        List<Mail> mailList = new ArrayList<>();
        Integer id = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(name)))) {
            String mail;
            
            while((mail = reader.readLine()) != null) {
                if(!mail.contains("@")) continue;
                mailList.add(new Mail(id,mail));
            }
        }
        return mailList;
    }
    
}
