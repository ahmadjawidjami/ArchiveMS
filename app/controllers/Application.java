package controllers;

import java.util.List;

import models.CategoryStorage;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	public static Result renderArchivePage() {
		List <CategoryStorage> categories = CategoryStorage.find.all();
		return ok(archive.render(categories));
	}

	public static Result renderRecordPage() {
		return ok(record.render());
	}

	public static Result renderCategoryPage() {
		
		List <CategoryStorage> categories = CategoryStorage.find.all();
		return ok(category.render(categories));
	}

}
