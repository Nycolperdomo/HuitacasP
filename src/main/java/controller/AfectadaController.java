package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.*;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class AfectadasController
 */
@WebServlet("/AfectadaController")
public class AfectadaController extends HttpServlet {

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

	afectadaVo aVo = new afectadaVo();
	afectadaDao aDao = new afectadaDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AfectadaController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		String accion = request.getParameter("accion");
		HttpSession session = request.getSession();
		System.out.println("Entr� al controlador" + accion);
		try {
			if (accion != null) {
				switch (accion) {

					case "abrirLogin":
						abrirLogin(request, response);
						System.out.print("Aqui esta el login");
						break;
					case "login":
						aVo.setCorreo(request.getParameter("correo"));
						aVo.setContrasena(request.getParameter("password"));
						try {
							aVo = aDao.validarUsuario(aVo.getCorreo(), aVo.getContrasena());
							if (aVo.isEstado() == true) {
								System.out.println("Se encontro un usuario activo");
								session.setAttribute("us", aVo);
								response.sendRedirect("AfectadaController?accion=page");

							} else if (aVo.isEstado() == false) {
								System.out.println("Se encontro un usuario inactivo");
								//para enviar un msm
								response.sendRedirect("AfectadaController?accion=abrirLogin&msn=Usuario Inactivo consulte con el administrador");
							} else {
								System.out.println("Se encontro no registrado");
								response.sendRedirect("AfectadaController?accion=abrirLogin&msn=Datos de acceso incorrectos");
							}
						} catch (Exception e) {
							System.out.println("Se presentó un error " + e);
						}
						break;

					case "logout":
						session.removeAttribute("us");
						session.invalidate();
						response.sendRedirect("AfectadaController?accion=abrirLogin&msn=Se ha cerrado la sesion");
						break;
					case "listar":
						listar(request, response);
						break;
					//case "abrirForm":
					//	System.out.println("entro a la accion abrirFormulario");
					//	abrirForm(request, response);
					//	break; ESTE ES EL ABRIR FORMULARIO DE AGREGAR UN USUARIO
					case "add":
						System.out.println("Entro al caso ADD" );
						add(request, response);
						break;
					case "abrirFormulario2":
						System.out.println("entro a la accion abrirFormulario");
						abrirFormulario2(request, response);
						break;
					case "delete":
						delete(request, response);
						break;
					case "ver":
						ver(request, response);
						break;
					case "edit":
						edit(request, response);
						break;
					case "changeEstado":
						changeEstado(request, response);
						break;case "verPerfil":
						verPerfil(request,response);
						break;
					case "openPass":
						openPass(request,response);
						break;
					case "changePass":
						changePass(request,response);
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
						page(request, response);
						break;
			/*case "abrirForm":
				abrirForm(request,response);
				break;
				
			case "add":
				add(request,response);
				break;
			;*/
					case "reporteAfectadas":
						reporteAfectadas(request, response);
						break;
					default:
						response.sendRedirect("login.jsp");
				}
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	private void reporteAfectadas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Crear objeto de tipo ServletOutputStream
		ServletOutputStream out = response.getOutputStream();
		try {
			//Declarar variables de im�genes y de reporte con sus rutas en webapp
			java.io.InputStream logo = this.getServletConfig()
					.getServletContext()
					.getResourceAsStream("reportes/img/logo.jpg");
			java.io.InputStream reporteAfectadas = this.getServletConfig()
					.getServletContext()
					.getResourceAsStream("reportes/AfectadaReport.jasper");
			//Validar que no vengan vacios
			if (logo != null && reporteAfectadas != null) {
				//Crear lista de la clase Vo para guardar resultado de la consulta
				List<afectadaVo> reporteAfectadas1 = new ArrayList<>();
				reporteAfectadas1 = aDao.listarReport();

				//Declarar variable tipo Jasper Reports asignando el reporte creado
				JasperReport report = (JasperReport) JRLoader.loadObject(reporteAfectadas);
				//Declarar variable ds para asignar el reporteUsuario1
				JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteAfectadas1.toArray());

				//Mapeamos los par�metros del Jasper reports
				Map<String, Object> parameters = new HashMap();
				parameters.put("ds", ds);
				parameters.put("logo", logo);
				//Formateamos la salida del reporte
				response.setContentType("application/pdf");
				//Para abrir el reporte en otra pesta�a
				response.addHeader("Content-disposition", "inline; filename=ReporteAfectadas.pdf");
				//Imprimimos el reporte
				JasperPrint jasperPrint = JasperFillManager.fillReport(report, parameters, ds);
				JasperExportManager.exportReportToPdfStream(jasperPrint, out);
				out.flush();
				out.close();
			} else {
				response.setContentType("text/plain");
				out.println("no se pudo generar el reporte");
				out.println("esto puede deberse a que la lista de datos no fue recibida o el "
						+ "archivo plantilla del reporte no se ha encontrado");
				out.println("contacte a soporte");
			}
		} catch (Exception e) {
			response.setContentType("text/plain");
			out.print("ocurri� un error al intentar generar el reporte:" + e.getMessage());
			e.printStackTrace();
		}
	}


	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Entramos al método listar");
		try {
			//(para que del modelo suba al controlador)
			List afect = aDao.listar();
			//(para que del controlador suba a una vista)
			request.setAttribute("afectadas", afect);
			request.getRequestDispatcher("views/afectada.jsp").forward(request, response);
			System.out.println("afectadas encontrados");

		} catch (Exception e) {
			System.out.println("afectadas no encontradods" + e.getMessage());
		} finally {
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
		System.out.println("Entramos al método borrar");
		if (request.getParameter("id") != null) {
			aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		}


		try {
			aDao.eliminar(aVo.getIDafectada());
			response.sendRedirect("AfectadaController?accion=listar");
			System.out.println("Afectada eliminado");
		} catch (Exception e) {

			System.out.println("Error al eliminar el formulario Afectada");
		}
	}

/*
private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		aVo.getAfecUs().setEstado(Boolean.parseBoolean(request.getParameter("estad")));
	
	
	try {
		aDao.changeEstado(aVo);
		
		response.sendRedirect("AfectadaController?accion=listar");
		System.out.println("afectada cambiada");
	}catch(Exception e) {
		
		System.out.println("Error al cambiar el estado de afectada");
	}
}

*/


	private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		afectadaDao udao = new afectadaDao();
		afectadaVo r = new afectadaVo();
		r.setIDafectada(Integer.parseInt(request.getParameter("id")));
		r.setEstado(Boolean.parseBoolean(request.getParameter("estad")));
		System.out.println("estad");

		try {
			//r dato que s guardo en el Vo (par de datos)
			udao.changeEstado(r);
			response.sendRedirect("AfectadaController?accion=listar");
			System.out.println("Afectada estado cambiado");
		} catch (Exception e) {

			System.out.println("Error al cambiar el estado de la afectada");
		}
	}

	private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entramos al metodo ver");
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		try {
			//(para que del modelo suba al controlador)
			aVo = aDao.consultaId(aVo.getIDafectada());
			//(para que del controlador suba a una vista)
			request.setAttribute("afectada", aVo);
			request.getRequestDispatcher("views/afectada-edit.jsp").forward(request, response);
			System.out.println("afectada encontrado");

		} catch (Exception e) {
			System.out.println("afectada no encontrado" + e.getMessage());
		} finally {
			//rdao=null;
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entramos al método editar");
		aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
		aVo.setNombre(request.getParameter("nombre"));
		aVo.setApellido(request.getParameter("apellido"));
		aVo.setCorreo(request.getParameter("correo"));
		aVo.setContrasena(request.getParameter("password"));
		aVo.setNumeroDocumento(request.getParameter("nuDocumento"));
		aVo.setFechaNacimiento(request.getParameter("fechaNa"));
		if (request.getParameter("id") != null && request.getParameter("correo") != null && request.getParameter("password") != null) {


		}
		aVo.setEstado(request.getParameter("chkEstado") != null);
		aVo.setCargo(request.getParameter("cargo"));
		//aVo.getAfecUs().setCorreo(request.getParameter("correo"));
		//aVo.getAfecUs().setContrase�a(request.getParameter("contrasena"));
		//aVo.getAfecUs().setCargo(request.getParameter("cargo"));

		try {
			aDao.edit(aVo);
			response.sendRedirect("AfectadaController?accion=listar");
			System.out.println("Afectada cambiado");
		} catch (Exception e) {

			System.out.println("Error al cambiar a afectada");
		}

	}

	private void abrirLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/loginNico.jsp").forward(request, response);
			System.out.println("Login abierto");
		} catch (Exception e) {

			System.out.println("Error al abrir el formulario Login" + e.getMessage());
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entramos al método agrgarADD");
			if (request.getParameter("nombre") != null) {
				aVo.setNombre(request.getParameter("nombre"));
			}
			if (request.getParameter("apellido") != null) {
				aVo.setApellido(request.getParameter("apellido"));
			}
			if (request.getParameter("correo") != null) {
			aVo.setCorreo(request.getParameter("correo"));
			if (request.getParameter("contrasena") != null) {
				aVo.setContrasena(request.getParameter("contrasena"));
			}
				if (request.getParameter("numeroDocumento") != null) {
					aVo.setNumeroDocumento(request.getParameter("numeroDocumento"));
				}
				if (request.getParameter("fechaNa") != null) {
					aVo.setFechaNacimiento(request.getParameter("fechaNa"));
				}
			aVo.setEstado(request.getParameter("chkEstado") != null);
			if (request.getParameter("cargo") != null) {
				aVo.setCargo(request.getParameter("cargo"));
			}

			String destinatario = request.getParameter("correo");
			String asunto = "Bienvenido A Huitacas";
			String cuerpo = "<h1> Gracias por registrarse en Huitacas </h1>"
					//+ r.getCorreo() +", " +r.getContrasena()
					+ " <img src ='https://harmonia.la/imagen_nota/feminismo.jpg?mrf-size=m'/>"
					+ " <h4> Para iniciar sesiòn </h4>"
					+ " <a href='http://localhost:8080/prac_war/AfectadaController?accion=abrirLogin'>Haga click aquì</a>";
			try {
				Configmail.enviarCorreo(host, puerto, remitente, password, destinatario, asunto, cuerpo);
				System.out.println("el mensaje fue enviado correctamwnte");
			} catch (Exception e) {
				System.out.println("el mensaje fue enviado correctamwnte" + e.getMessage());
			}
			try {
				aDao.registrar(aVo);
				response.sendRedirect("AfectadaController?accion=abrirLogin");
				System.out.println("Afectada registrada");
			} catch (Exception e) {

				System.out.println("Error al abrir el formulario regidtrar afec" + e.getMessage());
			}
		}
	}
//este formulario es el registar afectada desde el login
	private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			//para enviar a una vista particular
			request.getRequestDispatcher("views/jspaddAfectada.jsp").forward(request, response);
			System.out.println("Formulario afectada Abierto");
		} catch (Exception e) {
			System.out.println("Error al abrir el formulario afectada" + e.getMessage());

		}
	}
	//registro de a acfectada
	//este formulario es el registar afectada desde el login
	private void abrirFormulario2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//para enviar a una vista particular
			request.getRequestDispatcher("views/add-afectada.jsp").forward(request, response);
			System.out.println("Formulario Rol Abierto");
		} catch (Exception e) {
			System.out.println("Error al abrir el formulario");

		}

	}

	private void validarCorreo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=iso-8859-1");
		PrintWriter out=response.getWriter();
		System.out.println("Entramos al m�todo listar");

		try {
			int cant=aDao.validarCorreo(request.getParameter("correo"));
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
//ver correo antes de cambiar
	private void verPerfil(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changeCorreoA.jsp").forward(request, response);
			System.out.println("formulario cambio correo abierto");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario cambio contrase�a"+e.getMessage());
		}

	}

	private void changeCorreo (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
			aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
			aVo.setCorreo(request.getParameter("passnew"));
		}
		try {
			aDao.changeCorreo(aVo);
			request.getRequestDispatcher("AfectadaController?accion=logout").forward(request, response);
		}catch(Exception e) {
			System.out.println("error al cambiar password"+e.getMessage());
		}

	}
	private void openPass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			request.getRequestDispatcher("views/changePassA.jsp").forward(request, response);
			System.out.println("Cambio Password abierto");
		}catch(Exception e) {

			System.out.println("Error al abrir el formulario de cambio de password");
		}
	}


	private void changePass (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id")!=null && request.getParameter("passnew")!=null) {
			aVo.setIDafectada(Integer.parseInt(request.getParameter("id")));
			aVo.setContrasena(request.getParameter("passnew"));
		}
		try {
			aDao.changePassword(aVo);
			request.getRequestDispatcher("AfectadaController?accion=logout").forward(request, response);
		}catch(Exception e) {
			System.out.println("error al cambiar password"+e.getMessage());
		}

	}
	/*este formulario es el que abre el administrador y es donde agrega al profesional,pero segun yo este form ya debe ir en el otro servlet
	private void abrirForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//para enviar a una vista particular
			request.getRequestDispatcher("views/rol_Edit.jsp").forward(request, response);
			System.out.println("Formulario Rol Abierto");
		} catch (Exception e) {
			System.out.println("Error al abrir el formulario");

		}

	}

*/


}
