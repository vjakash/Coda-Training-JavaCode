package manytomany;

import java.util.Date;
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

@Entity
@Table(name="training")
public class Training {
	@Id @GeneratedValue(strategy = GenerationType. AUTO)
	private int tid;
	private String tname;
	private Date startDate;
	
	@ManyToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY)
	@JoinTable(name="Student_has_Training")
	private Set<Student> students;
	
	public final int getTid() {
		return tid;
	}
	public final void setTid(int tid) {
		this.tid = tid;
	}
	public final String getTname() {
		return tname;
	}
	public final void setTname(String tname) {
		this.tname = tname;
	}
	public final Date getStartDate() {
		return startDate;
	}
	public final void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public final Set<Student> getStudents() {
		return students;
	}
	public final void setStudents(Set<Student> students) {
		this.students = students;
	}

}
