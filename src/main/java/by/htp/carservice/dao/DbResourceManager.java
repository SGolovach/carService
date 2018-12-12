package by.htp.carservice.dao;

import java.util.Locale;
import java.util.ResourceBundle;

public class DbResourceManager {
    private ResourceBundle bundle;
    private static final String REGEX_EXPRESSION = "_";
    private static final String REPLACE_VALUE = ".";

    private DbResourceManager() {
        bundle = ResourceBundle.getBundle("dbMySQL",Locale.ENGLISH);
    }

    private static class DbResourceManagerHolder {
        private static final DbResourceManager INSTANCE = new DbResourceManager();
    }

    public static DbResourceManager getInstance() {
        return DbResourceManagerHolder.INSTANCE;
    }

    public String getValue(DbParameter key) {
        return bundle.getString(
                key.toString().replace(REGEX_EXPRESSION,REPLACE_VALUE).toLowerCase());
    }
}
