package com.outlook.sftjun.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置可以上传的图像类型
 * @author yinjun
 *
 */
public class PicTypes {
	private List<String> PIC_TYPES = new ArrayList<String>();
	
	public PicTypes(){
		PIC_TYPES.add("BMP");
		PIC_TYPES.add("GIF");
		PIC_TYPES.add("JPEG");
		PIC_TYPES.add("PNG");
		PIC_TYPES.add("SWF");
		PIC_TYPES.add("SVG");
		PIC_TYPES.add("JPG");
	}
	/**
	 * 返回可以上传的图片类型集合
	 * @return
	 */
	public List<String> getPIC_TYPES() {
		return PIC_TYPES;
	}
}
