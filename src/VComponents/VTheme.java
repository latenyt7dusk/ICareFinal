package VComponents;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author HERU
 */
public abstract interface VTheme {
    
    abstract void setVThemeColor(Color c);
    abstract Color getVThemeColor();
    abstract void setVThemeAlpha(int i);
    abstract int getVThemeAlpha();
    
    abstract void setVSubColor(Color c);
    abstract Color getVSubColor();
    abstract void setVSubAlpha(int i);
    abstract int getVSubAlpha();
    
    abstract void setVImage(Icon i);
    abstract Icon getVImage();
    
    abstract void setVThemeVisible(boolean b);
    abstract boolean isVThemeVisible();
    
    abstract void setVSubVisible(boolean b);
    abstract boolean isVSubVisible();
    
}
