package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import service.ComentarioService;

@WebServlet("/CadastraComentario.do")
public class CadastraComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastraComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome=request.getParameter("nome");
		String texto=request.getParameter("texto");
		
		Comentario comentariocadastro = new Comentario();
		
		comentariocadastro.setNome(nome);
		comentariocadastro.setTexto(texto);
		
		HttpSession session=request.getSession();
		int id_noticia = (Integer) session.getAttribute("id_noticia");
		
		ComentarioService comentarioservice = new ComentarioService();
		
		comentarioservice.cadastrar(comentariocadastro,id_noticia);
		
		response.sendRedirect("form-consulta.html");
	}

}
