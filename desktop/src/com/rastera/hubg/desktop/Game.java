package com.rastera.hubg.desktop;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rastera.hubg.HUBGMain;

class Game extends GeiPanel {

	private BufferedImage background;

	public Game(Main parent) {
		this.parent = parent;
		this.parent.setMasterTimer(50);
		this.constantUpdate = false;

		try {
			this.background = ImageIO.read(new File("images/menu-background.png"));
		} catch (Exception e) {
			Main.errorQuit(e);
		}

		this.repaint();
		System.out.println("IM ALIVE!!!!");

		//Rah.webbrowserOpen("https://agar.io");
		Main.stopMusic();
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new HUBGMain(), config);
	}

	public void exitGame() {
		this.parent.startPage(Main.Pages.MENU);
	}

	@Override
	public void paintComponent(Graphics graphics) {

		this.parent.updateFrameRate();

		Graphics2D g = (Graphics2D) graphics;

		g.setRenderingHint( RenderingHints.KEY_TEXT_ANTIALIASING,
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		int dimension = Math.max(this.getHeight(), this.getWidth());
		g.drawImage(this.background, 0, 0, dimension, dimension, this);

		String loadingMessage = "Game is in progress...";

		g.setColor(Color.WHITE);
		g.setFont(Main.getFont("Lato-Light", 30));
		FontMetrics metrics = g.getFontMetrics(Main.getFont("Lato-Light", 30));
		g.drawString(loadingMessage, this.getWidth() / 2 - metrics.stringWidth(loadingMessage) / 2, this.getHeight() / 2 - metrics.getHeight() / 2);

        try {
            TimeUnit.SECONDS.sleep(5);
            exitGame();

        } catch (Exception e) {

        }

	}

}