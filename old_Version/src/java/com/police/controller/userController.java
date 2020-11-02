
package com.police.controller;

import com.police.entity.Case;
import com.police.entity.Comments;
import com.police.entity.Criminal;
import com.police.model.criminalCaseModel;
import com.police.model.userModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author asifmuztaba
 */

@Controller
@SessionAttributes("session")
public class userController {
    
    @RequestMapping(value="u_dash",method = RequestMethod.GET)
    public String demo(@RequestParam(value="district") String district,Model m)
    {
       
       criminalCaseModel ccModel=new criminalCaseModel();
       List<String> criminalId=ccModel.getRunningCriminal();
       
       
       List<Criminal> criminal=new ArrayList<Criminal>();
       userModel model=new userModel();
       for(String id:criminalId)
       {
           String temp_id=id.toString();
           System.out.println(temp_id);
           Criminal obj=model.getCriminal(temp_id, district);
           
           criminal.add(obj);
       }
       
       m.addAttribute("criminal", criminal);
       return "u_dash";
    }
    
    @RequestMapping(value="u_criminalcase",method=RequestMethod.GET)
    public String criminalcase(@RequestParam(value="criminalId")String criminalId,Model m)
    {
        criminalCaseModel ccModel=new criminalCaseModel();
        List<String> caseList=ccModel.getCaseList(criminalId);
        
        List<Case> caseDetail=new ArrayList<Case>();
        userModel model=new userModel();
        for(String id:caseList)
        {
            String temp_id=id.toString();
            System.out.println(temp_id);
            Case obj=model.getCaseDetails(temp_id);
            caseDetail.add(obj);
        }
        m.addAttribute("caseDetail", caseDetail);
        
        m.addAttribute("criminalId", criminalId);
        
        return "u_criminalcase";
    }
    
    @RequestMapping(value="u_provideinfo",method=RequestMethod.GET)
    public String view_provideinfo(@RequestParam(value="criminalId") String criminalId,@RequestParam(value="ps") String policeStation,Model m)
    {
        m.addAttribute("criminalId", criminalId);
        System.out.println(policeStation);
        m.addAttribute("policeStation", policeStation);
        return "u_provideinfo";
    }
    
    @RequestMapping(value="provideinfo",method=RequestMethod.POST)
    public String provideinfo(@ModelAttribute(value="Comments") Comments comments)
    {
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(d);
        comments.setPostDate(date);
        userModel model=new userModel();
        model.insert_comments(comments);
        return "UR";
    }
}
