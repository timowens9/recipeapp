package models;

import io.ebean.Finder;
import io.ebean.Model;
import play.data.validation.Constraints;

import javax.persistence.*;
import javax.validation.Constraint;
import java.util.List;

@Entity
public class Recipe extends Model {

    @Id
    public Long id;

    @Constraints.Required
    public String name;

    public String category;

    public Integer calories;

    public Integer rating;

    public static List<Recipe> all() {
        return find.all();
    }

    public static Finder<Long, Recipe> find = new Finder<>(Recipe.class);

    public static void create(Recipe recipe) {
        recipe.save();
    }

    public static void delete(Long id) {
        find.ref(id).delete();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

}
