package com.arabsoft.ws.controller;

import com.arabsoft.ws.entity.Vocabulaire;

import com.arabsoft.ws.util.RestApiUtil;

import com.google.gson.Gson;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import javax.ws.rs.core.Response;

import oracle.jbo.ApplicationModule;
import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.ViewObject;

@Path(value = "vocabulaire")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VocabulaireController {
    
    public VocabulaireController(){}
    
    private static final Logger LOGGER = Logger.getLogger(VocabulaireController.class.getName());


    @GET
    @Path("listbycode/{code}")
    public Response listVocabulaireParType(@PathParam("code")
        String code) {
        ApplicationModule am = null;
        Gson gson = new Gson();
        List<Vocabulaire> list = new ArrayList<Vocabulaire>();
        try {

                    am = RestApiUtil.GetInstanceRestApplicationModule();
                    ViewObject vowVo = am.findViewObject("VocabulaireVO1");
                    vowVo.setNamedWhereClauseParam("code", code);
                    vowVo.executeQuery();
                    RowIterator ri = vowVo.createRowSetIterator(null);
                    Row r = null;
                    while (ri.hasNext()) {
                        r = ri.next();
                        list.add(new Vocabulaire((Long) r.getAttribute("VowId"), (String) r.getAttribute("VowCode"),
                                                 (String) r.getAttribute("VowIcode"), (String) r.getAttribute("VowName"),
                                                 (String) r.getAttribute("VowName")));
                    } 
                } catch (Exception ex) {
                    LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
                    return Response.status(500).entity(gson.toJson(ex.getMessage())).type(MediaType.APPLICATION_JSON).build();
                } finally {
                    if (am != null)
                        RestApiUtil.ReleaseInstanceRestApplicationModule(am);
                }
                return Response.ok(gson.toJson(list), MediaType.APPLICATION_JSON).build();

        
    }
}
