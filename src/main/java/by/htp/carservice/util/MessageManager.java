package by.htp.carservice.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Enum MessageManager.
 */
public enum MessageManager {
    
    /** The en. */
    EN(ResourceBundle.getBundle("localization.msg", new Locale("en", "EN"))),
    
    /** The ru. */
    RU(ResourceBundle.getBundle("localization.msg", new Locale("ru", "RU")));

    /** The bundle. */
    private ResourceBundle bundle;

    /**
     * Instantiates a new message manager.
     *
     * @param bundle the bundle
     */
    MessageManager(ResourceBundle bundle) {
        this.bundle = bundle;
    }

    /**
     * Gets the message.
     *
     * @param key the key
     * @return the message
     */
    public String getMessage(String key) {
        return bundle.getString(key);
    }

    /**
     * Gets the locale.
     *
     * @return the locale
     */
    public Locale getLocale() {
        return bundle.getLocale();
    }

    /**
     * Gets the base name.
     *
     * @return the base name
     */
    public String getBaseName() {
        return bundle.getBaseBundleName();
    }
}
