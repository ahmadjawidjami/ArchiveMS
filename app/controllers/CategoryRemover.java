package controllers;

import java.io.File;
import java.io.FileNotFoundException;

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
			removeCategoryFromDisk(new File("uploads/"+categoryToDelete.categoryName));
//			return ok("Category '" + categoryToDelete.categoryName
//					+ "' is now Deleted");
			return redirect(controllers.routes.Application.renderCategoryPage());
		} else
			return notFound("No category was selected");
	}

	public static void removeCategoryFromDatabase(
			CategoryStorage categoryToDelete) {
		categoryToDelete.delete();

	}

	public static void removeCategoryFromDisk(File f) {
		
		if (f.isDirectory()) {
		    for (File c : f.listFiles())
		      removeCategoryFromDisk(c);
		  }
		if (!f.delete())
			try {
				throw new FileNotFoundException("Failed to delete file: " + f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	

}
