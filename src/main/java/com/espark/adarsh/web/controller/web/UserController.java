package com.espark.adarsh.web.controller.web;

import com.espark.adarsh.annotations.WebMvcController;
import com.espark.adarsh.bean.TaskCreateForm;
import com.espark.adarsh.bean.UserCreateForm;
import com.espark.adarsh.persistence.entites.impl.Task;
import com.espark.adarsh.persistence.entites.impl.User;
import com.espark.adarsh.persistence.entites.impl.UserRole;
import com.espark.adarsh.web.manager.UserManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@WebMvcController
public class UserController {
	Task task = null;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(UserController.class);

	@Autowired(required = true)
	private UserManager userManager;
//****************************User View********************************//
	@RequestMapping("/users")
	public ModelAndView getUsersPage() {
		LOGGER.debug("Getting users page");
		return new ModelAndView("users", "users", userManager.getAllUser());
	}
//********************************Task View****************************//
	@RequestMapping("/tasks")
	public ModelAndView getTasksPage() {
		LOGGER.debug("Getting task page");
		return new ModelAndView("viewTask", "tasks", userManager.getAllTask());
	}

//***********************User Create**********************************//	
	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public ModelAndView getUserCreatePage() {
		LOGGER.debug("Getting user create form");
		return new ModelAndView("createUser", "form", new UserCreateForm());
	}

	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/user/create", method = RequestMethod.POST)
	public String handleUserCreateForm(
			@Valid @ModelAttribute("form") UserCreateForm form,
			BindingResult bindingResult) {
		LOGGER.debug("Processing user create form={}, bindingResult={}", form,
				bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "createUser";
		}
		try {
			final UserRole userRole = this.userManager.getUserRole(form
					.getRoleName());
			form.setRole(userRole);
			this.userManager.saveUser(new User(form));
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn(
					"Exception occurred when trying to save the user, assuming duplicate email",
					e);
			bindingResult.reject("email.exists", "Email already exists");
			return "createUser";
		}
		// ok, redirect
		return "redirect:/users";
	}
//***********************Task Create ***********************************//
	@RequestMapping(value = "/task/create", method = RequestMethod.GET)
	public ModelAndView getTaskCreatePage() {
		LOGGER.debug("Getting task create form");
		System.out.println("Hi**************I am creating task********************");
		return new ModelAndView("createTask", "form", new TaskCreateForm());
	}

	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
	@RequestMapping(value = "/task/create", method = RequestMethod.POST)
	public String handleTaskCreateForm(
			@Valid @ModelAttribute("form") TaskCreateForm form,
			BindingResult bindingResult) {
		LOGGER.debug("Processing task create form={}, bindingResult={}", form,
				bindingResult);
		if (bindingResult.hasErrors()) {
			// failed validation
			return "createTask";
		}
		try {
			final UserRole userRole = this.userManager.getUserRole(form
					.getIssue_name());
			form.setRole(userRole);
			this.userManager.saveTask(new Task(form));
		} catch (DataIntegrityViolationException e) {
			// probably email already exists - very rare case when multiple
			// admins are adding same user
			// at the same time and form validation has passed for more than one
			// of them.
			LOGGER.warn(
					"Exception occurred when trying to save the task, assuming duplicate task id",
					e);
			bindingResult.reject("email.exists", "Email already exists");
			return "createTask";
		}
		// ok, redirect
		return "redirect:/users";
	}
	//***********************Task Edit ***********************************//	
	@RequestMapping(value = "/task/edit", method = RequestMethod.GET)
	public ModelAndView getTaskEditPage() {
		System.out.println("Hi******1********am editing task********************");
		LOGGER.debug("Getting task create form");
		Task a  = userManager.getTaskById(task);
		System.out.println("*****************"+a);
		return new ModelAndView("editTask", "form", userManager.getAllTask());
		//return new ModelAndView("editTask", "form", userManager.updateTask());
	}

	// @PreAuthorize("hasAuthority('ROLE_ADMIN')")
			@RequestMapping(value = "/task/edit", method = RequestMethod.POST)
			public String handleTaskEditForm(
					@Valid @ModelAttribute("formEdit") UserCreateForm form,
					BindingResult bindingResult) {
				LOGGER.debug("Processing task edit form={}, bindingResult={}", form,
						bindingResult);
				System.out.println("Hi*********2*****am editing task********************");
				if (bindingResult.hasErrors()) {
					System.out.println("Hi***************am editing task*****in error block***************");
					// failed validation
					return "editTask";
				}
				try {
					System.out.println("Hi***************am editing task*****in try block***************");
					final UserRole userRole = this.userManager.getUserRole(form.getUserName());
					form.setRole(userRole);
					this.userManager.updateTask(new Task());
					System.out.println("Hi***************am editing task*****in try block****last***********");
					
				} catch (DataIntegrityViolationException e) {
					// probably email already exists - very rare case when multiple
					// admins are adding same user
					// at the same time and form validation has passed for more than one
					// of them.
					LOGGER.warn(
							"Exception occurred when trying to save the user, assuming duplicate email",
							e);
					bindingResult.reject("email.exists", "Email already exists");
					return "editTask";
				}
				// ok, redirect
				return "redirect:/users";
			}
//***********************************************************************************//		
			
}
