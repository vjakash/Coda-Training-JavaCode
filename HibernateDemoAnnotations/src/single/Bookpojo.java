package single;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="books")
//@NamedQuery(name="mybookquery", query = "from books")
public class Bookpojo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bid;
	@Column(name = "NAME", nullable = false)
	private String bname;
	private String bauthor;
	private float price;
	private Comment comment;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Bookpojo [bid=" + bid + ", bname=" + bname + ", bauthor=" + bauthor + ", price=" + price + ", comment="
				+ comment + "]";
	}
	
}
