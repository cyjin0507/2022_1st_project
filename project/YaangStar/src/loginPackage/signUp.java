package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signUp() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		int idx = 0;
		String userId, userPassword, userName, nickname, major, gender, reserved1, reserved2, userProfile, mail,
				phoneNumber, introduce;
		MemberDAO dao = new MemberDAO();
		int c = 0;
		idx = dao.getLastIdxUser() + 1;
		userId = request.getParameter("userId");
		userPassword = request.getParameter("userPassword");
		userName = request.getParameter("userName");
		nickname = request.getParameter("nickname");
		major = request.getParameter("major");
		gender = request.getParameter("gender");
		phoneNumber = "";
		mail = "";
		introduce = "야앙스타 신규 회원";
		reserved1 = "";
		reserved2 = "";
		userProfile = "resources/upload/imageProfile/defaultProfile.jpeg";

		c = dao.insertUser(idx, userId, userPassword, userName, nickname, major, gender, reserved1, reserved2,
				userProfile, introduce, phoneNumber, mail);

		if (c > 0)
			response.sendRedirect("login.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");

	}

}
