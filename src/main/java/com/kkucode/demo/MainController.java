package com.kkucode.demo;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	private User_dailyRepository user_dayRepo;
	
	@GetMapping("/")
	public String HomePage(Model model) {
		return "home";
	}
	
	
	@GetMapping("/register")
		public String registerForm(Model model) {
			model.addAttribute("user_day", new User_daily());
			return "register";
		}
	
	@GetMapping("/login")
    public String showLoginpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }	
	
	@PostMapping("/successful")
	public String successfulRegister(User_daily user_day) {
		user_dayRepo.save(user_day);
		
		return "successful";
	}
	
}
	
