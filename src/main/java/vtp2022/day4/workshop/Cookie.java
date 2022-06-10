package vtp2022.day4.workshop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Cookie {


    public static String ChooseCookies(String cookieFilePath) throws IOException {
        // System.out.println("ChooseCookies Filepath A: "+ cookieFilePath);
        // String workingDirectory = System.getProperty("user.dir");
        // String cookieAbsolutePath = workingDirectory.concat("/").concat(cookieFilePath);
        // System.out.println("ChooseCookies Filepath B: "+ cookieAbsolutePath);

        InputStream is = new FileInputStream(cookieFilePath);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String flavour;    
        List<String> cookies = new LinkedList<>();
        while((flavour = br.readLine()) != null)
            cookies.add(flavour);
        br.close();
        isr.close();


        for (String cookie : cookies){
            System.out.println(cookie);
        }

        Random rand = new Random();
        return cookies.get(rand.nextInt(cookies.size())).toString();
    }

}
