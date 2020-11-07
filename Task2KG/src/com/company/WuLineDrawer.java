package com.company;

import java.awt.*;

import static com.company.DrawPanel.*;

public class WuLineDrawer implements LineDrawer {

    public PixelDrawer pd;

    public WuLineDrawer(PixelDrawer g) {
        this.pd = g;
    }

    static float fractionalPart(float x) {
        int tmp = (int) x;
        return x - tmp;
    }

    @Override
    public void drawLine(int x1, int y1, int x2, int y2) {
        mistake1(x1,y1,x2,y2);
        // mistake2(x1, y1, x2, y2);
    }

    public void mistake1(int x1, int y1, int x2, int y2){
        int dx = x2 - x1, dy = y2 - y1;
        float gradient;
        float interx;
        float intery;
        if (Math.abs(dy) >= Math.abs(dx)){
            if (y2 < y1) {
                y1 += y2;
                y2 = y1 - y2;
                y1 -= y2;
                x1 += x2;
                x2 = x1 - x2;
                x1 -= x2;
            }
            gradient = (float) dx / dy;
            interx = x1 + gradient;
            pd.setPixel(x1, y1, c);
            for (int y = y1; y < y2; ++y) {
                pd.setPixel((int) interx, y, new Color(110, 30, 170, (int) (255 - fractionalPart(interx) * 255)));
                pd.setPixel((int) interx + 1, y, new Color(110, 30, 170, (int) (fractionalPart(interx) * 255)));
                interx += gradient;
            }
        }
        else{
            if (x2 < x1) {
                x1 += x2;
                x2 = x1 - x2;
                x1 -= x2;
                y1 += y2;
                y2 = y1 - y2;
                y1 -= y2;
            }
            gradient = (float) dy / dx;
            intery = y1 + gradient;
            pd.setPixel(x1, y1, c);
            for (int x = x1; x < x2; ++x) {
                pd.setPixel(x, (int) intery, new Color(110, 30, 170, (int) (255 - fractionalPart(intery) * 255)));
                pd.setPixel(x, (int) intery + 1, new Color(110, 30, 170, (int) (fractionalPart(intery) * 255)));
                intery += gradient;
            }
        }
    }

    /*public void mistake2(int x1, int y1, int x2, int y2){ // рисует только по y
        if (y2 < y1) {
            y1 += y2;
            y2 = y1 - y2;
            y1 -= y2;
            x1 += x2;
            x2 = x1 - x2;
            x1 -= x2;
        }
        int dx = x2 - x1, dy = y2 - y1;
        float gradient;
        float interx;
        if (dy >= dx) {
            gradient = (float) dx / dy;
            interx = x1 + gradient;
            pd.setPixel(x1, y1, c);
            for (int y = y1; y < y2; ++y) {
                pd.setPixel((int) interx, y, new Color(110, 30, 170, (int) (255 - fractionalPart(interx) * 255)));
                pd.setPixel((int) interx + 1, y, new Color(110, 30, 170, (int) (fractionalPart(interx) * 255)));
                interx += gradient;
            }
        }
        else{
            gradient = (float) dy / dx;
            float intery = y1 + gradient;
            pd.setPixel(x1, y1, c);
            for (int x = x1; x < x2; ++x) {
                pd.setPixel(x, (int) intery, new Color(110, 30, 170, (int) (255 - fractionalPart(intery) * 255)));
                pd.setPixel(x, (int) intery + 1, new Color(110, 30, 170, (int) (fractionalPart(intery) * 255)));
                intery += gradient;
            }
        }
    }
     */
}