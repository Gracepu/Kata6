package kata4.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListBuilder {
    
    public static List<String> read(String name) throws FileNotFoundException, IOException {
        List<String> mailList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(name)))) {
            String mail;
            
            while((mail = reader.readLine()) != null) {
                if(!mail.contains("@")) continue;
                mailList.add(mail);
            }
        }
        return mailList;
    }
    
}
