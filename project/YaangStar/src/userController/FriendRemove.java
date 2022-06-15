package userController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JdbcUtil;

/**
 * Servlet implementation class FriendRemove
 */
@WebServlet("/friendRemove")
public class FriendRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FriendRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		System.out.println(idx);
		Connection conn = null;
		PreparedStatement pstmt = null;
		conn = JdbcUtil.getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement("DELETE FROM friendTable where idx = " + idx);
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				response.sendRedirect("./myPage.jsp");
			} else {
				response.sendRedirect("./index.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
