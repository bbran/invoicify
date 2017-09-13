package com.libertymutual.goforcode.invoicify.controllers;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.libertymutual.goforcode.invoicify.models.User;
import com.libertymutual.goforcode.invoicify.repositories.UserRepository;

@Controller
@RequestMapping("/")
public class HomeController {
	private UserRepository userRepo;
	private PasswordEncoder encoder;
	
	public HomeController(UserRepository userRepo, PasswordEncoder encoder)	{
		this.userRepo = userRepo;
		this.encoder = encoder;
	}
	
	@GetMapping("")
	public String home()	{
		return "home/default";
	}
	
	@GetMapping("signup")
	public ModelAndView signup()	{
		ModelAndView modelAndView = new ModelAndView("home/signup");
		return modelAndView;
	}
	
	@PostMapping("signup")
	public ModelAndView addUser(User user)	{
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO THIS IS REALLY DUMB, CHANGE IT
		String password = user.getPassword();
		String encryptedPassword = encoder.encode(password);
		user.setPassword(encryptedPassword);
		
		try	{
			userRepo.save(user);
			modelAndView.setViewName("redirect:/login");
		} catch(DataIntegrityViolationException e)	{
			modelAndView.setViewName("home/signup");
			modelAndView.addObject("errorMessage", "Choose a different username");
		}
		
		return modelAndView;
	}
	
}
