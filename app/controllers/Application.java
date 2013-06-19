package controllers;

import java.util.List;

import models.CategoryStorage;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.archive;
import views.html.category;
import views.html.index;
import views.html.record;
@Security.Authenticated(Secured.class)
public class Application extends Controller {

	public static Result index() {
		return ok(index.render("Your new application is ready."));
	}

	
	public static Result renderArchivePage() {
		List<CategoryStorage> categories = CategoryStorage.find.all();
		return ok(archive.render(categories));
	}

	public static Result renderRecordPage() {
		return ok(record.render());
	}

	public static Result renderCategoryPage() {

		List<CategoryStorage> categories = CategoryStorage.find.all();
		return ok(category.render(categories));
	}

}
