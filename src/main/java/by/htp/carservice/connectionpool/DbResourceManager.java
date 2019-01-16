package by.htp.carservice.connectionpool;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * The Class DbResourceManager.
 */
class DbResourceManager {

    /**
     * The bundle.
     */
    private ResourceBundle bundle;

    /**
     * The Constant REGEX_EXPRESSION.
     */
    private static final String REGEX_EXPRESSION = "_";

    /**
     * The Constant REPLACE_VALUE.
     */
    private static final String REPLACE_VALUE = ".";

    /**
     * Instantiates a new db resource manager.
     */
    private DbResourceManager() {
        bundle = ResourceBundle.getBundle("dbMySQL", Locale.ENGLISH);
    }

    private static class DbResourceManagerHolder {
        private static final DbResourceManager INSTANCE = new DbResourceManager();
    }

    /**
     * Gets the single instance of DbResourceManager.
     *
     * @return single instance of DbResourceManager
     */
    static DbResourceManager getInstance() {
        return DbResourceManagerHolder.INSTANCE;
    }

    /**
     * Gets the value.
     *
     * @param key the key
     * @return the value
     */
    String getValue(DbParameter key) {
        return bundle.getString(
                key.toString().replace(REGEX_EXPRESSION, REPLACE_VALUE).toLowerCase());
    }
}
