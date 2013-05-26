
package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import play.db.ebean.Model;
@SuppressWarnings("serial")
@Entity
public class CategoryStorage extends Model {
	
	
	@Id
	public String categoryName;

}
