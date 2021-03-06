package original.app.mypage;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import original.domain.model.User;
import original.domain.service.RegistrationUserDetails;
import original.domain.service.UserService;

/**
 * 
 * トップ > 登録内容確認
 *
 */
@Controller
@RequestMapping("/mypage")
@SessionAttributes(types = { User.class })
public class MypageController {
		
	@Autowired
	UserService service;
	
	@ModelAttribute(value = "user")
	public User setUser(){
		return new User();
	}
	
	// > ユーザ情報
	@RequestMapping("")
	public String mypage(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("user", details.getUser());
		return "mypage/mypage";
	}
	
	// > 更新
	@RequestMapping(value = "/update",method = { RequestMethod.POST })
	public String update(@ModelAttribute("user") User user,Model model){
		model.addAttribute("user", user);
		return "mypage/update";
	}
	
	// > 更新確認
	@RequestMapping(value = "/update/confirm",method = { RequestMethod.POST })
	public String updateConfirm(@Valid @ModelAttribute User user, BindingResult result,Model model){
		if( result.hasErrors() || service.isDuplicateEmailandUserid(user.getUserID(), user.getEmail())){
			for(ObjectError error : result.getAllErrors()){
				System.out.println(error.getDefaultMessage());
			}
			if(service.isDuplicateEmail(user.getEmail())){
				model.addAttribute("duplicate","このメールアドレスはすでに登録されています");
			}
			return "mypage/update";
		}model.addAttribute(user);
		model.addAttribute("user", user);
		return "mypage/updateconfirm";
	}

	// > 更新完了
	@RequestMapping(value = "/update/complete",method = { RequestMethod.POST })
	public String updateResult(@ModelAttribute("user") User user,Model model){
		model.addAttribute("user", user);
		service.update(user);
		return "mypage/updateresult";
	}
	
	// > 削除
	@RequestMapping(value = "/delete", method = { RequestMethod.POST })
	public String delete(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("user", details.getUser());
		return "mypage/delete";
	}
	
	// > 削除完了
	@RequestMapping(value = "/delete/complete", method={ RequestMethod.POST })
	public String deleteResult(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("user", details.getUser());
		service.delete(details.getUser().getUserID());
		return "mypage/deleteresult";
	}
	
}
