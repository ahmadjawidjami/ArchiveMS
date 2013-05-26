package controllers;

import models.DetailsStorage;
import models.UniqueRecord;
import play.mvc.Controller;


public class RecordRemover extends Controller{


	public void  removeRecord(UniqueRecord record){
		removeRecordFromDatabase(record);
		removeRecordFromDisk();
	}
	
	public static void removeRecordFromDatabase(UniqueRecord record){
		DetailsStorage.find.byId(""+record.id).delete();
		
	}
	public static void removeRecordFromDisk(){
		
	}
	
	
}
