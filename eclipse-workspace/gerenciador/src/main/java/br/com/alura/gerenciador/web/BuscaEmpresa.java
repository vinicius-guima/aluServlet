package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;


@WebServlet(urlPatterns = "/busca")
public class BuscaEmpresa extends HttpServlet {
	
	 public BuscaEmpresa() {
		System.out.println("Instanciando uma servelt do tipo busca empresa" + this);
	}
	
	 @Override
	public void init() throws ServletException {
		super.init();
		System.out.println("iniciando a servlet " + this);
	}
	 
	  @Override
	public void destroy() {
		super.destroy();
		System.out.println("destruindo a servlet " + this);
	}
	  

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.write("Resultado da Busca: </br>");
		
		String filtro = req.getParameter("filtro");
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		pw.println("<ul>");
		for(Empresa empresa : empresas) {
			pw.println("<li>" + empresa.getId() + ":" + empresa.getNome() + "</li>");
		}
		pw.println("</ul>");
		
		pw.println("</html></body>");

	}

}




