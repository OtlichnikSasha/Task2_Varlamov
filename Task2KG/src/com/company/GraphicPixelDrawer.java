package com.company;

import java.awt.*;

public class GraphicPixelDrawer implements PixelDrawer {
    private Graphics g;

    public GraphicPixelDrawer(Graphics g) {
        this.g = g;
    }

    @Override
    public void setPixel(int x, int y, Color c) {
        g.setColor(c);
        g.drawLine(x, y, x, y);
    }
}
