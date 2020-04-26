package service;

import java.util.ArrayList;

import dao.ComentarioDAO;
import model.Comentario;

public class ComentarioService {
	
	private ComentarioDAO comentarioDAO;
	
	public ComentarioService()
	{
		comentarioDAO = new ComentarioDAO();
	}
	public void cadastrar(Comentario comentario,int id)
	{
		comentarioDAO.cadastrar(comentario,id);
	}
	public ArrayList<Comentario> listarComentarios()
	{
		return comentarioDAO.listarComentarios();
	}
	public void Excluir(int id)
	{
		comentarioDAO.excluir(id);
	}
}
