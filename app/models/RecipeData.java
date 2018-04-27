package models;

import javax.persistence.Entity;
import java.util.HashSet;

@Entity
public class RecipeData {

    public HashSet<Recipe> recipes;
    private int lastId;

    /**
     * Constructs a new RecipeData with test recipes
     */
    public RecipeData() {
        recipes = new HashSet<>();

        recipes.add(new Recipe(1, "Breakfast", "Omelet", 200, "8/10"));
        recipes.add(new Recipe(2, "Lunch", "Burger", 430, "6/10"));
        recipes.add(new Recipe(3, "Dinner", "Tacos", 360, "10/10"));
        lastId = 4;
    }

    /**
     * Returns the Recipe with the specified ID, or null if not found
     *
     * @param id the recipe's ID
     * @return the specified recipe or null if not found
     */
    public Recipe findByID(Integer id) {

        for (Recipe recipe : recipes) {
            if (id.equals(recipe.id)) {
                return recipe;
            }
        }
        return null;
    }


    /**
     * Adds the specified recipe
     * If there is an ID conflict the specified recipe's ID will be changed to the first available ID.
     *
     * @param recipe the recipe to add
     */
    public void add(Recipe recipe) {
        int suggestedId = recipe.id;
        boolean suggestedIdAlreadyExists = false;

        for (Recipe r : recipes) {
            if (r.getId() == suggestedId && !suggestedIdAlreadyExists) {
                suggestedIdAlreadyExists = true;
            }

            if (r.getId() > lastId) {
                lastId = r.getId() + 1;
            }
        }

        if (suggestedIdAlreadyExists) {
            lastId++;
            recipe.setId(lastId);
        }

        recipes.add(recipe);
    }

    /**
     * Creates a new Recipe with the specified attributes
     *
     * @param category
     * @param name
     * @param calories
     * @param rating
     */
    public Recipe add(String category, String name, int calories, String rating) {
        Recipe recipe = new Recipe(lastId, category, name, calories, rating);
        lastId++;
        recipes.add(recipe);
        return recipe;
    }

    /**
     * Removes the specified recipe
     *
     * @param recipe the recipe to remove
     * @return true if the recipe was removed, false if no recipe was found
     */
    public boolean remove(Recipe recipe) {
        return recipes.remove(recipe);
    }

    /**
     * Returns the set of recipes
     *
     * @return the set of recipes
     */
    public HashSet<Recipe> getRecipes() {
        return recipes;
    }
}
