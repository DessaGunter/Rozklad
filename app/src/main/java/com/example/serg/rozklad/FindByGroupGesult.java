package com.example.serg.rozklad;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FindByGroupGesult {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("group")
    @Expose
    private String group;

    @SerializedName("predmet")
    @Expose
    private String predmet;

    @SerializedName("p_tigden")
    @Expose
    private String p_tigden;


    @SerializedName("n_para")
    @Expose
    private String n_para;

    @SerializedName("korpus")
    @Expose
    private String korpus;

    @SerializedName("aud")
    @Expose
    private String aud;

    @SerializedName("teach")
    @Expose
    private String teach;

    @SerializedName("d_tigden")
    @Expose
    private String d_tigden;

    @Override
    public String toString() {
        return "FindByGroupGesult{" +
                "id='" + id + '\'' +
                ", group='" + group + '\'' +
                ", predmet='" + predmet + '\'' +
                ", p_tigden='" + p_tigden + '\'' +
                ", n_para='" + n_para + '\'' +
                ", korpus='" + korpus + '\'' +
                ", aud='" + aud + '\'' +
                ", teach='" + teach + '\'' +
                ", d_tigden='" + d_tigden + '\'' +
                '}';
    }

    public String getId() {          return id;  }

    public String getGroup() {    return group;  }

    public String getPredmet() {  return predmet;}

    public String getP_tigden() {    return p_tigden;  }

    public String getN_para() {      return n_para;   }

    public String getKorpus() {      return korpus;    }

    public String getAud() {      return aud;    }

    public String getTeach() {    return teach;    }

    public String getD_tigden() {    return d_tigden;    }


    public void setId(String id) {                this.id = id;    }

    public void setGroup(String group) {       this.group = group;   }

    public void setPredmet(String predmet) {   this.predmet = predmet;   }

    public void setP_tigden(String p_tigden) {    this.p_tigden = p_tigden;    }

    public void setN_para(String n_para) {        this.n_para = n_para;    }

    public void setKorpus(String korpus) {        this.korpus = korpus;    }

    public void setAud(String aud) {           this.aud = aud;    }

    public void setTeach(String teach) {       this.teach = teach;    }

    public void setD_tigden(String d_tigden) {    this.d_tigden = d_tigden;    }
}
