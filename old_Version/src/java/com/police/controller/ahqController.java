
package com.police.controller;

import com.police.entity.PsUser;
import com.police.entity.ahqSearch;
import com.police.model.PsUserModel;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author asifmuztaba
 */
@Controller
@SessionAttributes("session")
public class ahqController {
    
    @RequestMapping(value = "ahq_dash")
    public String dash()
    {
        return "ahq_dash";
    }
    

    @RequestMapping(value = "ahq_search")
    public String search() {
        ModelAndView mv = new ModelAndView();
        mv.setView("ahq_search");
        return "ahq_search";
    }
    
    
    @RequestMapping(value="ahq_viewAll",method=RequestMethod.GET)
    public String view(Model m)
    {
        
        PsUserModel model=new PsUserModel();
        List<PsUser> list=model.getAll();
        m.addAttribute("list",list);
        return "ahq_viewAll";
    }
    
    
    
    @RequestMapping(value = "ahq_viewAll",method=RequestMethod.POST)
    public String viewAll(@ModelAttribute("ahqSearch") ahqSearch s,Model m  )
    {
        ahqSearch search=new ahqSearch();
        
        search.setDistrict(s.getDistrict());
        search.setDivision(s.getDivision());
        
        PsUserModel model=new PsUserModel();
        List<PsUser> list=model.view(search);
        m.addAttribute("list",list);
        return "ahq_viewAll";
    }
    
    @RequestMapping(value = "ahq_create")
    public String create()
    {
        return "ahq_create";
    }
    
    
    @RequestMapping(value = "ahq_insert",method=RequestMethod.POST)
    public String insert(@ModelAttribute ("PsUser") PsUser u)
    {
        PsUser user=new PsUser();
        
        user.setDivision(u.getDivision());
        user.setDistrict(u.getDistrict());
        user.setPsName(u.getPsName());
        user.setRole(u.getRole());
        user.setUsername(u.getUsername());
        user.setPassword(u.getPassword());
        
        PsUserModel model=new PsUserModel();
        model.insert(user);
        return "ahq_insertSuccess";
    }
    
    
    @RequestMapping(value="view_edit",method=RequestMethod.GET)
    public String viewEdit(@RequestParam (value="id") int id,Model m )
    {
        BigDecimal long_id=new BigDecimal(id);
        PsUserModel model=new PsUserModel();
        PsUser user=new PsUser();
        
        user=model.getUser(long_id);
        m.addAttribute("user",user);
        return "ahq_update";
    }
    
    
    @RequestMapping(value="update",method=RequestMethod.POST)
    public String update(@ModelAttribute ("PsUser") PsUser u)
    {
        PsUserModel model=new PsUserModel();
        model.update(u);
        
        return "ahq_insertSuccess";
    }
    
    @RequestMapping(value="delete",method=RequestMethod.GET)
    public String delete(@RequestParam (value="id") int id)
    {
        BigDecimal long_id=new BigDecimal(id);
        
        PsUserModel model=new PsUserModel();
        PsUser user=new PsUser();
        user=model.getUser(long_id);
        model.delete(user);
        
        return "ahq_insertSuccess";
    }
}
