
package com.police.controller;

import com.police.entity.CaseDocuments;
import com.police.entity.CaseRecord;
import com.police.entity.CriminalCaseRecord;
import com.police.entity.CriminalDocument;
import com.police.entity.CriminalRecord;
import com.police.entity.PoliceStationUser;
import com.police.model.PolicePSModel;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author asifmuztaba
 */
@Controller
public class PoliceStationController {

    static HttpSession session;
    PolicePSModel psModel = new PolicePSModel();

    
    public static void craeteLoginSession(PoliceStationUser user, HttpServletRequest req) {
        System.out.println("Session Created");
        user.setPassword("null");
        session = req.getSession();
        session.setAttribute("ps", user.getPsName());
        session.setAttribute("user", user);

    }

    
    public static boolean checkSession() {
        boolean login = false;
        PoliceStationUser user;
        try {
            user = (PoliceStationUser) session.getAttribute("user");
            if (user.getRole().equals("PS_ADMIN")) {
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

    
    @RequestMapping(value = "PoliceStation/dashBoard")
    public String viewDash() {
        return "PoliceStation/dashBoard";
    }

    
    @RequestMapping(value = "PoliceStation/newCase", method = RequestMethod.GET)
    public String viewCaseInfoForm() {

        return "PoliceStation/newCase";
    }

    
    @RequestMapping(value = "PoliceStation/newCase", method = RequestMethod.POST)
    public String insertCaseInfo(@ModelAttribute(value = "CaseRecord") CaseRecord newCase, Model model) {

        PoliceStationUser user = (PoliceStationUser) session.getAttribute("user");
        System.out.println("Criem : " + newCase.getCrimeDate().toString());
        System.out.println("Criem : " + newCase.getCaseFileDate().toString());
        newCase.setPoliceStation(user.getPsName());
        newCase.setDistrict(user.getDistrict());
        newCase.setDivision(user.getDivision());
        newCase.setCaseId("C" + psModel.getCaseRecordMaxId().add(BigDecimal.ONE));
        System.out.println("case id :" + newCase.getCaseId());
        boolean insert = psModel.insertNewCase(newCase);
        System.out.println("insert val : " + insert);
        if (insert == true) {
            System.out.println("saodhashdhasihdiaosh");
            model.addAttribute("caseInfo", newCase);
            return "PoliceStation/CaseManagement";
        } else {
            return "PoliceStation/newCase";
        }
    }

    
    @RequestMapping(value = "PoliceStation/caseList", method = RequestMethod.GET)
    public String viewCaseList(Model m) {
        PoliceStationUser user = (PoliceStationUser) session.getAttribute("user");
        String sDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        List<CaseRecord> caseList = psModel.getPSCaseList(user.getPsName(), new Date());
        m.addAttribute("caseList", caseList);
        m.addAttribute("sDate", sDate);
        return "PoliceStation/caseList";
    }

    
    @RequestMapping(value = "PoliceStation/caseList", method = RequestMethod.POST)
    public String viewCaseListToDate(Model model, @RequestParam(value = "searchDate") String date) {
        PoliceStationUser user = (PoliceStationUser) session.getAttribute("user");

        Date searchDate = new Date();

        System.out.println("searchDate :  " + searchDate);
        try {
            searchDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String sDate = new SimpleDateFormat("yyyy-MM-dd").format(searchDate);
        List<CaseRecord> caseList = psModel.getPSCaseList(user.getPsName(), searchDate);
        model.addAttribute("caseList", caseList);
        model.addAttribute("sDate", sDate);
        return "PoliceStation/caseList";
    }

    
    @RequestMapping(value = "PoliceStation/CaseManagement")
    public String viewCaseManageMent(@RequestParam(value = "caseId") String caseId, Model model) {
        CaseRecord caseObj = psModel.getCaseRecordByCaseId(caseId);
        
        List<CaseDocuments> caseDocList = psModel.getCaseDocByCaseId(caseId);
        List<CriminalCaseRecord> cclist=psModel.getCriminalByCase(caseId);
        
        System.out.println("Doc list Size : " + caseDocList.size());
        model.addAttribute("caseDocList", caseDocList);
        model.addAttribute("caseObj", caseObj);
        model.addAttribute("cclist", cclist);
       
        return "PoliceStation/CaseManagement";
    }

    
    @RequestMapping(value = "addCaseDoc", method = RequestMethod.POST)
    public String addCaseDoc(@ModelAttribute(value = "CaseDocuments") CaseDocuments CaseDoc) {
        return "PoliceStation/CaseManagement";
    }

    
    @RequestMapping(value = "PoliceStation/uploadCaseFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadCaseFile(@RequestParam(value = "file1") MultipartFile file1,
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "caseId") String caseId,
            @RequestParam(value = "fileType") String fileType,
            HttpServletRequest req) {

        CaseDocuments newDoc = new CaseDocuments();
        newDoc.setCaseId(caseId);
        newDoc.setFileName(fileName);
        newDoc.setFileType(fileType);
        
        String root = req.getRealPath("/");
        String rootPath = root.substring(0, root.indexOf("OnlinePoliceStation"));
        
        try {
            if (newDoc.getFileType().contains("Image")) {
                String location = "OnlinePoliceStation\\src\\main\\webapp\\resources\\case_images\\";
                String newFileName=caseId + "_" + file1.getOriginalFilename();
                
                BufferedOutputStream outputStream = new BufferedOutputStream(
                                                    new FileOutputStream(
                                                    new File(rootPath + location, newFileName)));
                outputStream.write(file1.getBytes());
                outputStream.flush();
                outputStream.close();
                
                newDoc.setPath(rootPath+location+newFileName);
                System.out.println("Path : "+newDoc.getPath());
            } else {
                String location = "OnlinePoliceStation\\src\\main\\webapp\\resources\\case_documents\\";
                String newFileName=caseId + "_" + file1.getOriginalFilename();
                
                BufferedOutputStream outputStream = new BufferedOutputStream(
                                                    new FileOutputStream(
                                                    new File(rootPath + location, newFileName)));
                outputStream.write(file1.getBytes());
                outputStream.flush();
                outputStream.close();
                
                newDoc.setPath(rootPath+location+newFileName);
                System.out.println("Path : "+newDoc.getPath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        boolean insert=psModel.insertCaseDoc(newDoc);
        if(insert == true)
            return "Successfully uploaded...";
        else
             return "Server error...";
    }
    
    
    @RequestMapping(value = "PoliceStation/addCriminal")
    public @ResponseBody
    String addCriminal(@RequestParam(value = "caseID") String caseID,
                        @RequestParam(value = "criminalName") String criminalName,
                        @RequestParam(value = "criminalFather") String criminalFather,
                        @RequestParam(value = "criminalBirth") String criminalBirth,
                        @RequestParam(value = "address") String address,
                        @RequestParam(value = "district") String district,
                        @RequestParam(value = "division") String division,
                        @RequestParam(value = "policeStation") String policeStation)
    {
        CriminalRecord criminal=new CriminalRecord();
        System.out.println("Got req...");
        criminal.setAddress(address);
        try {
            criminal.setCriminalBirth(new SimpleDateFormat("yyyy-MM-dd").parse(criminalBirth));
        } catch (ParseException ex) {
            Logger.getLogger(PoliceStationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        criminal.setCriminalFather(criminalFather);
        criminal.setCriminalId("CRIM"+psModel.getCriminalMaxId().add(BigDecimal.ONE));
        criminal.setCriminalName(criminalName);
        criminal.setDistrict(district);
        criminal.setDivision(division);
        criminal.setPoliceStation(policeStation);
        
        BigDecimal maxId=psModel.getCriminalMaxId();
        System.out.println("Criminal max id : "+maxId);
        
        boolean insert=psModel.insertCriminalRec(criminal);
        if(insert == true)
        {
            CriminalCaseRecord criminalCase=new CriminalCaseRecord();
            criminalCase.setCriminalId(criminal.getCriminalId());
            criminalCase.setCaseId(caseID);
            criminalCase.setCriminalName(criminalName);
            criminalCase.setStatus("Running");
            
            insert=psModel.insertCriminalCaseRec(criminalCase);
            if(insert == true)
                return "Criminal Added";
            else
                return "Error occured";
        }
            
        else
            return "Error occured";
    }
    
    
    @RequestMapping(value = "PoliceStation/CriminalManagement")
    public String viewCriminalManagement(@RequestParam(value = "id") String crimId,Model model)
    {
        CriminalRecord criminal=psModel.getCriminalById(crimId);
        System.out.println("Criminal name : "+criminal.getCriminalName()+"ID :"+crimId);
        List<CriminalCaseRecord> crimCaseList=psModel.getCaseByCriminalId(crimId);
        List<CriminalDocument> crimDocList=psModel.getCriminalDocByCriminalId(crimId);
        
        model.addAttribute("criminal", criminal);
        model.addAttribute("crimCaseList", crimCaseList);
        model.addAttribute("crimDocList", crimDocList);
        
        return "PoliceStation/CriminalManagement";
    }
    
    
    @RequestMapping(value = "PoliceStation/uploadCriminalFile", method = RequestMethod.POST)
    public @ResponseBody
    String uploadCriminalFile(@RequestParam(value = "file1") MultipartFile file1,
            @RequestParam(value = "fileName") String fileName,
            @RequestParam(value = "criminalId") String criminalId,
            @RequestParam(value = "fileType") String fileType,
            HttpServletRequest req) {
        CriminalDocument newDoc = new CriminalDocument();
        newDoc.setCriminalId(criminalId);
        newDoc.setFileName(fileName);
        newDoc.setFileType(fileType);
        
        String root = req.getRealPath("/");
        String rootPath = root.substring(0, root.indexOf("OnlinePoliceStation"));
        
        try {
            if (newDoc.getFileType().contains("Image")) {
                System.out.println("Criminal Id : "+criminalId);
                String location = "OnlinePoliceStation\\src\\main\\webapp\\resources\\criminal_images\\";
                String newFileName=criminalId + "_" + file1.getOriginalFilename();
                
                BufferedOutputStream outputStream = new BufferedOutputStream(
                                                    new FileOutputStream(
                                                    new File(rootPath + location, newFileName)));
                outputStream.write(file1.getBytes());
                outputStream.flush();
                outputStream.close();
                
                newDoc.setFilePath(rootPath+location+newFileName);
                System.out.println("Path : "+newDoc.getFilePath());
            } else {
                String location = "OnlinePoliceStation\\src\\main\\webapp\\resources\\criminal_documents\\";
                String newFileName=criminalId + "_" + file1.getOriginalFilename();
                
                BufferedOutputStream outputStream = new BufferedOutputStream(
                                                    new FileOutputStream(
                                                    new File(rootPath + location, newFileName)));
                outputStream.write(file1.getBytes());
                outputStream.flush();
                outputStream.close();
                
                newDoc.setFilePath(rootPath+location+newFileName);
                System.out.println("Path : "+newDoc.getFilePath());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        boolean insert=psModel.insertCriminalDoc(newDoc);
        if(insert == true)
            return "Successfully uploaded...";
        else
             return "Server error...";
    }
    
    
    @RequestMapping(value = "PoliceStation/download")
    public  @ResponseBody void downLoadFile(@RequestParam(value = "file") String path,HttpServletResponse response)
    {
        System.out.println("Download Path : "+path);
        try {
        DefaultResourceLoader loader = new DefaultResourceLoader();
        InputStream is = loader.getResource(path).getInputStream();
        IOUtils.copy(is, response.getOutputStream());
        
        response.flushBuffer();
        is.close();
    } catch (IOException ex) {
        
        ex.printStackTrace();
    }
        
    }
}
