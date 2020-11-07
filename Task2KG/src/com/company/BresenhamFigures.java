package com.company;

import java.awt.*;

import static com.company.DrawPanel.*;
import static com.company.setPixel.*;


public class BresenhamFigures {



    static void drawEllipseBresenham(Graphics g) {
        int x = 0, y = radius, sigma, delta = 2 - 2 * radius, center_x = start_x, center_y = start_y;
        while (y >= 0) {
            setPixel(g, center_x + ellipse_angle_x * x, center_y - ellipse_angle_y * y);
            setPixel(g, center_x - ellipse_angle_x * x, center_y - ellipse_angle_y * y);
            setPixel(g, center_x - ellipse_angle_x * x, center_y + ellipse_angle_y * y);
            setPixel(g, center_x + ellipse_angle_x * x, center_y + ellipse_angle_y * y);
            sigma = 2 * (delta + y) - 1;
            if (delta < 0 && sigma <= 0) {
                x++;
                delta += x + 1;
            } else if (delta > 0 && sigma > 0) {
                y--;
                delta -= y + 1;
            } else {
                x++;
                delta += x - y;
                y--;
            }
        }
    }

    static void drawArcBresenham(Graphics g) {
        int x = 0, y = radius, sigma, delta = 2 - 2 * radius, center_x = start_x, center_y = start_y;
        while (y >= 0) {
            setPixel(g, center_x + arc_angle_x * x, center_y - arc_angle_y* y);
            setPixel(g, center_x - arc_angle_x * x, center_y - arc_angle_y * y);
            sigma = 2 * (delta + y) - 1;
            if (delta < 0 && sigma <= 0) {
                x++;
                delta += x + 1;
            } else if (delta > 0 && sigma > 0) {
                y--;
                delta -= y + 1;
            } else {
                x++;
                delta += x - y;
                y--;
            }
        }
    }

    static void drawCircleBresenham(Graphics g) {
        int x = 0, y = radius, sigma, delta = 2 - 2 * radius, center_x = start_x, center_y = start_y;
        while (y >= 0) {
            setPixel(g, center_x + x, center_y - y);
            setPixel(g, center_x - x, center_y - y);
            setPixel(g, center_x - x, center_y + y);
            setPixel(g, center_x + x, center_y + y);
            sigma = 2 * (delta + y) - 1;
            if (delta < 0 && sigma <= 0) {
                x++;
                delta += x + 1;
            } else if (delta > 0 && sigma > 0) {
                y--;
                delta -= y + 1;
            } else {
                x++;
                delta += x - y;
                y--;
            }
        }
    }

}
