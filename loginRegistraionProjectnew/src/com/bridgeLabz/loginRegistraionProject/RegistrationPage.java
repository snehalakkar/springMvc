package com.bridgeLabz.loginRegistraionProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegistrationPage extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		PrintWriter pw = resp.getWriter();
		if (session != null) {
			if (session.getAttribute("UserId") != null) {
				RequestDispatcher requestDispatcher = req.getRequestDispatcher("reg.jsp");
				requestDispatcher.forward(req, resp);
			} else {
				pw.print("<html><body><a href='user_login'>session invalid ,login again....</a></body></html>");
				System.out.println("session logout ");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String First_Name = req.getParameter("fname");
		String Last_Name = req.getParameter("lname");
		String email = req.getParameter("email");
		String address = req.getParameter("add");
		String comp_name = req.getParameter("comp_name");
		System.out.println(comp_name);
		System.out.println(comp_name);
		String age = req.getParameter("age");
		String sal = req.getParameter("sal");
		String gender = req.getParameter("gender");
		String specialized = req.getParameter("specialize");
		System.out.println(specialized);
		String[] lang_known = req.getParameterValues("lang_known");
		System.out.println(lang_known);
		String str = Arrays.toString(lang_known);
		String str1=str.replace("[", "").replace("]", "");
		System.out.println(str1);

		/* String pass = req.getParameter("pass"); */
		String contact = req.getParameter("contact");
		// long contact1=Long.parseLong(contact);
		HttpSession session = req.getSession();
		int user_id = (int) session.getAttribute("UserId");
		System.out.println("user_id :" + user_id);
		Connection con = null;
		PreparedStatement pstmt = null;
		String qry = "insert into snehal_db.employee_details values(?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");
			pstmt = con.prepareStatement(qry);

			if (First_Name == null || (First_Name = htmlFilter(First_Name.trim())).length() == 0) {
				out.println("<p>firstName: MISSING</p>");
			} else {
				pstmt.setString(1, First_Name);
			}

			if (Last_Name == null || (Last_Name = htmlFilter(Last_Name.trim())).length() == 0) {
				out.println("<p>lastName: MISSING</p>");
			} else {
				pstmt.setString(2, Last_Name);
			}

			if (email != null) {
				String regex = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]+)";
				if (email.matches(regex)) {
					pstmt.setString(3, email);
				} else {
					out.println("<p>mail is incorrect</p>");
				}
			}

			if (address == null || (address = htmlFilter(address.trim())).length() == 0 || address.length() > 70) {
				out.println("<p>address: MISSING and it must be of 70 characters only </p>");
			} else {
				pstmt.setString(4, address);
			}

			if (comp_name == null || comp_name.length() == 0) {
				out.println("<p>comp_name: MISSING</p>");
			} else {
				pstmt.setString(5, comp_name);
			}

			if (age == null || age.length() == 0) {
				out.println("<p>Age: MISSING</p>");
			} else {
				int age1 = Integer.parseInt(age);
				if (age1 < 18 || age1 > 65) {
					out.println("<p>Age: MISSING and should be between 18 to 65</p>");
				} else {
					pstmt.setString(6, age);
				}
			}
			
			if (sal == null || sal.length() == 0) {
				out.println("<p>salary: MISSING</p>");
			} else {
				pstmt.setString(7, sal);
			}

			if (gender == null) {
				out.println("<p>Gender: MISSING</p>");
			} else {
				pstmt.setString(8, gender);
			}

			if (specialized.equalsIgnoreCase("Default")) {
				out.println("<p>specialization: select specialization</p>");
			} else {
				System.out.println("hii");
				pstmt.setString(9, specialized);
			}

			if (str1.equalsIgnoreCase("Default")) {
				out.println("<p>Languages: NONE</p>");
			} else {
				pstmt.setString(10, str);
			}

			if (contact == null || contact.length() != 10) {
				out.println("<p>contact: MISSING and should be of 10 digits only</p>");
			} else {
				pstmt.setString(11, contact);
			}

			pstmt.setInt(12, user_id);
			int n = pstmt.executeUpdate();
			if (n > 0) {
				System.out.println(" Employee Registration Successfull ");
				/*
				 * out.
				 * print("<html><body><h3 style=font-family:verdana;><em>Employee :"
				 * + First_Name +
				 * " added successfully </em> </h3></body></html>");
				 */
				RequestDispatcher rdq = req.getRequestDispatcher("details");
				rdq.forward(req, resp);
			} else {
				System.out.println("You have to registered again ...");
				resp.sendRedirect("reg.jsp");

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

	private String htmlFilter(String message) {
		if (message == null)
			return null;
		int len = message.length();
		StringBuffer result = new StringBuffer(len + 20);
		char aChar;

		for (int i = 0; i < len; ++i) {
			aChar = message.charAt(i);
			switch (aChar) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			default:
				result.append(aChar);
			}
		}
		return (result.toString());
	}
}