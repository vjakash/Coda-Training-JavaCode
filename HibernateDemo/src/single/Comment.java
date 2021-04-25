package single;

import java.io.Serializable;

public class Comment implements Serializable{
	 String msg;
	 public Comment(String msg) {
		this.msg=msg;
	}
	 @Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.msg;
	}
	
}
