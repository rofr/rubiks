import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CameraAppTest {

    @Test
    void red() {
        int red = 255 << 16;
        float[] hsb = CameraApp.rgbToHsb(red);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('R', colorCode);
    }

    @Test
    void orange() {
        int color = (255 << 16) + (128 << 8);
        float[] hsb = CameraApp.rgbToHsb(color);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('O', colorCode);
    }

    @Test
    void yellow() {
        int color = (255 << 16) + (255 << 8);
        float[] hsb = CameraApp.rgbToHsb(color);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('Y', colorCode);
    }

    @Test
    void blue() {
        int color = 255;
        float[] hsb = CameraApp.rgbToHsb(color);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('B', colorCode);
    }

    @Test
    void green() {
        int color = 255 << 8;
        float[] hsb = CameraApp.rgbToHsb(color);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('G', colorCode);
    }

    @Test
    void white() {
        int color = (255 << 16) + (255 << 8) + 255;
        float[] hsb = CameraApp.rgbToHsb(color);
        char colorCode = CameraApp.HsbToColorCode(hsb);
        assertEquals('W', colorCode);
    }





}