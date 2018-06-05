package com.rastera.hubg;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.rastera.hubg.Screens.HUBGGame;


public class HUBGMain extends Game implements ApplicationListener{
	public static final int V_WIDTH = 400;
	public static final int V_HEIGHT = 208;
	public static final float TILESIZE = 48;
	public static final float PPM = 48/2f;
	public static final float SYNC_INTERVAL = 9/60f;

	public SpriteBatch batch;
	public com.rastera.hubg.desktop.Game parentGame;

	public HUBGMain(com.rastera.hubg.desktop.Game parentGame) {
		super();
		this.parentGame = parentGame;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new HUBGGame(this, this.parentGame));
	}

	@Override
	public void render () {
		super.render();
	}

    public void dispose() {
        System.out.println("lol");
        this.parentGame.exitGame();
    }

}
