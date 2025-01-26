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

    class RenderTexture extends Structure implements Structure.ByValue {
        public int id;
        public Texture texture;
        public Texture depth;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("id", "texture", "depth");
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

        public Rectangle() {
            this(0, 0, 0, 0);
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("x", "y", "width", "height");
        }
    }

    class GlyphInfo extends Structure implements Structure.ByValue {
        public int value;
        public int offsetX;
        public int offsetY;
        public int advanceX;
        public Image image;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("value", "offsetX", "offsetY", "advanceX", "image");
        }
    }

    class Font extends Structure implements Structure.ByValue {
        public int baseSize;
        public int glyphCount;
        public int glyphPadding;
        public Texture texture;
        public Rectangle recs;
        public GlyphInfo glyphs;

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("baseSize", "glyphCount", "glyphPadding", "texture", "recs", "glyphs");
        }
    }

    class Texture extends Structure implements Structure.ByValue {
        public int id;
        public int width;
        public int height;
        public int mipmaps;
        public int format;

        public Texture(){}

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
    Color black = new Color((byte)0, (byte)0, (byte)0, (byte)0);
    Color white = new Color((byte)255, (byte)255, (byte)255, (byte)255);

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
    void DrawTexture(Texture texture, int posX, int posY, Color tint);
    Texture LoadTexture(String fileName);
    Texture LoadTextureFromImage(Image image);
    int GetTouchX();                                    // Get touch position X for touch point 0 (relative to screen size)
    int GetTouchY();
    void ImageBlurGaussian(Image image, int blurSize);
    boolean ColorIsEqual(Color col1, Color col2);
    Font GetFontDefault();
    Font LoadFont(String fileName);
    Font LoadFontFromImage(Image image, Color key, int firstChar);
    void DrawFPS(int posX, int posY);
    void DrawText(String text, int posX, int posY, int fontSize, Color color);
    int MeasureText(String text, int fontSize);
    boolean ExportFontAsCode(Font font, String fileName);
    void DrawTextEx(Font font, String text, Vector2 position, float fontSize, float spacing, Color tint);
    void SetConfigFlags(int flags);
    int FLAG_MSAA_4X_HINT   = 0x00000020;
    int FLAG_VSYNC_HINT     = 0x00000040,
    FLAG_FULLSCREEN_MODE    = 0x00000002,
    FLAG_WINDOW_RESIZABLE   = 0x00000004,
    FLAG_WINDOW_UNDECORATED = 0x00000008,
    FLAG_WINDOW_HIDDEN      = 0x00000080,
    FLAG_WINDOW_MINIMIZED   = 0x00000200,
    FLAG_WINDOW_MAXIMIZED   = 0x00000400,
    FLAG_WINDOW_UNFOCUSED   = 0x00000800,
    FLAG_WINDOW_TOPMOST     = 0x00001000,
    FLAG_WINDOW_ALWAYS_RUN  = 0x00000100,
    FLAG_WINDOW_TRANSPARENT = 0x00000010,
    FLAG_WINDOW_HIGHDPI     = 0x00002000,
    FLAG_WINDOW_MOUSE_PASSTHROUGH = 0x00004000,
    FLAG_BORDERLESS_WINDOWED_MODE = 0x00008000;
    void SetTextureFilter(Texture texture, int filter);
    int TEXTURE_FILTER_POINT = 0;           // No filter, just pixel approximation
    int TEXTURE_FILTER_BILINEAR = 1;             // Linear filtering
    int TEXTURE_FILTER_TRILINEAR = 2;   // Trilinear filtering (linear with mipmaps)
    int TEXTURE_FILTER_ANISOTROPIC_4X = 3;          // Anisotropic filtering 4x
    int TEXTURE_FILTER_ANISOTROPIC_8X = 4;  // Anisotropic filtering 8x
    int TEXTURE_FILTER_ANISOTROPIC_16X = 5;
    float GetFrameTime();
    void TakeScreenshot(String fileName);
    boolean FileExists(String fileName);
    boolean DirectoryExists(String directory);
    String GetWorkingDirectory();
    void SetMousePosition(int x, int y);
    int GetTouchPointCount();

    boolean IsKeyPressed(int keyCode);
    boolean IsKeyPressedRepeat(int key);                       // Check if a key has been pressed again
    boolean IsKeyDown(int key);                                // Check if a key is being pressed
    boolean IsKeyReleased(int key);
    boolean IsKeyUp(int key);
    void SetMouseOffset(int offsetX, int offsetY);
    void SetMouseCursor(int cursor);
    void ImageRotate(Image image, int degrees);

    String R4JVersion = "1.0";
}


