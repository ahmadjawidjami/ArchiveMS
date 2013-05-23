package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class RecordFinder extends Controller {
	
	
	public static Result findRecord(){
		
		
		
		return ok(searched_record.render("fd"));
	}
	
	
	public static void findRecordFromDisk(){
		
	}
	
	
	
	public static void findRecordFromDatabase(){
		
		
		
	}

}
