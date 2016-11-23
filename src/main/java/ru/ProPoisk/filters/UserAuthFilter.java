package ru.ProPoisk.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by apple on 11.10.16.
 */
public class UserAuthFilter implements Filter {

    private List<String> urlList;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParameter = filterConfig.getInitParameter("allow-urls");
        urlList = new ArrayList<String>();
        Collections.addAll(urlList, initParameter.split(","));
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String servletPath = req.getServletPath();
        boolean allowedRequest = false;

        for (String s : urlList) {
            if(servletPath.startsWith(s)){
                allowedRequest = true;
                break;
            }
        }

        if(!allowedRequest){
            HttpSession session = req.getSession(false);

            if(session == null || session.getAttribute("user") == null){
                resp.sendRedirect("/login");
                return;
            }
        }

        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        urlList = null;
    }
}
