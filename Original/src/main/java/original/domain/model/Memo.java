package original.domain.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Size;

import java.sql.Timestamp;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the memo database table.
 * 
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name="Memo.findAll", query="SELECT m FROM Memo m")
public class Memo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memoID;

	@Lob
	@Size(min = 1)
	private String memo;

	@Column(name = "newdate")
	private Timestamp newDate;

	private int userID;

	private String language;
}