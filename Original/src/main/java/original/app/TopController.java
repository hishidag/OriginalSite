package original.app;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;

import original.domain.service.RegistrationUserDetails;


@Controller
@EnableAutoConfiguration
public class TopController {

	@RequestMapping("/")//URI
	public String top(@AuthenticationPrincipal RegistrationUserDetails detail,Model model){
		if(detail != null){model.addAttribute("user", detail.getUser());}
		model.addAttribute("lang", Language.getLanguage());
		return "top";//resourceのpath
	}	

	@RequestMapping("/description")//URI
	public String description(){
		return "description";//resourceのpath
	}	
	
}

