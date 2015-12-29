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
package VComponents;

import VComponents.VComboBox.ItemRenderer;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HERU
 */
public class VDateChooser extends JPanel{
    
    private VComboBox MM = new VComboBox(new Object[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
    private VComboBox DD = new VComboBox(new Object[]{"1"});
    private VComboBox YY = new VComboBox(new Object[]{"2015"});
    private Date selDate = new Date();
    private final Calendar curDate = Calendar.getInstance();
    private final long MILLI_SECONDS_YEAR = 31558464000L;
    private final long MILLI_SECONDS_DAY = 86400000L;
    private final ActionListener DAction = new VDateAction();
    private VTextField Age;
    private SimpleDateFormat SDF;
    
    public VDateChooser(){
        setOpaque(false);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(116,20));
        MM.setMaximumRowCount(12);
        MM.setPreferredSize(new Dimension(34,20));
        DD.setPreferredSize(new Dimension(28,20));
        YY.setPreferredSize(new Dimension(44,20));
        
        
        
        add(MM);
        add(new JLabel(" "));
        add(DD);
        add(new JLabel(" "));
        add(YY);
        
        MM.setNextFocusableComponent(DD);
        DD.setNextFocusableComponent(YY);
        
        ((ItemRenderer) MM.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        ((ItemRenderer) DD.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        ((ItemRenderer) YY.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        
        initStart(curDate.getTime());
        setDate(Calendar.getInstance().getTime());
        
        MM.addActionListener(DAction);
        YY.addActionListener(DAction);
    }
    
    public VDateChooser(VTextField e){
        Age = e;
        setOpaque(false);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(116,20));
        MM.setMaximumRowCount(12);
        MM.setPreferredSize(new Dimension(34,20));
        DD.setPreferredSize(new Dimension(28,20));
        YY.setPreferredSize(new Dimension(44,20));
        
        
        
        add(MM);
        add(new JLabel(" "));
        add(DD);
        add(new JLabel(" "));
        add(YY);
        
        MM.setNextFocusableComponent(DD);
        DD.setNextFocusableComponent(YY);
        
        ((ItemRenderer) MM.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        ((ItemRenderer) DD.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        ((ItemRenderer) YY.getRenderer()).labelItem.setHorizontalAlignment(JLabel.CENTER);
        
        initStart(curDate.getTime());
        setDate(Calendar.getInstance().getTime());
        
        MM.addActionListener(DAction);
        YY.addActionListener(DAction);
    }
    
        
    public void setAgeField(VTextField e){
        Age = e;
    }

    @Override
    public void setEnabled(boolean bln) {
        super.setEnabled(bln); 
        MM.setEnabled(bln);
        DD.setEnabled(bln);
        YY.setEnabled(bln);
    }
    
    private void MaxDays(int mm,int yy){
        try{
            
            Date tmp = Calendar.getInstance().getTime();
            tmp.setMonth(mm);
            tmp.setYear(yy);
            tmp.setDate(1);
            
            int i = tmp.getMonth();
            
            DD.removeAllItems();
            while(i == tmp.getMonth()){
                DD.addItem(String.valueOf(tmp.getDate()));
                tmp.setTime(tmp.getTime()+(MILLI_SECONDS_DAY));
            }
            DD.setSelectedIndex(0);
            
        }catch(Exception er){
            
        }
    }
    
    private void initStart(Date d){
        YY.removeAllItems();
        for(int i = 1915;i <= 2115;i++){
            YY.addItem(String.valueOf(i));
        }
    }
    
    
    
    public void setDate(Date e){
        Calendar cal = new GregorianCalendar();
        cal.setTime(e);
        selDate = cal.getTime();
        MM.setSelectedIndex(selDate.getMonth());
        YY.setSelectedIndex(selDate.getYear()-15);
        MaxDays(selDate.getMonth(),selDate.getYear());
        DD.setSelectedIndex(selDate.getDate()-1);
    }
    
    public void setDate(String e,String f){
        try {
            SDF = new SimpleDateFormat(f);
            Calendar cal = new GregorianCalendar();
            cal.setTime(SDF.parse(e));
            selDate = cal.getTime();
            MM.setSelectedIndex(selDate.getMonth());
            YY.setSelectedIndex(selDate.getYear()-15);
            MaxDays(selDate.getMonth(),selDate.getYear());
            DD.setSelectedIndex(selDate.getDate()-1);
            if(Age!= null){
                Age.setText(String.valueOf(computeAge(selDate)));
            }
        } catch (ParseException ex) {
            Logger.getLogger(VDateChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Date getDate(){
        return selDate;
    }
    
    public String getFormattedDate(String format){
        SDF = new SimpleDateFormat(format);
        return SDF.format(selDate);
    }
    
    private int computeAge(Date sDate) {
        Date dbDate = null;
        try {
            dbDate = sDate;
            dbDate.setHours(0);
            long timeDiff = ((System.currentTimeMillis() <= dbDate.getTime())? 0: System.currentTimeMillis() - dbDate.getTime());
            int age = (int) (timeDiff / MILLI_SECONDS_YEAR);

            return age;
        } catch (Exception e) {
            return 0;
        }
    }
    
    private class VDateAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == MM){
                MaxDays(MM.getSelectedIndex(),YY.getSelectedIndex()+1);
            }else if(e.getSource() == YY){
                MaxDays(MM.getSelectedIndex(),YY.getSelectedIndex()+1);
            }
            
            selDate.setMonth(MM.getSelectedIndex());
            selDate.setYear(YY.getSelectedIndex()+15);
            selDate.setDate(DD.getSelectedIndex()+1);
            if(Age != null){
                Age.setText(String.valueOf(computeAge(selDate)));
            }
        }
        
    }
    
}
