
package com.police.controller;

import com.police.entity.Criminal;
import com.police.entity.Criminalcase;
import com.police.entity.PUser;
import com.police.entity.PsUser;
import com.police.model.PUserModel;
import com.police.model.PsUserModel;
import com.police.model.criminalCaseModel;
import com.police.model.userModel;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

@Controller
@SessionAttributes("session")
public class mainController {

    @RequestMapping({"/", "index"})
    public String index() {
        ModelAndView mv = new ModelAndView();
        mv.setView("index");
        return "index";
    }

    @RequestMapping(value = "user_reg")
    public String user_reg() {
        return "user_reg";
    }

    @RequestMapping(value = "view_login")
    public String viewLogin() {
        return "login";
    }
    
    @RequestMapping(value = "logout")
    public String logout() {
        return "logout";
    }
    
    
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute("PUser") PUser pu, HttpServletRequest request, HttpServletResponse response, ModelMap modelmap) {
        
        boolean login=false;
        ModelAndView mv = new ModelAndView();
        PUser user = new PUser();

        user.setEmail(pu.getEmail());
        user.setPassword(pu.getPassword());
        String email = user.getEmail();

        Pattern pattern = Pattern.compile("^.+@.+\\..+$");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            PUserModel model = new PUserModel();

            login = (boolean)model.login(user);

            if (login == true) {
                HttpSession session = request.getSession();

                PUser user_info = (PUser) model.login_info(user);
                session.setAttribute("session", user_info);
                String district=user_info.getDistrict();
                mv.setView("UR");
                return "UR";
            } 
            
            else {
                
                return "error";
            }
        } 
        else {
            PsUser ps_user=new PsUser();
                
                ps_user.setUsername(pu.getEmail());
                ps_user.setPassword(pu.getPassword());
                
                PsUserModel ps_model=new PsUserModel();
                
                login=ps_model.login(ps_user);
                
                if(login == true)
                {
                    HttpSession session=request.getSession();
                    PsUser user_info=(PsUser) ps_model.login_info(ps_user);
                    
                    session.setAttribute("session", user_info);

                    String admin_role=user_info.getRole();
                    
                    String admin="police_station";
                    
                    
                    if(admin_role.equals(admin))
                    {
                        System.out.println("here...");
                        mv.setView("ps_dash");
                        return "ps_dash";
                    }
                      else
                    {
                        mv.setView("ahq_dash");
                        return "ahq_dash";
                    }
                        
                   
                }
                else
                     return "error";
            
           
        }
    }

    @RequestMapping(value = "insert_user", method = RequestMethod.POST)
    public String insert_user(@ModelAttribute(value = "PUser") PUser pu) {
        PUser user = new PUser();

        user.setName(pu.getName());
        user.setEmail(pu.getEmail());
        user.setPassword(pu.getPassword());
        user.setDistrict(pu.getDistrict());
        user.setAddress(pu.getAddress());
        user.setRole("public_user");

        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = dateFormat.format(d);
        user.setJoinedon(date);

        PUserModel model = new PUserModel();
        model.insert(user);
        return "index";
    }
    
    @RequestMapping(value="searchCriminal")
    public String view_search()
    {
        return "searchCriminal";
    }
    
    
     @RequestMapping(value="searchCriminal",method=RequestMethod.POST)
    public String search(@RequestParam(value="name") String name,Model m)       
    {
        userModel model=new userModel();
        List<Criminal> criminal_list=model.searchbyname(name);
        
        m.addAttribute("criminal_list",criminal_list);
        return "viewCriminal";
    }
    
    
    @RequestMapping(value="criminalDetails",method=RequestMethod.GET)
    public String criminalDetails(@RequestParam(value="id") String criminal_id,Model m)
    {
        userModel model=new userModel();
        Criminal criminal=model.criminalDetails(criminal_id);
        m.addAttribute("criminal", criminal);
        
        criminalCaseModel caseModel=new criminalCaseModel();
         
        List<Criminalcase> list=caseModel.searchbyId(criminal_id);
        
        m.addAttribute("list", list);
        
        return "criminalDetails";
    }
    
    @RequestMapping(value="customSearchCriminal",method=RequestMethod.POST)
    public String customSearch(@RequestParam(value="name") String name,Model m,@RequestParam(value="district") String district,@RequestParam(value="division") String division)
    {
        userModel model=new userModel();
        
        List<Criminal> criminal_list=model.customSearch(name, district, division);
        m.addAttribute("criminal_list", criminal_list);
        return "viewCriminal";
    }
    
    
}
