package dto;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: Author
 *
 */
public class IngredientDTO implements Serializable {

	   
	private Long id;
	private String firstname;
	private String lastname;
	private static final long serialVersionUID = 1L;

	public IngredientDTO() {
		super();
	}   
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}   
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
   
}
