package controllers;

import java.util.List;

import models.CategoryStorage;
import models.UserStorage;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.html.archive;
import views.html.category;
import views.html.index;
import views.html.record;
import views.html.add_user;
import views.html.remove_user;

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
	
	public static Result renderAddUserPage(){
		
		
		return ok(add_user.render());
	}
	
	
	public static Result renderRemoveUserPage(){
		
		List <UserStorage> users = UserStorage.findAll();
		
		
		return ok(remove_user.render(users));
		
	}

}
