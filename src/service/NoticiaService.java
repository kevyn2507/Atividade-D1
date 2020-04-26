package service;

import java.util.ArrayList;

import dao.NoticiaDAO;
import model.Noticia;

public class NoticiaService {
	
	private NoticiaDAO noticiaDAO;
	
	public NoticiaService()
	{
		noticiaDAO = new NoticiaDAO();
	}
	public void cadastrar(Noticia noticia)
	{
		noticiaDAO.cadastrar(noticia);
		System.out.println("Noticia Cadastrada!");
	}
	public Noticia consulta(int id)
	{
		Noticia n=noticiaDAO.consultar(id);
		return n;
	}
	public void Excluir(int id)
	{
		noticiaDAO.excluir(id);
		System.out.println("Noticia Excluida!");
	}
	public void Atualizar(Noticia noticia)
	{
		if(noticia.getId()>0)
		{
		noticiaDAO.alterar(noticia);
		}
		else
		{
			System.out.println("Numero digitado invalido");
		}
	}
	public ArrayList<Noticia> listarNoticias()
	{
		return noticiaDAO.listarnoticias();
	}
}
