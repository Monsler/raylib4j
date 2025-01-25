package com.monsler.raylib4j;

import com.sun.jna.Native;
import com.sun.jna.Platform;

public class RayLib {
    private static Ray raylib;
    public static void init() {
        if (Platform.isWindows()) {
            raylib = Native.load("raylib", Ray.class);
        } else if(Platform.isLinux()) {
            raylib = Native.load("libraylib", Ray.class);
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

    public static void drawTexture(Ray.Texture2D texture, int x, int y, Ray.Color color) {
        raylib.DrawTexture(texture, x, y, color);
    }

    public static Ray.Texture2D loadTexture(String filename) {
        return raylib.LoadTexture(filename);
    }

    public static Ray.Texture2D loadTextureFromImage(Ray.Image image) {
        return raylib.LoadTextureFromImage(image);
    }
}
