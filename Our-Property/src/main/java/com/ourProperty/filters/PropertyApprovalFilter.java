package com.ourProperty.filters;

import javax.servlet.*;
import java.io.IOException;

public class PropertyApprovalFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException{
        // Assuming you have to the property status from the request or session
        String status = getPropertyStatusFromRequest(request);

        if("Approved".equals(status)) {
            chain.doFilter(request, response);  // Allow the request to continue
        }else {
            response.getWriter().write("Access denied. Property status must be approved.");
        }
    }

    private String getPropertyStatusFromRequest(ServletRequest request){
        // Implement logic to extract property status from the request or session
        // This could involve reading from request parameters, headers, or session
        return "Approved";   // Replace with your actual implementation
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code , if needed
    }

    @Override
    public void destroy(){
        // cleanup code, if needed
    }
}
