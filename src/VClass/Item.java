/*
 * Copyright (C) 2015 Late7dusk
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

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Late7dusk
 */
public class Item implements Cloneable {

    public static final String INVENTORY = "Inventory";
    public static final String OUTSOURCE = "Outsource";
    private String ID, CATEGORY, TYPE, NAME, DESC;
    private String QTY = "0";
    private String PRICE = "0";
    private String AMT = "0";
    private String LOW = "0";
    private Item CLONE;

    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return this.ID;
    }

    public void setCategory(String cat) {
        this.CATEGORY = cat;
    }

    public String getCategory() {
        return this.CATEGORY;
    }

    public void setType(String typ) {
        this.TYPE = typ;
    }

    public String getType() {
        return this.TYPE;
    }

    public void setName(String name) {
        this.NAME = name;
    }

    public String getName() {
        return this.NAME;
    }

    public void setDescription(String desc) {
        this.DESC = desc;
    }

    public String getDescription() {
        return this.DESC;
    }

    //Quantity
    public void setQuantity(int i) {
        this.QTY = String.valueOf(i);
        this.setAmount(this.QTY, this.PRICE);
    }
    public void setQuantity(String qty){
        this.QTY = qty;
        this.setAmount(this.QTY, this.PRICE);
    }

    public String getQuantity() {
        return this.QTY;
    }

    public void addjustQuantity(int i) {
        this.QTY = String.valueOf((Integer.parseInt(this.QTY) + i));
        this.setAmount(this.QTY, this.PRICE);
    }
    //Price
    public void setPrice(double prc){
        this.PRICE = Manager.CURRENCY_FORMATTER.format(prc);
        this.setAmount(this.QTY, this.PRICE);
    }
    public void setPrice(String prc){
        this.PRICE = Manager.CURRENCY_FORMATTER.format(prc);
        this.setAmount(this.QTY, this.PRICE);
    }
    public String getPrice(){
        return this.PRICE;
    }
    //Amount
    private void setAmount(String qty,String prc){
        this.AMT = String.valueOf(Manager.CURRENCY_FORMATTER.format((Integer.parseInt(qty)*Double.parseDouble(prc))));
    }
    public String getAmount(){
        return this.AMT;
    }
    //Low Level Quantity
    public void setLowQuantityLimit(int i){
        this.LOW = String.valueOf(i);
    }
    public void setLowQuantityLimit(String i){
        this.LOW = i;
    }
    public String getLowQuantityLimit(){
        return this.LOW;
    }
    public boolean hasLowQuantity(){
        return ((this.LOW.equals("0"))? false:(Integer.parseInt(this.LOW) >= Integer.parseInt(this.QTY)));
    }
        
    public Item sell(int i) {
        try {
            if (Integer.parseInt(this.QTY) >= i) {
                CLONE = (Item) this.clone();

                return CLONE;
            } else {
                return null;
            }
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(Item.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
