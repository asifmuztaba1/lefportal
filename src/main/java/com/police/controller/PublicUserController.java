
package com.police.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author asifmuztaba
 */
@Controller
public class PublicUserController {
    
    public static void getUserCredential(String email,String encryptedPassw)
    {
        System.out.println("Pub"+email);
        System.out.println("Pubpas"+encryptedPassw);
    }
    
    @RequestMapping(value = "PublicUser/dashBoard")
    public String showDash()
    {
        System.out.println("PubCon Got Call......");
        return "PublicUser/dashBoard";
    }
}
