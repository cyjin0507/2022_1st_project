package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JdbcUtil;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		String id = request.getParameter("userId");
		String password = request.getParameter("userPassword");
		try {
			Connection conn = JdbcUtil.getConnection();

			Statement stmt = conn.createStatement();
			ResultSet rs;

			// 최근에 넣은 idx 값 가져 오기
			rs = stmt.executeQuery("SELECT * FROM usertable where userId ='" + id + "'and userPassword = '" + password + "'");

			while (rs.next()) {
				if(rs.getString("idx") != null) {
					String idx = rs.getString("idx");
					session.setAttribute("logOK", idx);
					response.sendRedirect("index.jsp");
					break; 
				}
			} if(!rs.next()) {
				out.println("<script> alert(\"로그인에 실패하였습니다.\"); history.go(-1); </script>");
			}

			conn.close();

		} catch (Exception e) {
		}

	}
}
