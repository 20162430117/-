package chapter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormResquestServlet")
public class FormResquestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String username=request.getParameter("username");
		
		String password=request.getParameter("password");
		
		String[] channel = request.getParameterValues("channel");
		
		Enumeration<String> elem = request.getParameterNames();
		
        out.println("<p>注册的用户名是："+username+"</p>");
		
		out.println("<p>请求的查询字符是："+password+"</p>");
		
		out.println("<p>注册的信息来源是:");
		
		for (String c: channel) {
			out.print(c +"&nbsp");
			out.print("</p><p> 所有用户请求的参数名是:");
			while(elem.hasMoreElements())
				out.print(elem.nextElement()+"&nbsp");
			out.print("</p>");					
		out.flush();
		out.close();
		
	}
}
}
