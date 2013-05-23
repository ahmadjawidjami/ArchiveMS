package models;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class CategoryStorage extends Model {
	@Id
	public String categoryName;

}
