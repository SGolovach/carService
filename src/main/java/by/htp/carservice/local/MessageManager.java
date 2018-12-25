package by.htp.carservice.local;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("",new Locale("en","EN"))),
    RU(ResourceBundle.getBundle("",new Locale("ru","RU")));

    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle){
        this.bundle = bundle;
    }

    public String getMessage(String key){
        return bundle.getString(key);
    }
}
