package original.app.memolist;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import original.domain.service.MemoService;
import original.domain.service.RegistrationUserDetails;

/**
 * 
 * メモ登録用コントローラ
 *
 */
@RestController
public class MemoController {
	@Autowired
	MemoService service;
	
	@RequestMapping(value = "/Memo", method = { RequestMethod.POST })
	public void memorize(@AuthenticationPrincipal RegistrationUserDetails details,@RequestParam String memo,@RequestParam String language){
		service.insert(details.getUser().getUserID(),memo,language);
	}
		
	
	
}
