package controllers;

import models.DetailsStorage;
import models.UniqueRecord;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.update;

public class RecordSelector extends Controller {

	public static Result selectRecord() {

		Form<DetailsStorage> uniqueRecordForm = Form.form(DetailsStorage.class)
				.bindFromRequest();
		DetailsStorage getUniqueRecord = uniqueRecordForm.get();
		DetailsStorage uniqueRecord = DetailsStorage.find.byId(""+getUniqueRecord.id);
		new RecordUpdater(uniqueRecord);

		return ok(update.render(uniqueRecord));
	}

}
