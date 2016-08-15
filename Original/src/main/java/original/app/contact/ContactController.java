package original.app.contact;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import original.domain.model.ContactForm;
import original.domain.service.RegistrationUserDetails;
import original.domain.service.SendMail;


@Controller
@RequestMapping("/contact")
@SessionAttributes(types = { ContactForm.class })
public class ContactController {
	
	@Autowired
	SendMail sendMail;
	
	@ModelAttribute(value = "contact")
	public ContactForm setForm(){
		return new ContactForm();
	}
	
	@RequestMapping(value = "")
	public String getContact(@AuthenticationPrincipal RegistrationUserDetails details ,@ModelAttribute("contact") ContactForm contact,Model model){
		if(details != null){ contact.setName(details.getUser().getName());}
		model.addAttribute("contact", contact);
		return "contact/contact";
	}
	
	@RequestMapping(value = "/confirm", method = { RequestMethod.POST })
	public String contactConfirm(@Valid @ModelAttribute("contact") ContactForm contact,Model model){
		model.addAttribute("contact", contact);
		return "contact/confirm";
	}

	@RequestMapping(value = "/result", method = { RequestMethod.POST })
	public String contactResult(SessionStatus session, @ModelAttribute("contact") ContactForm contact,Model model) throws MessagingException{
		model.addAttribute("contact", contact);
		sendMail.sendMail(contact.getName(),contact.getSubject(), contact.getText());
		session.setComplete();
		return "contact/result";
	}
}
