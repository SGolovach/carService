package by.htp.carservice.filter;

import by.htp.carservice.local.MessageManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LocaleFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String language = request.getParameter("language");
        MessageManager bundelMessage;
        ((HttpServletRequest) request).getSession().getAttribute("bundel");
        if (language != null && !language.isEmpty()) {
            if (language.equalsIgnoreCase("en")) {
                bundelMessage = MessageManager.EN;
            } else {
                bundelMessage = MessageManager.RU;
            }
        } else {
            bundelMessage = MessageManager.EN;
        }
        ((HttpServletRequest) request).getSession().setAttribute("bundel", bundelMessage);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
