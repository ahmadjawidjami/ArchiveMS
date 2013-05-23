package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    
    
    
    public static Result renderArchivePage(){
    	return ok (archive.render());
    }
    public static Result renderRecordPage(){
    	return ok (record.render());
    }
}
