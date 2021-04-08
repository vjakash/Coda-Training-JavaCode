package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddItemAction extends Action{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String items[]=request.getParameterValues("item");
		List<String> list = Arrays.asList(items);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}

		return request.getParameter("shopid");
	}
}
