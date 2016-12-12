package ru.ProPoisk.filters;

import ru.ProPoisk.servlets.Login;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
            HttpSession session = req.getSession(true);

            if(session.getAttribute("user") == null){
                if(!checkCookie(req.getCookies(), session)) {
                    resp.sendRedirect("/login");
                    return;
                }
            }
        }

        filterChain.doFilter(req, resp);
    }

    public static boolean checkCookie(Cookie[] cookies, HttpSession session) throws UnsupportedEncodingException {
        String name = "";
        String pass = "";

        for(Cookie c : cookies){
            if("name".equals(c.getName())){
                name =  URLDecoder.decode(c.getValue(), "UTF-8");
            } else if("pass".equals(c.getName())){
                pass = URLDecoder.decode(c.getValue(), "UTF-8");
            }
        }

        return Login.login(name, pass, session) == Login.UserLoginState.Success;
    }

    @Override
    public void destroy() {
        urlList = null;
    }
}
