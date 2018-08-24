package cn.studio.zps.blue.ljy.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AccessFilter")
public class AccessFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String uri=request.getRequestURI();
        if(uri.endsWith("/admin/login.do")||uri.endsWith(".html")||uri.endsWith(".css")||uri.endsWith(".js")) {
            chain.doFilter(req, resp);
            return ;
        }
        String token = request.getHeader("token");
        HttpSession session = request.getSession();
        String tokenTrue = (String) session.getAttribute("token");
        if(token!=null&&token.equals(tokenTrue)) {
            chain.doFilter(req,resp);
            return ;
        }
        response.getWriter().println("please login");
        response.getWriter().flush();
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
