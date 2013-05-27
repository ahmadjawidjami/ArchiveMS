package controllers;

import models.CategoryStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryCreator extends Controller {

	public static Result addCategory() {
		Form<CategoryStorage> categoryNameFromForm = Form.form(
				CategoryStorage.class).bindFromRequest();
		CategoryStorage newCategory = categoryNameFromForm.get();
		CategoryStorage sameCategoryInDatabase = CategoryStorage.find.where()
				.eq("categoryName", newCategory.categoryName).findUnique();

		if (newCategory.categoryName.length() >= 4) {
			if (sameCategoryInDatabase==null) {
				addCategoryToDatabase(newCategory);
				addCategoryToDisk();
				return ok("Category '" + newCategory.categoryName
						+ "' successfully added to the sysyem");

			}
			else{
				return ok("category already exists");
			}

			
		} else {
			return ok("Your category name is less than 4");
		}

	}

	private static void addCategoryToDisk() {

	}

	private static void addCategoryToDatabase(CategoryStorage newCategory) {
		newCategory.save();

	}
}
