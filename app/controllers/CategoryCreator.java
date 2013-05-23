package controllers;

import models.CategoryStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class CategoryCreator extends Controller{
		static String categoryName;
		static CategoryStorage categoryRem;
		static Form<CategoryStorage> categoryRemove;

		public static Result createCategory() {
			categoryRemove = Form.form(CategoryStorage.class).bindFromRequest();
			categoryRem = categoryRemove.get();
			if (categoryRem.categoryName.length()>=4 && categoryRem.categoryName!=null ) {
				createCategoryToDB();
				createCategoryIntoDisk();
				categoryName = categoryRem.categoryName;
				return ok("Category '" + categoryName + "' is now added to the system");
			} else
				return notFound("No/short name was entered, please enter a name with atleast 4 characters");
		}

		public static void createCategoryToDB() {
			categoryRem.save();

		}

		public static void createCategoryIntoDisk() {

		}
	}

