package insetPackage;

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

import dao.MemberDAO;

@WebServlet("/boardInsert")
public class BoardInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String image, tage, userContent, reserved1, reserved2;

		int idx;
		int uidx = 0;
		int c = 0;

		MemberDAO dao = new MemberDAO();
		Date create_date;
		create_date = dao.myDate();

		idx = dao.getLastIdxBoard() + 1;
		uidx = dao.getLastUidxBoard() + 1;

		/*
		 * 지정된 경로에 이미지 넣는거 지정된 경로 :
		 * C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/project/
		 * YaangStar/WebContent/resources/upload/imageBoard
		 */

		MultipartRequest mr = new MultipartRequest(request,
				"C:\\Users\\user\\Desktop\\2022_1st_project\\project\\YaangStar\\WebContent\\resources\\upload\\imageBoard",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		String fileName = mr.getFilesystemName("image");
		System.out.println("사진 이름 : " + fileName);

		image = "resources/upload/imageProfile/" + fileName;
		System.out.println("이미지 경로 : " + image);

		tage = request.getParameter("tage");
		userContent = request.getParameter("userContent");

		reserved1 = "";
		reserved2 = "";

		System.out.println("idx : " + idx);
		System.out.println("uidx : " + uidx);

		c = dao.insertBoard(idx, uidx, tage, userContent, image, create_date, reserved1, reserved2);

		if (c > 0)
			response.sendRedirect("index.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");

	}

}
