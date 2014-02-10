/* HelloAndReply */
package org.xlattice.xlReg;

import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.encodings.OAEPEncoding;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.util.PublicKeyFactory;

/**
 *
 * @author Jim Dixon
 */

public class HelloAndReply {

    private int value;      // XXX never set

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
    
   
    public byte[] ClientEncodeHello(DecimalVersion version, 
            PublicKey ck) throws Exception {

        // data is 56 random bytes + 4 byte version where 
        // 56 = iv + key + salt = 16 + 32 + 8
        byte[] data = new byte[56];
        new SecureRandom().nextBytes(data);
        
        //BOUNCY CASTLE:
        SubjectPublicKeyInfo publicKeyInfo = new SubjectPublicKeyInfo(
                ASN1Sequence.getInstance(ck.getEncoded()));
        AsymmetricKeyParameter param = PublicKeyFactory.
            createKey(publicKeyInfo);
        AsymmetricBlockCipher cipher = new OAEPEncoding(new RSAEngine(),
                new SHA1Digest());
        return cipher.processBlock(data, 0, 32);
    }
    
    
    // public boolean equals(Object o) {
   
    // }

    // SERIALIZATION ////////////////////////////////////////////////

    
    // public String toString() {
    // }
}



