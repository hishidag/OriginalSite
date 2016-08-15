package original.app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import original.domain.service.UserService;
import original.domain.model.User;

@Controller
@RequestMapping("/loginForm")
@SessionAttributes(names = "regist")
public class LoginControrller {
	
	@Autowired
	UserService service;
	User user;
	
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public String getLogin(){
		return "login";
	}
		
}
