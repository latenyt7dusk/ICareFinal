/*
 * Copyright (C) 2015 HERU
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package VClass;

import Utilities.DataBridge;

/**
 *
 * @author HERU
 */
public class User extends PersonalInfo{
    
    private String uname,upass,role;
    
    
    public User(){
        this(null,null,null,null);
    }
    public User(String id,String u,String p,String r){
        this.setID(id);
        this.uname = u;
        this.upass = p;
        this.role = r;
    }
    
    public void setUsername(String u){
        this.uname = u;
    }
    public String getUsername(){
        return uname;
    }
    
    public void setPassword(String p){
        this.upass = p;
    }
    public String getPassword(){
        return upass;
    }
    
    public void setRole(String r){
        this.role = r;
    }
    public String getRole(){
        return role;
    }
    
    public String getUserEntry(){
        return getID()+","+uname+","+upass+","+role;
    }
    
    public java.util.List<String> getBatch(){
        java.util.List<String> tmp = new java.util.ArrayList();
        tmp.add("INSERT INTO "+Manager.USER_TABLE_NAME+ " VALUES('"+getID()+"','"+uname+"','"+upass+"','"+role+"')");
        tmp.add("INSERT INTO "+Manager.PERSONAL_TABLE_NAME+ " VALUES('"+getID()+"','"+getSurname()+"','"+getFirstname()+"','"
                +getMiddlename()+"','"+getBirthdate()+"','"+getGender()+"','"+getCivilStatus()+"','"+getContactNumber()+"','"
                +getEmail()+"','"+getAddress()+"')");
        return tmp;
    }
    
    public void LoadPersonalInfo(DataBridge DB){
        try{
            java.util.List<String> data = DB.FetchRowData(Manager.PERSONAL_TABLE_NAME, Manager.ID, getID());
            setSurname(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.SURNAME)));
            setFirstname(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.FIRSTNAME)));
            setMiddlename(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.MIDDLENAME)));
            setBirthdate(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.BIRTHDATE)));
            setGender(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.GENDER)));
            setCivilStatus(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.CIVILSTATUS)));
            setContactNumber(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.CONTACT)));
            setEmail(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.EMAIL)));
            setAddress(data.get(Manager.PERSONAL_TABLE_MAP.get(Manager.ADDRESS)));
        }catch(Exception er){
            
        }
    }
    
}
