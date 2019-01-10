package by.htp.carservice.connectiondb;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

 /**
  * The Class DbResourceManager.
  */
 class DbResourceManager {
    
    /** The instance. */
    private static DbResourceManager instance;
    
    /** The bundle. */
    private ResourceBundle bundle;
    
    /** The lock db resource manager. */
    private static ReentrantLock lockDbResourceManager = new ReentrantLock();
    
    /** The create db resource manager. */
    private static AtomicBoolean createDbResourceManager = new AtomicBoolean(false);
    
    /** The Constant REGEX_EXPRESSION. */
    private static final String REGEX_EXPRESSION = "_";
    
    /** The Constant REPLACE_VALUE. */
    private static final String REPLACE_VALUE = ".";

    /**
     * Instantiates a new db resource manager.
     */
    private DbResourceManager() {
        bundle = ResourceBundle.getBundle("dbMySQL", Locale.ENGLISH);
    }

     /**
      * Gets the single instance of DbResourceManager.
      *
      * @return single instance of DbResourceManager
      */
     static DbResourceManager getInstance() {
        if (!createDbResourceManager.get()) {
            try {
                lockDbResourceManager.lock();
                if (instance == null) {
                    instance = new DbResourceManager();
                    createDbResourceManager.set(true);
                }
            } finally {
                lockDbResourceManager.unlock();
            }
        }
        return instance;
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
