package com.springapp.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}
	@RequestMapping(value = "/docs", method = RequestMethod.GET)
	public String printDocs(ModelMap modelMap){
		return "docs";
	}

	@RequestMapping(value = "/getDocList", method = RequestMethod.GET)
	public String getFileList(ModelMap modul, @RequestParam(value = "tabul", defaultValue = "0") int tabul){

		ArrayList<Docs> list = Direct.listFile(tabul);

		String[][] listt = new String[list.size()][3];

		for(int i = 0; i < list.size(); i++){
			listt[i][0] = list.get(i).getName();
			listt[i][1] = String.valueOf(list.get(i).getLink());
			listt[i][2] = list.get(i).getFormat();
		}

		modul.addAttribute("list", listt);
		return "docs";
	}
}