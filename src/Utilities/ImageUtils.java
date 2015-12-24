/*
 * Copyright (C) 2015 late7dusk
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
package Utilities;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author HERU
 */
public class ImageUtils {
    
    private static BufferedImage bi;
    private static Graphics g;
    private static Graphics2D g2;

    public static BufferedImage Convert(Icon icon) {
        bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        g = bi.createGraphics();
        icon.paintIcon(null, g, 0, 0);
        g.dispose();
        return bi;
    }
    
    public static Icon makeWatermark(BufferedImage b,float o) {
        Icon icon = new ImageIcon(b);
        bi = new BufferedImage(
                icon.getIconWidth(),
                icon.getIconHeight(),
                BufferedImage.TYPE_INT_ARGB);
        g2 = bi.createGraphics();
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, o));
        icon.paintIcon(null, g, 0, 0);
        g2.dispose();
        return new javax.swing.ImageIcon(bi);
    }

    public static BufferedImage Colorize(Icon icon, Color c) {
        bi = Convert(icon);
        Colorizer.doRGB(c, bi);
        return bi;
    }

    public static BufferedImage Colorize(Icon icon, int r, int g, int b) {
        bi = Convert(icon);
        Colorizer.doRGB(new Color(r, g, b), bi);
        return bi;
    }

    public static BufferedImage Colorize(Icon icon, int r, int g, int b, int a) {
        bi = Convert(icon);
        Colorizer.doRGB(new Color(r, g, b, a), bi);
        return bi;
    }
    
    public static String RGBtoHex(Color col){
       String r =  String.valueOf(Integer.valueOf(String.valueOf(col.getRed()), 16));
       String g =  String.valueOf(Integer.valueOf(String.valueOf(col.getGreen()), 16));
       String b =  String.valueOf(Integer.valueOf(String.valueOf(col.getBlue()), 16));
       return "#"+r+g+b;
    }

    public static ByteArrayOutputStream crop(ByteArrayInputStream bais, int width, int height) throws IOException {
        BufferedImage src = ImageIO.read(bais);
        BufferedImage clipping = crop(src, width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(clipping, "JPG", baos);
        return baos;
    }

    public static BufferedImage crop(BufferedImage src, int width, int height) throws IOException {
        int x = src.getWidth() / 2 - width / 2;
        int y = src.getHeight() / 2 - height / 2;

        BufferedImage clipping = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D area = (Graphics2D) clipping.getGraphics().create();
        area.drawImage(src, 0, 0, clipping.getWidth(), clipping.getHeight(), x, y, x + clipping.getWidth(),
                y + clipping.getHeight(), null);
        area.dispose();
        
        return clipping;
    }

    public static ByteArrayOutputStream smartCrop(ByteArrayInputStream bais, int width, int height) throws IOException {
        BufferedImage src = ImageIO.read(bais);

        Float scale;
        if (src.getWidth() > src.getHeight()) {
            scale = Float.valueOf(height) / Float.valueOf(src.getHeight());
            if (src.getWidth() * scale < width) {
                scale = Float.valueOf(width) / Float.valueOf(src.getWidth());
            }
        } else {
            scale = Float.valueOf(width) / Float.valueOf(src.getWidth());
            if (src.getHeight() * scale < height) {
                scale = Float.valueOf(height) / Float.valueOf(src.getHeight());
            }
        }

        
        BufferedImage temp = scale(src, Float.valueOf(src.getWidth() * scale).intValue(),
                Float.valueOf(src.getHeight() * scale).intValue());

        temp = crop(temp, width, height);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(temp, "JPG", baos);

        return baos;
    }

    public static ByteArrayOutputStream scale(ByteArrayInputStream bais, int width, int height) throws IOException {
        BufferedImage src = ImageIO.read(bais);
        BufferedImage dest = scale(src, width, height);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(dest, "JPG", baos);
        return baos;
    }

    public static BufferedImage scale(BufferedImage src, int width, int height) throws IOException {
        BufferedImage dest = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = dest.createGraphics();
        AffineTransform at = AffineTransform.getScaleInstance(
                (double) width / src.getWidth(),
                (double) height / src.getHeight());
        g.drawRenderedImage(src, at);
        return dest;
    }

}
