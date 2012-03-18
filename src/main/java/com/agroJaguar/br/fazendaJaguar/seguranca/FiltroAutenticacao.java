package com.agroJaguar.br.fazendaJaguar.seguranca;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.agroJaguar.br.fazendaJaguar.persistencia.bean.UsuarioBean;

/**
 * Filtro que verifica se usuário tem permissão de acesso as URLs do sistema. 
 */
public class FiltroAutenticacao implements Filter {

	/**
	 * Lista de URL que devem ser verificadas permissões de acesso.
	 */
	private static Map<String, String> mapURLs;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}	

	@Override
	public void doFilter(ServletRequest servletRequest, 
						 ServletResponse servletResponse,
						 FilterChain filterChain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		String url = request.getRequestURI();

		HttpSession session = request.getSession(false);
		
		if(session == null) {
		    retorna(request, response, "Sessão expirada.");
		}else {
			UsuarioBean usuarioBean = (UsuarioBean)session.getAttribute(UsuarioBean.class.getSimpleName());
		    if(usuarioBean == null) {
			//TODO Questionar mensagem ao analista.		    
			retorna(request, response, "Usuário não logado.");
		    }else {
			filterChain.doFilter(request, response);
		    }
		}
	}
	
	/**
	 * Retorna para a página de login.
	 * 
	 * @param request
	 * @param response
	 * @param mensagem
	 * @throws ServletException
	 * @throws IOException
	 */
	public void retorna(HttpServletRequest request, HttpServletResponse response, String mensagem)
			throws ServletException, IOException {
	
		//JSFUtil.getResponse().sendRedirect("login.jsf");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/publico/xhtml/login.jsf");
		requestDispatcher.forward(request, response);
	}
	
	@Override
	public void destroy() {
	}

}
