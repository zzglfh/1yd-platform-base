package com.tjcloud.platform.model;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Simple JavaBean domain object with an id property. Used as a base class for
 * objects needing this property.
 *
 * @author Feng.Guo
 * @date Aug 22, 2014 10:49:21 AM
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

	/**
	 * @Fields serialVersionUID
	 */

	private static final long serialVersionUID = 1834434750520520302L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;

	@Column(name = "creation_time")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	protected DateTime creationTime;

	@Column(name = "remove_mark")
	protected Boolean removeMark;

	public Boolean getRemoveMark() {
		return removeMark;
	}

	public void setRemoveMark(Boolean removeMark) {
		this.removeMark = removeMark;
	}

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public boolean isNew() {
		return (this.id == null);
	}

	@PrePersist
	public void prePersist() {
		creationTime = DateTime.now();
		removeMark = false;
	}

}
