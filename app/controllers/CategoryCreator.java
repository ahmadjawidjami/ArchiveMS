package controllers;

import models.CategoryStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryCreator extends Controller {

	static String categoryName;
	static CategoryStorage object;

	public static Result createCategory() {
		Form<CategoryStorage> getForm = Form.form(CategoryStorage.class).bindFromRequest();
		object = getForm.get();
		
		if (object.categoryName.length()>= 4) {
			addCategoryToDatabase();
			addCategoryIntoDisk();
			return ok("Category '" + object.categoryName + "' successfully added to the sysyem");

		} else {
			return ok("Your category name is less than 4");
		}
		
	}
	
	
	
	private static void addCategoryIntoDisk() {
		// TODO Auto-generated method stub

	}

	private static void addCategoryToDatabase() {
		object.save();

	}
	
	

}
