package original.app.news;

import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.jboss.logging.annotations.Param;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;

import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import original.app.Language;
import original.domain.model.RssBean;

@Controller
@EnableAutoConfiguration
public class NewsController {
	
	@RequestMapping("/newslink")
	public String news(Model model){
		model.addAttribute("lang", Language.getLanguage());
		return "news/newslink";
	}

	//URL先RSSからnewsを取得する関数
	ArrayList<RssBean> getNews(String url) throws IllegalArgumentException, FeedException, IOException {
		ArrayList<RssBean> news = new ArrayList<>(); 		
		URL feedUrl = new URL(url);
		SyndFeedInput input = new SyndFeedInput();
		XmlReader xml = new XmlReader(feedUrl);
		SyndFeed feed = input.build(xml);
		for(Object obj : feed.getEntries()){
			SyndEntry entry = (SyndEntry)obj; 
			news.add(new RssBean(entry.getTitle(),entry.getLink(),entry.getPublishedDate(),entry.getDescription().getValue()));
		}
		return news;
	}
	
	@RequestMapping("/news/English")
	public String EnglishNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=us&ned=us&ie=UTF-8&oe=UTF-8&output=rss&topic=h";				
		model.addAttribute("news", getNews(url));		
		model.addAttribute("toptitle","News");
		return "news/News";
	}
	
	@RequestMapping("/news/French")
	public String FrenchNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=fr&ned=fr&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", getNews(url));
		model.addAttribute("toptitle","nouvelles");
		return "news/News";
	}
	
	@RequestMapping("/news/German")
	public String DeutchNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=de&ned=de&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", getNews(url));
		model.addAttribute("toptitle","Nachrichten");
		return "news/News";
	}

	@RequestMapping("/news/Spanish")
	public String SpanishNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=es&ned=es&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", getNews(url));
		model.addAttribute("toptitle","Noticias");
		return "news/News";
	}
	
	/*
	@RequestMapping("/news/Chinese")
	public String ChineseNews(Model model) throws IllegalArgumentException, FeedException, IOException{
		String url = "https://news.google.com/news?hl=cn&ned=cn&ie=UTF-8&oe=UTF-8&output=rss&topic=h";						
		model.addAttribute("news", getNews(url));
		model.addAttribute("toptitle","新闻");
		return "news/News";
	}
	*/
	
	@RequestMapping(value = "/news/original")
	public String Original(@Param String url ,Model model) throws IllegalArgumentException, FeedException, IOException{
		model.addAttribute("news", getNews(url));
		model.addAttribute("getrss",url);
		return "news/News";
	}

	@ExceptionHandler(MalformedURLException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
	public String MalformedURLExceptionHandler(Model model){
		model.addAttribute("lang", Language.getLanguage());
		model.addAttribute("error", "URLが無効です。rss形式のURLを入力してください。");
		return "news/newslink";
	}
	
}

