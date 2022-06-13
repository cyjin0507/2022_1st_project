package comment;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

@WebServlet("/commentInsert")
public class CommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CommentInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String idx = null;
		String uidx = null;
		String bidx = request.getParameter("bidx");
		int s = 0;

		String commentContent, reserved1, reserved2;
		MemberDAO dao = new MemberDAO();
		Date create_date;
		create_date = dao.myDate();
		HttpSession session = request.getSession();

		idx = dao.getLastIdxComment() + 1 + "";
		uidx = (String) session.getAttribute("logOK");

		System.out.println("board_idx_insert : " + bidx);

		commentContent = request.getParameter("commentContent");
		reserved1 = "";
		reserved2 = "";
		System.out.println("commentContent : " + commentContent);
		
		s = dao.insertComment(idx, uidx, bidx, commentContent, create_date, reserved1, reserved2);

		if (s > 0) {
			response.sendRedirect("main.jsp");
			out.println("<script> alert(\"댓글 작성 성공\");</script>");
		}else
			out.print("버그");
		out.println("<script> alert(\"내용을 입력해주세요\"); history.go(-1); </script>");
	}

}
