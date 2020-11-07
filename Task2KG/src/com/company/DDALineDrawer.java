package com.company;

import java.awt.*;

import static com.company.DrawPanel.*;
import static com.company.setPixel.setPixel;

public class DDALineDrawer implements LineDrawer {

    public PixelDrawer pd;

    public DDALineDrawer(PixelDrawer g) {
        this.pd = g;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        int iX1 = Math.round(start_x), iY1 = Math.round(start_y),
                iX2 = Math.round(end_x), iY2 = Math.round(end_y), // округление до целого
                deltaX = Math.abs(iX1 - iX2), deltaY = Math.abs(iY1 - iY2),
                length = Math.max(deltaX, deltaY);
        double dX = (double) (end_x - start_x) / length, dY = (double) (end_y - start_y) / length,
                x = start_x, y = start_y;
        while (length > 0) {
            x += dX;
            y += dY;
            pd.setPixel((int) x, (int) y,c);
            length--;
        }
    }

}
