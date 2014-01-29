/* HelloAndReply */
package org.xlattice.xlReg;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

/**
 *
 * @author Jim Dixon
 */

public class HelloAndReply {

    private final int value;

    // CONSTRUCTORS /////////////////////////////////////////////////

    /**
     *
     */
    private HelloAndReply () {
    }

    /** 
     * Convert parameters into a HelloAndReply.  Each parameter is treated
     * as an unsigned byte in the range 0..255.  No error is returned 
     * if a value is out of range.
     */

    // PROPERTIES ///////////////////////////////////////////////////
    //
    
    // OTHER METHODS ////////////////////////////////////////////////
    
   
    public byte[] ClientEncodeHello(version DecimalVersion, 
            ck *rsaPublicKey) throws Exception {

        // data is 56 random bytes + 4 byte version where 
        // 56 = iv + key + salt = 16 + 32 + 8
        //
        //
        //BOUNCY CASTLE:
        SubjectPublicKeyInfo publicKeyInfo = new SubjectPublicKey(
                ASN1Sequence.getInstance(ck.getEncoded()));
        AsymmetricKeyParameter param = PublicKeyFactory.
            createKey(publicKeyInfo);
        AsymmetricBlockCipher cipher = new OAEPEncoding(new RSAEngine(),
                new SHA1Digest();
        return cipher.processBlock(data, 0, 32)
    }
    
    
    // public boolean equals(Object o) {
    
    // SERIALIZATION ////////////////////////////////////////////////

    // Convert the HelloAndReply to dotted string format.  We always include
    // at least the two leading parts, so version 1.0.0.0 in string form 
    // is "1.0".
    
    // public String toString() {
}



