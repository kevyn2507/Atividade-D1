package dao;
import model.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ComentarioDAO { 
	
	private Connection conexao;
	
	public ComentarioDAO() {
		this.conexao = ConnectionFactory.conectar();
	}
	public void cadastrar(Comentario comentario,int id) {
		
		String inserir = "INSERT INTO comentario "
				+ " (nome, texto,fk_noticia_id) "
				+ " VALUES (?, ?, ?) ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setString(1, comentario.getNome());
			pst.setString(2, comentario.getTexto());
			pst.setInt(3, id);
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
		}
	}
	public ArrayList<Comentario> listarComentarios() {
		
		String inserir = "SELECT * FROM comentario";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			ResultSet resultado = pst.executeQuery();
			
			ArrayList<Comentario> lista = new ArrayList<>();
			while (resultado.next()) {
				Comentario p = new Comentario();
				p.setId(Integer.parseInt((resultado.getString("id"))));
				p.setNome(resultado.getString("nome"));
				p.setTexto(resultado.getString("texto"));
				lista.add(p);
			}
			return lista;
 
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
			
			return null;
		}
	}
public void excluir(int id) {
		
		String inserir = "DELETE FROM comentario "
				+ " WHERE fk_noticia_id = ? ";
		
		try ( PreparedStatement pst = 
				conexao.prepareStatement(inserir) ) {
			
			pst.setInt(1, id);
			
			pst.execute();
			
		} catch (SQLException ex) {
			
			System.err.println("Não foi possível manipular "
					+ "a tabela Professor.");
			ex.printStackTrace();
		}
	}
}
