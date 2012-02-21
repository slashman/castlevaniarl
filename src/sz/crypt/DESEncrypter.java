package sz.crypt;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.KeySpec;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

public class DESEncrypter {
    Cipher ecipher;
    Cipher dcipher;

//  8-byte Salt
    byte[] salt = {
        (byte)0xA9, (byte)0x9B, (byte)0xC8, (byte)0x32,
        (byte)0x56, (byte)0x35, (byte)0xE3, (byte)0x03
    };
    int iterationCount = 19;
    
    public DESEncrypter(String passPhrase) {
    	try {
			KeySpec keySpec = new PBEKeySpec(passPhrase.toCharArray(), salt, iterationCount);
			SecretKey key = SecretKeyFactory.getInstance(
			     "PBEWithMD5AndDES").generateSecret(keySpec);
			             ecipher = Cipher.getInstance(key.getAlgorithm());
			             dcipher = Cipher.getInstance(key.getAlgorithm());
			 
			             // Prepare the parameter to the ciphers
			             AlgorithmParameterSpec paramSpec = new PBEParameterSpec(salt, iterationCount);
			 
			             // Create the ciphers
			ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
			dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
    	} catch (java.security.InvalidAlgorithmParameterException e) {
        } catch (java.security.spec.InvalidKeySpecException e) {
        } catch (javax.crypto.NoSuchPaddingException e) {
        } catch (java.security.NoSuchAlgorithmException e) {
        } catch (java.security.InvalidKeyException e) {
        }
    }

    // Buffer used to transport the bytes from one stream to another
    byte[] buf = new byte[1024];

    public void encrypt(InputStream in, OutputStream out) {
        try {
            // Bytes written to out will be encrypted
            out = new CipherOutputStream(out, ecipher);

            // Read in the cleartext bytes and write to out to encrypt
            int numRead = 0;
            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
            out.close();
        } catch (java.io.IOException e) {
        }
    }

    public void decrypt(InputStream in, OutputStream out) {
        try {
            // Bytes read from in will be decrypted
            in = new CipherInputStream(in, dcipher);

            // Read in the decrypted bytes and write the cleartext to out
            int numRead = 0;
            while ((numRead = in.read(buf)) >= 0) {
                out.write(buf, 0, numRead);
            }
            out.close();
        } catch (java.io.IOException e) {
        }
    }
    
    public InputStream decrypt(InputStream in) {
        // Bytes read from in will be decrypted
        in = new CipherInputStream(in, dcipher);
        return in;
    }
}