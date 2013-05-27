package controllers;

import models.DetailsStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class RecordUpdater extends Controller {
	
	public static DetailsStorage recordForUpdate;
	
	public RecordUpdater(DetailsStorage recordForUpdate){
		this.recordForUpdate = recordForUpdate;
		
	}
	
	public static Result updateRecord(){
		
		
		Form <DetailsStorage> updateForm = Form.form(DetailsStorage.class).bindFromRequest();
		DetailsStorage updateDetails = updateForm.get();
		
		
		DetailsStorage detailsFromDatabase = DetailsStorage.find.byId(""+updateDetails.id);
		
		detailsFromDatabase = updateForm.get();
		detailsFromDatabase.update(recordForUpdate.id);
		
		return ok(updateDetails.name);
	}
	
	
	


}
