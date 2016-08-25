package original.app.news;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jboss.logging.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;

import com.rometools.rome.io.FeedException;

import original.app.Language;
import original.domain.service.RSSreader;


/**
 *
 * トップ > ニュースリンク
 *
 */
@Controller
@RequestMapping("/news")
@EnableAutoConfiguration
public class NewsController {
	
	@Autowired
	RSSreader rss;
	
	// > ニュースリンク
	@RequestMapping("")
	public String news(Model model){
		model.addAttribute("lang", Language.getLanguage());
		return "news/newslink";
	}

	// > 英語
	@RequestMapping("/English")
	public String EnglishNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		final String url = "https://news.google.com/news?hl=us&ned=us&ie=UTF-8&oe=UTF-8&output=rss&topic=h";				
		model.addAttribute("news", rss.getNews(url));		
		model.addAttribute("toptitle","News");
		return "news/News";
	}
	
	// > フランス語
	@RequestMapping("/French")
	public String FrenchNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		final String url = "https://news.google.com/news?hl=fr&ned=fr&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", rss.getNews(url));
		model.addAttribute("toptitle","nouvelles");
		return "news/News";
	}
	
	// > ドイツ語
	@RequestMapping("/German")
	public String DeutchNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		final String url = "https://news.google.com/news?hl=de&ned=de&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", rss.getNews(url));
		model.addAttribute("toptitle","Nachrichten");
		return "news/News";
	}

	// > スペイン語
	@RequestMapping("/Spanish")
	public String SpanishNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		final String url = "https://news.google.com/news?hl=es&ned=es&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", rss.getNews(url));
		model.addAttribute("toptitle","Noticias");
		return "news/News";
	}
	
	/* 中国語　いつか実装予定
	@RequestMapping("/Chinese")
	public String ChineseNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=cn&ned=cn&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", rss.getNews(url));
		model.addAttribute("toptitle","新闻");
		return "news/News";
	}
	*/
	
	//ユーザの指定したRSSを取得、表示
	@RequestMapping("/original")
	public String Original(@Param String url ,Model model) throws IllegalArgumentException, FeedException, IOException{
		model.addAttribute("news", rss.getNews(url));
		model.addAttribute("getrss",url);
		return "news/News";
	}

	//ユーザが指定したRSSが無効の場合のエラーハンドリング
	@ExceptionHandler(MalformedURLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public String MalformedURLExceptionHandler(Model model){
		model.addAttribute("lang", Language.getLanguage());
		model.addAttribute("error", "URLが無効です。rss形式のURLを入力してください。");
		return "news/newslink";
	}
	
}

