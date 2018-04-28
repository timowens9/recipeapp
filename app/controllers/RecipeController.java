package controllers;

import models.Recipe;
import play.data.Form;
import play.data.FormFactory;
import play.libs.concurrent.HttpExecutionContext;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.recipes.*;

import javax.inject.Inject;


public class RecipeController extends Controller {
    private final FormFactory formFactory;
    private final HttpExecutionContext httpExecutionContext;


    @Inject
    public RecipeController(FormFactory formFactory, HttpExecutionContext httpExecutionContext) {
        this.formFactory = formFactory;
        this.httpExecutionContext = httpExecutionContext;
    }

    /**
     * Display the home page with all recipes
     *
     * @return the view
     */
    public Result index() {
        return ok(index.render(Recipe.all()));

    }

    /**
     * Display the recipe creation view
     *
     * @return the form data
     */
    public Result createRecipe() {

        Form<Recipe> recipeForm = formFactory.form(Recipe.class);
        return ok(
                createRecipe.render(recipeForm)
        );
    }

    /**
     * Handler for submitting the create recipe form
     *
     * @return the index view
     */
    public Result saveRecipe() {
        Form<Recipe> recipeForm = formFactory.form(Recipe.class).bindFromRequest();
        if (recipeForm.hasErrors()) {
            return (badRequest(index.render(Recipe.all())));
        } else {
            Recipe.create(recipeForm.get());
            return redirect(routes.RecipeController.index());
        }
    }

    /**
     * Display the recipe editing view
     *
     * @param id the ID of the recipe to edit
     * @return the form data
     */
    public Result editRecipe(Integer id) {
        return TODO;
    }

    /**
     * Handler for submitting the recipe editing form
     *
     * @return the index view
     */
    public Result updateRecipe() {
        return TODO;
    }

    /**
     * Handler for deleting a recipe
     *
     * @param id the id of the recipe to delete
     * @return the index view
     */
    public Result deleteRecipe(Integer id) {
        Recipe.delete(Long.valueOf(id));
        return redirect(routes.RecipeController.index());
    }

    /**
     * Display the details of a recipe
     *
     * @param id the recipe to display
     * @return the recipe view
     */
    public Result showRecipe(Integer id) {

        return ok(viewRecipe.render(Recipe.find.ref(Long.valueOf(id))));

    }

    public static void createTestData() {
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
