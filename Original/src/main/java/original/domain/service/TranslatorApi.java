package original.domain.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * 
 * Microsoft Translator APIに外国語の単語を渡し訳をもらうサービス
 *
 */
@RestController
public class TranslatorApi {

	@CrossOrigin
	@RequestMapping(value = "/translator", produces = "text/plain;charset=UTF-8")
	public String getAccessToken(@RequestParam String word,@RequestParam String language) throws Exception{
		// Set the Client ID / Client Secret once per JVM. It is set statically and applies to all services
        Translate.setClientId("hishidag");
        Translate.setClientSecret("vualaiJmuIr/+H0LEcHigWX2C1FWjKkMhMhOz/m2HyQ=");
        
        Language from;
        if(language.equals("English")){
        	from = Language.ENGLISH;
        }else if(language.equals("French")){
        	from = Language.FRENCH;
        }else if(language.equals("German")){
        	from = Language.GERMAN;
        }else if(language.equals("Spanish")){
        	from = Language.SPANISH;
        }else{
        	from = Language.ENGLISH;
        }
        
        
        return Translate.execute(word, from, Language.JAPANESE);       
	}
	
}
