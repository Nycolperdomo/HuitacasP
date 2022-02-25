/*package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.RepaintManager;

import model.Configmail;
import model.UsuarioDao;
import model.UsuarioVo;
import model.UsuarioDao;

/**
 * Servlet implementation class RolController
 */
/*
@WebServlet("/RolController")
public class RolController extends HttpServlet {
	
	private String host;
	private String puerto;
	private String remitente;
	private String password;
	
	/*public void init() {
		ServletContext contexto=getServletContext();
		host=contexto.getInitParameter("host");
		puerto=contexto.getInitParameter("puerto");
		remitente=contexto.getInitParameter("remitente");
		password=contexto.getInitParameter("contexto");
	}*/
/*
	public void init() {
		ServletContext contexto=getServletContext();
		host=contexto.getInitParameter("host");
		puerto=contexto.getInitParameter("puerto");
		remitente=contexto.getInitParameter("remitente");
		password=contexto.getInitParameter("password");
	}
	
	private static final long serialVersionUID = 1L;

	UsuarioDao udao=new UsuarioDao();
	//UsuarioVo r=new UsuarioVo();
	UsuarioVo r = new UsuarioVo();
    /**
     * @see HttpServlet#HttpServlet()
     */
/*
    public RolController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
/*	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		String accion= request.getParameter("accion");
		HttpSession session = request.getSession();
		System.out.println("Entr� al controlador"+accion);
		try {
			if(accion!=null) {
				switch (accion) {

				case "abrirLogin":
					abrirLogin(request, response);
					break;
				case "login":
					r.setCorreo(request.getParameter("correo"));
					r.setContrasena(request.getParameter("password"));
					
					try {
						r=udao.validarUsuario(r.getCorreo(),r.getContrasena());
						if(r.isEstado()==true) {
							System.out.println("Se encontro un usuario activo");
							session.setAttribute("us", r);
							response.sendRedirect("RolController?accion=page");
							
						}
						else if(r.isEstado()==false){
							System.out.println("Se encontro un usuario inactivo");
							//para enviar un msm
							response.sendRedirect("RolController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
						}
						else {
							System.out.println("Se encontro no registrado");
							response.sendRedirect("RolController?accion=abrirLogin&msn=Datos de acceso incorrectos");
						}
					}catch(Exception e) {
						System.out.println("Se presentó un error "+e);
					}
					 
					
					break;
				case "logout":
					session.removeAttribute("us");
					session.invalidate();
					response.sendRedirect("RolController?accion=abrirLogin&msn=Se ha cerrado la sesion");
				break;
				case "listarRoles": 
					System.out.println("entro a la accion listar");
					listarRoles(request,response);
					break;
					
				case "abrirForm":
					System.out.println("entro a la accion abrirFormulario");
					abrirForm(request,response);
					break;
				case "addatos":
					addatos(request,response);
				break;
				case "add":
					System.out.println("entro a la accion aregar");
					add(request,response);
					break;
				case "abrirFormulario2":
					System.out.println("entro a la accion abrirFormulario");
					abrirFormulario2(request,response);
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
				case "abrirFormRegis":
					abrirFormRegis(request,response);
					break;
				case "validarCorreo":
					validarCorreo(request,response);
					break;
				case "page":
					page(request,response);
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
/*	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	
	//el metodo doGet y doPost nos sirven para procesar las peticiones
		//se comenta la segunda linea del do get (response.getwritter().appenes("seved at:"))...
	}

private void listarRoles(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Entramos al m�todo listar");
		
		try {
			List rol=udao.listarRoles();
			request.setAttribute("roles",rol);
			request.getRequestDispatcher("views/rol.jsp").forward(request, response);
			System.out.println("Roles encontrados");
			
			
		}catch(Exception e) {
			System.out.println("Roles no encontrados "+e.getMessage());
		}
		finally {
			//udao=null;
		}
		
	}

	//este formulario es el que abre el administrador y es donde agrega al profesional
private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/rol_Edit.jsp").forward(request, response);
		System.out.println("Formulario Rol Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
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
//add profesional registro aparte
private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/add-profesional.jsp").forward(request, response);
		System.out.println("Formulario Rol Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}
//registro de a acfectada
private void abrirFormulario2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try {
		//para enviar a una vista particular
		request.getRequestDispatcher("views/reg.jsp").forward(request, response);
		System.out.println("Formulario Rol Abierto");
	} catch (Exception e) {
		System.out.println("Error al abrir el formulario");
	
	}
		
}

private void addA(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("correo") !=null) {
		r.setCorreo(request.getParameter("correo"));
	}
	if(request.getParameter("contrasena") !=null) {
		r.setContrasena(request.getParameter("contrasena"));
	}

	r.setEstado(request.getParameter("chkEstado") != null);
	if(request.getParameter("cargo") !=null) {
		r.setCargo(request.getParameter("cargo"));
	}
	
	//String usuario=r.getCargo();
	
	String destinatario=request.getParameter("correo");
	String asunto="Bienvenido A Huitacas";
	String cuerpo="<h1> Gracias por registrarse en Huitacas </h1>"
			//+ r.getCorreo() +", " +r.getContrasena()
    		+ " <img src ='https://www.clinicaveterinariaanimalandia.com/images/clinica-veterinaria-animalandia-logo.png'/>"
    		+ " <h4> Para iniciar sesiòn </h4>"
    		+" <a href='http://localhost:8080/prac_war/RolController?accion=abrirLogin'>Haga click aquì</a>";
	try {
		Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
		System.out.println("el mensaje fue enviado correctamwnte");
	} catch (Exception e) {
		System.out.println("el mensaje fue enviado correctamwnte"+e.getMessage());
	}
	try {
		udao.registrar(r);
		response.sendRedirect("RolController?accion=abrirLogin");
		System.out.println("Rol registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Rol");
	}
}



private void addatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("nombre") !=null) {
		
		r.getProfesional().setNombre(request.getParameter("nombre"));
	}
	if(request.getParameter("contrasena") !=null) {
		r.setContrasena(request.getParameter("contrasena"));
	}

	r.setEstado(request.getParameter("chkEstado") != null);
	if(request.getParameter("cargo") !=null) {
		r.setCargo(request.getParameter("cargo"));
	}
	try {
		udao.registrar(r);
		response.sendRedirect("RolController?accion=abrirFormRegis");
		System.out.println("Rol registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Rol");
	}
}
VERDADEROOOOOOOOOOOOOOOOOOO

private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//dentro de la aplicacion el agregar
	if(request.getParameter("correo") !=null) {
		r.setCorreo(request.getParameter("correo"));
	}
	if(request.getParameter("contrasena") !=null) {
		r.setContrasena(request.getParameter("contrasena"));
	}

	r.setEstado(request.getParameter("chkEstado") != null);
	if(request.getParameter("cargo") !=null) {
		r.setCargo(request.getParameter("cargo"));
	}
	String destinatario=request.getParameter("correo");
	String asunto="Bienvenido A Huitacas";
	String cuerpo="<h1> Gracias por registrarse en Huitacas </h1>"
			+ r.getCorreo() +", " +r.getContrasena()
    		+ " <img src ='https://harmonia.la/imagen_nota/feminismo.jpg?mrf-size=m'/>"
    		+ " <h4> Para iniciar sesiòn </h4>"
    		+" <a href='http://localhost:8080/prac_war/RolController?accion=abrirLogin'>Haga click aquì</a>";
	try {
		Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
		System.out.println("el mensaje fue enviado correctamwnte");
	} catch (Exception e) {
		System.out.println("el mensaje fue enviado correctamwnte"+e.getMessage());
	}
	try {
		udao.registrarProf(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol registrado");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Rol");
	}
}
	

private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id") !=null) {
		r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	}
	
	
	try {
		udao.eliminar(r.getIDusuario());
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Rol eliminado");
	}catch(Exception e) {
		
		System.out.println("Error al eliminar el formulario Rol");
	}
}

private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	r.setEstado(Boolean.parseBoolean(request.getParameter("estad")));
System.out.println("estad");

try {
	//r dato que s guardo en el Vo (par de datos)
	udao.changeEstado(r);
	response.sendRedirect("RolController?accion=listarRoles");
	System.out.println("Rol cambiado");
}catch(Exception e) {
	
	System.out.println("Error al cambiar el estado del Rol");
}
}

private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	try {
		//(para que del modelo suba al controlador)
		r=udao.consultaId(r.getIDusuario());
		//(para que del controlador suba a una vista)
		request.setAttribute("roles", r);
		request.getRequestDispatcher("views/rol-eddit.jsp").forward(request, response);
		System.out.println("Usuario encontrado");
		
	} catch (Exception e) {
		System.out.println("Usuario no encontrado"+e.getMessage());
	}
	finally {
		//rdao=null;
		}
	
	}

private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//estos datos se miran desde la vista como tal en el name 
	System.out.println(request.getParameter("password"));
	r.setIDusuario(Integer.parseInt(request.getParameter("id")));
	r.setCorreo(request.getParameter("correo"));
	r.setContrasena(request.getParameter("password"));
	r.setCargo(request.getParameter("cargo"));
	
	if(request.getParameter("id")!=null && request.getParameter("correo") !=null && request.getParameter("password")!=null) {
		
		
	}
	r.setEstado(request.getParameter("chkEstado") != null);
	
	
	
	try {
		udao.edit(r);
		response.sendRedirect("RolController?accion=listarRoles");
		System.out.println("Usuario cambiado");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el Usuario");
	}
}
private void abrirLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
	request.getRequestDispatcher("views/loginNico.jsp").forward(request, response);
	System.out.println("Login abierto");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario Login" +e.getMessage());
	}

}

	private void openPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePass.jsp").forward(request, response);
			System.out.println("Cambio Password abierto");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}



private void changePass (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
		r.setIDusuario(Integer.parseInt(request.getParameter("id")));
		r.setContrasena(request.getParameter("passnew"));
	}
 try {
	udao.changePassword(r);
	request.getRequestDispatcher("RolController?accion=logout").forward(request, response);
 }catch(Exception e) {
	 System.out.println("error al cambiar password"+e.getMessage());
 }
	 
}


private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
	request.getRequestDispatcher("views/changeCorreo.jsp").forward(request, response);
	System.out.println("formulario cambio correo abierto");
	}catch(Exception e) {
		
		System.out.println("Error al abrir el formulario cambio contrase�a"+e.getMessage());
	}

}


private void changeCorreo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
		r.setIDusuario(Integer.parseInt(request.getParameter("id")));
		r.setCorreo(request.getParameter("passnew"));
	}
 try {
	udao.changeCorreo(r);
	request.getRequestDispatcher("RolController?accion=logout").forward(request, response);
 }catch(Exception e) {
	 System.out.println("error al cambiar password"+e.getMessage());
 }
	 
}
private void validarCorreo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html; charset=iso-8859-1");
	PrintWriter out=response.getWriter();
	System.out.println("Entramos al m�todo listar");
	
	try {
		int cant=udao.validarCorreo(request.getParameter("correo"));
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

}
*/