package manytomany;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="student")
@Table(name="student")
public class Student {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int sid;
	private String sname;
	private int marks;
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name="Student_has_Training")
	private Set<Training> trainings;
	
	public final int getSid() {
		return sid;
	}
	public final void setSid(int sid) {
		this.sid = sid;
	}
	public final String getSname() {
		return sname;
	}
	public final void setSname(String sname) {
		this.sname = sname;
	}
	public final int getMarks() {
		return marks;
	}
	public final void setMarks(int marks) {
		this.marks = marks;
	}
	public final Set<Training> getTrainings() {
		return trainings;
	}
	public final void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}
}
