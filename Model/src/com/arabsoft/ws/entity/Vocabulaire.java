package com.arabsoft.ws.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
public class Vocabulaire {


    @XmlElement
    Long id;

    @XmlElement
    String iCode;

    @XmlElement
    String code;

    @XmlElement
    String libelle;

    @XmlElement
    String libelleAr;

    public Vocabulaire(Long id, String iCode, String code, String libelle, String libelleAr) {
        super();
        this.id = id;
        this.iCode = iCode;
        this.code = code;
        this.libelle = libelle;
        this.libelleAr = libelleAr;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setICode(String iCode) {
        this.iCode = iCode;
    }

    public String getICode() {
        return iCode;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelleAr(String libelleAr) {
        this.libelleAr = libelleAr;
    }

    public String getLibelleAr() {
        return libelleAr;
    }
}
