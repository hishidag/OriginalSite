package original.app.exchange;

import org.springframework.ui.Model;

import java.io.IOException;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import original.app.Language;
import original.domain.model.ExchangeForm;
import original.domain.service.Exchange;
import original.domain.service.RegistrationUserDetails;

@Controller
@EnableAutoConfiguration
@SessionAttributes(types = { ExchangeForm.class })
public class ExchangeController {
	
	@ModelAttribute(value = "exchangeForm")
	public ExchangeForm getExchangeform(){
		return new ExchangeForm();
	}
	
	@RequestMapping("/input")
	public String exchange(@ModelAttribute("exchangeForm") ExchangeForm ef,Model model){
		if(ef != null){ 
			model.addAttribute("input",ef);
		}
		model.addAttribute("lang",Language.getLanguage());		
		return "exchange/input";
	}
	
	@RequestMapping(value = "/result",method = { RequestMethod.POST })
	public String resultPost(@AuthenticationPrincipal RegistrationUserDetails details,@ModelAttribute("exchangeForm") ExchangeForm ef, Model model) 
			throws IOException{
		model.addAttribute(ef);
		if(details != null){ 
			model.addAttribute("isLogin", "true");		
		}
		model.addAttribute("exchange",Language.valueOf(ef.getLang()).languagename);
		model.addAttribute("language", ef.getLang());
		model.addAttribute("result", (new Exchange()).exchange(ef.getText(),ef.getLang()));
		return "exchange/result";
	}
	
}
