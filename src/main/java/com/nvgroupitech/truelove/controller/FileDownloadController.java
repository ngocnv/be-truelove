package com.nvgroupitech.truelove.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nvgroupitech.truelove.enums.ErrorMessages;
import com.nvgroupitech.truelove.exceptions.ApiRuntimeException;
import com.nvgroupitech.truelove.service.FileService;

@RestController
@RequestMapping("/v1.0")
public class FileDownloadController {

	@Autowired
	private FileService fileService;

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public void getFile(@RequestParam(name = "fileUri",required = true) String fileUri, HttpServletResponse response) throws Exception {

		if (StringUtils.isBlank(fileUri)) {
			throw new ApiRuntimeException(ErrorMessages.E0004.getErrorDefaultMsgCd(), ErrorMessages.E0003,
					LocaleContextHolder.getLocale());
		} else {
			String getType = null;
			if (StringUtils.isBlank(getType) || !"inline".equals(getType) && !"attachment".equals(getType)) {
				getType = "inline";
			}

			String filename = URLEncoder.encode(fileUri, "UTF-8").replaceAll("\\+", " ");
			response.setHeader("content-disposition",
					getType + ";filename=" + filename.substring(filename.lastIndexOf("\\") + 3));
			InputStream in = null;
			Map<String, Object> map = fileService.downloadFile(fileUri);
			if (!(Boolean) map.get("result")) {
				throw new ApiRuntimeException(ErrorMessages.E0005.getErrorDefaultMsgCd(), ErrorMessages.E0005,
						LocaleContextHolder.getLocale());
			} else {
				in = (InputStream) map.get("resultIS");
				OutputStream out = response.getOutputStream();
				byte[] buffer = new byte[1024];
				boolean var10 = false;

				int len;
				while ((len = in.read(buffer)) > 0) {
					out.write(buffer, 0, len);
				}
				in.close();
				out.close();
			}
		}
	}
}
