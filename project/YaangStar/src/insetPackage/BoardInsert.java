package insetPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		MultipartRequest mr;
		HttpSession session = request.getSession();
		
		String image, tage = null, userContent = null, reserved1, reserved2, name, value;
		int idx;
		String uidx;
		int c = 0;

		MemberDAO dao = new MemberDAO();
		Date create_date;
		create_date = dao.myDate();

		idx = dao.getLastIdxBoard() + 1;
		uidx = (String) session.getAttribute("logOK");
		
		/*
		 * userContent = request.getParameter("content"); tage =
		 * request.getParameter("tage");
		 */

		/*
		 * 지정된 경로에 이미지 넣는거 지정된 경로 :
		 * C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/project/
		 * YaangStar/WebContent/resources/upload/imageBoard
		 * 
		 * C:\\Users\\user\\Desktop\\2022_1st_project\\project\\YaangStar\\WebContent\\
		 * resources\\upload\\imageBoard 이 경로 버그남
		 */

		mr = new MultipartRequest(request,
				"C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/project/YaangStar/WebContent/resources/upload/imageBoard",
				1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());

		/* 사진 이름 불러 오기 */
		String fileName = mr.getFilesystemName("image");
		System.out.println("사진 이름 : " + fileName);

		image = "resources/upload/imageBoard/" + fileName;
		System.out.println("이미지 경로 : " + image);

		Enumeration<String> params = mr.getParameterNames();

		while (params.hasMoreElements()) {
			name = (String) params.nextElement(); // jsp name 부분 가져오기
			value = mr.getParameter(name); // jsp name 부분의 내용 가져오기
			if (name.equals("content")) { // jsp 에서 content 의 내용 가져오기
				userContent = value;
			} else if (name.equals("userTage")) { // jsp 에서 userTage 의 내용 가져오기
				tage = value;
			}
		}

		reserved1 = "";
		reserved2 = "";

		System.out.println("tage : " + tage);
		System.out.println("userContent : " + userContent);
		System.out.println("idx : " + idx);
		System.out.println("uidx : " + uidx);

		if (!tage.equals(null) || !userContent.equals(null)) {
			c = dao.insertBoard(idx, uidx, tage, userContent, image, create_date, reserved1, reserved2);
		} else {
			System.out.println("버그_배고파...\n게시글 올리는거 버그");
		}
		if (c > 0)
			response.sendRedirect("main.jsp");
		else
			out.print("버그");
		out.print("<script> History.back() </script>");

	}

}
