package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UsuarioDao;
import model.UsuarioVo;

import model.casoDao;
import model.casoVo;
import model.miscasosDao;
import model.miscasosVo;
import model.tipoAbusoDao;
import model.tipoAbusoVo;
import model.tipoAsesoriaVo;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class CasoController
 */
@WebServlet("/MisCasosController")
public class MisCasosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	miscasosVo cVo = new miscasosVo();
	miscasosDao cDao = new miscasosDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MisCasosController() {
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
		//variable de sesion
		//HttpSession session= request.getSession();
		try {
			if (accion != null) {
				switch (accion) {
				

				case "listar":
					listar(request, response);
					break;
					
				case "abrirFormRegis":
					abrirFormRegis(request,response);
					break;

				
				case "add":
					add(request,response);
					break;
			

				case "ver":
					ver(request,response);
					break;
				case "edit":
					edit(request,response);
				break;

				default:
					response.sendRedirect("login.jsp");
				}
			}
			else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			
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
					//(para que del modelo suba al controlador)
					List cas= cDao.listar();
					//(para que del controlador suba a una vista)
					request.setAttribute("caso", cas);
					request.getRequestDispatcher("views/mycaso.jsp").forward(request, response);
					System.out.println("caso encontrados");
					
				} catch (Exception e) {
					System.out.println("casp no encontradods"+e.getMessage());
				}
				finally {
					//rdao=null;
				}
				
			}



		private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				request.getRequestDispatcher("views/add-mycasos.jsp").forward(request, response);
				System.out.println("Formulario MY caso Abierto");
			} catch (Exception e) {
				System.out.println("Error al abrir el formulario MYcaso");
			
			}
				
		}


		private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("Descripcion") !=null) {
				cVo.setDescripcion(request.getParameter("Descripcion"));
			}

			try {
				cDao.registrar(cVo);
				response.sendRedirect("MisCasosController?accion=listar");
				System.out.println("Mycaso registrado");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario regidtrar profesional"+e.getMessage());
			}
		}

private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	miscasosDao dao;
	miscasosVo vo;
	if(request.getParameter("id")!=null) {
		vo = new miscasosVo();
	vo.setIDmicaso(Integer.parseInt(request.getParameter("id")));
	dao = new miscasosDao();
	try {
		//(para que del modelo suba al controlador)
		vo=dao.consultaId(vo.getIDmicaso());
		//(para que del controlador suba a una vista)
		request.setAttribute("caso", vo);
		request.getRequestDispatcher("views/eddit-mycaso.jsp").forward(request, response);
		System.out.println("mycaso encontrado");
		
	} catch (Exception e) {
		System.out.println("my caso no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	}
}
		
	
		private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("id")!=null) {
				
				cVo.setIDmicaso(Integer.parseInt(request.getParameter("id")));
				cVo.setDescripcion(request.getParameter("Descripcion"));
				
			try {
				cDao.edit(cVo);
				response.sendRedirect("MisCasosController?accion=listar");
				System.out.println("MYCASO cambiado");
			}catch(Exception e) {
				
				System.out.println("Error al cambiar el MYCASO"+e.getMessage());
			}
		}

		}
}


