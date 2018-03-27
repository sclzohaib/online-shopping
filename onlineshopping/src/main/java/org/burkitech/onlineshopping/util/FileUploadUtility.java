package org.burkitech.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.tagext.TryCatchFinally;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {
	private static final String ABS_PATH = "E:\\Projects\\spring\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	private static final Logger logger = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String code) {
		// to get real path
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		logger.info(REAL_PATH);
		// to make sure all the directories exits
		if (!new File(ABS_PATH).exists()) {
			new File(ABS_PATH).mkdirs();
		}

		// to make sure all the directories exits
				if (!new File(REAL_PATH).exists()) {
					new File(REAL_PATH).mkdirs();
				}
try {
	//for server upload
	file.transferTo(new File(REAL_PATH+code+".jpg"));
	//for upload in project directory
	file.transferTo(new File(ABS_PATH+code+".jpg"));
} catch (IOException ex) {
	
}
		
	}
}
