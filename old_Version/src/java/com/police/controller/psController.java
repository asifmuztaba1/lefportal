
package com.police.controller;

import com.police.entity.Case;
import com.police.entity.Comments;
import com.police.entity.Criminal;
import com.police.entity.CriminalDocument;
import com.police.entity.Criminalcase;
import com.police.entity.Document;
import com.police.entity.Notification;
import com.police.model.criminalCaseModel;
import com.police.model.policeStationModel;
import java.io.File;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.portlet.ModelAndView;

/**
 *
 * @author asifmuztaba
 */
@Controller
@SessionAttributes("session")
public class psController {

    @RequestMapping(value = "ps_dash")
    public String dash() {
        return "ps_dash";
    }

    @RequestMapping(value = "ps_newcase")
    public String view_Newcase() {
        return "ps_newcase";
    }

    @RequestMapping(value = "insert_case")
    public String insert(@ModelAttribute("Case") Case c, Model m) {
        Case new_case = new Case();

        new_case.setCaseName(c.getCaseName());
        new_case.setCaseDate(c.getCaseDate());
        new_case.setCrimeDate(c.getCrimeDate());
        new_case.setDistrict(c.getDistrict());
        new_case.setDivision(c.getDivision());
        new_case.setOfficer(c.getOfficer());
        new_case.setType(c.getType());
        new_case.setVictim(c.getVictim());
        new_case.setVictimAge(c.getVictimAge());
        new_case.setPoliceStation(c.getPoliceStation());

        policeStationModel model = new policeStationModel();
        model.insert_case(new_case);

        BigDecimal case_id = model.get_caseID(new_case);
        System.out.println(case_id);
        m.addAttribute("case_id", case_id);
        return "ps_criminalinfo";
    }

    @RequestMapping(value = "insert_criminal", method = {RequestMethod.POST, RequestMethod.GET})
    public String insert_criminal(@ModelAttribute("Criminal") Criminal c, @RequestParam(value = "case_id") BigDecimal case_id, Model m) {
        Criminal criminal = new Criminal();

        criminal.setName(c.getName());
        criminal.setFather(c.getFather());
        criminal.setAddress(c.getAddress());
        criminal.setContact(c.getContact());
        criminal.setDistrict(c.getDistrict());
        criminal.setDivision(c.getDivision());

        policeStationModel model = new policeStationModel();
        model.insert_criminal(c);

        BigDecimal criminal_id = model.get_criminalID(c);
        m.addAttribute("case_id", case_id);
        m.addAttribute("criminal_id", criminal_id);

        return "ps_criminalcase";
    }

    @RequestMapping(value = "insert_criminalcase", method = RequestMethod.POST)
    public String insert_criminalcase(@ModelAttribute("Criminalcase") Criminalcase c) {
        criminalCaseModel model = new criminalCaseModel();
        model.insert_criminalcase(c);
        System.out.println(c.getCriminalId());
        System.out.println(c.getCaseId());
        return "ps_dash";
    }

    @RequestMapping(value = "ps_documents", method = RequestMethod.GET)
    public String documents(@RequestParam(value = "district") String district, Model m) {
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(d);

        policeStationModel model = new policeStationModel();
        List<Case> list = model.searchbyDate(date, district);

        m.addAttribute("list", list);
        return "ps_documents";
    }

    @RequestMapping(value = "ps_documents", method = RequestMethod.POST)
    public String documentsPost(@RequestParam(value = "district") String district, Model m, @RequestParam(value = "caseDate") String date) {
        List<Case> list = null;
        policeStationModel model = new policeStationModel();

        if (date != null) {

            list = model.searchbyDate(date, district);
        }

        m.addAttribute("list", list);
        return "ps_documents";
    }

    @RequestMapping(value = "ps_documentID", method = RequestMethod.POST)
    public String documentsPostID(@RequestParam(value = "district") String district, Model m, @RequestParam(value = "id") String id) {
        List<Case> list = null;
        policeStationModel model = new policeStationModel();

        list = model.searchbyID(id, district);

        m.addAttribute("list", list);
        return "ps_documents";
    }

    @RequestMapping(value = "ps_upDocuments", method = RequestMethod.GET)
    public String view_upDocument(@RequestParam(value = "id") String case_id, Model m) {
        m.addAttribute("case_id", case_id);

        return "ps_upDocuments";
    }

    @RequestMapping(value = "ps_upDocuments", method = RequestMethod.POST)
    public String upDocument(@RequestParam CommonsMultipartFile file, @ModelAttribute("Document") Document d,Model m) {
        Document data = new Document();

        String fileName = file.getOriginalFilename();
        String type = d.getType();

        data.setCaseId(d.getCaseId());
        data.setName(d.getName());
        data.setType(d.getType());

        if (type.equals("Image")) {
            System.out.println(type);
            String image_upPath = "E:\\Programming Practice\\JSP\\projectFinal\\web\\resources\\case_images\\" + fileName;
            try {
                File destination = new File(image_upPath);
                file.transferTo(destination);
            } catch (Exception e) {

                e.printStackTrace();
            }
            
            data.setPath(image_upPath);

        } else {
            System.out.println(type);
            String doc_upPath = "E:\\Programming Practice\\JSP\\projectFinal\\web\\resources\\case_documents\\" + fileName;
            try {
                File destination = new File(doc_upPath);
                file.transferTo(destination);
            } catch (Exception e) {

                e.printStackTrace();
            }
            
            data.setPath(doc_upPath);
        }
        
        m.addAttribute("case_id", data.getCaseId());
        policeStationModel model=new policeStationModel();
        model.insert_documents(data);
        return "ps_upDocuments";
    }
    
    @RequestMapping(value="ps_makeNotification")
    public String view_notify()
    {
        
        return "ps_makeNotification";
    }
    
    
    @RequestMapping(value="insert_notification",method=RequestMethod.POST)
    public String insert_notify(@ModelAttribute("Notification") Notification n)
    {
        Date d = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(d);
        n.setCreateDate(date);
        
        policeStationModel model=new policeStationModel();
        
        model.insert_notification(n);
        return "ps_makeNotification";
    }
    
    
    @RequestMapping(value="ps_notification")
    public String check_notification(@RequestParam(value="district") String district,Model m,@RequestParam(value="division") String division,@RequestParam(value="ps") String policeStation)
    {
        policeStationModel model=new policeStationModel();
        List<Notification> list=null;
        System.out.println(division);
        System.out.println(district);
        list=model.view_notification(district, division);
        
        long tot_notf=list.size();
        
        long viewed_notf=model.ps_viewedNotf(district);
        
        long new_notf= tot_notf - viewed_notf;
        
        m.addAttribute("list", list);
        
        List<Comments> comments=model.getComments(policeStation);
        m.addAttribute("comments", comments);
        
        return "ps_viewnotification";
    }
    
    @RequestMapping(value="ps")
    public String ps()
    {
        return "ps";
    }
    
    @RequestMapping (value="ps_viewCase",method=RequestMethod.GET)
    public String view_case(@RequestParam(value="id") String case_id,Model m)
    {
        policeStationModel model=new policeStationModel();
        Case case_info=model.get_caseinfo(case_id);
        
        m.addAttribute("case_info", case_info);
        
        BigDecimal id=case_info.getId();
        
        List<Document> list_caseDoc=model.searchDocument(case_id);
        m.addAttribute("list_caseDoc", list_caseDoc);
        
        List<Criminalcase> criminal_list=model.get_crimanalCaseinfo(id);
        
        m.addAttribute("criminal_list", criminal_list);
        
        
        
        return "ps_viewCase";
    }
    
    @RequestMapping (value="ps_criminalDetail",method=RequestMethod.GET)
    public String view_criminal(@RequestParam(value="id") String criminal_id,Model m)
    {
        policeStationModel model=new policeStationModel();
        Criminal criminal=model.get_criminalinfo(criminal_id);
        
        m.addAttribute("criminal", criminal);
        
        List<CriminalDocument> docs=model.get_criminalDoc(criminal_id);
        m.addAttribute("docs", docs);
        return "ps_criminalDetail";
    }
    
    
    @RequestMapping (value="ps_searchMissing")
    public String view_searchMissing()
    {
        return "ps_searchMissing";
    }
    
    
    @RequestMapping (value="ps_searchMissing",method=RequestMethod.POST)
    public String searchMissing(@RequestParam(value="ageStart") String ageStart,@RequestParam(value="ageEnd") String ageEnd,Model m)
    {
        policeStationModel model=new policeStationModel();
        
        
        List<Case> case_info=model.searchMissing(ageStart, ageEnd);
        
        m.addAttribute("case_info", case_info);
        
        return "ps_viewMissing";
    }
    
    
    @RequestMapping (value="ps_searchAccident")
    public String view_searchAccident()
    {
        return "ps_searchAccident";
    }
    
    @RequestMapping (value="ps_searchAccident",method=RequestMethod.POST)
    public String searchAccident(@RequestParam(value="ageStart") String ageStart,@RequestParam(value="ageEnd") String ageEnd,Model m)
    {
        policeStationModel model=new policeStationModel();
        
        List<Case> case_info=model.searchAccident(ageStart, ageEnd);
        m.addAttribute("case_info", case_info);
        return "ps_viewAccident";
    }
    
    
    @RequestMapping (value="ps_searchCriminal")
    public String view_searchCriminal()
    {
        return "ps_searchCriminal";
    }
    
    
    @RequestMapping (value="ps_CustomsearchCriminal",method=RequestMethod.POST)
    public String customSearchCriminal(@RequestParam (value="name") String name,@RequestParam (value="district") String district,@RequestParam(value="division") String division,Model m)
    {
        policeStationModel model =new policeStationModel();
        
        List<Criminal> criminal_info=model.customSearchCriminal(name, district, division);
        
        m.addAttribute("criminal_info", criminal_info);
        return "ps_viewCriminal";
    }
    
    @RequestMapping (value="ps_searchCriminal",method=RequestMethod.POST)
    public String searchCriminal(@RequestParam (value="name") String name,Model m)
    {
        policeStationModel model=new policeStationModel();
        List<Criminal> criminal_info=model.searchCriminal(name);
        
        m.addAttribute("criminal_info", criminal_info);
        return "ps_viewCriminal";
    }
    
    
    @RequestMapping (value="ps_criminalDoc")
    public String view_criminalDoc()
    {

        return "ps_criminalDoc";
    }
    
    @RequestMapping (value="ps_criminalDoc",method=RequestMethod.POST)
    public String criminalDoc(@RequestParam (value="criminal_id") String criminal_id,Model m)
    {
        policeStationModel model=new policeStationModel();
        Criminal criminal_info=model.get_criminalinfo(criminal_id);
        m.addAttribute("criminal_info", criminal_info);
        return "ps_criminalDoc";
    }
    
    
    @RequestMapping (value="ps_upCriminalDoc",method=RequestMethod.GET)
    public String view_upcriminalDoc(@RequestParam(value="id") String id,Model m)
    {
        if(id.isEmpty())
            return "ps_criminalDoc";
        m.addAttribute("criminal_id", id);
        
        return "ps_upCriminalDoc";
    }
    
    @RequestMapping (value="ps_upCriminalDoc",method=RequestMethod.POST)
    public String upCriminalDoc(@ModelAttribute("CriminalDocument") CriminalDocument doc,@RequestParam CommonsMultipartFile file,Model m )
    {
        
        String fileName=file.getOriginalFilename();
        String fileType=doc.getType();
        
        if(fileType.equals("Image"))
        {
            System.out.println(fileName);
            String imagePath="E:\\Programming Practice\\JSP\\projectFinal\\web\\resources\\criminal_images\\" +fileName ;
            
            try{
                File destination=new File(imagePath);
                file.transferTo(destination);
            }catch (Exception e) {

                e.printStackTrace();
            }
            
            doc.setPath(imagePath);
        }
        
        else{
            System.out.println(fileName);
            String docPath="E:\\Programming Practice\\JSP\\projectFinal\\web\\resources\\criminal_documents\\"+fileName;
            
            try{
                File destination=new File(docPath);
                file.transferTo(destination);
            }catch (Exception e) {

                e.printStackTrace();
            }
            doc.setPath(docPath);
        }
        
        policeStationModel model=new policeStationModel();
        model.insert_criminalDoc(doc);
        m.addAttribute("criminal_id", doc.getCriminalId());
        return "ps_upCriminalDoc";
    }
    
}
