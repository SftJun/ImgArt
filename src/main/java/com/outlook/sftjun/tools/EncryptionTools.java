package com.outlook.sftjun.tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

/**
 * 加密工具类
 * 
 * @author YinJun
 *
 */
public class EncryptionTools {
	/* 构造一个自身类的对象 */
	private static final EncryptionTools encryptionTools = new EncryptionTools();

	/**
	 * 构造函数私有化，不对外提供
	 */
	private EncryptionTools() {
	}

	/**
	 * 得到EncryptionTools类的实例
	 * 
	 * @return
	 */
	public static EncryptionTools getInstance() {
		return encryptionTools;
	}

	/**
	 * 对字符进行MD5加密
	 * 
	 * @param oldStr
	 * @return 返回加密后的密文
	 */
	public static String MD5(String oldStr) {
		// 把要加密的字符串转换成字节数组
		byte[] oldBytes = oldStr.getBytes();
		// 得到MessageDigest对象
		MessageDigest md;
		try {
			// 得到MD5加密算法的MessageDigest对象
			md = MessageDigest.getInstance("MD5");
			// 调用digest方法对其进行加密
			byte[] newBytes = md.digest(oldBytes);
			BASE64Encoder encoder = new BASE64Encoder();
			// 利用Based64算法，将字节数组转换成等长字符串
			String newStr = encoder.encode(newBytes);
			return newStr;
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}
}
