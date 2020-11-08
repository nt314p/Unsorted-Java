package platformer;

import fastj.engine.FastJEngine;
import fastj.engine.io.Display;
import fastj.engine.systems.game.LogicManager;
import fastj.engine.systems.game.Scene;

public class Main extends LogicManager {
	
	private Scene mainScene;

	public static void main(String[] args) {
		FastJEngine.log("Hello World!");
		FastJEngine.init("Wheee", new Main());
		FastJEngine.setTargetFPS(1000);
		FastJEngine.setTargetUPS(100);
		FastJEngine.run();
	}

	@Override
	public void setup(Display window) {
		mainScene = new MainScene();
		this.addScene(mainScene);
		setCurrentScene(mainScene);
		initCurrentScene(window);
	}

}
