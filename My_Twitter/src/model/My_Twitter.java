package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the MYTWITTER database table.
 * 
 */
@Entity
@Table(name="MYTWITTER")
@NamedQuery(name="My_Twitter.findAll", query="SELECT m FROM My_Twitter m")
public class My_Twitter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;

	private String comments;

	private String name;

	public My_Twitter() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}