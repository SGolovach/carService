package by.htp.carservice.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * The Class PasswordHash.
 */
public class PasswordHash {
    /** The Constant SALT. */
    private static final String SALT = "random";
    
    /**
     * Gets the hash Pass.
     *
     * @param password the password
     *
     * @return the hash Pass
     */
    public String getHashPass(String password){
        String resultHash = DigestUtils.sha256Hex(password+SALT);
        return resultHash;
    }
}
