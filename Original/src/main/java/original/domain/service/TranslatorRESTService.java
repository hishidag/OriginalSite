package original.domain.service;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

/**
 * 
 * Microsoft Translator(MST)に外国語の単語を渡し訳をもらうRESTサービス
 *
 */
@RestController
public class TranslatorRESTService {

	@CrossOrigin
	@RequestMapping(value = "/translator", produces = "text/plain;charset=UTF-8")
	public String getAccessToken(@RequestParam String word,@RequestParam String language) throws Exception{
		// Set the Client ID / Client Secret once per JVM. It is set statically and applies to all services
        Translate.setClientId("クライアントID");
        Translate.setClientSecret("顧客の秘密");
        
        //MSTのもつEnumクラス
        Language from;
        if(language.equals("English")){
        	from = Language.ENGLISH;
        }else if(language.equals("French")){
        	from = Language.FRENCH;
        }else if(language.equals("German")){
        	from = Language.GERMAN;
        }else if(language.equals("Spanish")){
        	from = Language.SPANISH;
        }else{//予期しない文字列の場合英語で訳す
        	from = Language.ENGLISH;
        }
        
        //wordをfromから日本語に訳す
        return Translate.execute(word, from, Language.JAPANESE);       
	}
	
}
