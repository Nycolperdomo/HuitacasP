package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
@MultipartConfig
@WebServlet("/MisCasosController")
public class MisCasosController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private String pathFiles = "C:\\prac\\src\\main\\webapp\\files";
    private File uploads = new File(pathFiles);
    private String[] extensiones = {".pdf", ".rar", ".zip"};
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
        String accion = request.getParameter("accion");
        //variable de sesion
        //HttpSession session= request.getSession();
        try {
            if (accion != null) {
                switch (accion) {


                    case "listar":
                        listar(request, response);
                        break;

                    case "abrirFormRegis":
                        abrirFormRegis(request, response);
                        break;


                    case "add":
                        add(request, response);
                        break;


                    case "ver":
                        ver(request, response);
                        break;
                    case "edit":
                        edit(request, response);
                        break;
                    case "addDocumentCase":
                        saveDocument(request, response);
                        break;

                    default:
                        response.sendRedirect("login.jsp");
                }
            } else {
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

    private void saveDocument(HttpServletRequest req, HttpServletResponse res) throws IOException {
        documentoDao daodocumentos = new documentoDao();
        try {

            String name = req.getParameter("nombre");
            Part part = req.getPart("documento");
            String descripcion =req.getParameter("descripcion");

            if (part == null) {
                System.out.println("No ha seleccionado un archivo");
                return;
            }

            if (isExtension(part.getSubmittedFileName(), extensiones)) {
                String photo = saveFile(part, uploads);
                documentoVo docs = new documentoVo (name, photo, descripcion);
                daodocumentos.addArchivos(docs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        res.sendRedirect("RolController?accion=page");
    }


    private String saveFile(Part part, File pathUploads) {
        String pathAbsolute = "";

        try {
            Path path = Paths.get(part.getSubmittedFileName());
            String fileName = path.getFileName().toString();
            InputStream input = part.getInputStream();

            if (input != null) {
                File file = new File(pathUploads, fileName);
                pathAbsolute = file.getAbsolutePath();
                Files.copy(input, file.toPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pathAbsolute;
    }

    private boolean isExtension(String fileName, String[] extensiones) {
        for (String et : extensiones) {
            if (fileName.toLowerCase().endsWith(et)) {
                return true;
            }
        }
        return false;
    }


    private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //(para que del modelo suba al controlador)
            List cas = cDao.listar();
            //(para que del controlador suba a una vista)
            request.setAttribute("caso", cas);
            request.getRequestDispatcher("views/mycaso.jsp").forward(request, response);
            System.out.println("caso encontrados");

        } catch (Exception e) {
            System.out.println("casp no encontradods" + e.getMessage());
        } finally {
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

        if (request.getParameter("descripcion") != null) {
            cVo.setDescripcion(request.getParameter("descripcion"));
        }

        try {
            cDao.registrar(cVo);
            response.sendRedirect(" RolController?accion=page");
            System.out.println("Mycaso registrado");
        } catch (Exception e) {

            System.out.println("Error al abrir el formulario regidtrar profesional" + e.getMessage());
        }
    }

    private void ver(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        miscasosDao dao;
        miscasosVo caso;
        if (request.getParameter("id") != null) {
            caso = new miscasosVo();
            dao = new miscasosDao();
            caso.setIDmicaso(Integer.parseInt(request.getParameter("id")));

            try {
                //(para que del modelo suba al controlador)
                caso = dao.consultaId(cVo.getIDmicaso());
                //(para que del controlador suba a una vista)
                request.setAttribute("caso", caso);
                request.getRequestDispatcher("views/eddit-mycaso.jsp").forward(request, response);
                System.out.println("mycaso encontrado");

            } catch (Exception e) {
                System.out.println("my caso no encontrado" + e.getMessage());
            } finally {
                //rdao=null;
            }
        }
    }


    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        cVo.setIDmicaso(Integer.parseInt(request.getParameter("id")));
        cVo.setDescripcion(request.getParameter("Descripcion"));
        if (request.getParameter("id") != null && request.getParameter("Descripcion") != null) {


            try {
                cDao.edit(cVo);
                response.sendRedirect("MisCasosController?accion=listar");
                System.out.println("MYCASO cambiado");
            } catch (Exception e) {

                System.out.println("Error al cambiar el MYCASO" + e.getMessage());
            }
        }

    }
}


