package Planner.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Planner {
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Planner(String name, String date, String time, String note) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.time = time;
		this.note = note;
	}

	private String name;

	private String date;
	private String time;
	private String note;
	
    public Planner() {}

	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDate() {
		return date;
	}





	public void setDate(String date) {
		this.date = date;
	}





	public String getTime() {
		return time;
	}





	public void setTime(String time) {
		this.time = time;
	}





	public String getNote() {
		return note;
	}





	public void setNote(String note) {
		this.note = note;
	}









@Override
public String toString() {
	return "planner [name=" + name + "date=" + date + ", time=" + time + ", note=" + note + ", ]";
}

}
