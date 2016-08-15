package original.app.registration;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import original.domain.model.User;
import original.domain.service.UserService;


@Controller
@RequestMapping("")
@SessionAttributes(types = { User.class })
public class RegistrationController {
	
	@Autowired
	UserService service;

	@ModelAttribute(value = "user")
	public User setUser(){
		return new User();
	}
	
	@RequestMapping(value = "/Registration")
	public String getRegistory(){		
		return "registration/registory";
	}

	@RequestMapping(value = "/Registration", method= { RequestMethod.POST })
	public String postRegistory(@ModelAttribute("user") User user,Model model){
		model.addAttribute("user", user);
		return "registration/registory";
	}
		
	@RequestMapping(value = "/Registration/confirm", method = { RequestMethod.POST })
	public String confirm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){		
		if( result.hasErrors() || service.isDuplicateEmail(user.getEmail())){
			for(ObjectError error : result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			if(service.isDuplicateEmail(user.getEmail())){
				model.addAttribute("duplicate","このメールアドレスはすでに登録されています");
			}
			return "registration/registory";
		}
		model.addAttribute("user", user);
		return "registration/confirm";
	}

	@RequestMapping(value = "/Registration/result", method = { RequestMethod.POST })
	public String result(SessionStatus session, @ModelAttribute("user") User user, Model model){
		service.create(user);
		model.addAttribute("user", user);
		session.setComplete();
		return "registration/result";
	}


}
