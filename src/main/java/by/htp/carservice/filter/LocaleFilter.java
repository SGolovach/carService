package by.htp.carservice.filter;

import by.htp.carservice.local.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LocaleFilter implements Filter {
    private static Logger logger = LogManager.getLogger();
    private static final String BUNDEL_NAME = "bundel";
    private static final String LANGUAGE_NAME = "language";
    private static final String LOCALE_NAME = "locale";
    private static final String LANGUAGE_EN = "en";


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();
        String language = request.getParameter(LANGUAGE_NAME);
        String locale = (String) session.getAttribute(LOCALE_NAME);
        MessageManager bundelMessage;
        if (locale == null && language == null) {
            bundelMessage = MessageManager.EN;
            session.setAttribute(BUNDEL_NAME, bundelMessage);
            session.setAttribute(LOCALE_NAME, bundelMessage.getLocale().getLanguage());
        }
        if (language != null && !language.isEmpty()) {
            if (language.equalsIgnoreCase(LANGUAGE_EN)) {
                bundelMessage = MessageManager.EN;
            } else {
                bundelMessage = MessageManager.RU;
            }
            session.setAttribute(BUNDEL_NAME, bundelMessage);
            session.setAttribute(LOCALE_NAME, bundelMessage.getLocale().getLanguage());
        }

        chain.doFilter(request,response);
}

    @Override
    public void destroy() {

    }
}
