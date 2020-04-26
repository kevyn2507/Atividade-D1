package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Comentario;
import model.Noticia;
import service.ComentarioService;
import service.NoticiaService;

/**
 * Servlet implementation class ListarNoticia
 */
@WebServlet("/ConsultarNoticia.do")
public class ConsultarNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarNoticia() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		
		NoticiaService consultaservice = new NoticiaService();
		
		Noticia n = consultaservice.consulta(id);
		
		response.setContentType("text/html");
		
		PrintWriter saida = response.getWriter();
		
		saida.println("RealNews<br><hr>");
		saida.println("ID da Noticia #"+n.getId()+"<br>");
		saida.println("<h1>"+n.getDescricao()+"</h1>");
		saida.println("<h2>"+n.getTitulo()+"</h2>");
		saida.println("<h5>"+n.getTexto()+"</h5>");
		saida.println("<br><hr><hr>");
		
		saida.println("<br><h5>Comentarios</h5>");
		
		ComentarioService comentarioService = new ComentarioService();
		ArrayList<Comentario> lista = comentarioService.listarComentarios();
		
		lista.forEach(p->{
			saida.println(p.getNome()+"<br>");
			saida.println(p.getTexto()+"<br><hr>");
		});
		
		saida.print("Adicionar Comentario<br>");
		saida.println("<form method=\"post\" action=\"CadastraComentario.do\">" + 
				"	<h5>Nome:<input type=\"text\" name=\"nome\"></h5>" + 
				"	<h5>Texto:<br><textarea name=\"texto\"></textarea>" + 
				"<input type=\"submit\" >\n" + 
				"</form>");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("id_noticia", n.getId());
	}

}
