package com.example.serg.rozklad;


import java.util.ArrayList;

public class Parser {
    ArrayList <Para> rozklad = new ArrayList();


    ArrayList getParaList(String request){
        ArrayList <Para> rozklad = new ArrayList();
        String predmet="";
        String group="";
        int n_tigden=0;
        int n_para=0;
        String teach="";
        String chas="";
        String aud="";
        request = request.replace("[", "");
        request = request.replace("]", "");
        request = request.replace("{", "<");
        request = request.replace("}", "");

        String [] n1 = request.split("<");
        for (String n2:n1){
            String [] n3 = n2.split(",");

            predmet = "";group ="";n_tigden=0;n_para =0;teach ="";chas ="";
            for (String n4:n3){
                n4 = n4.replace("\"", "");
                String [] n5 = n4.split(":");

                if (n5[0].equals("predmet"))predmet = n5[1];
                if (n5[0].equals("group"))group = n5[1];
                if (n5[0].equals("n_tigden"))n_tigden = Integer.parseInt(n5[1].replaceAll("[^0-9]", ""));
                if (n5[0].equals("n_para"))n_para = Integer.parseInt(n5[1].replaceAll("[^0-9]", ""));
                if (n5[0].equals("teach"))teach = n5[1];
                if (n5[0].equals("chas"))chas = n5[1];
                if (n5[0].equals("aud"))chas = n5[1];
            } rozklad.add(new Para(n_tigden, group, n_para, predmet,  teach, chas,aud));
        }
        return rozklad;
    }

}
