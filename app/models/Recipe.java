package models;

import java.util.HashSet;
import java.util.Set;

public class Recipe {

    public Integer id;

    public String type;

    public String name;

    public Integer calories;

    public String rating;



    public Recipe(Integer id, String type, String name, Integer calories, String rating){

        this.id = id;
        this.type = type;
        this.name = name;
        this.calories = calories;
        this.rating = rating;
    }


    //Some data
    public static Set<Recipe> recipes;

    static {
        recipes = new HashSet<>();
        recipes.add(new Recipe(1, "Breakfast", "Omelet", 200,"8/10" ));
        recipes.add(new Recipe(2, "Lunch", "Burger", 430,"6/10" ));
        recipes.add(new Recipe(3, "Dinner", "Tacos", 360,"10/10" ));

    }


    public static Set<Recipe> allRecipes(){
        return recipes;
    }

    public static Recipe findByID(Integer id){

        for (Recipe recipe : recipes){
            if (id.equals(recipe.id)){
                return recipe;
            }
        }
        return null;

    }

    public static void add(Recipe recipe){

        recipes.add(recipe);
    }



    public static boolean remove(Recipe recipe){

        return recipes.remove(recipe);
    }

}
