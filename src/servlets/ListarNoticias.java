package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Noticia;
import service.NoticiaService;

@WebServlet("/ListarNoticias.do")
public class ListarNoticias extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarNoticias() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		NoticiaService noticiaService = new NoticiaService();
		ArrayList<Noticia> lista = noticiaService.listarNoticias();
		PrintWriter saida = response.getWriter();
		
		lista.forEach(p->{
			saida.println("<h3>Descrição</h3>"+p.getDescricao()+"<br>");
			saida.println("<h3>Titulo</h3>"+p.getTitulo()+"<br>");
			saida.println("<h3>Texto</h3>"+p.getTexto()+"<br><hr>");
		});
		saida.println("<form action=\"index.html\">\n" + 
				"    <input type=\"submit\" value=\"Inicio\" />\n" + 
				"</form>");
	}

}
