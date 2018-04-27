import models.Recipe;

/**
 * Loads test data on application startup
 *
 * Reference: https://stackoverflow.com/questions/26934354/how-to-load-insert-initial-data-into-database-with-ebean-in-play-framework
 */
public class TestData {

    public TestData() {

        if (Recipe.all().size() == 0) {
            Recipe recipe = new Recipe();
            recipe.name = "Omelet";
            recipe.category = "Breakfast";
            recipe.calories = 200;
            recipe.rating = 5;
            Recipe.create(recipe);

            Recipe recipe2 = new Recipe();
            recipe2.name = "Burger";
            recipe2.category = "Lunch";
            recipe2.calories = 430;
            recipe2.rating = 6;
            Recipe.create(recipe2);

            Recipe recipe3 = new Recipe();
            recipe3.name = "Tacos";
            recipe3.category = "Dinner";
            recipe3.calories = 360;
            recipe3.rating = 10;
            Recipe.create(recipe3);
        }

    }
}
