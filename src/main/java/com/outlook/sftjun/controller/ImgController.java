package com.outlook.sftjun.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.outlook.sftjun.config.AppString;
import com.outlook.sftjun.config.PropertyPlaceholderConfig;
import com.outlook.sftjun.domain.Img;
import com.outlook.sftjun.service.ImgService;
import com.outlook.sftjun.tools.PicTypes;

@Controller
@RequestMapping(value = "/img")
@Import(PropertyPlaceholderConfig.class)
@SessionAttributes("userId")
public class ImgController extends BaseController {

	private static final Logger log = LoggerFactory.getLogger(ImgController.class);

	@Autowired
	private ImgService imgService;

	@Value("${file.upload.directory}")
	private String fileUploadDirectory;

	@RequestMapping(value = "upload", method = RequestMethod.GET)
	public String upLoad(HttpSession httpSession) {
		log.info("图片上传的Get请求");
		Object sessionObj = httpSession.getAttribute(AppString.SESSION_USER_ID);
		if (sessionObj == null || sessionObj.toString().equals("")) {
			log.info("没有\"userId\"对应的Session");
		} else {
			log.info(httpSession.getAttribute(AppString.SESSION_USER_ID).toString());
		}
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
		Map<String, String[]> parameterMap = request.getParameterMap();
		String location = parameterMap.get("location")[0];
		log.info("地址是:" + location);
		String shortInfo = parameterMap.get("shortInfo")[0];
		log.info("简介是:" + shortInfo);
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
				String trueFileName = UUID.randomUUID().toString() + "." + type;
				// 设置存放图片文件的路径
				path = fileUploadDirectory + trueFileName;
				img.setImgName(trueFileName);
				img.setImgUrl(path);
				img.setContentType(type);
				img.setLocation(location);
				img.setShortInfo(shortInfo);
				img.setUser(null);// TODO
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
				log.info("文件成功上传到" + path);
			} else {
				log.info("不是我们想要的文件类型,请按要求重新上传");
			}
		}
	}
	

	@RequestMapping(value="list",method=RequestMethod.GET)
	public String listImg(){
		return "/imgs/list";
	}
	
	@ResponseBody
	@RequestMapping(value="listjson/{offset}/{length}",produces="application/json;charset=UTF-8") //利用produces参数，设置json响应，为避免返回之后在html中乱码
	public String listImgWithJson(
			@PathVariable(value="offset") int offset,
			@PathVariable(value="length") int length){
		List<Img> imgList = imgService.findImgForPage(offset, length);
		log.info(JSON.toJSONStringWithDateFormat(imgList,AppString.DATE_FORMAT));
		return JSON.toJSONStringWithDateFormat(imgList,AppString.DATE_FORMAT);
	}
	
	@RequestMapping(value="showimg/{imgid}")
	public void showImg(
			@PathVariable(value="imgid") String imgId,
			HttpServletResponse httpServletResponse) throws IOException{
		File file = imgService.findImgById(imgId);
		if(file != null){
			FileInputStream inputStream = new FileInputStream(file);
			byte[] data = new byte[(int) file.length()];
			inputStream.read(data);
			inputStream.close();
			httpServletResponse.setContentType("image/png");
			OutputStream stream = httpServletResponse.getOutputStream();
			stream.write(data);
			stream.flush();
			stream.close();
		}
	}
}
