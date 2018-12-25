package by.htp.carservice.dao;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class DbResourceManager {
    private static DbResourceManager instance;
    private ResourceBundle bundle;
    private static ReentrantLock lockDbResourceManager = new ReentrantLock();
    private static AtomicBoolean createDbResourceManager = new AtomicBoolean(false);
    private static final String REGEX_EXPRESSION = "_";
    private static final String REPLACE_VALUE = ".";

    private DbResourceManager() {
        bundle = ResourceBundle.getBundle("dbMySQL", Locale.ENGLISH);
    }

    public static DbResourceManager getInstance() {
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

    String getValue(DbParameter key) {
        return bundle.getString(
                key.toString().replace(REGEX_EXPRESSION, REPLACE_VALUE).toLowerCase());
    }
}
