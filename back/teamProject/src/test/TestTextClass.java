package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.MemberDAO;

/**
 * Servlet implementation class TestTextClass
 */
@WebServlet("/TestTextClass")
public class TestTextClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TestTextClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String tage, userContent, reserved1, reserved2, image;

		int idx = 0;
		int c = 0;
		int uidx = 0;

		MemberDAO dao = new MemberDAO();

		idx = dao.getLastIdxBoard();
		userContent = request.getParameter("userContent");
		tage = request.getParameter("tage");

		c = dao.updateContent(userContent, tage, idx);

		System.out.println("test_userContent : " + userContent + "\ntest_tage : " + tage);

		Date create_date;
		create_date = dao.myDate();

		idx = dao.getLastIdxBoard() + 1;
		uidx = dao.getLastUidxBoard() + 1;

		// 이미지 넣는거
		MultipartRequest mr = new MultipartRequest(request,
				"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/back/teamProject/WebContent/imageBoard",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("image");
		System.out.println("사진 이름 : " + fileName);

		image = "/imageBoard/" + fileName;
		System.out.println("이미지 경로 : " + image);

		tage = "";
		userContent = "";

		reserved1 = "";
		reserved2 = "";

		System.out.println("idx : " + idx);
		System.out.println("uidx : " + uidx);

		c = dao.insertBoard(idx, uidx, tage, userContent, image, create_date, reserved1, reserved2);

		if (c > 0)
			response.sendRedirect("/boardUpload/boardReultScreen.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");
	}

}
