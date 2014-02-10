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
 * In the Hello/Reply sequence, the client sends to the server a packet
 * containing an AES IV and Key, another 8-byte random value, and a 
 * proposed version from a subsequent session.  This data is encrypted
 * using the server's public RSA key.  The server decrypt's this message
 * using its private RSA key, chooses a second AES IV and key plus a 
 * second salt, and decides on the protocol version to the used in the
 * session.  This information is encrypted using the client's AES IV
 * and key (which are never used again) and returned to the client.  
 *
 * @author Jim Dixon
 */

public class HelloAndReply {

    // sent by the client to the server
    private byte[]	        aesIV;
    private byte[]	        aesKey;
    private byte[]	        salt1;
    private DecimalVersion  version1;

    // received from the server by the client
    private byte[]          sessionIV;
    private byte[]          sessionKey;
    private byte[]          salt2;
    private DecimalVersion  version2;

    private HelloAndReply () {
    }

    // PROPERTIES ///////////////////////////////////////////////////

    /** @return the AES IV used for the server reply */
    public byte[] GetIV1() { 
        return this.aesIV;
    }
    /** @return the AES key used for the server reply */
    public byte[] GetKey1() { 
        return this.aesKey;
    }
    /** @return the salt used in the client message */
    public byte[] GetSalt1() { 
        return this.salt1;
    }
    /** @return the protocol version proposed by the client */
    public DecimalVersion GetSVersion1() { 
        return this.version1;
    } 

    /** @return the AES IV to be used for the rest of the session */
    public byte[] GetSessionIV() { 
        return this.sessionIV;
    }
    /** @return the AES key to be used for the rest of the session */
    public byte[] GetSessionKey() { 
        return this.sessionKey;
    }
    /** @return salt2 from the server reply */
    public byte[] GetSalt2() { 
        return this.salt2;
    }
    /** @return the protocol version decided by the server */
    public DecimalVersion GetSVersion2() { 
        return this.version2;
    } 

    // OTHER METHODS ////////////////////////////////////////////////
    
    /**
     * Given the proposed protocol version number and the server's RSA
     * public key, prepare the client Hello packet.
     */
   
    public byte[] ClientEncodeHello (DecimalVersion version, 
            PublicKey ck) throws Exception {

        // data is 56 random bytes + 4 byte version where 
        // 56 = iv + key + salt = 16 + 32 + 8
        byte[] data = new byte[56];
        new SecureRandom().nextBytes(data);
       
        this.aesIV  	= new byte[16];
        this.aesKey 	= new byte[32];
        this.salt1  	= new byte[8];
        this.version1   = version;

        System.arraycopy(data,  0, this.aesIV, 0, 16);
        System.arraycopy(data, 16, this.aesIV, 0, 32);
        System.arraycopy(data, 48, this.aesIV, 0,  8);

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



