package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class ExcluirNoticia
 */
@WebServlet("/ExcluirNoticia.do")
public class ExcluirNoticiaEComent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirNoticiaEComent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("id"));
		
		NoticiaService exclusaonoticia = new NoticiaService();
		
		ComentarioService exclusaocomentario = new ComentarioService();
		
		exclusaocomentario.Excluir(id);
		exclusaonoticia.Excluir(id);
		
		response.sendRedirect("form-exclusao.html");
	}

}
