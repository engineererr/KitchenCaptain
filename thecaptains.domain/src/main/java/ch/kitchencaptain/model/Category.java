package ch.kitchencaptain.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by User on 15.01.2016.
 */
@Entity
public class Category {
    @GeneratedValue
    @Id
    private java.lang.Long id;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    private String name;

    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    private List<Ingredient> ingredients;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
