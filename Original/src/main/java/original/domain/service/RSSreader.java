package original.domain.service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import original.domain.model.RssBean;

/**
 *
 * RSS変換サービス
 *
 */
@Service
public class RSSreader {

	//URL先RSSからnewsを取得する
	public ArrayList<RssBean> getNews(String url) throws IllegalArgumentException, FeedException, IOException {
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

}
