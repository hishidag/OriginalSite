package original.app.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * トップ > ログイン 
 * 
 */
@Controller
@RequestMapping("/loginForm")
public class LoginControrller {
	
	@RequestMapping(value = "", method = { RequestMethod.GET })
	public String getLogin(){
		return "login";
	}
		
}
