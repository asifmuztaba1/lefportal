
package com.police.controller;

import static com.police.controller.encrypt.encryptPassword;
import com.police.entity.PoliceStationUser;
import com.police.entity.PublicUser;
import com.police.model.defaultModel;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author asifmuztaba
 */
@Controller
public class DefaultController {

    defaultModel dm = new defaultModel();

    @RequestMapping(value = {"/", "index"})
    public String viewIndex() {
        return "index";
    }

    @RequestMapping(value = "userReg", method = RequestMethod.GET)
    public String viewRegForm() {
        return "userReg";
    }

    @RequestMapping(value = "RegisterUser", method = RequestMethod.POST)
    public String regUser(@ModelAttribute(value = "PublicUser") PublicUser user) {

        boolean emailFound = dm.checkEmail(user.getEmail());

        if (emailFound == false) {
            Date d=new Date();
            user.setJoinDate(d);
            user.setRole("Inactive");
            String encryptedPassword=encryptPassword(user.getPassword());
            user.setPassword(encryptedPassword);
            boolean done = dm.insertUser(user);
            if (done == true) {
                return "successMsg";
            } else {
                return "errorMsg";
            }
        }
        else
            return "emailMatchFound";
    }
    
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String viewLogin()
    {
        return "userLogin";
    }
    
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String userLogin(@RequestParam(value="email") String email,@RequestParam(value = "password") String password,HttpServletRequest req,Model model)
    {
        System.out.println("e"+email);
        System.out.println("p"+password);
        String encrytedPassword=encryptPassword(password);
        
        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher match = pattern.matcher(email);
        
        if(match.find())
        {
            boolean matchFound=dm.checkPubllicUser(email, encrytedPassword);
            
            if(matchFound == true)
            {
                PublicUserController.getUserCredential(email, encrytedPassword);
                return "PublicUser/redirectDash";
            }
            
        }
        else{
            boolean matchFound=dm.checkPoliceStationUser(email, encrytedPassword);
            if(matchFound == true)
            {
                PoliceStationUser policeUser=dm.getPoliceStationUserCredential(email, encrytedPassword);
                
                if(policeUser.getRole().contains("PS_ADMIN"))
                {
                    System.out.println("Police Station Admin login...");
                    PoliceStationController.craeteLoginSession(policeUser, req);
                    return "PoliceStation/redirectDash";
                }
                else if(policeUser.getRole().contains("HQ_ADMIN"))
                {
                    System.out.println("Police HQ Admin login...");
                    PoliceHQController.craeteLoginSession(policeUser,req);
                    return "PoliceHQ/redirectDash";
                }
                else{
                    
                    return "errorMsg";
                }
            }
        }
        model.addAttribute("loginMsg", "Wrong username or password");
        return "userLogin";
    }
}
