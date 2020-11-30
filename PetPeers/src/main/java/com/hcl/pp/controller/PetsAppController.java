package com.hcl.pp.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.hcl.pp.model.Pet;
import com.hcl.pp.model.User;
import com.hcl.pp.service.PetService;
import com.hcl.pp.service.SecurityService;
import com.hcl.pp.service.UserService;

@Controller
public class PetsAppController {
	@Autowired
	private UserService userService;
	@Autowired
	private SecurityService securityService;
	@Autowired
	private PetService petService;

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String homePage(Model model) {
		return "redirect:home";
	}

	@RequestMapping(value = { "/home" }, method = RequestMethod.GET)
	public String homePage1(Model model) {
		String message= (String)model.asMap().get("Message");
		model.addAttribute("Message", message);
		return "home";
	}

	@RequestMapping(value = { "/signup" }, method = RequestMethod.GET)
	public String userRegistration(Model model) {
		return "user_registration";
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String logIn(Model model) {
		String message= (String)model.asMap().get("Message");
		model.addAttribute("Message", message);
		return "login";
	}

	@RequestMapping(value = { "/insert" }, method = RequestMethod.POST)
	public String insert(@ModelAttribute User user, Model model,RedirectAttributes redirectAttributes) {

		Long userId = userService.getIdByUserEmail(user.getUserEmail());
		if (userId == 0) {
			userService.addUser(user);
			redirectAttributes.addFlashAttribute("Message", "Account Created Successfully Please login to continue");
			return "redirect:login";
		} else {
			model.addAttribute("errorMessage", "UserEmail already Exists Please login to continue");
			return "user_registration";
		}
	}

	@RequestMapping(value = { "/pet_home" }, method = RequestMethod.GET)
	public String petHome(HttpSession httpSession, Model model) {

		List<Pet> list = petService.getAllPets();

		Long userId = (Long) httpSession.getAttribute("userId");
		model.addAttribute("list1", list);
		model.addAttribute("userId", userId);
		return "pet_home";
	}

	@RequestMapping(value = { "/my_pets" }, method = RequestMethod.GET)
	public String myPets(Model model, HttpSession httpSession) {
		/* Long userId = (Long) httpSession.getAttribute("userId"); */
		List<Pet> myPets = petService.getAllPets();
		if (myPets.size() > 0 && !myPets.isEmpty()) {
			model.addAttribute("myPets", myPets);
		} else {
			model.addAttribute("message", "No Pets Are owned by You");
		}
		return "my_pets";
	}

	@RequestMapping(value = { "/add_pet" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "pet_form";
	}

	@RequestMapping(value = { "/signin" }, method = RequestMethod.POST)
	public String signIn(@RequestParam String userEmail, @RequestParam String userPassword, Model model,
			HttpSession httpSession, HttpServletRequest httpServletRequest) {

		boolean isMatch = securityService.authenticateUse(userEmail, userPassword);
		Long userId = 0L;
		if (isMatch) {
			httpSession = httpServletRequest.getSession();

			userId = userService.getIdByUserEmail(userEmail);
			httpSession.setAttribute("userId", userId);

			return "redirect:pet_home";
		} else {
			model.addAttribute("errorMessage", "Username and Password are Incorrect");
			return "login";
		}

	}

	@RequestMapping(value = { "/buy" }, method = RequestMethod.POST)
	public String buyPet(@RequestParam("petId") Long petId, @RequestParam("userId") Long userId) {

		int status = petService.setOwnerId(petId, userId);
		if (status > 0) {
			return "redirect:my_pets";
		} else {
			return "pet_home";
		}

	}

	@RequestMapping(value = "/addpet", method = RequestMethod.POST)
	public String addPet(@ModelAttribute Pet pet, Model model) {
		petService.savePet(pet);
		model.addAttribute("message", "Added Pet Succesfully");
		return "pet_form";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logOut(HttpSession httpSession, Model model,RedirectAttributes redirectAttributes) {
		
		httpSession.invalidate();
		redirectAttributes.addFlashAttribute("Message","logged  out successfully");
		
		return "redirect:home";
	}
}
