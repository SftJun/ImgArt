package com.outlook.sftjun.tools;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class U8JsonDecoder {
	/**
	 * Decoder utf-8 json
	 * @param u8JsonStr
	 * @return
	 */
	public String decoderU8Json(String u8JsonStr){
		try {
			return URLDecoder.decode(u8JsonStr, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
}