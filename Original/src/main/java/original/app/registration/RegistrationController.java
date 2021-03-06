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


/**
 *
 * トップ > ログイン > 新規登録
 *
 */
@Controller
@RequestMapping("/Registration")
@SessionAttributes(types = { User.class })
public class RegistrationController {
	
	@Autowired
	UserService service;

	@ModelAttribute(value = "user")
	public User setUser(){
		return new User();
	}

	// > 新規登録
	@RequestMapping("")
	public String getRegistory(){		
		return "registration/registory";
	}

	// 新規登録 < 確認画面
	@RequestMapping(value = "", method= { RequestMethod.POST })
	public String postRegistory(@ModelAttribute("user") User user,Model model){
		model.addAttribute("user", user);
		return "registration/registory";
	}
		
	// > 確認画面
	@RequestMapping(value = "/confirm", method = { RequestMethod.POST })
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

	// > 登録完了
	@RequestMapping(value = "/result", method = { RequestMethod.POST })
	public String result(SessionStatus session, @ModelAttribute("user") User user, Model model){
		service.create(user);
		model.addAttribute("user", user);
		//SessionStatusと@ModelAttributeを引数に置くことでそのセッションを破棄できる
		session.setComplete();
		return "registration/result";
	}


}
