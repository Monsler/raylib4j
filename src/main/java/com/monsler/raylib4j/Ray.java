package com.monsler.raylib4j;

import com.sun.jna.Library;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public interface Ray extends Library {
    class Image extends Structure implements Structure.ByValue {
        public Pointer data;
        public int width;
        public int height;
        public int mipmaps;
        public int format;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("data", "width", "height", "mipmaps", "format");
        }
    }

    class Vector2 extends Structure implements Structure.ByValue{
        public float x;
        public float y;

        public Vector2(float x, float y) {
            this.x = x;
            this.y = y;
        }
        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("x", "y");
        }
    }

     class Color extends Structure implements Structure.ByValue {
        public byte r;
        public byte g;
        public byte b;
        public byte a;

        public Color(byte r, byte g, byte b, byte a) {
            this.r = r;
            this.g = g;
            this.b = b;
            this.a = a;
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("r", "g", "b", "a");
        }
    }

    class Rectangle extends Structure implements Structure.ByValue {
        public int x;
        public int y;
        public int width;
        public int height;

        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("x", "y", "width", "height");
        }
    }

    class Texture extends Structure implements Structure.ByValue {
        int id;
        int width;
        int height;
        int mipmaps;
        int format;

        public Texture(int id, int width, int height, int mipmaps, int format) {
            this.id = id;
            this.width = width;
            this.height = height;
            this.mipmaps = mipmaps;
            this.format = format;
        }
        public Texture(){}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("id", "width", "height", "mipmaps", "format");
        }
    }

    class Texture2D extends Structure implements Structure.ByValue {
        int id;
        int width;
        int height;
        int mipmaps;
        int format;

        public Texture2D(int id, int width, int height, int mipmaps, int format) {
            this.id = id;
            this.width = width;
            this.height = height;
            this.mipmaps = mipmaps;
            this.format = format;
        }
        public Texture2D(){}

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("id", "width", "height", "mipmaps", "format");
        }
    }





    void InitWindow(int width, int height, String title);
    void SetTargetFPS(int fps);
    boolean WindowShouldClose();
    void CloseWindow();
    void BeginDrawing();
    void EndDrawing();
    void ShowCursor();
    void HideCursor();
    boolean IsWindowFullscreen();
    void EnableCursor();
    void DisableCursor();
    void SetWindowMaxSize(int width, int height);
    void SetWindowMinSize(int width, int height);

    void SetWindowIcon(Image image);


    Image LoadImage(String fileName);
    Image LoadImageFromScreen();

    int GetScreenWidth();
    int GetScreenHeight();
    void ClearBackground(Color c);

    Color gray = new Color((byte)130, (byte)130, (byte)130, (byte)255);    // Gray
    Color darkGray = new Color((byte)80, (byte)80, (byte)80, (byte)255);    // Dark Gray
    Color yellow = new Color((byte)253, (byte)249, (byte)0, (byte)255);     // Yellow
    Color gold = new Color((byte)255, (byte)203, (byte)0, (byte)255);       // Gold
    Color orange = new Color((byte)255, (byte)161, (byte)0, (byte)255);      // Orange
    Color pink = new Color((byte)255, (byte)109, (byte)194, (byte)255);      // Pink
    Color red = new Color((byte)230, (byte)41, (byte)55, (byte)255);        // Red
    Color maroon = new Color((byte)190, (byte)33, (byte)55, (byte)255);      // Maroon
    Color green = new Color((byte)0, (byte)228, (byte)48, (byte)255);        // Green
    Color lime = new Color((byte)0, (byte)158, (byte)47, (byte)255);         // Lime
    Color darkGreen = new Color((byte)0, (byte)117, (byte)44, (byte)255);    // Dark Green
    Color skyBlue = new Color((byte)102, (byte)191, (byte)255, (byte)255);   // Sky Blue
    Color blue = new Color((byte)0, (byte)121, (byte)241, (byte)255);       // Blue
    Color darkBlue = new Color((byte)0, (byte)82, (byte)172, (byte)255);     // Dark Blue
    Color purple = new Color((byte)200, (byte)122, (byte)255, (byte)255);    // Purple
    Color violet = new Color((byte)135, (byte)60, (byte)190, (byte)255);     // Violet
    Color darkPurple = new Color((byte)112, (byte)31, (byte)126, (byte)255); // Dark Purple
    Color beige = new Color((byte)211, (byte)176, (byte)131, (byte)255);    // Beige
    Color brown = new Color((byte)127, (byte)106, (byte)79, (byte)255);     // Brown
    Color darkBrown = new Color((byte)76, (byte)63, (byte)47, (byte)255);    // Dark Brown

    String GetClipboardText();
    void SetClipboardText(String text);
    boolean IsCursorOnScreen();

    double GetTime();
    void WaitTime(double seconds);
    void OpenURL(String url);
    int GetMouseX();
    int GetMouseY();
    void DrawRectangle(int posX, int posY, int width, int height, Color color);
    void DrawPixel(int posX, int posY, Color color);
    void DrawCircle(int centerX, int centerY, float radius, Color color);                              // Draw a color-filled circle
    void DrawCircleSector(Vector2 center, float radius, float startAngle, float endAngle, int segments, Color color);      // Draw a piece of a circle
    void DrawCircleSectorLines(Vector2 center, float radius, float startAngle, float endAngle, int segments, Color color); // Draw circle sector outline
    void DrawCircleGradient(int centerX, int centerY, float radius, Color inner, Color outer);
    void DrawRectangleRounded(Rectangle rec, float roundness, int segments, Color color);
    void DrawLine(int startPosX, int startPosY, int endPosX, int endPosY, Color color);
    void DrawTriangle(Vector2 v1, Vector2 v2, Vector2 v3, Color color);
    boolean IsImageValid(Image image);                                                                    // Check if an image is valid (data and parameters)
    void UnloadImage(Image image);                                                                     // Unload image from CPU memory (RAM)
    boolean ExportImage(Image image, String fileName);
    Image GenImageColor(int width, int height, Color color);
    Image ImageCopy(Image image);
    void ImageClearBackground(Image dst, Color color);
    void DrawTexture(Texture2D texture, int posX, int posY, Color tint);
    Texture2D LoadTexture(String fileName);
    Texture2D LoadTextureFromImage(Image image);
}


