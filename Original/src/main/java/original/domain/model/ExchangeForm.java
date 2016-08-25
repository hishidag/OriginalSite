package original.domain.model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 *
 * 解析ページのフォーム内容管理
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeForm {
	private String lang;
	private String text;
}


