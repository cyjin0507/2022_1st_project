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

	// get방식으로 넘어온다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// 세션을 가져온다
		HttpSession session = request.getSession();
		int friendId = Integer.parseInt(request.getParameter("id"));
		// firendDAO 클래스를 사용한다.
		firendDAO friendListUpdate = new firendDAO();
		String idx = friendListUpdate.getLastIdxFirend() + 1 + "";
		// 현재 로그인 중인 user의 idx를 세션에서 가져온다.
		String myIdx = (String) session.getAttribute("logOK");
		
		// 친구리스트 추가한 함수의 리턴값을 변수에 담는다.
		boolean updateCheck = friendListUpdate.insertFollows(idx, friendId, myIdx);

		// 성공할 경우
		if (updateCheck) {
			// 메인페이지로 이동하고 성공이라는 알림창이 뜬다.
			response.sendRedirect("main.jsp");
			out.println("<script> alert(\"성공\");</script>");
		} else {
			// 실패할 경우 이전 페이지로 이동한다.
			out.println("<script> alert(\"실패\"); history.go(-1); </script>");
		}

	}
}
