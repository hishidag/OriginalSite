package original.domain.model;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 *
 * ご意見・ご要望のフォーム内容管理
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactForm {
	
	@NotBlank( message = "名前が入力されていません")
	private String name;

	@NotBlank( message = "題名が入力されていません")
	private String subject;
	
	@NotBlank( message = "本文が入力されていません")
	private String text;
}
