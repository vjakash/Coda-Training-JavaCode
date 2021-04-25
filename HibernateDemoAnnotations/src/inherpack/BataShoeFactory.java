package inherpack;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity()
@DiscriminatorValue(value="BSF")
public class BataShoeFactory extends ShoeFactory {
	@Column(name = "bataName")
	private String bataName;

	public String getBataName() {
		return bataName;
	}

	public void setBataName(String bataName) {
		this.bataName = bataName;
	}
}
