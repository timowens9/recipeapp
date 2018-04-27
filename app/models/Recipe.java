package models;

import java.util.HashSet;
import java.util.Set;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.Entity;

@Entity
public class Recipe extends BaseModel {

    private static final long serialVersionUID = 1L;

    public String name;

    public String category;

    public Integer calories;

    public String rating;



    public Recipe(Integer id, String category, String name, Integer calories, String rating){

        this.id = id;
        this.category = category;
        this.name = name;
        this.calories = calories;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
