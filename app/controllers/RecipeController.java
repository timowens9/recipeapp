package controllers;

import models.Recipe;
import models.RecipeData;
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
    private final RecipeData recipeData;


    @Inject
    public RecipeController(FormFactory formFactory, HttpExecutionContext httpExecutionContext, RecipeData recipeData) {
        this.formFactory = formFactory;
        this.httpExecutionContext = httpExecutionContext;
        this.recipeData = recipeData;

    }

    //For all Recipes

    public Result index(){
        return ok(index.render(recipeData.getRecipes()));

    }

    //To create recipe
    public Result createRecipe(){

        Form<Recipe> recipeForm = formFactory.form(Recipe.class);
        return ok(
                createRecipe.render(recipeForm)
        );
    }

    //To save recipe
    public Result saveRecipe(){
        return TODO;
    }

    //To edit a recipe
    public Result editRecipe(Integer id){
        return TODO;
    }

    // Updates recipe from edits in db
    public Result updateRecipe(){
        return TODO;
    }

    //To Delete a recipe based on ID
    public Result deleteRecipe(Integer id){
        return TODO;
    }

    // Method for Recipe Details based on ID
    public Result showRecipe(Integer id){

        return ok(viewRecipe.render(recipeData.findByID(id)));

    }

}
