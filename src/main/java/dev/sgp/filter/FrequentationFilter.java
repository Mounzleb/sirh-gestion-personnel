package dev.sgp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebService;
import dev.sgp.util.Constantes;

/**
 * Servlet Filter implementation class FrequentationFilter
 */
public class FrequentationFilter implements Filter {
	private VisiteWebService visiteWebService = Constantes.VISITE_WEB_SERVICE;
	private FilterConfig config = null;

	/**
	 * Default constructor.
	 */
	public FrequentationFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("TimeFilter initialized");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// The java.lang.System.currentTimeMillis() method returns the current
		// time in milliseconds.The unit of time of the return value is a
		// millisecond, the granularity of the value depends on the underlying
		// operating system and may be larger
		long before = System.currentTimeMillis();

		// pass the request along the filter chain
		chain.doFilter(request, response);

		long after = System.currentTimeMillis();
		String path = ((HttpServletRequest) request).getRequestURI();

		// On fait un cast pour faire passer le after - before d'un long à un
		// int car le set du temps d'execution est un int
		int tempsExecution = (int) (after - before);
		VisiteWeb visite = new VisiteWeb();

		visite.setChemin(path);
		visite.setTempsExecution(tempsExecution);

		// la ligne suivante est pour afficher le temps d'execution dans la
		// console
		config.getServletContext().log(path + " : " + (after - before));
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
