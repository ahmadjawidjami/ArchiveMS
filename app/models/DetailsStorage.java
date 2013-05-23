package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import play.db.ebean.Model;
@Entity
public class DetailsStorage extends Model{
	@Id
	public int id;
	public String name;
	public String category;
	public String content;
	public String path;
	public Date publishDate;
	public Date recordDate;
	public Date archiveDate;

}
