package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.net.httpserver.HttpsServer;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest requisicao = (HttpServletRequest)req;
	    HttpServletResponse resposta = (HttpServletResponse) resp;

		
	    HttpSession session = requisicao.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
		
		String usuario = "<deslogado>";
		
		if(usuarioLogado != null) {
			usuario = usuarioLogado.getEmail();
		}
	
 		System.out.println("Usuario " + usuario  + " acessando a URI " +
		requisicao.getRequestURI());
		
		chain.doFilter(requisicao, resposta);
	}
	

	private String getUsuario(HttpServletRequest req){
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		if(cookie == null ) return "<Deslogado>";
		return cookie.getValue();
	
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
