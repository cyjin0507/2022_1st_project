package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
//매핑
@WebServlet("/signUp")
public class signUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signUp() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//한글 설정
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		int idx = 0;
		String userId, userPassword, userName, nickname, major, gender, reserved1, reserved2, userProfile, mail,
				phoneNumber, introduce; //회원정보 가져오기
		MemberDAO dao = new MemberDAO();
		int c = 0;
		idx = dao.getLastIdxUser() + 1;
		userId = request.getParameter("userId"); //유저 ID 가져오기
		userPassword = request.getParameter("userPassword"); //유저 userPassword 가져오기
		userName = request.getParameter("userName"); //유저 userName 가져오기
		nickname = request.getParameter("nickname"); //유저 nickname 가져오기
		major = request.getParameter("major"); //유저 major 가져오기
		gender = request.getParameter("gender"); //유저 gender 가져오기
		phoneNumber = ""; // 사용자가 입력
		mail = ""; // 사용자가 입력
		introduce = "야앙스타 신규 회원"; 
		reserved1 = "";
		reserved2 = "";
		//프로필
		userProfile = "resources/upload/imageProfile/defaultProfile.jpeg"; //이미지 불러오기
		// 
		c = dao.insertUser(idx, userId, userPassword, userName, nickname, major, gender, reserved1, reserved2,
				userProfile, introduce, phoneNumber, mail);

		if (c > 0)
			response.sendRedirect("login.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");

	}

}
