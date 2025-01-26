# raylib4j
<img align="left" style="width:260px" src="Raylib_logo.jpg"/>

*RayLib Modern bindings for java.* Its a simple and easy-to-use way to enjoy videogames programming.

raylib is highly inspired by Borland BGI graphics lib and by XNA framework and it's especially well suited for prototyping, tooling, graphical applications, embedded systems and education.

this project include not only bindings themself, but native libraries too.

*NOTE for ADVENTURERS: raylib is a programming library to enjoy videogames programming; no fancy interface, no visual helpers, no debug button... just coding in the most pure spartan-programmers way.*

Ready to learn? Jump to [code examples!](https://www.raylib.com/examples.html)

---

<br>


[![GitHub Releases Downloads](https://img.shields.io/github/downloads/Monsler/raylib4j/total)](https://github.com/Monsler/raylib4j/releases)
[![GitHub Stars](https://img.shields.io/github/stars/Monsler/raylib4j?style=flat&label=stars)](https://github.com/Monsler/raylib4j/stargazers)

Hello world code
------

```java
import com.monsler.raylib4j.Ray;
import com.monsler.raylib4j.RayLib;

public class Main {
    public static void main(String[] args) {
        RayLib.init();
        RayLib.initWindow(450, 300, "raylib4j");
        var closed = false;

        RayLib.setTargetFps(120); // set up the fps limit

        while (!closed) {
            if (RayLib.windowShouldClose()) {
                closed = true;
            }

            RayLib.clearBackground(Ray.black);
            RayLib.beginDrawing();
            RayLib.drawFps(10, 10);
            RayLib.drawText("Hello, world!", 10, 30, 20, Ray.white);
            RayLib.endDrawing();
        }

        RayLib.closeWindow(); // shut the program down after the window has been closed
    }
}
```
<br>

![screenshot](https://github.com/user-attachments/assets/ab635129-bf9c-4ca5-9f0b-28a779de77d1)
