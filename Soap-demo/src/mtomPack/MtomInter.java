package mtomPack;

import java.awt.Image;

import javax.jws.WebService;

@WebService
public interface MtomInter {

	public Image getImage(String name)throws Exception;
	public void setImage(Image img,String name);
}
