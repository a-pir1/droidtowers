/*
 * Copyright (c) 2012. HappyDroids LLC, All rights reserved.
 */

package com.happydroids.droidtowers;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.happydroids.droidtowers.gamestate.server.TowerGameService;
import com.happydroids.droidtowers.platform.PlatformProtocolHandlerFactory;
import com.happydroids.platform.*;

public class DesktopGame {
  public static void main(final String[] args) {
    PlatformQuitHandlerFactory.initialize();

    TowerGameService.setDeviceOSMarketName("stripe");
    TowerGameService.setDeviceType(Platform.getOSType().name());
    TowerGameService.setDeviceOSVersion(System.getProperty("os.version"));

    Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
    config.setTitle(String.format("Droid Towers (v%s)", TowerConsts.VERSION));
    config.setResizable(false);
    config.setWindowedMode(800, 600);

    new Lwjgl3Application(new LwjglApplicationShim(new DroidTowersGame(new Runnable() {
      @Override
      public void run() {
        PlatformProtocolHandler protocolHandler = PlatformProtocolHandlerFactory.newInstance();
        if (protocolHandler != null) {
          protocolHandler.initialize(args);
          Platform.setProtocolHandler(protocolHandler);
        }

        Platform.setDialogOpener(new DesktopDialogOpener());
        Platform.setUncaughtExceptionHandler(new DesktopUncaughtExceptionHandler());
        Platform.setBrowserUtil(new DesktopBrowserUtil());
        Platform.setConnectionMonitor(new PlatformConnectionMonitor());
        Platform.setPurchaseManager(new DesktopPurchaseManager());

//        new GameVersionCheckTask().run();
      }
    })), config);
  }

}
