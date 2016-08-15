package original.app.memolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import original.app.Language;
import original.domain.service.MemoService;
import original.domain.service.RegistrationUserDetails;

@Controller
@RequestMapping(value = "/memolist")
public class MemolistController {
	
	@Autowired
	MemoService service;
		
	@RequestMapping("/English")
	public String memolistEn(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("memolist", service.findAll(details.getUser().getUserID(),Language.English.name()));
		return "memolist/memolist";
	}

	@RequestMapping("/French")
	public String memolistFR(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("memolist", service.findAll(details.getUser().getUserID(),Language.French.name()));
		return "memolist/memolist";
	}

	@RequestMapping("/German")
	public String memolistGe(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("memolist", service.findAll(details.getUser().getUserID(),Language.German.name()));
		return "memolist/memolist";
	}
	
	@RequestMapping("/Spanish")
	public String memolist(@AuthenticationPrincipal RegistrationUserDetails details,Model model){
		model.addAttribute("memolistEs", service.findAll(details.getUser().getUserID(),Language.Spanish.name()));
		return "memolist/memolist";
	}
	
	@RequestMapping(value = "/update")
	public String update(@RequestParam("memoID") int memoid, Model model){
		model.addAttribute("memo", service.findOne(memoid));
		return "memolist/update";
	}

	@RequestMapping(value = "/update/complete", method = { RequestMethod.POST })
	public String updateComplete(@RequestParam("memo") String memo,@RequestParam("memoID")int memoID, Model model){
		service.update(memo,memoID);
		model.addAttribute("memo", service.findOne(memoID));
		return "memolist/updatecomplete";
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam("memoID") int memoid, Model model){
		model.addAttribute("memo", service.findOne(memoid));
		return "memolist/delete";
	}

	@RequestMapping(value = "/delete/complete", method = { RequestMethod.POST })
	public String deleteComplete(@RequestParam("memoID") int memoid, Model model){
		model.addAttribute("memo", service.findOne(memoid));
		service.delete(memoid);
		return "memolist/deletecomplete";
	}

}
