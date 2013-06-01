package controllers;

import java.io.File;
import java.util.StringTokenizer;

import models.DetailsStorage;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class RecordUpdater extends Controller {

	public static DetailsStorage recordForUpdate;

	public RecordUpdater(DetailsStorage recordForUpdate) {
		RecordUpdater.recordForUpdate = recordForUpdate;

	}

	public static Result updateRecord() {

		Form<DetailsStorage> updateForm = Form.form(DetailsStorage.class)
				.bindFromRequest();
		DetailsStorage updateDetails = updateForm.get();

		DetailsStorage detailsFromDatabase = DetailsStorage.find.byId(""
				+ recordForUpdate.id);

		// detailsFromDatabase = updateForm.get();

		updateRecordInDisk(detailsFromDatabase, updateDetails);
		updateRecordInDatabase(updateDetails);

		return redirect(controllers.routes.Application.renderRecordPage());
	}

	public static void updateRecordInDatabase(DetailsStorage updateDetails) {

		updateDetails.update(recordForUpdate.id);

	}

	public static void updateRecordInDisk(DetailsStorage detailsFromDatabase,
			DetailsStorage updateDetails) {

		// if (!detailsFromDatabase.name.equals(updateDetails.name)) {
		//
		// File f = new File(detailsFromDatabase.path);
		//
		// if (f.isDirectory()) {
		//
		//
		// for (File c : f.listFiles()) {
		// StringTokenizer st = new StringTokenizer(c.getName(), ".");
		//
		// if (st.nextToken().equals(detailsFromDatabase.name)) {
		//
		// c.renameTo(new File(detailsFromDatabase.path + "/"
		// + updateDetails.name+"."+st.nextToken()));
		// }
		//
		// }
		// }
		//
		// }

		if (!detailsFromDatabase.category.equals(updateDetails.category)) {

			File f = new File(detailsFromDatabase.path);

			if (f.isDirectory()) {

				for (File c : f.listFiles()) {
					StringTokenizer st = new StringTokenizer(c.getName(), ".");

					if (st.nextToken().equals(detailsFromDatabase.name)) {

						File tag = new File("uploads/" + updateDetails.category
								+ "/" + updateDetails.tag);
						if (!tag.exists()) {
							tag.mkdir();
						}

						updateDetails.path = detailsFromDatabase.path
								+ "/../../" + updateDetails.category + "/"
								+ updateDetails.tag;
						updateDetails.update(recordForUpdate.id);

						c.renameTo(new File(updateDetails.path + "/"
								+ updateDetails.name + "." + st.nextToken()));
						// c.deleteOnExit();

					}

				}
			}

		} else

		if (!detailsFromDatabase.tag.equals(updateDetails.tag)) {

			File f = new File(detailsFromDatabase.path);

			if (f.isDirectory()) {

				for (File c : f.listFiles()) {
					StringTokenizer st = new StringTokenizer(c.getName(), ".");

					if (st.nextToken().equals(detailsFromDatabase.name)) {

						File tag = new File("uploads/"
								+ detailsFromDatabase.category + "/"
								+ updateDetails.tag);
						if (!tag.exists()) {
							tag.mkdir();
						}

						updateDetails.path = detailsFromDatabase.path + "/../"
								+ updateDetails.tag;
						updateDetails.update(recordForUpdate.id);

						c.renameTo(new File(updateDetails.path + "/"
								+ updateDetails.name + "." + st.nextToken()));

					}

				}
			}

		}
		else

		if (!detailsFromDatabase.name.equals(updateDetails.name)) {

			File f = new File(detailsFromDatabase.path);

			if (f.isDirectory()) {

				for (File c : f.listFiles()) {
					StringTokenizer st = new StringTokenizer(c.getName(), ".");

					if (st.nextToken().equals(detailsFromDatabase.name)) {

//						File tag = new File("uploads/"
//								+ detailsFromDatabase.category + "/"
//								+ updateDetails.tag);
//						if (!tag.exists()) {
//							tag.mkdir();
//						}

						updateDetails.path = detailsFromDatabase.path;
						updateDetails.update(recordForUpdate.id);

						c.renameTo(new File(updateDetails.path + "/"
								+ updateDetails.name + "." + st.nextToken()));

					}

				}
			}

		}

	}

}
