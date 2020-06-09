package com.aneesh.hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {

	//annotate the class as an entity and map to a database table
	
	//define the fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;
	
	@Column(name="hobby")
	private String hobby;
	
	//annotate the fields with db column names
	
	
	//create constructors 
	public InstructorDetail() {
		
	}

	public InstructorDetail(String youtubeChannel, String hobby) {
		super();
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id= " + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeChannel() {
		return youtubeChannel;
	}

	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	
	//getters and setters
	
	
	//override toString
	
	
	
}
