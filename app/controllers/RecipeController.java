package controllers;

import models.Recipe;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Set;



public class RecipeController extends Controller {

    //For all Recipes

    public static Result index(){
        Set<Recipe> recipes= Recipe.allRecipes();
        return ok(views.html.index.render(recipes));

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
        return TODO;
    }

}
