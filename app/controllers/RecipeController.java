package controllers;

import models.RecipeData;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.recipes.index;
import views.html.recipes.viewRecipe;


public class RecipeController extends Controller {

    RecipeData recipes;

    public RecipeController() {
        this.recipes = new RecipeData();
    }

    //For all Recipes

    public Result index(){
        return ok(index.render(recipes.getRecipes()));

    }

    //To create recipe
    public Result createRecipe(){
        return TODO;
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

        return ok(viewRecipe.render(this.recipes.findByID(id)));

    }

}
