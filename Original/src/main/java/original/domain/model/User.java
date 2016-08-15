package original.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userid")
	private int userID;

	@NotBlank( message =  "メールアドレスが入力されていません")
	@Size(max=255,message="メールアドレスの文字列が長すぎます")
	private String email;

	@NotBlank(message = "名前が入力されていません")
	@Size(max=31,message="名前の文字列が長すぎます")
	private String name;

	@Column(name = "newdate")
	private Timestamp newDate;

	@NotBlank(message = "パスワードが入力されていません")
	@Size(max=31,message="パスワードの文字列が長すぎます")
	private String password;


}