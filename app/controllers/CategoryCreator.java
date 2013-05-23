package controllers;

import models.CategoryStorage;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryCreator extends Controller{
	
	
	
	public static Result createCategory(){
		
		
		
		
		return ok("category created");
		
	}
	
	public static void addCategoryToDisk(){
		
		
	}
	
	
	public static void addCategoryDatabase(CategoryStorage name){
		
		name.save();
	}
	
	
	

}
