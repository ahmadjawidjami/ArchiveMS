package controllers;

import java.util.List;

import models.DetailsStorage;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class PageMaker extends Controller {

	public static List<DetailsStorage> records;

	public PageMaker(List<DetailsStorage> records) {

		this.records = records;

	}

	public static Result makePage() {

		return ok(searched_record.render(records));
	}
}
