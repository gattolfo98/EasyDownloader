/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easydownloader;

import java.io.Serializable;

/**
 *
 * @author gattolfo
 */
public class Dwn implements Serializable{
    private static final long serialVersionUID = 6529685098267757690L;
    private String name;
    private String url;
    private String info;
    private int type;
//    public Dwn(){
//        name = "";
//        url = "";
//    }
//    
//    public Dwn(String name,String url){
//        this.name = name;
//        this.url = url;
//    }
//    
    public Dwn(String name,String url,String info,int type){
        this.name = name;
        this.url = url;
        this.info = info;
        this.type = type;
    }
    
    public String getName(){
        return name;
    }
    public String getUrl(){
        return url;
    }
    
    public String getInfo(){
        return info;
    }
    
    public int getType(){
        return type;
    }
    
}
