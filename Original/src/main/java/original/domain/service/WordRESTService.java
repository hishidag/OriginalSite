package original.domain.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import original.domain.model.Word;

/**
 * 
 * 単語登録用コントローラ。解析ページの結果ページからアクセス
 *
 */
@RestController
@RequestMapping("/Word")
public class WordRESTService {
	
	@Autowired
	WordService service;
	Word word;
	
	@RequestMapping(value = "", method = { RequestMethod.POST })
	public void registWord(@AuthenticationPrincipal RegistrationUserDetails details,@Valid @ModelAttribute Word word){
		service.create(details.getUser().getUserID(),word.getAltword(),word.getTranslation(),word.getLanguage());
	}		
		
}
