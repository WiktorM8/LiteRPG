package Framework.Misc;

public class Color {
    private int red;
    private int green;
    private int blue;
    private int alpha;

    public Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    public Color(int red, int green, int blue) {
        this(red, green, blue, 255);
    }

    public void setRed(int red) {
        this.red = red;
    }
    public int getRed() {
        return red;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public int getGreen() {
        return green;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }
    public int getBlue() {
        return blue;
    }
    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }
    public int getAlpha() {
        return alpha;
    }

    public java.awt.Color toAWTColor() {
        return new java.awt.Color(red, green, blue, alpha);
    }
}
