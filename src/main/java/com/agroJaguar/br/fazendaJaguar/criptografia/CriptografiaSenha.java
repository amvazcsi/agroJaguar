package com.agroJaguar.br.fazendaJaguar.criptografia;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CriptografiaSenha {

	public String criptografar(String senha) {    
		MessageDigest algorithm;	
		byte[] md5hash = new byte[32];    

		try {

			algorithm = MessageDigest.getInstance("MD5");
			algorithm.reset();
			algorithm.update(senha.getBytes("iso-8859-1"), 0, senha.length());	    
			md5hash = algorithm.digest();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return convertToHex(md5hash);
	}

	private static String convertToHex(byte[] data) { 
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < data.length; i++) { 
			int halfbyte = (data[i] >>> 4) & 0x0F;
			int two_halfs = 0;
			do { 
				if ((0 <= halfbyte) && (halfbyte <= 9)) 
					buf.append((char) ('0' + halfbyte));
				else 
					buf.append((char) ('a' + (halfbyte - 10)));
				halfbyte = data[i] & 0x0F;
			} while(two_halfs++ < 1);
		} 
		return buf.toString();
	} 
}
