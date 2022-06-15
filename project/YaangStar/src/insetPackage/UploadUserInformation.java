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

@WebServlet("/UploadUser")
public class UploadUserInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UploadUserInformation() {
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

		String proFile, name_ = "", userNickname = "", userIntroduce = "", userMail = "", userPhoneNumber = "",
				userGender = "", userMajor = "", fileName = "", value, name_jsp;
		MemberDAO dao = new MemberDAO();

		String login_idx = (String) session.getAttribute("logOK");

		String idx = null;
		int c = 0;

		/* 로그인시 idx > 0 이기땜에 idx < 0 == 로그인 중 X */
		if (login_idx != null) {
			idx = login_idx;
		} else {
			out.println("<script> alert(\"로그인 상태가 아닙니다.\"); response.sendRedirect(\"login.jsp\"); </script>");
		}

		/*
		 * 지정된 경로에 이미지 넣는거 지정된 경로 :
		 * C:/Users/User/Desktop/TeamProject_1stSemester/2022_1st_project/project/
		 * YaangStar/WebContent/resources/upload/imageBoard
		 * 
		 * C:/Users/user/Documents/GitHub/2022_1st_project/project/YaangStar/WebContent/
		 * resources/upload/imageProfile
		 */

		String url = request.getRealPath(
				"./resources/upload/imageProfile/");
		url = request.getSession().getServletContext().getRealPath("resources/upload/imageProfile");
		mr = new MultipartRequest(request, url, 1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		/* 사진 이름 불러 오기 */
		fileName = mr.getFilesystemName("proFile_");

		if (fileName == null || fileName.equals("")) {
			proFile = dao.getMyData((String) session.getAttribute("logOK"), "userProfile");
		} else {
			proFile = "resources/upload/imageProfile/" + fileName;
		}

		Enumeration<String> params = mr.getParameterNames();

		while (params.hasMoreElements()) {
			name_jsp = (String) params.nextElement(); // jsp name 부분 가져오기
			value = mr.getParameter(name_jsp); // jsp name 부분의 내용 가져오기

			if (name_jsp.equals("name")) { // jsp 에서 content 의 내용 가져오기
				name_ = value;
			} else if (name_jsp.equals("userNickname")) { // jsp 에서 userTage 의 내용 가져오기
				userNickname = value;
			} else if (name_jsp.equals("userIntroduce")) { // jsp 에서 userTage 의 내용 가져오기
				userIntroduce = value;
			} else if (name_jsp.equals("userMail")) { // jsp 에서 userTage 의 내용 가져오기
				userMail = value;
			} else if (name_jsp.equals("userPhoneNumber")) { // jsp 에서 userTage 의 내용 가져오기
				userPhoneNumber = value;
			} else if (name_jsp.equals("userGender")) { // jsp 에서 userTage 의 내용 가져오기
				if (value.equals("he")) {
					userGender = "he";
				} else if (value.equals("she")) {
					userGender = "she";
				} else if (userMajor.equals("") || userMajor == null) {
					userGender = dao.getMyData((String) session.getAttribute("logOK"), "gender");
				}
			} else if (name_jsp.equals("userMajor")) { // jsp 에서 userTage 의 내용 가져오기
				if (value.equals("") || value.equals("선택")) {
					userMajor = dao.getMyData((String) session.getAttribute("logOK"), "major");
				} else {
					userMajor = value;
				}
			}
		}
		c = dao.updateUser(proFile, name_, userNickname, userIntroduce, userMail, userPhoneNumber, userGender,
				userMajor, idx);

		if (c > 0) {
			out.println("<script> alert(\"정보 수정됨\");</script>");
			response.sendRedirect("myPage.jsp");
		} else {
			out.print("버그");
			out.println("<script> alert(\"수정 실패\"); history.go(-1); </script>");
		}
	}
}
