package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import models.DetailsStorage;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;

public class Archiver extends Controller {

	public static Result archive() {

		// file details form
		Form<DetailsStorage> detailsForm = Form.form(DetailsStorage.class)
				.bindFromRequest();
		DetailsStorage recordDetails = detailsForm.get();

		// file form
		MultipartFormData recordForm = request().body().asMultipartFormData();

		FilePart record = recordForm.getFile("record");

		if (record != null) {
			String fileName = record.getFilename();
			File file = record.getFile();

			try {
				if (recordDetails.category.equals("lessons")) {
					recordDetails.path = "uploads/lessons/";
					archiveToDisk(file,
							new File(recordDetails.path + recordDetails.name+"."
									+ fileName.charAt((int) fileName.length() - 3)
									+ fileName.charAt((int) fileName.length() - 2)
									+ fileName.charAt((int) fileName.length() - 1)));
					archiveToDatabase(recordDetails);
				}

			} catch (Exception ex) {
				return ok(ex.getMessage());
			}

			return ok("file uploaded");
		} else {
			flash("error", "Missing file");
			return redirect(routes.Application.index());
		}

	}

	public static void archiveToDisk(File source, File destination)
			throws Exception {

		InputStream src = new FileInputStream(source);

		OutputStream dest = new FileOutputStream(destination);

		byte buf[] = new byte[1024];
		int read = -1;
		while ((read = src.read(buf)) != -1)
			dest.write(buf, 0, read);

		src.close();
		dest.close();
	}

	public static void archiveToDatabase(DetailsStorage details) {

		details.save();

	}

}
