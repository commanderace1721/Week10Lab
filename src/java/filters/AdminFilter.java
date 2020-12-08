/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 826847
 */
public class AdminFilter implements Filter {
     public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        // this code will execute before the servlet
        
        HttpServletRequest httprequest = (HttpServletRequest)request;
        HttpSession session = httprequest.getSession();
        
        
        
        int role = (int) session.getAttribute("role");
         HttpServletResponse httpResponse = (HttpServletResponse)response;
         
        
        if(role == 2)
        {
             httpResponse.sendRedirect("notes");
            return;
        }
        
        
        
        chain.doFilter(request, response);// execute the servlet, or next filter in the chain
                //this code will execute after the servlet
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {

    }
       
    
}
