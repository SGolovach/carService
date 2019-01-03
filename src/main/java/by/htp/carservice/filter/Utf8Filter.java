package by.htp.carservice.filter;

import javax.servlet.*;
import java.io.IOException;

public class Utf8Filter implements Filter {
    private String code;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("code");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String encoding = request.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(code))
            request.setCharacterEncoding(code);

        encoding = response.getCharacterEncoding();
        if (encoding == null || !encoding.equalsIgnoreCase(code))
            response.setCharacterEncoding(code);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
