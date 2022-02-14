package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cargoDao;
import model.cargoVo;

/**
 * Servlet implementation class CargoController
 */
@WebServlet("/CargoController")
public class CargoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	cargoVo cVo = new cargoVo();
	cargoDao cDao = new cargoDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CargoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String accion= request.getParameter("accion");
		try {
			if(accion!=null) {
				switch (accion) {
				case "listar": 
					listar(request,response);
					break;
				default:
				  response.sendRedirect("login.jsp");
				}
			}
			else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println("error"+e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			List cargo= cDao.listar();
			request.setAttribute("cargo", cargo);
			request.getRequestDispatcher("views/cargo.jsp").forward(request, response);
			System.out.println("afectadas encontrados");
			
		} catch (Exception e) {
			System.out.println("afectadas no encontradods"+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}


}
