package original.app.wordlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import original.app.Language;
import original.domain.service.RegistrationUserDetails;
import original.domain.service.WordService;

/**
 *
 * トップ > 単語
 *
 */
@Controller
@RequestMapping("/wordlist")
public class WordlistController {
	
	@Autowired
	WordService service;
	
	//　> 英語
	@RequestMapping("/English")
	public String wordlistEn(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("wordlist", service.findAll(details.getUser().getUserID(),Language.English.name()));
		return "wordlist/wordlist";
	}

	// > フランス語
	@RequestMapping("/French")
	public String wordlistFr(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("wordlist", service.findAll(details.getUser().getUserID(),Language.French.name()));
		return "wordlist/wordlist";
	}

	// > ドイツ語
	@RequestMapping("/German")
	public String wordlistGe(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("wordlist", service.findAll(details.getUser().getUserID(),Language.German.name()));
		return "wordlist/wordlist";
	}

	// > スペイン語
	@RequestMapping("/Spanish")
	public String wordlistEs(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("wordlist", service.findAll(details.getUser().getUserID(),Language.Spanish.name()));
		return "wordlist/wordlist";
	}

	// > 更新
	@RequestMapping(value = "/update")
	public String update(@RequestParam("wordID") int wordid, Model model){
		model.addAttribute("word", service.findOne(wordid));
		return "wordlist/update";
	}

	// > 更新完了
	@RequestMapping(value = "/update/complete", method = { RequestMethod.POST })
	public String updateComplete(@RequestParam("word") String word,@RequestParam("translation")String translation, @RequestParam("wordID")int wordID, Model model){
		service.update(wordID,word,translation);
		model.addAttribute("word", service.findOne(wordID));
		return "wordlist/updatecomplete";
	}

	// > 削除
	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("wordID") int wordid, Model model){
		model.addAttribute("word", service.findOne(wordid));
		return "wordlist/delete";
	}

	// > 削除完了
	@RequestMapping(value = "/delete/complete", method = { RequestMethod.POST })
	public String deleteComplete(@RequestParam("wordID") int wordid, Model model){
		model.addAttribute("word", service.findOne(wordid));
		service.delete(wordid);
		return "wordlist/deletecomplete";
	}

}
