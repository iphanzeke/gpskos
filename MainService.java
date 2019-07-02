package com.ivansoft.api;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jpos.iso.ISOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ivansoft.iso.ServiceISO;
import com.ivansoft.model.RespService;

@Controller
@RequestMapping("/esta")
public class MainService {
	
	@RequestMapping(value = "/kirim", method = RequestMethod.POST)
	@ResponseBody
	public String postISO(@RequestBody String string, HttpServletRequest request, HttpSession httpSession) throws ISOException {
		ServiceISO si = new ServiceISO();	
		return si.prepareMsg(string);
	}
	
	
	

}
