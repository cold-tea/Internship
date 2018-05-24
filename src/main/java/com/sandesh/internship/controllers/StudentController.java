package com.sandesh.internship.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sandesh.internship.models.Student;
import com.sandesh.internship.services.EnrollService;
import com.sandesh.internship.services.StudentService;

/**
 * This controller class has mapping for all student specific Urls.
 * The request beginning with the url pattern /student is handled. 
 * @author Sandesh
 *
 */

@Controller
@RequestMapping(value="/student")
@SessionAttributes(names="studentModel")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EnrollService enrollService;
	
	/**
	 * It displays the form through which the student detail is provided.
	 * @param student	ModelAttribute for the form.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String getAddStudent(@ModelAttribute Student student, ModelMap model) {
		model.addAttribute("action", "addstudent");
		return "index";
	}
	
	/**
	 * This method persists the posted student record.
	 * @param student	This is the student object to be added in the database.
	 * @param result
	 * @param modelSave
	 * @param redirectAtts
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String postAddStudent(@Valid @ModelAttribute Student student, BindingResult result, 
			ModelMap modelSave, RedirectAttributes redirectAtts) {
		
		if(result.hasErrors()) {
			List<FieldError> fieldErrors= result.getFieldErrors();
			for(FieldError error : fieldErrors) {
				System.out.println(error.getObjectName() + ": " + error.getDefaultMessage());
			}
			modelSave.addAttribute("action", "addstudent");
			modelSave.addAttribute("add", "fail");
			return "index";
		}
	    studentService.jdbcInsertStudent(student);
	    redirectAtts.addAttribute("add", "success");
		return "redirect:/student/list";
	}
	
	/**
	 * This method list all the student from the database.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listStudents(ModelMap model) {
		model.addAttribute("action", "liststudent");
		model.addAttribute("students", studentService.jdbcGetAll());
		return "index";
	}
	
	/**
	 * This method displays the view which provide details about the student.
	 * Path variable id refers to student id.
	 * @param id	Represents the student id for which the details is to be displayed.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/view/{id}", method=RequestMethod.GET)
	public String viewStudent(@PathVariable int id, ModelMap model) {
		model.addAttribute("action", "viewstudent");
		model.addAttribute("student", studentService.jdbcGetById(id));
		return "index";
	}
	
	/**
	 * This method renders the form to update the student.
	 * Path variable representing the student id is passed.
	 * @param student	Student object converted from the student PV with the help of converters.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/update/{student}", method=RequestMethod.GET)
	public String getUpdateStudent(@PathVariable @ModelAttribute Student student, ModelMap model) {
		model.addAttribute("action", "updatestudent");
		return "index";
	}
	
	/**
	 * This method updates the student record from the database consulting the service.
	 * @param model
	 * @param student Represents the student object to be updated
	 * @param result
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String postUpdateStudent(ModelMap model,@Valid @ModelAttribute Student student, 
			BindingResult result, RedirectAttributes redirectAttrs) {
		if(result.hasErrors()) {
			List<FieldError> fieldErrors= result.getFieldErrors();
			for(FieldError error : fieldErrors) {
				System.out.println(error.getObjectName() + ": " + error.getDefaultMessage());
			}
			model.addAttribute("action", "updatestudent");
			model.addAttribute("update", "fail");
			return "index";
		}
		
		boolean status = studentService.jdbcUpdateStudent(student);
		if (status) redirectAttrs.addAttribute("update", "success");
		else redirectAttrs.addAttribute("update", "fail");
		return "redirect:/student/list";
	}

	/**
	 * This method controls the request to remove the student from the database.
	 * @param id	This represents the student id to be removed.
	 * @param model
	 * @param redirectAttrs
	 * @return Redirection url
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/remove/{id}")
	public String removeStudent(@PathVariable int id, ModelMap model, RedirectAttributes redirectAttrs) {
		boolean isRemoved = enrollService.jdbcRemoveEnrollByStudentId(id);
		if (isRemoved) {
			boolean status = studentService.jdbcRemoveStudent(studentService.jdbcGetById(id));
			if (status) redirectAttrs.addAttribute("remove", "success");
			else redirectAttrs.addAttribute("remove", "fail");
			return "redirect:/student/list";
		} else {
			redirectAttrs.addAttribute("remove", "fail");
			return "redirect:/student/list";
		}
	}

}

