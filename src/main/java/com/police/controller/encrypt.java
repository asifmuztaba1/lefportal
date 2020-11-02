
package com.police.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author asifmuztaba
 */
public class encrypt {
    
    public static String encryptPassword(String password) {
    String encryptedPassword = null;
    try {
        MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
        msdDigest.update(password.getBytes("UTF-8"), 0, password.length());
        encryptedPassword = DatatypeConverter.printHexBinary(msdDigest.digest());
    } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
       
    }
        System.out.println("encryptedPassword "+encryptedPassword);
    return encryptedPassword;
}
    
}
