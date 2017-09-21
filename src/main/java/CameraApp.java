import com.github.sarxos.webcam.Webcam;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CameraApp {


    private static Point[] getCenterPixels() {
        return
                new Point[]{
                        new Point(53,58),
                        new Point(69,50),
                        new Point(83,45),
                        new Point(68,65),
                        new Point(85,57),
                        new Point(99,49),
                        new Point(86,74),
                        new Point(103,64),
                        new Point(116,50),

                        new Point(47,71),
                        new Point(61,80),
                        new Point(78,90),
                        new Point(49,71),
                        new Point(63,99),
                        new Point(79,110),
                        new Point(51,104),
                        new Point(65,115),
                        new Point(79,126),

                        new Point(95,90),
                        new Point(111,78),
                        new Point(124,68),
                        new Point(95,109),
                        new Point(111,96),
                        new Point(122,87),
                        new Point(95,125),
                        new Point(109,113),
                        new Point(120,103)
        };
    }

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
        StringBuilder builder = new StringBuilder();
        for (Point point : getCenterPixels()) {
            builder.append(colorFromPixel(image,point.x, point.y));
        }
        return builder.toString();
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
        ImageIO.write(webcam.getImage(), "PNG", new File("ugly-dudes-on-the-bus+.png"));
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
