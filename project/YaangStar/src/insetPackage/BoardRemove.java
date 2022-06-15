package insetPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.JdbcUtil;

/**
 * Servlet implementation class BoardRemove
 */
@WebServlet("/BoardRemove")
public class BoardRemove extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardRemove() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = Integer.parseInt(request.getParameter("idx"));
		PrintWriter out = response.getWriter();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = JdbcUtil.getConnection();
		int n = 0;
		try {
			pstmt = conn.prepareStatement("DELETE FROM boardtable where idx = " + idx);
			n = pstmt.executeUpdate();
			
			if(n > 0) {
				response.sendRedirect("./myPage.jsp");
			} else {
				response.sendRedirect("./myPage.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
