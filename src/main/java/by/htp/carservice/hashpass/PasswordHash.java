package by.htp.carservice.hashpass;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PasswordHash {
    private static Logger logger = LogManager.getLogger();
    private static final String SALT = "random";
    public String getHashPAss(String password){
        logger.log(Level.INFO,"Start method getHashPAss");
        String resultHash = DigestUtils.sha256Hex(password+SALT);
        logger.log(Level.INFO,"Finish method getHashPAss");
        return resultHash;
    }
}
