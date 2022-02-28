package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;

/**
 * Servlet implementation class ProfesionalController
 */
@WebServlet("/ProfesionalController")
public class ProfesionalController extends HttpServlet {
	private String host;
	private String puerto;
	private String remitente;
	private String password;

	public void init() {
		ServletContext contexto = getServletContext();
		host = contexto.getInitParameter("host");
		puerto = contexto.getInitParameter("puerto");
		remitente = contexto.getInitParameter("remitente");
		password = contexto.getInitParameter("password");
	}
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
		HttpSession session = request.getSession();
	//variable de sesion
	//HttpSession session= request.getSession();
	try {
		if (accion != null) {
			switch (accion) {

				case "abrirLogin":
					abrirLogin(request, response);
					break;
				case "login":
					pVo.setCorreo(request.getParameter("correo"));
					pVo.setContrasena(request.getParameter("password"));
					try {
						pVo = pDao.validarUsuario(pVo.getCorreo(), pVo.getContrasena());
						if (pVo.isEstado() == true) {
							System.out.println("Se encontro un usuario activo");
							session.setAttribute("us", pVo);
							response.sendRedirect("ProfesionalController?accion=page");

						} else if (pVo.isEstado() == false) {
							System.out.println("Se encontro un usuario inactivo");
							//para enviar un msm
							response.sendRedirect("ProfesionalController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
						} else {
							System.out.println("Se encontro no registrado");
							response.sendRedirect("AfectadaController?accion=abrirLogin&msn=Datos de acceso incorrectos");
						}
					} catch (Exception e) {
						System.out.println("Se presentó un error " + e);
					}
					break;
/*
				case "logout":
					session.removeAttribute("us");
					session.invalidate();
					response.sendRedirect("ProfesionalController?accion=abrirLogin&msn=Se ha cerrado la sesion");
					break;*/
				case "listar":
					listar(request, response);
					break;
				case "add":
					add(request,response);
					break;
				/*case "abrirFormulario2":
					System.out.println("entro a la accion abrirFormulario");
					abrirFormulario2(request, response);
					break;*/
				case "delete":
					delete(request,response);
					break;
				case "ver":
					ver(request,response);
					break;
				case "edit":
					edit(request,response);
					break;
				case "changeEstado":
					changeEstado(request,response);
					break;
					case "openPass":
						openPass(request,response);
						break;
					case "changePass":
						changePass(request,response);
						break;
					case "verPerfil":
						verPerfil(request,response);
						break;
					case "changeCorreo":
						changeCorreo(request,response);
						break;
					/*case "abrirFormRegis":
						abrirFormRegis(request,response);
						break;*/
				case "validarCorreo":
					validarCorreo(request,response);
					break;
				case "page":
					page(request, response);
					break;
				case "abrirFormRegis":
				abrirFormRegis(request,response);
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
	private void page(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//para enviar a una vista particular
			request.getRequestDispatcher("views/page.jsp").forward(request, response);
			System.out.println("pagina abierta");
		} catch (Exception e) {
			System.out.println("Error al abrir pagina");

		}
	}

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

		pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
		pVo.setEstado(Boolean.parseBoolean(request.getParameter("estad")));
		System.out.println("estad");
		try {
			pDao.changeEstado(pVo);
			response.sendRedirect("ProfesionalController?accion=listar");
			System.out.println("Profesional estado cambiado");
		} catch (Exception e) {
			System.out.println("Error al cambiar el estado de la Profesional");
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
private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
			pVo.setNombre(request.getParameter("nombre"));
			pVo.setApellido(request.getParameter("apellido"));
			pVo.setCorreo(request.getParameter("correo"));
			pVo.setContrasena(request.getParameter("password"));
			pVo.setNumeroDocumento(request.getParameter("nuDocumento"));
	if (request.getParameter("id") != null && request.getParameter("correo") != null && request.getParameter("password") != null) {


	}
	pVo.setEstado(request.getParameter("chkEstado") != null);
	pVo.setCargo(request.getParameter("cargo"));

	/*	pVo.getProUs().setCorreo(request.getParameter("correo"));
		pVo.getProUs().setContrase�a(request.getParameter("password"));
		pVo.getProUs().setCargo(request.getParameter("cargo"));
}*/
	try {
			pDao.edit(pVo);
			response.sendRedirect("ProfesionalController?accion=listar");
			System.out.println("Profesional cambiado");
			}catch(Exception e) {

			System.out.println("Error al cambiar el Profesional");
			}
			}

	private void abrirLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/loginProfesional.jsp").forward(request, response);
			System.out.println("Login abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario Login" + e.getMessage());
		}

	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("nombre") !=null) {
			pVo.setNombre(request.getParameter("nombre"));
		}
		if(request.getParameter("apellido") !=null) {
			pVo.setApellido(request.getParameter("apellido"));
		}
		if(request.getParameter("correo") !=null) {
			pVo.setCorreo(request.getParameter("correo"));
		}
		if(request.getParameter("contrasena") !=null) {
			pVo.setContrasena(request.getParameter("contrasena"));
		}
		if(request.getParameter("numeroDocumento") !=null) {
			pVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
		}
		pVo.setEstado(request.getParameter("chkEstado") != null);
		if (request.getParameter("cargo") != null) {
			pVo.setCargo(request.getParameter("cargo"));
		}

		String destinatario = request.getParameter("correo");
		String asunto = "Bienvenido A Huitacas";
		String cuerpo = "<h1> Gracias por registrarse en Huitacas </h1>"
				+ pVo.getCorreo() +", " +pVo.getContrasena()
				+ " <img src =''/>"
				+ " <h4> Para iniciar sesiòn </h4>"
				+ " <a href='https://harmonia.la/imagen_nota/feminismo.jpg?mrf-size=m'>Haga click aquì</a>";
		try {
			Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
			System.out.println("el mensaje fue enviado correctamwnte");
		} catch (Exception e) {
			System.out.println("el mensaje fue enviado correctamwnte" + e.getMessage());
		}
		try {
			pDao.registrar(pVo);
			response.sendRedirect("ProfesionalController?accion=listar");
			System.out.println("Profesional registrada");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario regidtrar profesional"+e.getMessage());
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
	private void validarCorreo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out=response.getWriter();
		System.out.println("Entramos al m�todo validar corr4eo");

		try {
			int cant=pDao.validarCorreo(request.getParameter("correo"));
			System.out.println("USUARIOS ENCONTRADOS"+cant);

			if(cant!=0) {
				System.out.println("El correo ya se encuentra registrado");
				out.println("El correo ya se encuentra registrado");
			}else {
				System.out.println("El correo no se encuentra registrado");
				out.println("El correo no se encuentra registrado puede continuar su registro");
			}
		}catch(Exception e) {
			System.out.println("correo no encontrado "+e.getMessage());
		}
		finally {
			//udao=null;
		}

	}
	private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changeCorreoP.jsp").forward(request, response);
			System.out.println("formulario cambio correo abierto");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario cambio contrase�a"+e.getMessage());
		}

	}


	private void changeCorreo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
			pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
			pVo.setCorreo(request.getParameter("passnew"));
		}
		try {
			pDao.changeCorreo(pVo);
			request.getRequestDispatcher("AfectadaController?accion=logout").forward(request, response);
		}catch(Exception e) {
			System.out.println("error al cambiar correo"+e.getMessage());
		}

	}private void openPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePassP.jsp").forward(request, response);
			System.out.println("Cambio Password abierto");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}


	private void changePass (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
			pVo.setIDprofesional(Integer.parseInt(request.getParameter("id")));
			pVo.setContrasena(request.getParameter("passnew"));
		}
		try {
			pDao.changePassword(pVo);
			request.getRequestDispatcher("AfectadaController?accion=logout").forward(request, response);
		}catch(Exception e) {
			System.out.println("error al cambiar password"+e.getMessage());
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


*/
}
	
