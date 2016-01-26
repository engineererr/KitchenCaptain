package ch.kitchencaptain.model;

import javax.persistence.*;

/**
 * Created by User on 15.01.2016.
 */
@Entity
public class Ingredient {
    @GeneratedValue
    @Id
    private java.lang.Long id;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    private String title;

    @Basic
    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    private Category category;

    @ManyToOne(cascade = CascadeType.ALL)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
