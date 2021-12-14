package com.arabsoft.ws.util;

import oracle.jbo.ApplicationModule;
import oracle.jbo.client.Configuration;

public class RestApiUtil {
    
    private static String restApiAmDef = "com.arabsoft.ws.am.GeneralAM";
    private static String config = "GeneralAMLocal"; 
    
    public static ApplicationModule GetInstanceRestApplicationModule(){
            return Configuration.createRootApplicationModule(restApiAmDef, config);
        }
        
        public static void ReleaseInstanceRestApplicationModule(ApplicationModule am){
            Configuration.releaseRootApplicationModule(am, true);
        }
}
