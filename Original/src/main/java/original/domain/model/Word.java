package original.domain.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * The persistent class for the word database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="Word.findAll", query="SELECT w FROM Word w")
public class Word implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "wordID")
	private int wordID;

	@Lob
	@NotNull
	private String translation;

	private int userID;

	@Column(name = "word")
	@NotNull
	@Size(min=1)
	private String altword;

	@Column(name = "newdate")
	private Timestamp newDate;

	private String language;
}