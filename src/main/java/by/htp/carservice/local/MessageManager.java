package by.htp.carservice.local;

import java.util.Locale;
import java.util.ResourceBundle;

public enum MessageManager {
    EN(ResourceBundle.getBundle("localization.msg", new Locale("en", "EN"))),
    RU(ResourceBundle.getBundle("localization.msg", new Locale("ru", "RU")));

    private ResourceBundle bundle;

    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    public String getMessage(String key) {
        return bundle.getString(key);
    }

    public Locale getLocale() {
        return bundle.getLocale();
    }

    public String getBaseName() {
        return bundle.getBaseBundleName();
    }
}
