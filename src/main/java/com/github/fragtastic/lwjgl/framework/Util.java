package com.github.fragtastic.lwjgl.framework;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import javax.imageio.ImageIO;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author mitch
 */
public class Util {

    private static long lastFrame = 0L;

    // TODO - deal with netbeans running from target/..
    // shitty fix for now
    /**
     * Automatically sets "org.lwjgl.librarypath" for the natives.
     *
     * Needs to be called once before anything else.
     */
    public static void setNatives() {
        File t = new File(System.getProperty("user.dir") + "/target");
        if (t.exists() && t.isDirectory()) {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/target/natives/");
        } else {
            System.setProperty("org.lwjgl.librarypath", System.getProperty("user.dir") + "/natives/");
        }
    }

    /**
     * Get the time in milliseconds
     *
     * @return The system time in milliseconds
     */
    public static long getTime() {
        return System.nanoTime() / 1000000;
    }

    public static int getDelta() {
        long time = getTime();
        int delta = (int) (time - lastFrame);
        lastFrame = time;

        return delta;
    }

    public static void takeScreenShot() {
        try {
            GL11.glReadBuffer(GL11.GL_FRONT);
            int width = Display.getDisplayMode().getWidth();
            int height = Display.getDisplayMode().getHeight();
            int bpp = 4; // Assuming a 32-bit display with a byte each for red, green, blue, and alpha.
            ByteBuffer buffer = BufferUtils.createByteBuffer(width * height * bpp);
            GL11.glReadPixels(0, 0, width, height, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buffer);

            File file = new File("screenshot_" + System.currentTimeMillis()); // The file to save to.
            String format = "png"; // Example: "PNG" or "JPG"
            BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int i = (x + (width * y)) * bpp;
                    int r = buffer.get(i) & 0xFF;
                    int g = buffer.get(i + 1) & 0xFF;
                    int b = buffer.get(i + 2) & 0xFF;
                    image.setRGB(x, height - (y + 1), (0xFF << 24) | (r << 16) | (g << 8) | b);
                }
            }

            try {
                ImageIO.write(image, format, file);
            } catch (IOException e) {
                System.err.println(e);
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static String getOs() {
        String s = System.getProperty("os.name").toLowerCase();
        if (s.contains("win")) {
            return "windows";
        }
        if (s.contains("mac")) {
            return "macosx";
        }
        if (s.contains("solaris")) {
            return "solaris";
        }
        if (s.contains("sunos")) {
            return "solaris";
        }
        if (s.contains("linux")) {
            return "linux";
        }
        if (s.contains("unix")) {
            return "linux";
        } else {
            System.out.println("Your OS was not detected!");
            System.exit(1);
            return "unknown";
        }
    }
}
