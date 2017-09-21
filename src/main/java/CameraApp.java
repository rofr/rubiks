import com.github.sarxos.webcam.Webcam;
import sun.awt.AWTIcon32_security_icon_yellow16_png;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CameraApp {


    public static void main(String[] args) throws IOException {
        takePicture();
        System.out.println(getCubeFromImage("moyu"));
        System.out.println(getCubeFromImage("rubik"));
        System.out.println(getCubeFromImage("guanlong"));
        System.out.println(getCubeFromImage("dayan"));
    }


    public static String getCubeFromImage(String cubeName) throws IOException {
        return getHalfCube(cubeName + "-wgo.png") + getHalfCube(cubeName + "-wgo.png");
    }

    static String getHalfCube(String name) throws IOException {
        BufferedImage image = ImageIO.read(new File(name));
        return colorFromPixel(image,89,44) +
                colorFromPixel(image,113,90) +
                colorFromPixel(image,62,89);

    }

    static String colorFromPixel(BufferedImage image, int x, int y) {
     return String.valueOf(colorFromRgb(image.getRGB(x,y)));
    }

    static char colorFromRgb(int rgb) {
        return HsbToColorCode(rgbToHsb(rgb));
    }

    static void takePicture() throws IOException {
        Webcam webcam = Webcam.getDefault();
        webcam.open();
        ImageIO.write(webcam.getImage(), "PNG", new File("guanlong-yrb.png"));
    }

    static float[] rgbToHsb(int rgb) {
        float [] hsb = new float[3];
        int r = (rgb >> 16) & 255;
        int g = (rgb >> 8) & 255;
        int b = rgb & 255;
        Color.RGBtoHSB(r,g,b, hsb);
        return hsb;
    }

    static char HsbToColorCode(float[] hsb) {

        float tone = hsb[0] * 360;
        if (hsb[1] < 0.1 && hsb[2] > 0.9 ) return 'W';
        if (tone < 20) return 'R';
        if (tone < 40) return 'O';
        if (tone < 65) return 'Y';
        if (tone < 170) return 'G';
        if (tone < 250) return 'B';
        return 'R';
    }

}
