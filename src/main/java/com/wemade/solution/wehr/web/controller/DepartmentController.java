package com.wemade.solution.wehr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wemade.solution.wehr.web.dto.DepartmentDto;
import com.wemade.solution.wehr.web.service.DepartmentService;

@Controller
@RequestMapping(value="/department")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value="/tree/{companyId}", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public void getTree(Model model,  @PathVariable Long companyId){
		List<DepartmentDto> list = this.departmentService.getRoots(companyId);
		model.addAttribute("model", list);
	}
}
