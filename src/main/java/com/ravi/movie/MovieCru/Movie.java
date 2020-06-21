package com.ravi.movie.MovieCru;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="movie")
public class Movie {

	@Id
	
	@Column
	private Long id;
	@Column
	private String  movieName;
	
	@Column
	private String  desc;
	@Column
	private Date  rdate;
	@Column
	private int  rate;
	@Column
	private String  comment;
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column
	private String  imgUrl;
	
	public Movie() {
		
	}
	
	public Movie(Long id, String movieName, String desc, Date rdate, int rate,String  imgUrl,String  comment) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.desc = desc;
		this.rdate = rdate;
		this.rate = rate;
		this.imgUrl = imgUrl;
		this.comment = comment;
	}
	
	
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public void setRdate(Date rdate) {
		this.rdate = rdate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public Long getId() {
		return id;
	}
	public String getMovieName() {
		return movieName;
	}
	public String getDesc() {
		return desc;
	}
	public Date getRdate() {
		return rdate;
	}
	public int getRate() {
		return rate;
	}
	
	
}
