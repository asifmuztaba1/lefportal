
package com.police.interceptors;

import com.police.controller.PoliceStationController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author asifmuztaba
 */
public class InterCeptorPS extends HandlerInterceptorAdapter{
    
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean login=PoliceStationController.checkSession();
        
        if(login==true)
        {
            return true;
        }
        else{
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
    }
}
