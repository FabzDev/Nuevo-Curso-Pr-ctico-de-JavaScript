/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fabzdev.watch;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author fabio
 */
public class JavaWatch10 extends JPanel {

    //definiendo variables de colores
    Color backgroundColor = new Color(0x4040c0);
    Color horaColor = Color.BLACK;
    Color minColor = Color.BLACK;
    Color segColor = new Color(0xa00000);
    Color faceColor = new Color(0xc0c0c0);
    Color lblColor = Color.BLACK;
    Color gradientA = new Color(224, 224, 224, 255);
    Color gradientB = new Color(32, 32, 32, 144);
    Color shadowColor = new Color(0x0, 0x0, 0x0, 0x30);
    //definiendo variables de fuentes
    Font smallFont;
    Font mediumFont;
    Font largeFont;
    Font smallTitleFont;
    Font mediumTitleFont;
    Font largeTitleFont;
    //definiendo strokes manecillas
    int stHora = 12;
    int stMin = 5;
    int stSeg = 3;
    //definiendo variables de tiempo
    int hora;
    int min;
    int seg;
    int ampm;
    Timer timer;
    //definiendo BufferedImages
    BufferedImage buffimg;
    BufferedImage dayNightImg;
    //definiendo arreglos de X y Y
    float[] xArr = new float[61];
    float[] yArr = new float[61];
    //definiendo variable clip
    Shape clip;

    //constructor
    public JavaWatch10() {
        super();
        fillX(); //llenando arrays trigonometricos
        fillY();
        updatetime();
        timer = new Timer(1000, e -> {
            updatetime();
            repaint();
        });
        timer.start();
    }

    //dibujar estrella
    public void drawStar(Graphics2D g2d, int x, int y, int radius, int intRadius, int nPicos, int rotacion) {
        int[] xPoints = new int[nPicos * 2];
        int[] yPoints = new int[xPoints.length];

        for (int n = 0; n < (nPicos * 2); n = n + 2) {
            double ang1 = (270 + rotacion + (360.0 / nPicos) * (n / 2)) % 360;
            double ang2 = (270 + rotacion + (360.0 / nPicos) * (n / 2) + ((360.0 / nPicos) / 2)) % 360;
            xPoints[n] = (int) (x + radius * Math.cos(Math.toRadians(ang1)));
            yPoints[n] = (int) (y + (radius * Math.sin(Math.toRadians(ang1))));
            xPoints[n + 1] = (int) (x + (intRadius * Math.cos(Math.toRadians(ang2))));
            yPoints[n + 1] = (int) (y + (intRadius * Math.sin(Math.toRadians(ang2))));
        }
        g2d.fillPolygon(xPoints, yPoints, nPicos * 2);

    }

    //dibujar sol
    public void drawSun(Graphics2D g2d, int x, int y, int radius, int intRadius, int nPicos, int rotacion) {
        int sunRadius = (int) (intRadius * 0.9);
        g2d.setColor(Color.ORANGE);
        drawStar(g2d, x, y, radius, intRadius, nPicos, rotacion);
        g2d.setColor(Color.YELLOW);
        g2d.fillOval((int) (x - sunRadius), (int) (y - sunRadius), (int) (sunRadius * 2), (int) (sunRadius * 2));
    }

    //llenarArrays x y y
    public void fillX() {
        for (int i = 0; i < 60; i++) {
            xArr[i] = (float) (Math.cos(Math.toRadians((270 + i * (360 / 60)) % 360)));
        }
    }

    public void fillY() {
        for (int i = 0; i < 60; i++) {
            yArr[i] = (float) (Math.sin(Math.toRadians((270 + i * (360 / 60)) % 360)));
        }
    }

    //obtener seno y coseno
    public float cos(int min) {
        return xArr[min];
    }

    public float sin(int min) {
        return yArr[min];
    }

    //detener timer
    public void stopTimer() {
        timer.stop();
    }

    //definir hora
    private void updatetime() {
        Calendar time = Calendar.getInstance();
        hora = time.get(Calendar.HOUR);
        min = time.get(Calendar.MINUTE);
        seg = time.get(Calendar.SECOND);
        ampm = time.get(Calendar.AM_PM);
    }

    //obtener Fonts
    private Font getSmallFont(Graphics2D g2d) {
        if (smallFont != null) {
            return smallFont;
        }
        smallFont = g2d.getFont().deriveFont(24f);
        return smallFont;
    }

    private Font getMediumFont(Graphics2D g2d) {
        if (mediumFont != null) {
            return mediumFont;
        }
        mediumFont = g2d.getFont().deriveFont(36f);
        return mediumFont;
    }

    private Font getLargeFont(Graphics2D g2d) {
        if (largeFont != null) {
            return largeFont;
        }
        largeFont = g2d.getFont().deriveFont(48f);
        return largeFont;
    }

    //definiendo fuentes marca JavaWatch
    private Font getSmallFontTitle(Graphics2D g2d) {
        if (smallTitleFont != null) {
            return smallTitleFont;
        }
        smallTitleFont = g2d.getFont().deriveFont(12f);
        return smallTitleFont;
    }

    private Font getMediumFontTitle(Graphics2D g2d) {
        if (mediumTitleFont != null) {
            return mediumTitleFont;
        }
        mediumTitleFont = g2d.getFont().deriveFont(18f);
        return mediumTitleFont;
    }

    private Font getLargeFontTitle(Graphics2D g2d) {
        if (largeTitleFont != null) {
            return largeTitleFont;
        }
        largeTitleFont = g2d.getFont().deriveFont(24f);
        return largeTitleFont;
    }

    private void updateBackgroundImage(Rectangle bounds, Rectangle frame) {
        buffimg = new BufferedImage(bounds.width, bounds.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = buffimg.createGraphics();

        //definiendo coordenadas
        int centerX = frame.x + frame.width / 2;
        int centerY = frame.y + frame.height / 2;
        double radius = frame.width / 2 - 10;
        double angle;

        //definiendo grosores de linea
        Stroke st = g2d.getStroke();
        Stroke boldSt = new BasicStroke(2);

        //obteniendo tamaño de fuente
        Font f;
        if (frame.width < 400) {
            f = getSmallFont(g2d);
        } else if (frame.width < 800) {
            f = getMediumFont(g2d);
        } else {
            f = getLargeFont(g2d);
        }
        g2d.setFont(f);

        //obteniendo FontMetrics
        FontMetrics fm = g2d.getFontMetrics();

        //dibujando background
        g2d.setColor(backgroundColor);
        g2d.fillRect(0, 0, bounds.width, bounds.height);

        //dibujando face-background del reloj
        g2d.setColor(faceColor);
        g2d.fillOval(frame.x + 4, frame.y + 4, frame.width - 8, frame.height - 8);

        //definiendo gradiente
        Paint defaultPaint = g2d.getPaint();
        g2d.setPaint(new RadialGradientPaint(
                (float) (centerX - Math.cos(Math.toRadians(45)) * radius),
                (float) (centerY - Math.sin(Math.toRadians(45)) * radius),
                (float) radius * 3.5f,
                new float[]{0.0f, 0.5f},
                new Color[]{gradientA, gradientB}));
        //dibujando gradiente
        g2d.fillOval(frame.x + 4, frame.y + 4, frame.width - 8, frame.height - 8);
        g2d.setPaint(defaultPaint);

        //definiendo propiedades del contorno
        g2d.setColor(lblColor);
        g2d.setStroke(new BasicStroke(10));

        //dibujando contorno del reloj
        g2d.drawOval(frame.x + 4, frame.y + 4, frame.width - 8, frame.height - 8);

        //dibujando minuteros
        for (int n = 0; n < 60; n++) {
            //definiendo valores geometricos
            angle = Math.toRadians((270 + (360 / 60) * n) % 360);
            double cos = Math.cos(angle);
            double sin = Math.sin(angle);
            double intRadius;

            //para horas
            if (n % 5 == 0) {
                //definiendo largo de la lina para horas
                intRadius = 0.9 * radius;
                //definiendo el grosor de los minuteros para horas
                g2d.setStroke(boldSt);

                //definiendo la hora
                int h = n / 5;
                if (n == 0) {
                    h = 12;
                }

                //definiendo posición de las horas
                Rectangle2D sb = fm.getStringBounds(String.valueOf(h), g2d);
                int x = (int) (-sb.getWidth() / 2 + (radius * cos * 0.8));
                int y = (int) ((fm.getAscent() - fm.getDescent()) / 2 + (radius * sin * 0.8));

                //dibujando texto horas
                g2d.drawString(String.valueOf(h), centerX + x, centerY + y);

            } else {
                //definiendo largo de la lina para minutos
                intRadius = 0.95 * radius;
                //definiendo el grosor de los minuteros para minutos
                g2d.setStroke(st);
            }

            //dibujar el minutero
            g2d.drawLine((int) (centerX + intRadius * cos), (int) (centerY + intRadius * sin), centerX + (int) (radius * cos), centerY + (int) (radius * sin));
        }

        //dibujar marca Javawatch
        if (frame.width < 400) {
            g2d.setFont(getSmallFontTitle(g2d));
        } else if (frame.width < 800) {
            g2d.setFont(getMediumFontTitle(g2d));
        } else {
            g2d.setFont(getLargeFontTitle(g2d));
        }
        Rectangle2D borderTitle = g2d.getFontMetrics().getStringBounds("JavaWatch", g2d);
        g2d.drawString("JavaWatch", (float) (centerX - borderTitle.getWidth() / 2), (float) (centerY + radius * 0.3));
        
        //cerrar el entorno de dibujo e la imagen
        g2d.dispose();
    }

    private void createDayNightImage(int size) {
        dayNightImg = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = dayNightImg.createGraphics();
        int dnRadius = (int) (size / 7);
        //firmamento con gradiente
        Paint savedPaint = g2d.getPaint();
        GradientPaint gpaint = new GradientPaint(size / 2, size / 2 - size / 16, backgroundColor, size / 2, size, lblColor);
        g2d.setPaint(gpaint);
        g2d.fillRect(0, 0, size, size);
        g2d.setPaint(savedPaint);

        //dibujando sol
        drawSun(g2d, size / 2, size / 6, dnRadius, (int) (dnRadius / 1.6), 12, 0);

        //dibujando estrellas en el firmamento
        g2d.setColor(Color.YELLOW);
        int angle = 0;
        for (int n = 0; n < 4; n++) {
            if (n == 0) {
                angle = 15;
            } else {
                angle += 50;
            }
            int posX = size / 2 + (int) (size / 2 * 0.8 * Math.cos(Math.toRadians(angle)));
            int posY = size / 2 + (int) (size / 2 * 0.8 * Math.sin(Math.toRadians(angle)));
            drawStar(g2d, posX, posY, (int) (size / 20), (int) (size / 40), 5, n * 3 + 5);
        }
        for (int n = 0; n < 2; n++) {
            if (n == 0) {
                angle = 40;
            } else {
                angle += 100;
            }
            int posX = size / 2 + (int) (size / 2 * 0.3 * Math.cos(Math.toRadians(angle)));
            int posY = size / 2 + (int) (size / 2 * 0.3 * Math.sin(Math.toRadians(angle)));
            drawStar(g2d, posX, posY, (int) (size / 20), (int) (size / 40), 5, n * 3 + 10);
        }

        //dibujando luna
        float moonRadius = dnRadius * 0.8f;
        g2d.setColor(Color.WHITE);
        Arc2D lunaArc = new Arc2D.Float(size / 2f - moonRadius - moonRadius * 0.2f, size * 0.70f, moonRadius * 2, moonRadius * 2, 0f, 360.0f, Arc2D.CHORD);
        Area lunaArea = new Area(lunaArc);
        lunaArea.subtract(new Area(new Arc2D.Float(size / 2f - moonRadius - moonRadius * 0.7f - moonRadius * 0.2f, size * 0.70f, moonRadius * 2, moonRadius * 2, 0f, 360.0f, Arc2D.CHORD)));
        g2d.fill(lunaArea);

        // Punto en coordenadas
        //        g2d.setColor(new Color(255, 255, 0, 150));
        //        g2d.fillOval(x3-5, y3-5, 10, 10);
        
        //creando abanico del reloj
        
        //lado derecho
        //definiendo variables
        float fanRadius = size/2;
        float border = fanRadius * 0.2f;
        int x1 = (int) (fanRadius + (fanRadius * Math.cos(Math.toRadians(10))) - (border * Math.cos(Math.toRadians(10))));
        int y1 = (int) (fanRadius - (fanRadius * Math.sin(Math.toRadians(10))) + (border * Math.sin(Math.toRadians(10))))+2;
        int xn = (int) (fanRadius + (fanRadius * Math.cos(Math.toRadians(10))));
        int yn = (int) (fanRadius - (fanRadius * Math.sin(Math.toRadians(10))));
        double angleFan = (border / fanRadius) + Math.toRadians(10);
        int x3 = (int) (fanRadius + (fanRadius * Math.cos(angleFan)));
        int y3 = (int) (fanRadius - (fanRadius * Math.sin(angleFan)));
        int x4 = (int) (fanRadius + (fanRadius * 1.1 * Math.cos(Math.toRadians(10))));
        int y4 = (int) (fanRadius - (fanRadius * 1.1 * Math.sin(Math.toRadians(10))))+2;
        //definiendo formas
        Arc2D fanArc = new Arc2D.Float(0, 0, size, size, 10, 180, Arc2D.CHORD);
        Arc2D del1 = new Arc2D.Float(-25, -25, fanRadius*2+50, fanRadius*2+50, 170, 180, Arc2D.CHORD);
        Area fanArea = new Area(fanArc);
        fanArea.subtract(new Area(del1));
        //generando path
        GeneralPath gp = new GeneralPath();
        gp.moveTo(x1, y1);
        gp.lineTo(x4, y4);
        gp.lineTo(x3+10, y3);
        gp.lineTo(x3, y3);
        gp.quadTo(xn, yn, x1, y1);
        fanArea.subtract(new Area(gp));
        
        //lado izquierdo
        //definiendo variables
        x1 = (int) (fanRadius - (fanRadius * Math.cos(Math.toRadians(10))) + (border * Math.cos(Math.toRadians(10))));
        y1 = (int) (fanRadius - (fanRadius * Math.sin(Math.toRadians(10))) + (border * Math.sin(Math.toRadians(10))))+2;
        xn = (int) (fanRadius - (fanRadius * Math.cos(Math.toRadians(10))));
        yn = (int) (fanRadius - (fanRadius * Math.sin(Math.toRadians(10))));
        angleFan = (border / fanRadius) + Math.toRadians(10);
        x3 = (int) (fanRadius - (fanRadius * Math.cos(angleFan)));
        y3 = (int) (fanRadius - (fanRadius * Math.sin(angleFan)));
        x4 = (int) (fanRadius - (fanRadius * 1.1 * Math.cos(Math.toRadians(10))));
        y4 = (int) (fanRadius - (fanRadius * 1.1 * Math.sin(Math.toRadians(10))))+2;
        //definiendo formas
        Area del2 = new Area(new Arc2D.Float(-25, -25, fanRadius*2+50, fanRadius*2+50, 170, 180, Arc2D.CHORD));
        fanArea.subtract(new Area(del2));
        //generando path
        gp = new GeneralPath();
        gp.moveTo(x1, y1);
        gp.lineTo(x4, y4);
        gp.lineTo(x3-10, y3);
        gp.lineTo(x3, y3);
        gp.quadTo(xn, yn, x1, y1);   
        fanArea.subtract(new Area(gp));
        clip = fanArea;
        
//        g2d.fill(clip);
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        //creando objetos para dibujar
        Graphics2D g2d = (Graphics2D) g;
        Rectangle bounds = new Rectangle(getWidth(), getHeight());

        //definiendo tamaño del frame
        int size = Math.min(bounds.width, bounds.height);
        Rectangle frame = new Rectangle(bounds.width / 2 - size / 2, bounds.height / 2 - size / 2, size, size);

        //definiendo coordenadas
        int centerX = frame.x + frame.width / 2;
        int centerY = frame.y + frame.height / 2;
        double radius = frame.width / 2 - 10;
        
        //definiendo tamaño del firmamento
        int sz = (int) (radius * 1.5);

        //optimizando el codigo para dibujar la imagen solo al inicio de la ejecicion y cuando se modifique el tamaño de ventana
        if (buffimg == null || buffimg.getWidth() != frame.width || buffimg.getHeight() != frame.height) {
            updateBackgroundImage(bounds, frame);
            createDayNightImage(sz);
        }
        g2d.drawImage(buffimg, 0, 0, null);
        
        Shape defClip = g2d.getClip();
//        g2d.setClip(clip);

        g2d.drawImage(dayNightImg, centerX - sz/2, centerY - sz/2, null);

        g2d.setClip(defClip);
        

        //definiendo valor de x y y para manecillas
        int xSeg = (int) ((0.9 * radius) * cos(seg));
        int ySeg = (int) ((0.9 * radius) * sin(seg));
        int xMin = (int) ((0.7 * radius) * cos(min));
        int yMin = (int) ((0.7 * radius) * sin(min));
        int xHora = (int) ((0.5 * radius) * Math.cos(Math.toRadians((270 + hora * (360 / 12)) % 360)));
        int yHora = (int) ((0.5 * radius) * Math.sin(Math.toRadians((270 + hora * (360 / 12)) % 360)));

        //dibujar manecillas
        //--sombras
        //----horas
        g2d.setStroke(new BasicStroke(stHora));
        g2d.setColor(shadowColor);
        g2d.drawLine(centerX + 2, centerY + 2, centerX + xHora + 2, centerY + yHora + 2);
        //----minutos
        g2d.setStroke(new BasicStroke(stMin));
        g2d.setColor(shadowColor);
        g2d.drawLine(centerX - (int) (xMin * 0.15) + 2, centerY - (int) (yMin * 0.15) + 2, centerX + xMin + 2, centerY + yMin + 2);
        //----segundos
        g2d.setStroke(new BasicStroke(stSeg));
        g2d.setColor(shadowColor);
        g2d.drawLine(centerX - (int) (xSeg * 0.2) + 2, centerY - (int) (ySeg * 0.2) + 2, centerX + xSeg + 2, centerY + ySeg + 2);

        //--manecillas
        //----horas
        g2d.setStroke(new BasicStroke(stHora));
        g2d.setColor(horaColor);
        g2d.fillOval(centerX - 10, centerY - 10, 20, 20);
        g2d.drawLine(centerX, centerY, centerX + xHora, centerY + yHora);
        //----minutos
        g2d.setStroke(new BasicStroke(stMin));
        g2d.setColor(minColor);
        g2d.drawLine(centerX - (int) (xMin * 0.15), centerY - (int) (yMin * 0.15), centerX + xMin, centerY + yMin);
        //----segundos
        g2d.setStroke(new BasicStroke(stSeg));
        g2d.setColor(segColor);
        g2d.drawLine(centerX - (int) (xSeg * 0.2), centerY - (int) (ySeg * 0.2), centerX + xSeg, centerY + ySeg);
        //remache
        g2d.setColor(backgroundColor);
        g2d.fillOval(centerX - 3, centerY - 3, 6, 6);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JavaWatch1");
            frame.setMinimumSize(new Dimension(400, 400));
            JavaWatch10 mainPanel = new JavaWatch10();
            frame.setContentPane(mainPanel);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    mainPanel.stopTimer();
                }
            });
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
