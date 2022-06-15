package userController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/friendAdd")
public class friendAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public friendAdd() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		int friendId = Integer.parseInt(request.getParameter("id"));
		firendDAO friendListUpdate = new firendDAO();
		String idx = friendListUpdate.getLastIdxFirend() + 1 + "";
		String myIdx = (String) session.getAttribute("logOK");
		
		boolean updateCheck = friendListUpdate.insertFollows(idx, friendId, myIdx);

		if (updateCheck) {
			response.sendRedirect("main.jsp");
			out.println("<script> alert(\"성공\");</script>");
		} else {
			out.println("<script> alert(\"실패\"); history.go(-1); </script>");
		}

	}
}
