package dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Entity implementation class for Entity: Book
 *
 */
public class CategoryDTO implements Serializable {

	   
	private Long id;
	private String title;

	private Date releaseDate;
	private static final long serialVersionUID = 1L;
	
	private CategoryDTO category;

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
	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public CategoryDTO getCategory() {
		return category;
	}
	public void setCategory(CategoryDTO author) {
		this.category = category;
	}
   
}
