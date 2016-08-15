package original.domain.model;

import java.util.Date;
import lombok.Data;
import lombok.AllArgsConstructor;

/**
 * 
 * RSSを展開するためのモデル
 *
 */
@Data
@AllArgsConstructor
public class RssBean {
	private String title;
	private String link;
	private Date date;
	private String comment;
}
