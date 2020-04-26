package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Noticia;
import service.NoticiaService;

@WebServlet("/CadastraNoticia.do")
public class CadastraNoticia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String descricao=request.getParameter("descricao");
		String titulo=request.getParameter("titulo");
		String texto=request.getParameter("texto");
		
		Noticia noticiacadastro = new Noticia();
		
		noticiacadastro.setId(id);
		noticiacadastro.setDescricao(descricao);
		noticiacadastro.setTitulo(titulo);
		noticiacadastro.setTexto(texto);
		
		NoticiaService noticiaservice = new NoticiaService();
		
		noticiaservice.cadastrar(noticiacadastro);
		
		response.sendRedirect("form-noticia.html");
	}

}
