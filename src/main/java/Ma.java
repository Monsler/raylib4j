import com.monsler.raylib4j.Ray;
import com.monsler.raylib4j.RayLib;

import java.awt.*;

public class Ma {
    public static void main(String[] args) {
        RayLib.init();
        RayLib.initWindow(500, 400, "raylib4j example");
        RayLib.setTargetFps(60);

        Ray.Image img = RayLib.loadImage("icon-1.png");
        Ray.Texture2D tx = RayLib.loadTextureFromImage(img);
        RayLib.setWindowIcon(img);
        boolean stopped = false;

        RayLib.setWindowMinSize(500, 400);
        System.out.println(Ray.darkGray);
        int x = 0;
        while (!stopped) {
            if (RayLib.windowShouldClose()) {
                stopped = true;
            }
            RayLib.clearBackground(Ray.red);
            RayLib.beginDrawing();
            RayLib.drawCircle(x, x, 60, Ray.blue);
            RayLib.drawRectangle(x, RayLib.getScreenHeight()/2, 50, 50, Ray.darkGreen);
            RayLib.drawCircleSector(new Ray.Vector2(10, 10), 30, 15, 90, 5, Ray.darkPurple);
            RayLib.drawCircleSectorLines(new Ray.Vector2(50, 10), 30, 15, 90, 5, Ray.darkPurple);
            RayLib.drawCircleGradient(80, 50, 30, Ray.gray, Ray.darkGray);
            RayLib.drawRectangleRounded(new Ray.Rectangle(70, 100, 50, 50), 12, 5, Ray.beige);
            RayLib.drawTexture(tx, 0, 0, Ray.blue);
            x += 1;
            if (x >= RayLib.getScreenWidth()) {
                x = 0;
            }
            RayLib.endDrawing();
        }

        RayLib.closeWindow();
    }
}
