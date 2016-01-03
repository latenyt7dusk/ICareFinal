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

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HERU
 */
public class Transaction {
    
    public String ID,OR,DATE,TOTAL,TAX,DISC,DEP,BAL,DUE;
    public List<Item> items = new ArrayList();
    
    public void setID(String id){
        this.ID = id;
    }
    public String getID(){
        return this.ID;
    }
    public void setOR(String or){
        this.OR = or;
    }
    public String getOR(){
        return this.OR;
    }
    public void setDate(String date){
        this.DATE = date;
    }
    public String getDate(){
        return this.DATE;
    }
    public void setTotal(String total){
        this.TOTAL = total;
    }
    public String getTax(){
        return this.TAX;
    }
    public void setDiscount(String disc){
        this.DISC = disc;
    }
    public String getDiscount(){
        return this.DISC;
    }
    public void setDeposit(String dep){
        this.DEP = dep;
    }
    public String getDeposit(){
        return this.DEP;
    }
    public void setBalance(String bal){
        this.BAL = bal;
    }
    public String getBalance(){
        return this.BAL;
    }
    public void setDue(String due){
        this.DUE = due;
    }
    public String getDue(){
        return this.DUE;
    }
    
    public void setItems(List<Item> items){
        this.items = items;
    }
    public void addItem(Item e){
        if(e != null){
            this.items.add(e);
        }        
    }
    public List<Item> getItems(){
        return this.items;
    }
}
