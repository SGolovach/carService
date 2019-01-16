package by.htp.carservice.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * The Class Utf8Filter.
 */
public class Utf8Filter implements Filter {
    
    /** The code. */
    private String code;

    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("code");
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse,
      * javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String encoding = request.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(code))
            request.setCharacterEncoding(code);

        encoding = response.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(code))
            response.setCharacterEncoding(code);
        chain.doFilter(request, response);
    }

    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {

    }
}
