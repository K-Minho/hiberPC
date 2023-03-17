package shop.mtcoding.hiberpc.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyBlackListFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 버퍼를 비우지 말것, 컨트롤러에서 읽지 못함
        // x-www-form-urlencoded
        String value = request.getParameter("value");
        if (value == null) {
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().println("Need Parameter!");
            return;
        }
        if (value.equals("x")) {
            response.setContentType("text/plain; charset=utf-8");
            response.getWriter().println("You are Blocked!");
            return;
        }
        chain.doFilter(request, response);
    }
}
