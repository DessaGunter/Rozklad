package com.example.serg.rozklad;

public class Para {
    String predmet;
    String group;
    int n_tigden;
    int n_para;
    String teach;
    String chas;
    String aud;
    public Para( int n_tigden,String group,int n_para,String predmet, String teach,String chas,String aud){
        this.chas=chas;this.group=group;this.n_para=n_para;this.n_tigden=n_tigden;this.predmet=predmet;this.teach=teach;this.aud= aud;
    }
    public String toString(){
        return n_tigden+","+group+","+n_para+","+predmet+","+teach+","+chas+","+aud;
    }
}