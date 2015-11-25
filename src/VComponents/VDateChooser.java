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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author HERU
 */
public class VDateChooser extends JPanel{
    
    private static VComboBox MM = new VComboBox(new Object[]{"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"});
    private static VComboBox DD = new VComboBox(new Object[]{"1"});
    private static VComboBox YY = new VComboBox(new Object[]{"2015"});
    private static Date selDate = new Date();
    private static final Calendar curDate = Calendar.getInstance();
    private static final long MILLI_SECONDS_YEAR = 31558464000L;
    private static final long MILLI_SECONDS_DAY = 86400000L;
    private static final ActionListener DAction = new VDateAction();
    
    public VDateChooser(){
        setOpaque(false);
        setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(116,20));
        MM.setMaximumRowCount(12);
        MM.setPreferredSize(new Dimension(34,20));
        DD.setPreferredSize(new Dimension(32,20));
        YY.setPreferredSize(new Dimension(40,20));
        
        
        
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
    
    

    @Override
    public void setEnabled(boolean bln) {
        super.setEnabled(bln); 
        MM.setEnabled(bln);
        DD.setEnabled(bln);
        YY.setEnabled(bln);
    }
    
    private static void MaxDays(int mm,int yy){
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
    
    public Date getDate(){
        return selDate;
    }
    
    private static class VDateAction implements ActionListener{

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
        }
        
    }
    
}
