package com.company;

import java.awt.*;

import static com.company.DrawPanel.*;
import static com.company.DrawPanel.end_y;
import static com.company.setPixel.setPixel;

public class BresenhamLineDrawer implements LineDrawer {

    public PixelDrawer pd;

    public BresenhamLineDrawer(PixelDrawer g) {
        this.pd = g;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int x = 0, y = 0, dx, dy, pdx, pdy, incx, incy, es, el, err;
        dx = x2 - x1;
        dy = y2 - y1;
        incx = sign(dx); // сравнивает число с 0
        incy = sign(dy);
        if (dx < 0) {
            dx = -dx;
        }
        if (dy < 0) {
            dy = -dy;
        }
        if (dx > dy) {
            pdx = incx;
            pdy = 0;
            es = dy;
            el = dx;
        }
        else {
            pdx = 0;
            pdy = incy;
            es = dx;
            el = dy;
        }
        x = x1;
        y = y1;
        err = el / 2;
        pd.setPixel(x, y,c);
        for (int t = 0; t < el; t++) {
            err -= es;
            if (err < 0) {
                err += el;
                x += incx;
                y += incy;
            }
            else {
                x += pdx;
                y += pdy;
            }
            pd.setPixel(x, y, c);
        }
    }

    static int sign(int x) {
        return Integer.compare(x, 0); // сравнение двух чисел
    }
}
