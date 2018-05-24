package com.sandesh.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sandesh.internship.services.InstallmentService;

/**
 * This controller class has mapping for all installment specific Urls.
 * The request beginning with the url pattern /installment is handled. 
 * @author Sandesh
 *
 */

@Controller
@RequestMapping("/installment")
public class InstallmentController {
	
	@Autowired
	private InstallmentService installmentService;

	/**
	 * This method handles the listing of installment information.
	 * @param model
	 * @return	Name of the jsp page to be rendered.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String displayInstallment(ModelMap model) {
		model.addAttribute("action", "listinstallment");
		model.addAttribute("installments", installmentService.jdbcListAll());
		return "index";
	}
	
	/**
	 * 
	 * @param sid	Represents the student id.
	 * @param cid	Represents the course id.	
	 * @param installmentAmount		Represents the installment amount to be added
	 * @param redirectAttrs		
	 * @return	Redirection url.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public String postAddInstallment(@RequestParam int sid, @RequestParam int cid, 
			@RequestParam long installmentAmount, RedirectAttributes redirectAttrs) {
		
		installmentService.jdbcInsertInstallment(sid, cid, installmentAmount);
		redirectAttrs.addAttribute("add", "success");
		return "redirect:/installment";
	}
}
