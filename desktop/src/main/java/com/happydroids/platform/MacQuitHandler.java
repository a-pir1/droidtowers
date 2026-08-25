/*
 * Copyright (c) 2012. HappyDroids LLC, All rights reserved.
 */

package com.happydroids.platform;

import com.badlogic.gdx.Gdx;

import java.awt.Desktop;
import java.awt.desktop.QuitStrategy;

public class MacQuitHandler {
  public MacQuitHandler() {
    Desktop.getDesktop().setQuitHandler((quitEvent, quitResponse) -> Gdx.app.exit());
    Desktop.getDesktop().setQuitStrategy(QuitStrategy.NORMAL_EXIT);
  }
}
