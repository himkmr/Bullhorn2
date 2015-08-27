package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TWITTER_USER database table.
 * 
 */
@Entity
@Table(name="TWITTER_USER")
@NamedQuery(name="TwitterUser.findAll", query="SELECT t FROM TwitterUser t")
public class TwitterUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String name;

	private String password;

	public TwitterUser() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}