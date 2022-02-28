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

import model.*;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 * Servlet implementation class CasoController
 */
@WebServlet("/CasoController")
public class CasoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	casoVo cVo = new casoVo();
	casoDao cDao = new casoDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CasoController() {
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
                   /* case  "listarCaso":
                        listarCaso(request,response);
                        break;*/
				case "abrirFormRegis":
					abrirFormRegis(request,response);
					break;

					case "abrirFormRegistro":
						abrirFormRegistro(request,response);
						break;
				case "delete":
					delete(request,response);
					break;
				case "add":
					add(request,response);
					break;
				case "changeEstado":
					changeEstado(request,response);
					break;

				case "ver":
					ver(request,response);
					break;
				case "edit":
					edit(request,response);
				break;

				case "reporteCasos":
					reporteCasos(request,response);
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

	private void reporteCasos(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//Crear objeto de tipo ServletOutputStream
		ServletOutputStream out = response.getOutputStream();
        try {
        	//Declarar variables de im�genes y de reporte con sus rutas en webapp
            java.io.InputStream logo = this.getServletConfig()
                    .getServletContext()
                    .getResourceAsStream("reportes/img/logo.jpg");
			java.io.InputStream reporteCasos = this.getServletConfig()
                            .getServletContext()
                            .getResourceAsStream("reportes/rCas.jasper");
			//Validar que no vengan vacios
			if (logo != null && reporteCasos != null) {
                //Crear lista de la clase Vo para guardar resultado de la consulta
                List<casoVo> reporteCaso1 = new ArrayList<>();
                reporteCaso1= cDao.report() ;
                
                //Declarar variable tipo Jasper Reports asignando el reporte creado
                JasperReport report = (JasperReport) JRLoader.loadObject(reporteCasos);
                //Declarar variable ds para asignar el reporteUsuario1
                JRBeanArrayDataSource ds = new JRBeanArrayDataSource(reporteCaso1.toArray());
                
                //Mapeamos los par�metros del Jasper reports
                Map<String, Object> parameters = new HashMap();
                parameters.put("ds", ds);
                parameters.put("logo", logo);
                //Formateamos la salida del reporte
                response.setContentType("application/pdf");
                //Para abrir el reporte en otra pesta�a
                response.addHeader("Content-disposition", "inline; filename=ReporteCasos.pdf");
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
					request.getRequestDispatcher("views/caso.jsp").forward(request, response);
					System.out.println("caso encontrados");
					
				} catch (Exception e) {
					System.out.println("casoooo no encontrado"+e.getMessage());
				}
				finally {
					//rdao=null;
				}
				
			}
    private void listarCaso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	profesionalDao adao = new profesionalDao();
	List<profesionalVo> profesional=null;
        try {
            //(para que del modelo suba al controlador)
			profesional= adao.listar();
            //(para que del controlador suba a una vista)
            request.setAttribute("prof"	,profesional);
            request.getRequestDispatcher("views/add-caso.jsp").forward(request, response);
            System.out.println("caso encontrados");

        } catch (Exception e) {
            System.out.println("casoooo no encontrado"+e.getMessage());
        }
        finally {
            //rdao=null;
        }

    }



	private void abrirFormRegis(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.listarCaso(request,response);
			request.getRequestDispatcher("views/add-caso.jsp").forward(request, response);
			System.out.println("Formulario caso Abierto");
		} catch (Exception e) {
			System.out.println("Error al abrir el formulario caso");

		}

	}
	private void abrirFormRegistro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.listarCaso(request,response);
			request.getRequestDispatcher("views/add-caso2.jsp").forward(request, response);
			System.out.println("Formulario caso Abierto");
		} catch (Exception e) {
			System.out.println("Error al abrir el formulario caso");

		}

	}

		private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("fechaInicio") !=null && request.getParameter("fechaFin")!=null) {
				cVo.setTipoAbuso(request.getParameter("tipoAbuso"));
				cVo.setTipoAsesoria(request.getParameter("tipoAsesoria"));
				cVo.setFechaInicio(request.getParameter("fechaInicio"));
				cVo.setFechaFin(request.getParameter("fechaFin"));
				cVo.setUrlDocumento(request.getParameter("documneto"));
				//cVo.setEstado(request.getParameter("chkEstado") != null);
				if(request.getParameter("chkEstado") !=null){
					cVo.setEstado(true);
				}
				else {
					cVo.setEstado(false);
				}
				afectadaVo a = new afectadaVo();
				a.setIDafectada(Integer.parseInt(request.getParameter("afecas")));
				profesionalVo p = new profesionalVo();
				p.setIDprofesional(Integer.parseInt(request.getParameter("procaso")));

				cVo.setAfeCas(a);
				cVo.setProfCaso(p);

			}
			/*tipoAsesoriaVo t = new tipoAsesoriaVo(); 
			
				t.setIDasesoria(Integer.parseInt(request.getParameter("asesoria")));
				cVo.setAseCas(t);
			*/
			try {
				cDao.registrar(cVo);
				response.sendRedirect("CasoController?accion=page");
				System.out.println("caso registrado");
			}catch(Exception e) {
				
				System.out.println("Error al abrir el formulario regidtrar profesional"+e.getMessage());
			}
		}

		private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("id") !=null) {
				cVo.setIDcaso(Integer.parseInt(request.getParameter("id")));
			}
			try {
				cDao.eliminar(cVo.getIDcaso());
				response.sendRedirect("CasoController?accion=listar");
				System.out.println("Cadso eliminado");
			}catch(Exception e) {
				
				System.out.println("Error al eliminar el formulario caso");
			}
		}


		private void changeEstado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//casoDao udao = new casoDao();
			//casoVo r = new casoVo();
			cVo.setIDcaso(Integer.parseInt(request.getParameter("id")));
			cVo.setEstado(Boolean.parseBoolean(request.getParameter("estad")));
		System.out.println("estad");
		try {
			//r dato que s guardo en el Vo (par de datos)
			cDao.changeEstado(cVo);
			response.sendRedirect("CasoController?accion=listar");
			System.out.println("caso cambiado");
		}catch(Exception e) {
			
			System.out.println("Error al cambiar el estado del caso");
		}
		}
		
		
		private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			cVo.setIDcaso(Integer.parseInt(request.getParameter("id")));
			try {
				//(para que del modelo suba al controlador)
				cVo=cDao.consultaId(cVo.getIDcaso());
				//(para que del controlador suba a una vista)
				request.setAttribute("caso", cVo);
				request.getRequestDispatcher("views/caso-edit.jsp").forward(request, response);
				System.out.println("caso encontrado");
				
			} catch (Exception e) {
				System.out.println("caso no encontrado"+e.getMessage());
			}
			finally {
				//rdao=null;
				}
			}
		private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			if(request.getParameter("id")!=null && request.getParameter("fechaInicio") !=null && request.getParameter("fechaFin")!=null) {
				
				cVo.setIDcaso(Integer.parseInt(request.getParameter("id")));
				cVo.setTipoAbuso(request.getParameter("tipoAbuso"));
				cVo.setTipoAsesoria(request.getParameter("tipoAsesoria"));
				cVo.setFechaInicio(request.getParameter("fechaInicio"));
				cVo.setFechaFin(request.getParameter("fechaFin"));
				//cVo.setUrlDocumento(request.getParameter("urlDocumento"));
				cVo.setEstado(request.getParameter("chkEstado") != null);
				//afectadaVo a = new afectadaVo();
				//a.setIDafectada(Integer.parseInt(request.getParameter("afecas")));
				//profesionalVo p = new profesionalVo();
				//p.setIDprofesional(Integer.parseInt(request.getParameter("procaso")));

				//cVo.setAfeCas(a);
				//cVo.setProfCaso(p);
			}
			try {
				cDao.edit(cVo);
				response.sendRedirect("CasoController?accion=listar");
				System.out.println("CASO cambiado");
			}catch(Exception e) {
				
				System.out.println("Error al cambiar el CASO"+e.getMessage());
			}
		}

	}


