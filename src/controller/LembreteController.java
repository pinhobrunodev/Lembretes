package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.LembreteBeans;
import dao.LembreteDAO;

// TODO

@WebServlet(urlPatterns = { "/LembreteController", "/insert", "/main", "/delete", "/select", "/atualizar" })
public class LembreteController extends HttpServlet {

	LembreteBeans lb = new LembreteBeans();
	LembreteDAO ld = new LembreteDAO();
	private static final long serialVersionUID = 1L;

	public LembreteController() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.process(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.process(request, response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getServletPath();

		if (url.equals("/main")) {
			listarLembretes(request, response);
		} else if (url.equals("/insert")) {
			registrarLembrete(request, response);
		} else if (url.equals("/delete")) {
			excluir(request, response);
		} else if (url.equals("/select")) {
			selecionarContato(request, response);
		} else if (url.equals("/atualizar")) {
			atualizarLembrete(request, response);

		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void registrarLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		lb.setTitulo(request.getParameter("titulo"));
		lb.setMsg(request.getParameter("msg"));
		ld.adicionarLembrete(lb);
		response.sendRedirect("main");

	}

	protected void listarLembretes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<LembreteBeans> list = ld.listarLembretes();
		request.setAttribute("registros", list);
		RequestDispatcher rd = request.getRequestDispatcher("Lembretes.jsp");
		rd.forward(request, response);

	}

	protected void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		lb.setId(request.getParameter("id"));
		ld.removerLembrete(lb);
		response.sendRedirect("main");

	}

	protected void selecionarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// CONTATO SELECIONADO
		lb.setId(request.getParameter("id"));
		ld.selecionarLembrete(lb);

		// OBS : O ''selecionarLembrete'' necessita tbm que anexe as informacoes das
		// colunas...

		/*
		 * lb.setId(rs.getString(1)); lb.setTitulo(rs.getString(2));
		 * lb.setMsg(rs.getString(3));
		 * 
		 */

		// JA QUE NECESSITO ANEXAR ESSA INFORMACOES E NAO DEIXAR ELAS PERDIDAS , FAZEMOS
		// ISSO....

		// PRECISO AGORA ANEXAR CADA COLUNA EM ALGUMA INFORMACAO
		// VAMOS SETAR A COLUNA ID NA VARIAVEL ID E ASSIM VAI...
		request.setAttribute("id", lb.getId());
		request.setAttribute("titulo", lb.getTitulo());
		request.setAttribute("msg", lb.getMsg());
		// DPS DE FAZER ISSO, VAMOS ENCAMINHAR ESSE DADOS PRA EDITAR.JSP QUE IRA RECEBER
		// ESSES ATRIBUTOS NOS CAMPOS DO FORM
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void atualizarLembrete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		lb.setId(request.getParameter("id"));
		lb.setTitulo(request.getParameter("titulo"));
		lb.setMsg(request.getParameter("msg"));
		ld.atualizarLembrete(lb);
		response.sendRedirect("main");

	}

}
