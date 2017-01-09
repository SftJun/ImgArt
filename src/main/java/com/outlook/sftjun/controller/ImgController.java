package com.outlook.sftjun.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.outlook.sftjun.config.PropertyPlaceholderConfig;
import com.outlook.sftjun.domain.Img;
import com.outlook.sftjun.domain.User;
import com.outlook.sftjun.service.ImgService;
import com.outlook.sftjun.tools.PicTypes;

@Controller
@RequestMapping(value = "/img")
@Import(PropertyPlaceholderConfig.class)
@SessionAttributes("user")
public class ImgController extends BaseController {
	
	private static final Logger log = LoggerFactory.getLogger(ImgController.class);

	@Autowired
	private ImgService imgService;

	@Value("${file.upload.directory}")
	private String fileUploadDirectory;

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upLoad() {
		log.info("图片上传的Get请求");
		return "/imgs/upload";
	}

	/**
	 * 
	 * @param files
	 *            这个参数名必须与表单提交的参数名相对应
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "upload", method = RequestMethod.POST)
	public void upload(@RequestParam("files") CommonsMultipartFile[] files, HttpServletRequest request,
			HttpServletResponse response) {
		log.info("图片上传的POST请求");
		//
		Map<String,String[]> parameterMap = request.getParameterMap();
		String location = new StringBuilder(parameterMap.get("location")[0]).toString();
		log.info("地址是:"+location);
		String shortInfo = new StringBuilder(parameterMap.get("shortInfo")[0]).toString();
		log.info("简介是:"+shortInfo);
		//
		for (CommonsMultipartFile file : files) {
			Img img = new Img();
			String path = null;// 文件路径
			String type = null;// 文件类型
			String fileName = file.getOriginalFilename();// 文件原名称
			log.info("上传的文件原名称:" + fileName);
			// 判断文件类型
			type = StringUtils.substringAfterLast(fileName, ".").toUpperCase();
			PicTypes picTypes = new PicTypes();
			if (picTypes.getPIC_TYPES().contains(type)) {
				// 自定义的文件名称
				String trueFileName = UUID.randomUUID().toString() +"."+ type;
				// 设置存放图片文件的路径
				path = fileUploadDirectory + trueFileName;
				img.setImgName(fileName);
				img.setImgUrl(path);
				img.setContentType(type);
				img.setLocation(location);
				img.setShortInfo(shortInfo);
				img.setUser(null);//TODO
				log.info("存放图片文件的路径:" + path);
				try {
					// 转存文件到指定的路径
					file.transferTo(new File(path));
					imgService.save(img);
				} catch (IllegalStateException e) {
					log.error(e.toString());
				} catch (IOException e) {
					log.error(e.toString());
				}
				log.info("文件成功上传到"+path);
			} else {
				log.info("不是我们想要的文件类型,请按要求重新上传");
			}
		}
	}
}
