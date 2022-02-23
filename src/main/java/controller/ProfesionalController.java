package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UsuarioDao;
import model.UsuarioVo;
import model.cargoDao;
import model.cargoVo;
import model.profesionalDao;
import model.profesionalVo;

/**
 * Servlet implementation class ProfesionalController
 */
@WebServlet("/ProfesionalController")
public class ProfesionalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	profesionalVo pVo = new profesionalVo();
	profesionalDao pDao= new profesionalDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfesionalController() {
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

				case "abrirLogin":
					abrirLogin(request, response);
			case "listar":
				listar(request, response);
				break;
				
			case "abrirFormRegis":
				abrirFormRegis(request,response);
				break;

			case "delete":
				delete(request,response);
				break;
			/*case "add":
				add(request,response);
				break;
				case "edit":
					edit(request,response);
					break;*/
			case "changeEstado":
				changeEstado(request,response);
				break;

			case "ver":
				ver(request,response);
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
			List profes= pDao.listar();
			//(para que del controlador suba a una vista)
			request.setAttribute("profesional", profes);
			request.getRequestDispatcher("views/profesional.jsp").forward(request, response);
			System.out.println("profesionales encontrados");
			
		} catch (Exception e) {
			System.out.println("profesionales no encontradods"+e.getMessage());
		}
		finally {
			//rdao=null;
		}
		
	}



private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		request.getRequestDispatcher("views/add-profesional.jsp").forward(request, response);
		System.out.println("Formulario profesional Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario profesionall");
	
	}
		
}

/*

private void obtenerCargo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("Entramos al m�todo obtener cargos");
	cargoDao cdao=new cargoDao();
	List<cargoVo> cargo=null;
	
	try {
		cargo=cdao.listarCargos();
		request.setAttribute("cargos",cargo);
		
		System.out.println("cargoss encontrados");
		
		
	}catch(Exception e) {
		System.out.println("carfos no encontrados "+e.getMessage());
	}
	finally {
		//rdao=null;
	}
	
}
private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null && request.getParameter("apellido")!=null && request.getParameter("telefono") !=null
			&& request.getParameter("tipodoc") !=null
			&& request.getParameter("numdoc")!=null && request.getParameter("fechaNa")!=null && request.getParameter("correo")!=null
			) {
		pVo.setNombre(request.getParameter("nombre"));
		pVo.setApellido(request.getParameter("apellido"));
		pVo.setTelefono(request.getParameter("telefono"));
		pVo.setTipoDocumento(request.getParameter("tipodoc"));
		pVo.setNumeroDocumento(request.getParameter("numdoc"));
		pVo.setFechaNacimiento(request.getParameter("fechaNa"));
	
		
	}



private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null) {
		pVo.setNombre(request.getParameter("nombre"));
	}
	if(request.getParameter("apellido") !=null) {
		pVo.setApellido(request.getParameter("apellido"));
	}
	if(request.getParameter("telefono") !=null) {
		pVo.setTelefono(request.getParameter("telefono"));
	}

	if(request.getParameter("tipoDocumento") !=null) {
		pVo.setTipoDocumento(request.getParameter("tipoDocumento"));
	}

	if(request.getParameter("numeroDocumento") !=null) {
		pVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
	}

	if(request.getParameter("fechaNacimiento") !=null) {
		pVo.setFechaNacimiento(request.getParameter("fechaNacimiento"));
	}

	try {
		pDao.registrar(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional registrada");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario regidtrar profesional"+e.getMessage());
	}
}






private void obtenerUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("Entramos al m�todo obtener usuarios");
	UsuarioDao udao=new UsuarioDao();
	List<UsuarioVo> usu=null;
	
	try {
		usu=udao.listarRoles();
		request.setAttribute("usuarios",usu);
		
		System.out.println("Roles encontrados");
		
		
	}catch(Exception e) {
		System.out.println("Roles no encontrados "+e.getMessage());
	}
	finally {
		//rdao=null;
	}
	
}*/



/*private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("correo") !=null) {
		pVo.setCorreo(request.getParameter("correo"));
	}
	
	//if(request.getParameter("contrasena") !=null) {
		//pVo.setContrase�a(request.getParameter("contrasena"));
	//}
	
	try {
		pDao.registrar(pVo);
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("profesional registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario profesional");
	}
}

private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if(request.getParameter("id")!=null && request.getParameter("nombre") !=null && request.getParameter("apellido")!=null) {

		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
		pVo.setNombre(request.getParameter("nombre"));
		pVo.setApellido(request.getParameter("apellido"));
		pVo.setTelefono(request.getParameter("telefono"));
		pVo.setTipoDocumento(request.getParameter("tipoDocumento"));
		pVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
		pVo.setFechaNacimiento(request.getParameter("fechaNacimiento"));
	/*	pVo.getProUs().setCorreo(request.getParameter("correo"));
		pVo.getProUs().setContrase�a(request.getParameter("password"));
		pVo.getProUs().setCargo(request.getParameter("cargo"));

}

	try {
			pDao.edit(pVo);
			response.sendRedirect("ProfesionalController?accion=listar");
			System.out.println("Profesional cambiado");
			}catch(Exception e) {

			System.out.println("Error al cambiar el Profesional");
			}
			}

*/
private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		pDao.eliminar(pVo.getIDprofesional());
		response.sendRedirect("ProfesionalController?accion=listar");
		System.out.println("Profesional eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Profesional");
	}
}


private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UsuarioDao udao = new UsuarioDao();
	UsuarioVo r = new UsuarioVo();
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	r.setEstado(Boolean.parseBoolean(request.getParameter("estad")));
System.out.println("estad");

try {
	//r dato que s guardo en el Vo (par de datos)
	udao.changeEstado(r);
	response.sendRedirect("ProfesionalController?accion=listar");
	System.out.println("Rol cambiado");
}catch(Exception e) {
	
	System.out.println("Error al cambiar el estado del Rol");
}
}
private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		pVo=pDao.consultaId(pVo.getIDprofesional());
		//(para que del controlador suba a una vista)
		request.setAttribute("profesional", pVo);
		request.getRequestDispatcher("views/profesional-edit.jsp").forward(request, response);
		System.out.println("Profesional encontrado");
		
	} catch (Exception e) {
		System.out.println("Profesional no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	
	}


}
	
