package models;

import javax.persistence.Entity;

import play.db.ebean.Model;
@Entity
public class CategoryStorage extends Model {
	
	
	@id
	public String categoryName;

}
