package inherpack;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity()
@DiscriminatorValue(value="LSF")
public class LakhaniShoeFactory extends ShoeFactory{
	@Column(name = "lakhaniName")
	private String lakhaniName;

	public String getLakhaniName() {
		return lakhaniName;
	}

	public void setLakhaniName(String lakhaniName) {
		this.lakhaniName = lakhaniName;
	}
}
