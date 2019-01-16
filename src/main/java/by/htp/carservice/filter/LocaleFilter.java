package by.htp.carservice.filter;

import by.htp.carservice.util.MessageManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * The Class LocaleFilter.
 */
public class LocaleFilter implements Filter {
    
    /** The logger. */
    private static Logger logger = LogManager.getLogger();
    
    /** The Constant BUNDEL_NAME. */
    private static final String BUNDEL_NAME = "bundel";
    
    /** The Constant LANGUAGE_NAME. */
    private static final String LANGUAGE_NAME = "language";
    
    /** The Constant LOCALE_NAME. */
    private static final String LOCALE_NAME = "locale";
    
    /** The Constant LANGUAGE_EN. */
    private static final String LANGUAGE_EN = "en";


    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
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

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }
}
