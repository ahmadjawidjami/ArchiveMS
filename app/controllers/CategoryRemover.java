package controllers;

import models.CategoryStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryRemover extends Controller {
	static String categoryName;
	static CategoryStorage categoryRem;
	static Form<CategoryStorage> categoryRemove;

	public static Result removeCategory() {
		categoryRemove = Form.form(CategoryStorage.class).bindFromRequest();
		categoryRem = categoryRemove.get();
		if (categoryRem.categoryName != null) {
			removeCategoryFromDB();
			removeCategoryFromDisk();
			categoryName = categoryRem.categoryName;
			return ok("Category '" + categoryName + "' is now Deleted");
		} else
			return notFound("No category was selected");
	}

	public static void removeCategoryFromDB() {
		categoryRem.delete();

	}

	public static void removeCategoryFromDisk() {
		
		
	}

}
