package slicing.spring.mvc.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class UploadController {
	@Value("${slow.upload.path}")
	String uploadPath;

	@RequestMapping("/upload")
	public String upload(@RequestParam("slowFile")MultipartFile file, ModelMap modelMap){
		if (file.isEmpty()){
			modelMap.put("error","file empty");
			return "upload";
		}
		try {
			FileUtils.writeByteArrayToFile(new File("c:/Users/Sun Yongjiao/Desktop/" + file.getOriginalFilename()),file.getBytes()
			);
			modelMap.put("file",file.getOriginalFilename());
			return "upload";
		} catch (IOException e) {
			e.printStackTrace();
		}
		modelMap.put("error","upload failed");
		return "upload";
	}

}
