package day12;

import java.lang.reflect.Field;

public class GenericsDemo {
	public static void main(String[] args) throws Exception  {
		PaintBrush<Paint> brush=PaintContainer.getPaintBrush();
		Paint paint=(Paint)brush.obj;
		System.out.println(paint);
		
		PaintBrush<Water> waterBrush=WaterContainer.getPaintBrush();
		Water water=(Water)waterBrush.getObj();
		System.out.println(water);
	}
}
class PaintContainer {
	public static PaintBrush<Paint> getPaintBrush() throws Exception {
		PaintBrush<Paint> pb=new PaintBrush<>();
		Paint obj=new RedPaint();
//		pb.setObj(obj);
		Field field=pb.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		In in=field.getAnnotation(In.class);
		if(in!=null) {
			pb.setObj(obj);//dependency injection
		}
		return pb;
	}
}
class WaterContainer{
	public static PaintBrush<Water> getPaintBrush() throws Exception {
		PaintBrush<Water> pb=new PaintBrush<>();
		Water obj=new Water();
//		pb.setObj(obj);
		Field field=pb.getClass().getDeclaredField("obj");
		field.setAccessible(true);
		In in=field.getAnnotation(In.class);
		if(in!=null) {
//			System.out.println(in.value());
			pb.setObj(obj);//dependency injection
		}
		return pb;
	}
}
abstract class Paint{
	
}
class RedPaint extends Paint{
	
}
class BluePaint extends Paint{
	
}
//<T> can be assigned any objects
class PaintBrush<T>{
	//Paint paint;
	//Object obj;//generic
	//real generics is
	@In
	T obj;
	public T getObj() {
		return this.obj;
	}
	public void setObj(T obj) {
		this.obj=obj;
	}
}
class Water {}