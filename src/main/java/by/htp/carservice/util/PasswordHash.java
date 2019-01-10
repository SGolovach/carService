package by.htp.carservice.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The Class PasswordHash.
 */
public class PasswordHash {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant SALT. */
    private static final String SALT = "random";
    
    /**
     * Gets the hash P ass.
     *
     * @param password the password
     * @return the hash P ass
     */
    public String getHashPAss(String password){
        logger.log(Level.INFO,"Start method getHashPAss");
        String resultHash = DigestUtils.sha256Hex(password+SALT);
        logger.log(Level.INFO,"Finish method getHashPAss");
        return resultHash;
    }
}
