package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import static com.company.BresenhamFigures.*;
import static com.company.DDALineDrawer.*;
import static com.company.WuLineDrawer.*;

public class DrawPanel extends JPanel implements MouseMotionListener, MouseListener, MouseWheelListener {

    private Point position = new Point(0, 0);
    public static int start_x, start_y,
            end_x, end_y,
            ellipse_angle_x = 2, ellipse_angle_y = 1,
            arc_angle_x = 1, arc_angle_y = -1,
            radius = 20, i = 0;
    static Color c = new Color(98, 166, 0);

    DrawPanel() {
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
    }

    private void drawAll(LineDrawer ld) {
        ld.drawLine(start_x, start_y, end_x, end_y);
    }


    @Override
    public void paint(Graphics g) {
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics bi_g = bi.createGraphics();
        bi_g.setColor(Color.WHITE);
        bi_g.fillRect(0, 0, getWidth(), getHeight());
        bi_g.setColor(Color.BLACK);
        g.drawImage(bi, 0, 0, null);
        bi_g.dispose();
        PixelDrawer pd = new GraphicPixelDrawer(g);
        LineDrawer[] arr = new LineDrawer[3];
        arr[0] = new DDALineDrawer(pd);
        arr[1] = new BresenhamLineDrawer(pd);
        arr[2] = new WuLineDrawer(pd);
        drawAll(arr[i]);

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        position = new Point(e.getX(), e.getY());
        end_x = position.x;
        end_y = position.y;
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            i = (i + 1) % 3;
        }
        if (e.getButton() == MouseEvent.BUTTON2) {
            int change = ellipse_angle_y;
            ellipse_angle_y = ellipse_angle_x;
            ellipse_angle_x = change;
            arc_angle_x *= -1;
            arc_angle_y *= -1;
        }
        position = new Point(e.getX(), e.getY());
        start_x = position.x;
        start_y = position.y;
        repaint();
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        if (e.getWheelRotation() < 0) {
            radius += 1;
        } else {
            radius -= 1;
        }
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}