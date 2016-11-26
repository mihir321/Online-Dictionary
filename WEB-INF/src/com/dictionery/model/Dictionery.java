/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dictionery.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.dictionery.util.DbConnection;
import java.util.HashMap;
import java.util.Map;


public class Dictionery {
  
    public Map getWordDefinition(String word){
        Map<String,String> def = new HashMap<String,String>();
        try{
            DbConnection dsc = new DbConnection();
            Connection con = dsc.getDatabaseConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from entries where word='"+word+"'");
            int i=1;
            while(rs.next()){
                def.put(Integer.toString(i),i+"("+rs.getString("wordtype")+") :: "+rs.getString("definition"));
                i++;
            }
        }catch (Exception ex) {
            // handle the error
            throw new IllegalStateException("Cannot connect the database!", ex);
        }
        return def;
    }
}
