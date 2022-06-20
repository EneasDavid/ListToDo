package TodoList.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

import TodoList.Entity.*;

/**
 * Servlet implementation class ToDoServlet
 */
@WebServlet("/ToDoServlet")
public class ToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    List <AFazeres> agenda=new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		var direcionador=request.getParameter("direcionador");
		if(direcionador.equals("listar")) {
			request.setAttribute("eventos", this.agenda); 
			request.getRequestDispatcher("WEB-INF/visualizacao/Listar.jsp").forward(request,response);
			return;
		}
		if(direcionador.equals("editar")) {
			request.setAttribute("eventos",getByID(Integer.parseInt(request.getParameter("id"))));
			request.getRequestDispatcher("WEB-INF/visualizacao/Atualizacao.jsp").forward(request,response);
			return;
		}
		if(direcionador.equals("concluido")) {
			this.removerEvento(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("eventos", this.agenda);
			request.getRequestDispatcher("WEB-INF/visualizacao/Listar.jsp").forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		var atividade=request.getParameter("atividade");
		var horario=request.getParameter("horario");
		
		if(request.getParameter("id")==null) {
			AFazeres cadastro=new AFazeres(getIndex(),atividade,horario);
			agenda.add(cadastro);
			response.sendRedirect("http://localhost:8080/TodoList/ToDoServlet?direcionador=listar");
		}
		else {
			var idProduto=Integer.parseInt(request.getParameter("id"));
			AFazeres atualizacao=new AFazeres(idProduto,atividade,horario);
			this.atualizarEvento(atualizacao);
			response.sendRedirect("http://localhost:8080/TodoList/ToDoServlet?direcionador=listar");
		}
		System.out.println(agenda.toString());
	}
//Metodos
	
	public int getIndex() {
		return this.agenda.size()+1;
	}

	private AFazeres getByID (int id) {
		for (AFazeres evento: agenda) {
			//Percorre todo o array
			if(evento.getPosicao()==id) {
				return evento;
			}
		}
		return null;
	}
	private void atualizarEvento (AFazeres evento) {
		var posicao = this.agenda.indexOf(getByID(evento.getPosicao()));
		this.agenda.set(posicao,evento);
	}
		
	private void removerEvento (int id) {
		this.agenda.remove(getByID(id));
	}
}
