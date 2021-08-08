package texttesting;

import io.github.lucasstarsz.fastj.engine.FastJEngine;
import io.github.lucasstarsz.fastj.math.Pointf;
import io.github.lucasstarsz.fastj.graphics.Display;
import io.github.lucasstarsz.fastj.graphics.DrawUtil;
import io.github.lucasstarsz.fastj.graphics.game.Text2D;

import io.github.lucasstarsz.fastj.systems.control.LogicManager;
import io.github.lucasstarsz.fastj.systems.control.Scene;
import io.github.lucasstarsz.fastj.systems.input.mouse.Mouse;
import io.github.lucasstarsz.fastj.systems.input.mouse.MouseAction;
import jdk.nashorn.internal.runtime.regexp.joni.MatcherFactory;
import io.github.lucasstarsz.fastj.graphics.game.AttributeText2D;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.font.TextAttribute;

public class Main extends LogicManager {
    
	@Override
    public void setup(Display display) {
        Scene scene = new Scene("") {
            AttributeText2D attributeText2D;
            String text = "hello world";
            int idx = 0;
            int maxIdx = text.length();
            String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        

            @Override
            public void load(Display display) {
                attributeText2D = new AttributeText2D("hello world", new Pointf(300f), new Font("Comic Sans MS", 0, 100));
                attributeText2D.addAsGameObject(this);
            }

            @Override
            public void unload(Display display) {
            }

            @Override
            public void update(Display display) {
                //if (Mouse.interactsWith(attributeText2D, MouseAction.PRESS)) {
                    // puts a random color
                    attributeText2D.addAttribute(TextAttribute.FOREGROUND, DrawUtil.randomColor(), idx++, idx);
                    // resets index
                    if (idx == maxIdx) {
                        idx = 0;
                    }
                //}
                attributeText2D.addAttribute(TextAttribute.FONT, new Font(fonts[(int) (Math.random() * (fonts.length))], 0, (int) (Math.random() * 200)), 0, 11);
            }
        };
        
        addScene(scene);
        setCurrentScene(scene);
        loadCurrentScene();
        display.showFPSInTitle(true);
        display.modifyRenderSettings(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	}

    public static void main(String[] args) {
        FastJEngine.init("Main", new Main());
        FastJEngine.run();
    }
    
}
