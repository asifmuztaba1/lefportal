
package com.police.controller;

import static com.police.controller.encrypt.encryptPassword;
import com.police.entity.PoliceStationUser;
import com.police.model.PoliceHQModel;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

public class PoliceHQController {

    static HttpSession session;

    PoliceHQModel HQModel = new PoliceHQModel();

    public static void craeteLoginSession(PoliceStationUser user, HttpServletRequest req) {
        System.out.println("Session Created");
        user.setPassword("null");
        session = req.getSession();
        session.setAttribute("user", user);

    }

    public static boolean checkSession() {
        boolean login = false;
        PoliceStationUser user;
        try {
            user = (PoliceStationUser) session.getAttribute("user");
            if (user.getRole().equals("HQ_ADMIN")) {
                login = true;
            } else {
                login = false;
            }
        } catch (Exception e) {
            //e.printStackTrace();
            login = false;
        }

        return login;
    }

    @RequestMapping(value = "PoliceHQ/dashBoard")
    public String showDash() {
        
            System.out.println("Called HQ Con");
            return "PoliceHQ/dashBoard";
        
    }

    @RequestMapping(value = "PoliceHQ/addNewPS", method = RequestMethod.GET)
    public String viewForm() {
        
            return "PoliceHQ/NewPS";
        

    }

    @RequestMapping(value = "PoliceHQ/addNewPS", method = RequestMethod.POST)
    public String addNewPS(@ModelAttribute(value = "PoliceStationUser") PoliceStationUser psUser, Model model) {

        
            boolean userNameMatch = HQModel.checkUserName(psUser.getUsername());

            if (userNameMatch == false) {
                String encryptedPassword = encryptPassword(psUser.getPassword());
                psUser.setPassword(encryptedPassword);
                boolean insert = HQModel.addPS(psUser);
                if (insert == true) {
                    model.addAttribute("sucsMsg", "Successfully done...");
                } else {
                    model.addAttribute("errMsg", "Error ocuured...");
                }
                return "PoliceHQ/NewPS";
            } else {
                model.addAttribute("psUser", psUser);
                model.addAttribute("errMsg", "Username already exists.Please choose new username...");
                return "PoliceHQ/NewPS";
            }
        

    }

    @RequestMapping(value = "PoliceHQ/viewPSList")
    public String viewPSList(Model model) {
        List<PoliceStationUser> uList = HQModel.getAllPS();
        System.out.println("List Size " + uList.size());
        model.addAttribute("psList", uList);
        return "PoliceHQ/viewPSList";
    }

    @RequestMapping(value = "PoliceHQ/psEdit", method = RequestMethod.GET)
    public String viewEditPage(@RequestParam(value = "id") Long id, Model model) {
        System.out.println("ID " + id);
        PoliceStationUser user = HQModel.getUserById(id);
        model.addAttribute("psUser", user);
        return "PoliceHQ/psEdit";
    }

    @RequestMapping(value = "PoliceHQ/psEdit", method = RequestMethod.POST)
    public String updatePS(@ModelAttribute(value = "PoliceStationUser") PoliceStationUser psUser, Model model) {

        boolean userNameMatch = HQModel.checkUserName(psUser.getUsername());
        if (userNameMatch == false) {
            String encryptedPassword = encrypt.encryptPassword(psUser.getPassword());

            psUser.setPassword(encryptedPassword);
            System.out.println("pasw " + psUser.getPassword());
            boolean update = HQModel.updatePS(psUser);
            if (update == true) {
                model.addAttribute("sucsMsg", "Updated successfully...");
                List<PoliceStationUser> uList = HQModel.getAllPS();
                System.out.println("List Size " + uList.size());
                model.addAttribute("psList", uList);
                return "PoliceHQ/viewPSList";
            } else {
                model.addAttribute("psUser", psUser);
                model.addAttribute("errMsg", "Error occured...");
                return "PoliceHQ/psEdit";
            }
        } else {
            model.addAttribute("errMsg", "Username already exists.Please choose new username...");
            model.addAttribute("psUser", psUser);
            return "PoliceHQ/psEdit";
        }
    }
    
    
    @RequestMapping(value = "PoliceHQ/logOut")
    public String logOut(HttpServletRequest req)
    {
        PoliceHQController.session=req.getSession();
        PoliceHQController.session.invalidate();
        System.out.println("Logged out ...");
        return "PoliceHQ/redirRoot";
    }

}
