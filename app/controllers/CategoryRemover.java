package controllers;

import models.CategoryStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryRemover extends Controller {

	public static Result removeCategory() {
		Form <CategoryStorage> categoryDetailsForm = Form.form(
				CategoryStorage.class).bindFromRequest();
		CategoryStorage categoryToDelete = categoryDetailsForm.get();
		if (!categoryToDelete.categoryName.equals("")) {
			removeCategoryFromDatabase(categoryToDelete);
			removeCategoryFromDisk();
			return ok("Category '" + categoryToDelete.categoryName
					+ "' is now Deleted");
		} else
			return notFound("No category was selected");
	}

	public static void removeCategoryFromDatabase(
			CategoryStorage categoryToDelete) {
		categoryToDelete.delete();

	}

	public static void removeCategoryFromDisk() {

	}

}
