package com.sandesh.internship.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sandesh.internship.models.Course;
import com.sandesh.internship.models.Student;
import com.sandesh.internship.services.CourseService;
import com.sandesh.internship.services.EnrollService;
import com.sandesh.internship.services.InstallmentService;

/**
 * This controller class has mapping for all course specific Urls.
 * The request beginning with the url pattern /course is handled. 
 * @author Sandesh
 *
 */

@Controller
@RequestMapping(value="/course")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	@Autowired
	private InstallmentService installmentService;
	
	@Autowired
	private EnrollService enrollService;
	
	/**
	 * This method presents the form to add the course.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String displayAddCourse(ModelMap model) {
		model.addAttribute("course", new Course());
		model.addAttribute("action", "addcourse");
		return "index";
	}
	
	/**
	 * Presents form to add the enrollment record.
	 * Path variable is sent in the request which represents student id.
	 * @param id	This represents extracted id from the path variable.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="enroll/add/{id}", method=RequestMethod.GET)
	public String displayAddCourseEnroll(@PathVariable int id, ModelMap model) {
		model.addAttribute("id", id);
		model.addAttribute("action", "addcourseenroll");
		return "index";
	}
	
	/**
	 * This method adds the enrollment information for the student in enroll table.
	 * @param applicablePrice Represents applicable price for the course.
	 * @param id	Student id to be inserted in the enroll table.
	 * @param course 	Course id to be inserted in the enroll table.
	 * @param installmentPrice	Installment payed by student at the beginning.
	 * @param model
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping(value="enroll/add", method=RequestMethod.POST)
	public String addCourseEnroll(@RequestParam long applicablePrice, @RequestParam int id,
			@RequestParam int course,@RequestParam long installmentPrice, ModelMap model,
			RedirectAttributes redirectAttrs) {
		enrollService.jdbcInsertEnroll(id, course, applicablePrice);
		if(installmentPrice > 0) {
			Student student = new Student();
			student.setId(id);
			student.getCourse().setId(course);
			student.setInstallmentAmount(installmentPrice);
			installmentService.jdbcInsertInstallment(student);
		}
		redirectAttrs.addAttribute("add_enroll", "success");
		return "redirect:/student/list";
	}
	
	/**
	 * This is the method which handles the post record for the course model.
	 * @param course	Represents the course object to be inserted in the database.
	 * @param redirectAttrs
	 * @return
	 */
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addCourse(@Valid @ModelAttribute Course course, RedirectAttributes redirectAttrs) {
		courseService.jdbcInsertCourse(course);
		redirectAttrs.addAttribute("add", "success");
		return "redirect:/course/list";
	}
	
	/**
	 * This method returns the list of courses.
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listCourses(ModelMap model) {
		model.addAttribute("action", "listcourse");
		model.addAttribute("courses", courseService.jdbcGetAll());
		return "index";
	}
	
	/**
	 * This method returns the course update form. 
	 * @param model
	 * @param id Represents course id for which the update form is to be displayed.
	 * @return Index page.
	 */
	@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String displayUpdateCourse(ModelMap model, @PathVariable int id) {
		model.addAttribute("action", "updatecourse");
		model.addAttribute("course", courseService.jdbcGet(id));
		return "index";
	}
	
	/**
	 * This method updates the database analyzing the post record.
	 * @param model
	 * @param course This represents the course to be updated .
	 * @param redirectAttrs
	 * @return Redirection url.
	 */
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String updateCourse(ModelMap model, @ModelAttribute Course course, RedirectAttributes redirectAttrs) {
		model.addAttribute("action", "listcourse");
		boolean status = courseService.jdbcUpdateCourse(course);
		if (status) redirectAttrs.addAttribute("update", "success");
		else redirectAttrs.addAttribute("update", "fail");
		return "redirect:/course/list";
	}
	
	/**
	 * This method controls the request to remove the course from the database.
	 * @param model
	 * @param id	This represents the course id to be removed.
	 * @param redirectAttrs
	 * @return	Redirection url
	 * @deprecated The course removal functionality hinders the design principle.
	 */
	@RequestMapping(value="/remove/{id}", method=RequestMethod.GET)
	public String remove(ModelMap model, @PathVariable int id, RedirectAttributes redirectAttrs) {
		boolean status = courseService.jdbcRemoveCourse(id);
		model.addAttribute("action", "listcourse");
		if (status) redirectAttrs.addAttribute("remove", "success");
		else redirectAttrs.addAttribute("remove", "fail");
		return "redirect:/course/list";
	}
	
	

}
