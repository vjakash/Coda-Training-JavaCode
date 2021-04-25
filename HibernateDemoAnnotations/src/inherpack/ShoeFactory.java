package inherpack;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity(name="ShoeFactory")
@Table(name="SHOEFACTORY")
//@Inheritance(strategy=InheritanceType.JOINED) 
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="discriminatorValue")
@DiscriminatorValue(value="SF")
public class ShoeFactory {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String shoeName;
	public  int getSid() {
		return sid;
	}
	public  void setSid(int sid) {
		this.sid = sid;
	}
	public String getShoeName() {
		return shoeName;
	}
	public void setShoeName(String shoeName) {
		this.shoeName = shoeName;
	}
	
}
