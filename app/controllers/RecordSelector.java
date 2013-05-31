package controllers;

import java.util.List;

import models.ActionSpecifier;
import models.CategoryStorage;
import models.DetailsStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.update;

public class RecordSelector extends Controller {

	public static Result selectRecord(int id) {

		Form<ActionSpecifier> submitTypeForm = Form.form(ActionSpecifier.class)
				.bindFromRequest();
		ActionSpecifier actionType = submitTypeForm.get();

			DetailsStorage uniqueRecord = DetailsStorage.find.byId(""
					+ id);
			if (actionType.submitType.equals("edit")) {
				new RecordUpdater(uniqueRecord);
				List <CategoryStorage> categories = CategoryStorage.find.all();
				
				return ok(update.render(uniqueRecord, categories));
			} else {
				new RecordRemover().removeRecord(uniqueRecord);
				RecordFinder.findRecord();
				return redirect(controllers.routes.PageMaker.makePage());

			}
//		}

		

	}
}
