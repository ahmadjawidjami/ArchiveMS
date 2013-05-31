package controllers;

import java.util.List;

import models.DetailsStorage;
import models.SearchCriteriaStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class RecordFinder extends Controller {
	
	
	
	public RecordFinder(){
		
	}

	public static Result findRecord() {

		Form<SearchCriteriaStorage> searchCriteriaForm = Form.form(
				SearchCriteriaStorage.class).bindFromRequest();
		SearchCriteriaStorage searchCriteria = searchCriteriaForm.get();
		String query = new QueryCreator().createQuery(searchCriteria);
		List<DetailsStorage> records = findRecordFromDatabase(query);
		findRecordFromDisk();
		new PageMaker(records);

		return redirect(controllers.routes.PageMaker.makePage());
	}

	public static void findRecordFromDisk() {

	}

	public static List<DetailsStorage> findRecordFromDatabase(String query) {

		List<DetailsStorage> records = DetailsStorage.find.query().where(query)
				.findList();
		return records;

	}

}
