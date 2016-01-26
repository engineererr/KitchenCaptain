package ch.kitchencaptain.dto;

import java.io.Serializable;

/**
 * Entity implementation class for Entity: Book
 *
 */
public class CategoryDTO implements Serializable {

	   
	private Long id;
	private String title;

	private static final long serialVersionUID = 1L;



	public CategoryDTO() {
		super();
	}   
	public Long getId() {
		
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
