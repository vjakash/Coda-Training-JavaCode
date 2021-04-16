package mtomPack;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.jws.HandlerChain;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;

@MTOM
@WebService(endpointInterface = "mtomPack.MtomInter")
@HandlerChain(file="handler.xml")
public class MtomService implements MtomInter {
 

	@Override
	public Image getImage(String name) throws Exception {
		// TODO Auto-generated method stub 
		File f=new File(name);
		return ImageIO.read(f);
	}
	@Override
	public void setImage(Image img,String name) { 
		try{
			File fos=new File(name);
			BufferedImage bimage=(BufferedImage)img; 
			ImageIO.write(bimage, "jpg", fos); 
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
