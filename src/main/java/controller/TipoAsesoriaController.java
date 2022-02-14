package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.tipoAsesoriaDao;
import model.tipoAsesoriaVo;

/**
 * Servlet implementation class TipoAsesoriaController
 */
@WebServlet("/TipoAsesoriaController")
public class TipoAsesoriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	tipoAsesoriaDao tasdao=new tipoAsesoriaDao();
	
	tipoAsesoriaVo r = new tipoAsesoriaVo();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoAsesoriaController() {
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
		//HttpSession session = request.getSession();
		System.out.println("Entró al controlador"+accion);
		try {
			if(accion!=null) {
				switch (accion) {

				
				case "listartipoAsesoria": 
					System.out.println("entro a la accion listar");
					listartipoAsesoria(request,response);
					break;
				case "abrirForm":
					System.out.println("entro a la accion abrirFormulario");
					abrirForm(request,response);
					break;
				case "addA":
					System.out.println("entro a la accion aregar");
					addA(request,response);
					break;
				case "delete":
					delete(request,response);
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
private void listartipoAsesoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entramos al metodo listar");
		
		try {
			List tipoAsesoria=tasdao.listartipoAsesoria();
			request.setAttribute("asesorias",tipoAsesoria);
			request.getRequestDispatcher("views/Asesorias.jsp").forward(request, response);
			System.out.println("Tipo de asesoria encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Tipo de asesoria no encontrados "+e.getMessage());
		}
		finally {
			//udao=null;
		}
		
	}

private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-Asesorias.jsp").forward(request, response);
		System.out.println("Formulario Asesoria Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}
private void addA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("tipo") !=null) {
		r.setTipo(request.getParameter("tipo"));
	}

	try {
		tasdao.registrar(r);
		response.sendRedirect("TipoAsesoriaController?accion=listartipoAsesoria");
		System.out.println("Tipo de aseseoria registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario de tipo de asesoria");
	}
}
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		r.setIDasesoria(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		tasdao.eliminar(r.getIDasesoria());
		response.sendRedirect("TipoAsesoriaController?accion=listartipoAsesoria");
		System.out.println("Tipo de asesoria eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario tipo de asesoria");
	}
}
private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDasesoria(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		r=tasdao.consultaId(r.getIDasesoria());
		//(para que del controlador suba a una vista)
		request.setAttribute("asesorias", r);
		request.getRequestDispatcher("views/eddit-Asesorias.jsp").forward(request, response);
		System.out.println("Tipo de asesoria encontrado");
		
	} catch (Exception e) {
		System.out.println("Tipo de asesoria no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
}
private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//estos datos se miran desde la vista como tal en el name 
	System.out.println(request.getParameter("tipo"));
	r.setIDasesoria(Integer.parseInt(request.getParameter("id")));
	r.setTipo(request.getParameter("tipo"));
	
	
	
	if(request.getParameter("id")!=null && request.getParameter("tipo") !=null) {
		
	
	
	try {
		tasdao.edit(r);
		response.sendRedirect("TipoAsesoriaController?accion=listartipoAsesoria");
		System.out.println("Tipo de asesoria cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el tipo de asesoria");
	}
	}
}
}


