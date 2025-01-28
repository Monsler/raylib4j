package com.monsler;

import com.monsler.raylib4j.Ray;
import com.monsler.raylib4j.RayLib;

import static com.monsler.raylib4j.Ray.KEY_P;
import static com.monsler.raylib4j.Ray.KEY_SPACE;
import static com.monsler.raylib4j.RayLib.*;

public class Main {
    public static void main(String[] args) {
        int screenWidth = 800;
        int screenHeight = 450;
        RayLib.init();

        RayLib.setConfigFlags(Ray.FLAG_MSAA_4X_HINT);
        RayLib.initWindow(screenWidth, screenHeight, "raylib4j [audio] example - music playing (streaming)");
        RayLib.initAudioDevice();              // Initialize audio device

        Ray.Music music = loadMusicStream("country.mp3");
        setMusicVolume(music, 0.5f);

        playMusicStream(music);

        float timePlayed = 0.0f;        // Time played normalized [0.0f..1.0f]
        boolean pause = false;             // Music playing paused

        setTargetFps(30);               // Set our game to run at 30 frames-per-second
        //--------------------------------------------------------------------------------------

        // Main game loop
        while (!windowShouldClose())    // Detect window close button or ESC key
        {
            // Update
            //----------------------------------------------------------------------------------
            updateMusicStream(music);   // Update music buffer with new stream data

            // Restart music playing (stop and play)
            if (isKeyPressed(KEY_SPACE))
            {
                stopMusicStream(music);
                playMusicStream(music);
            }

            // Pause/Resume music playing
            if (isKeyPressed(KEY_P))
            {
                pause = !pause;

                if (pause) pauseMusicStream(music);
                else resumeMusicStream(music);
            }

            // Get normalized time played for current music stream
            timePlayed = getMusicTimePlayed(music)/getMusicTimeLength(music);

            if (timePlayed > 1.0f) timePlayed = 1.0f;   // Make sure time played is no longer than music
            //----------------------------------------------------------------------------------

            // Draw
            //----------------------------------------------------------------------------------
            beginDrawing();

            clearBackground(Ray.white);

            drawText("MUSIC SHOULD BE PLAYING!", 255, 150, 20, Ray.gray);

            drawRectangle(200, 200, 400, 12, Ray.gray);
            drawRectangle(200, 200, (int)(timePlayed*400.0f), 12, Ray.maroon);
            drawRectangleLines(200, 200, 400, 12, Ray.gray);

            drawText("PRESS SPACE TO RESTART MUSIC", 208, 250, 20, Ray.gray);
            drawText("PRESS P TO PAUSE/RESUME MUSIC", 208, 280, 20, Ray.gray);

            endDrawing();
            //----------------------------------------------------------------------------------
        }

        // De-Initialization
        //--------------------------------------------------------------------------------------
        unloadMusicStream(music);   // Unload music stream buffers from RAM

        closeAudioDevice();         // Close audio device (music streaming is automatically stopped)

        closeWindow();
    }
}
