package platformer;

import java.awt.Color;

import fastj.engine.graphics.drawable.single.Polygon2D;
import fastj.engine.io.Display;
import fastj.engine.systems.game.Scene;
import fastj.engine.util.DrawUtil;

public class MainScene extends Scene {

	@Override
	public void load(Display window) {
		Rigidbody2D rigidbody = new Rigidbody2D(1, true);
		Polygon2D player = (Polygon2D) new Polygon2D(DrawUtil.createBox(200, 200, 50, 50), Color.red, true, true)
				.addBehavior(rigidbody, this)
				.addBehavior(new BoxMovement(rigidbody), this)
				.addBehavior(new BoxCollider2D(rigidbody, true), this);
		
		this.addGameObject(player);
		player.addTag("Player", this);
		
		Rigidbody2D rigidbody2 = new Rigidbody2D(1, true);
		Polygon2D box = (Polygon2D) new Polygon2D(DrawUtil.createBox(300, 300, 50, 50), Color.red, true, true)
				.addBehavior(rigidbody2, this)
				.addBehavior(new BoxCollider2D(rigidbody2, true), this);
		this.addGameObject(box);

		

		this.addGameObject(new Polygon2D(DrawUtil.createBox(20, 100, 50, 500), Color.red, true, true)
				.addBehavior(new BoxCollider2D(), this));
		
		this.addGameObject(new Polygon2D(DrawUtil.createBox(400, 100, 50, 500), Color.red, true, true)
				.addBehavior(new BoxCollider2D(), this));
		
		this.addGameObject(new Polygon2D(DrawUtil.createBox(20, 100, 500, 50), Color.red, true, true)
				.addBehavior(new BoxCollider2D(), this));
		
		this.addGameObject(new Polygon2D(DrawUtil.createBox(20, 600, 500, 50), Color.red, true, true)
				.addBehavior(new BoxCollider2D(), this));
	}

	@Override
	public void unload(Display window) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Display window) {

	}

}
