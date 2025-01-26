package com.monsler.raylib4j;

import com.sun.jna.Native;
import com.sun.jna.Platform;

public class RayLib {
    private static Ray raylib;
    public static void init() {
        System.out.println("INFO: Hello from raylib4j "+Ray.R4JVersion);
        if (Platform.isWindows() && Platform.is64Bit()) {
            raylib = Native.load("raylib", Ray.class);
        } else if(Platform.isLinux()) {
            raylib = Native.load("libraylib", Ray.class);
        } else if(Platform.isAndroid()) {
            raylib = Native.load("libraylib_mac", Ray.class);
        } else if (Platform.isWindows() && !Platform.is64Bit()) {
            raylib = Native.load("raylib32", Ray.class);
        }
    }

    public static void initWindow(int width, int height, String title) {
        raylib.InitWindow(width, height, title);
    }

    public static void setTargetFps(int fps) {
        raylib.SetTargetFPS(fps);
    }

    public static boolean windowShouldClose() {
        return raylib.WindowShouldClose();
    }

    public static void closeWindow() {
        raylib.CloseWindow();
    }

    public static void beginDrawing() {
        raylib.BeginDrawing();
    }

    public static void endDrawing() {
        raylib.EndDrawing();
    }

    public static void showCursor() {
        raylib.ShowCursor();
    }

    public static void hideCursor() {
        raylib.HideCursor();
    }

    public static boolean isWindowFullscreen() {
        return raylib.IsWindowFullscreen();
    }

    public static void enableCursor() {
        raylib.EnableCursor();
    }

    public static void disableCursor() {
        raylib.DisableCursor();
    }

    public static void setWindowMaxSize(int width, int height) {
        raylib.SetWindowMaxSize(width, height);
    }

    public static void setWindowMinSize(int width, int height) {
        raylib.SetWindowMinSize(width, height);
    }

    public static Ray.Image loadImage(String filename) {
        return raylib.LoadImage(filename);
    }

    public static void setWindowIcon(Ray.Image image) {
        raylib.SetWindowIcon(image);
    }

    public static Ray.Image loadImageFromScreen() {
        return raylib.LoadImageFromScreen();
    }

    public static Ray.Image Image() {
        return new Ray.Image();
    }

    public static int getScreenWidth() {
        return raylib.GetScreenWidth();
    }

    public static int getScreenHeight() {
        return raylib.GetScreenHeight();
    }

    public static void clearBackground(Ray.Color c) {
        raylib.ClearBackground(c);
    }

    public static String getClipboardText() {
        return raylib.GetClipboardText();
    }
    public static void setClipboardText(String text) {
        raylib.SetClipboardText(text);
    }
    public static boolean isCursorOnScreen() {
        return raylib.IsCursorOnScreen();
    }

    public static double getTime() {
        return raylib.GetTime();
    }
    public static void waitTime(double seconds) {
        raylib.WaitTime(seconds);
    }
    public static void openURL(String url) {
        raylib.OpenURL(url);
    }

    public static int getMouseX() {
        return raylib.GetMouseX();
    }
    public static int getMouseY() {
        return raylib.GetMouseY();
    }

    public static void drawRectangle(int x, int y, int width, int height, Ray.Color color) {
        raylib.DrawRectangle(x, y, width, height, color);
    }

    public static void drawPixel(int x, int y, Ray.Color color) {
        raylib.DrawPixel(x, y, color);
    }

    public static void drawCircle(int x, int y, int radius, Ray.Color color) {
        raylib.DrawCircle(x, y, radius, color);
    }

    public static void drawCircleSector(Ray.Vector2 pos, int radius, float startAngle, float endAngle, int segments, Ray.Color color) {
        raylib.DrawCircleSector(pos, radius, startAngle, endAngle, segments, color);
    }

    public static void drawCircleSectorLines(Ray.Vector2 pos, int radius, float startAngle, float endAngle, int segments, Ray.Color color) {
        raylib.DrawCircleSectorLines(pos, radius, startAngle, endAngle, segments, color);
    }

    public static void drawCircleGradient(int x, int y, int radius, Ray.Color inner, Ray.Color outer) {
        raylib.DrawCircleGradient(x, y, radius, inner, outer);
    }

    public static void drawRectangleRounded(Ray.Rectangle rec, int roundness, int segments, Ray.Color color) {
        raylib.DrawRectangleRounded(rec, roundness, segments, color);
    }

    public static void drawLine(int x1, int y1, int x2, int y2, Ray.Color color) {
        raylib.DrawLine(x1, y1, x2, y2, color);
    }
    public static void drawTriangle(Ray.Vector2 v1, Ray.Vector2 v2, Ray.Vector2 v3,Ray.Color color) {
        raylib.DrawTriangle(v1, v2, v3, color);
    }

    public static boolean isImageValid(Ray.Image image) {
        return raylib.IsImageValid(image);
    }
    public static void unloadImage(Ray.Image image) {
        raylib.UnloadImage(image);
    }
    public static boolean exportImage(Ray.Image image, String filename) {
        return raylib.ExportImage(image, filename);
    }

    public static Ray.Image genImageColor(int width, int height, Ray.Color color) {
        return raylib.GenImageColor(width, height, color);
    }

    public static Ray.Image imageCopy(Ray.Image image) {
        return raylib.ImageCopy(image);
    }

    public static void imageClearBackground(Ray.Image image, Ray.Color color) {
        raylib.ImageClearBackground(image, color);
    }

    public static void drawTexture(Ray.Texture texture, int x, int y, Ray.Color color) {
        raylib.DrawTexture(texture, x, y, color);
    }

    public static Ray.Texture loadTexture(String filename) {
        return raylib.LoadTexture(filename);
    }

    public static Ray.Texture loadTextureFromImage(Ray.Image image) {
        return raylib.LoadTextureFromImage(image);
    }

    public static int getTouchX() {
        return raylib.GetTouchX();
    }
    public static int getTouchY() {
        return raylib.GetTouchY();
    }

    public static void imageBlurGaussian(Ray.Image image, int blurSize) {
        raylib.ImageBlurGaussian(image, blurSize);
    }

    public static boolean colorIsEqual(Ray.Color color1, Ray.Color color2) {
        return raylib.ColorIsEqual(color1, color2);
    }

    public static Ray.Font getFontDefault() {
        return raylib.GetFontDefault();
    }
    public static Ray.Font loadFont(String filename) {
        return raylib.LoadFont(filename);
    }
    public static Ray.Font loadFontFromImage(Ray.Image image, Ray.Color color, int firstChar) {
        return raylib.LoadFontFromImage(image, color, firstChar);
    }

    public static void drawFps(int posX, int posY) {
        raylib.DrawFPS(posX, posY);
    }
    public static void drawText(String text, int posX, int posY, int fontSize, Ray.Color color) {
        raylib.DrawText(text, posX, posY, fontSize, color);
    }

    public static int measureText(String text, int fontSize) {
        return raylib.MeasureText(text, fontSize);
    }

    public static boolean exportFontAsCode(Ray.Font font, String filename) {
        return raylib.ExportFontAsCode(font, filename);
    }

    public static void drawTextEx(Ray.Font font, String text, Ray.Vector2 pos, float fontSize, float spacing, Ray.Color color) {
        raylib.DrawTextEx(font, text, pos, fontSize, spacing, color);
    }

    public static void setConfigFlags(int flags) {
        raylib.SetConfigFlags(flags);
    }

    public static void setTextureFilter(Ray.Texture texture, int filter) {
        raylib.SetTextureFilter(texture, filter);
    }

    public static float getFrameTime() {
        return raylib.GetFrameTime();
    }

    public static void takeScreenshot(String filename) {
        raylib.TakeScreenshot(filename);
    }

    public static boolean fileExists(String filename) {
        return raylib.FileExists(filename);
    }
    public static boolean directoryExists(String filename) {
        return raylib.DirectoryExists(filename);
    }
    public static String getWorkingDirectory() {
        return raylib.GetWorkingDirectory();
    }

    public static void setMousePosition(int x, int y) {
        raylib.SetMousePosition(x, y);
    }

    public static int getTouchPointCount() {
        return raylib.GetTouchPointCount();
    }

    public static boolean isKeyPressed(int key) {
        return raylib.IsKeyPressed(key);
    }

    public static boolean isKeyReleased(int key) {
        return raylib.IsKeyReleased(key);
    }

    public static boolean isKeyDown(int key) {
        return raylib.IsKeyDown(key);
    }

    public static boolean isKeyPressedRepeat(int key) {
        return raylib.IsKeyPressedRepeat(key);
    }

    public static boolean isKeyUp(int key) {
        return raylib.IsKeyUp(key);
    }

    public static void setMouseOffset(int x, int y) {
        raylib.SetMouseOffset(x, y);
    }

    public static void setMouseCursor(int cursor) {
        raylib.SetMouseCursor(cursor);
    }

    public static void imageRotate(Ray.Image image, int angle) {
        raylib.ImageRotate(image, angle);
    }
}
