package com.example.androidtest.activity;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.example.androidtest.R;
import com.example.androidtest.util.RSAEncrpyt;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * RSA 加密
 * 
 * @author yangfeng
 *
 */
public class RSAEncryptActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jia_mi);

		String str = "我是齐天大圣";
		Map<String, Object> map;
		try {
			map = RSAEncrpyt.getKeys();
			RSAPrivateKey privateKey = (RSAPrivateKey) map.get("private");
			RSAPublicKey publicKey = (RSAPublicKey) map.get("public");
			
			System.out.println("公钥："+publicKey.toString());
			System.out.println("私钥："+privateKey.toString());

			byte[] encrypt = RSAEncrpyt.encrypt(publicKey, str.getBytes());
			System.out.println("加密后：" + new String(encrypt));
			byte[] decrypt = RSAEncrpyt.decrypt(privateKey, encrypt);
			System.out.println("解密后：" + new String(decrypt));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
