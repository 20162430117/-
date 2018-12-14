package chapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LinkRequestServlet")
public class LinkRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LinkRequestServlet() {
        super();
     
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		String pageNo=request.getParameter("pageNo");
		
		String queryString=request.getParameter("queryString");
		
		int pageNum=0;
		if(pageNo!=null)
				pageNum=Integer.parseInt(pageNo);
		
		out.println("<p>请求的页数是："+pageNum+"</p>");
		
		out.println("<p>请求的查询字符是："+queryString+"</p>");
		
		out.flush();
		out.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
