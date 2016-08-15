package original.app;

import java.util.LinkedHashMap;

/**
 * 言語型
 * 
 */
public enum Language {
	English("英語"),	French("フランス語"),German("ドイツ語"),Spanish("スペイン語") /*,Chinese("中国語")*/;
	public final String languagename;
	
	private Language(String languagename){
		this.languagename = languagename;
	}
		
	public static LinkedHashMap<String,String> getLanguage(){
		LinkedHashMap<String,String> map = new LinkedHashMap<>();
		for(Language lang :Language.values()){
			map.put(lang.name(), lang.languagename);
		}
		return map;
	}
		
}
