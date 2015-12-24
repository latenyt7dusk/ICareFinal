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
package Utilities;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Late7dusk
 */
public class ImageLimiterTest
{
    public static void main(String[] args) throws IOException
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    createAndShowGUI();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        });
    }

    private static void createAndShowGUI() throws IOException
    {
        JFrame f = new JFrame("ImageLimiter");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageLimiterPanel imageLimiterPanel = new ImageLimiterPanel(new ImageLimiter());
        BufferedImage inputImage = ImageIO.read(new File("E:\\Wallpapers\\goTO0.jpg"));
        imageLimiterPanel.setInputImage(inputImage);
        f.getContentPane().add(imageLimiterPanel);
        f.setSize(800,600);
        f.setVisible(true);
    }
}

class ImageLimiter
{
    private BufferedImage inputImage;
    private BufferedImage scaledImage;
    private BufferedImage outputImage;

    private int maxResolution;
    private float quality;

    private int fileSizeBytes;

    public void setInputImage(BufferedImage inputImage)
    {
        this.inputImage = inputImage;
        this.maxResolution = Math.max(inputImage.getWidth(), inputImage.getHeight());
        this.quality = 1.0f;
        this.scaledImage = computeScaledImage(inputImage, maxResolution);
        updateOutputImage();
    }

    public BufferedImage getOutputImage()
    {
        return outputImage;
    }

    public int getFileSizeBytes()
    {
        return fileSizeBytes;
    }

    public void setMaxResolution(int maxResolution)
    {
        this.maxResolution = maxResolution;
        this.scaledImage = computeScaledImage(inputImage, maxResolution);
        updateOutputImage();
    }

    public void setQuality(float quality)
    {
        this.quality = quality;
        updateOutputImage();
    }

    public float getQuality()
    {
        return quality;
    }

    public void setMaxFileSize(int maxFileSizeBytes)
    {
        this.quality = computeQuality(scaledImage, maxFileSizeBytes);
        updateOutputImage();
    }

    private void updateOutputImage()
    {
        try
        {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            writeJPG(scaledImage, baos, quality);
            baos.close();
            byte data[] = baos.toByteArray();
            fileSizeBytes = data.length;
            ByteArrayInputStream bais = new ByteArrayInputStream(data);
            outputImage = ImageIO.read(bais);
            bais.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    static float computeQuality(BufferedImage image, int sizeLimitBytes)
    {
        int minSizeBytes = computeSizeBytes(image, 0.0f);
        if (sizeLimitBytes < minSizeBytes)
        {
            return 0.0f;
        }
        int maxSizeBytes = computeSizeBytes(image, 1.0f);
        if (sizeLimitBytes > maxSizeBytes)
        {
            return 1.0f;
        }
        float intervalSize = 0.5f;
        float quality = 0.5f;
        float lastSmaller = 0;
        while (true)
        {
            int sizeBytes = computeSizeBytes(image, quality);
            if (sizeBytes >= sizeLimitBytes)
            {
                //System.out.println("For "+quality+" have size "+sizeBytes+", decrease quality by "+intervalSize);
                quality -= intervalSize;
                intervalSize /= 2;
            }
            else if (sizeBytes < sizeLimitBytes)
            {
                //System.out.println("For "+quality+" have size "+sizeBytes+", increase quality by "+intervalSize);
                lastSmaller = quality;
                quality += intervalSize;
                intervalSize /= 2;
            }
            if (intervalSize < 0.01f)
            {
                break;
            }
        }
        return lastSmaller;
    }

    private static int computeSizeBytes(BufferedImage image, float quality)
    {
        quality = Math.min(1, Math.max(0, quality));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try
        {
            writeJPG(image, baos, quality);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                baos.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        byte data[] = baos.toByteArray();
        return data.length;
    }

    private static BufferedImage computeScaledImage(BufferedImage input, int limit)
    {
        int w = input.getWidth();
        int h  = input.getHeight();
        float aspect = (float)w / h;
        if (aspect > 1)
        {
            w = limit;
            h = (int)(w / aspect);
        }
        else
        {
            h = limit;
            w = (int)(h * aspect);
        }
        BufferedImage output = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);    

        Graphics2D g = output.createGraphics();
        g.setRenderingHint(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(input, 0, 0, w, h, null);
        g.dispose();

        return output;
    }

    /**
     * Write the given RenderedImage as a JPEG to the given outputStream,
     * using the given quality. The quality must be a value between
     * 0 (lowest quality, maximum compression) and 1 (highest
     * quality, minimum compression). The caller is responsible for
     * closing the given stream.
     *  
     * @param renderedImage The image to write
     * @param outputStream The stream to write to
     * @param quality The quality, between 0 and 1
     * @throws IOException If an IO error occurs
     */
    public static void writeJPG(RenderedImage renderedImage,
        OutputStream outputStream, float quality) throws IOException
    {
        Iterator<ImageWriter> imageWriters =
            ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter imageWriter = imageWriters.next();
        ImageOutputStream imageOutputStream =
            ImageIO.createImageOutputStream(outputStream);
        imageWriter.setOutput(imageOutputStream);
        ImageWriteParam param = imageWriter.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(quality);
        IIOImage iioImage = new IIOImage(renderedImage, null, null);
        imageWriter.write(null, iioImage, param);
    }   
}


class ImageLimiterPanel extends JPanel
{
    private ImageLimiter imageLimiter;

    private ImageIcon inputImageIcon;
    private ImageIcon outputImageIcon;

    private JScrollPane inputScrollPane;
    private JScrollPane outputScrollPane;

    private JSlider qualitySlider;
    private JLabel qualityLabel;

    private JSlider resolutionLimitSlider;
    private JLabel resolutionLimitLabel;

    private JSpinner sizeLimitSpinner;
    private JLabel sizeLimitLabel;

    private boolean updating = false;

    public ImageLimiterPanel(ImageLimiter imageLimiter)
    {
        this.imageLimiter = imageLimiter;

        setLayout(new BorderLayout());

        final JSplitPane splitPane = new JSplitPane();

        inputImageIcon = new ImageIcon();
        JLabel inputImageLabel = new JLabel(inputImageIcon);
        inputScrollPane = new JScrollPane(inputImageLabel);
        inputScrollPane.setBorder(BorderFactory.createTitledBorder("Input"));
        splitPane.setLeftComponent(inputScrollPane);

        outputImageIcon = new ImageIcon();
        JLabel outputImageLabel = new JLabel(outputImageIcon);
        outputScrollPane = new JScrollPane(outputImageLabel);
        outputScrollPane.setBorder(BorderFactory.createTitledBorder("Output"));
        splitPane.setRightComponent(outputScrollPane);
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                splitPane.setDividerLocation(0.5);
            }
        });

        add(splitPane, BorderLayout.CENTER);


        JPanel controlPanel = new JPanel(new GridLayout(0,1));

        JPanel resolutionLimitPanel = createResolutionLimitPanel();
        controlPanel.add(resolutionLimitPanel);

        JPanel qualityPanel = createQualityPanel();
        controlPanel.add(qualityPanel);

        JPanel sizePanel = createSizeLimitPanel();
        controlPanel.add(sizePanel);

        add(controlPanel, BorderLayout.NORTH);

    }

    public void setInputImage(BufferedImage inputImage)
    {
        imageLimiter.setInputImage(inputImage);
        inputImageIcon.setImage(inputImage);
        int max = Math.max(inputImage.getWidth(), inputImage.getHeight());
        resolutionLimitSlider.setMaximum(max);        
        resolutionLimitSlider.setValue(max);        
    }

    private JPanel createResolutionLimitPanel()
    {
        JPanel resolutionLimitPanel = new JPanel(new BorderLayout());
        resolutionLimitLabel = new JLabel("Resolution: ");
        resolutionLimitLabel.setPreferredSize(new Dimension(300, 10));
        resolutionLimitPanel.add(resolutionLimitLabel, BorderLayout.WEST);
        resolutionLimitSlider = new JSlider(0,100,80);
        resolutionLimitSlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent arg0)
            {
                if (!updating)
                {
                    updating = true;

                    int maxResolution = resolutionLimitSlider.getValue();
                    imageLimiter.setMaxResolution(maxResolution);
                    updateOutputImage(imageLimiter.getOutputImage());

                    sizeLimitLabel.setText("Size: "+imageLimiter.getFileSizeBytes());
                    sizeLimitSpinner.setValue(imageLimiter.getFileSizeBytes());

                    updating = false;
                }
            }
        });
        resolutionLimitPanel.add(resolutionLimitSlider, BorderLayout.CENTER);
        return resolutionLimitPanel;
    }

    private JPanel createQualityPanel()
    {
        JPanel qualityPanel = new JPanel(new BorderLayout());
        qualityLabel = new JLabel("Quality: ");
        qualityLabel.setPreferredSize(new Dimension(300, 10));
        qualityPanel.add(qualityLabel, BorderLayout.WEST);
        qualitySlider = new JSlider(0,100,80);
        qualitySlider.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent arg0)
            {
                if (!updating)
                {
                    updating = true;

                    float quality = qualitySlider.getValue()/100.0f;
                    imageLimiter.setQuality(quality);
                    updateOutputImage(imageLimiter.getOutputImage());

                    qualityLabel.setText("Quality: "+String.format("%.2f", quality));
                    sizeLimitLabel.setText("Size: "+imageLimiter.getFileSizeBytes());
                    sizeLimitSpinner.setValue(imageLimiter.getFileSizeBytes());

                    updating = false;
                }
            }
        });
        qualityPanel.add(qualitySlider, BorderLayout.CENTER);
        return qualityPanel;
    }

    private JPanel createSizeLimitPanel()
    {
        JPanel sizeLimitPanel = new JPanel(new BorderLayout());
        sizeLimitLabel = new JLabel("Size: ");
        sizeLimitLabel.setPreferredSize(new Dimension(300, 10));
        sizeLimitPanel.add(sizeLimitLabel, BorderLayout.WEST);
        sizeLimitSpinner = new JSpinner(new SpinnerNumberModel(10000, 0, 1000000000, 1000));
        sizeLimitSpinner.addChangeListener(new ChangeListener()
        {
            @Override
            public void stateChanged(ChangeEvent arg0)
            {
                if (!updating)
                {
                    updating = true;

                    int sizeLimit = (Integer)sizeLimitSpinner.getValue();
                    imageLimiter.setMaxFileSize(sizeLimit);
                    updateOutputImage(imageLimiter.getOutputImage());

                    qualityLabel.setText("Quality: "+String.format("%.2f", imageLimiter.getQuality()));
                    qualitySlider.setValue((int)(imageLimiter.getQuality()*100));

                    sizeLimitLabel.setText("Size: "+imageLimiter.getFileSizeBytes());
                    sizeLimitSpinner.setValue(imageLimiter.getFileSizeBytes());

                    updating = false;
                }

            }
        });
        sizeLimitPanel.add(sizeLimitSpinner, BorderLayout.CENTER);
        return sizeLimitPanel;
    }

    private void updateOutputImage(BufferedImage outputImage)
    {
        outputImageIcon.setImage(outputImage);
        outputScrollPane.invalidate();
        revalidate();
        outputScrollPane.repaint();
    }

}
