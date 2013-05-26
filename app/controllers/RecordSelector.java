package controllers;

import models.DetailsStorage;
import models.UniqueRecord;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.archive;
import views.html.update;

public class RecordSelector extends Controller {

	public static Result selectRecord() {

		Form<UniqueRecord> uniqueRecordForm = Form.form(UniqueRecord.class)
				.bindFromRequest();
		UniqueRecord UniqueRecord = uniqueRecordForm.get();

		DetailsStorage uniqueRecord = DetailsStorage.find.byId(""
				+ UniqueRecord.id);
		if (UniqueRecord.submitType.equals("edit")) {
			new RecordUpdater(uniqueRecord);

			return ok(update.render(uniqueRecord));
		} else {
			new RecordRemover().removeRecord(UniqueRecord);
			return ok("Record is deleted");

		}

	}
}
