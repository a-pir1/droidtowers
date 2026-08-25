/*
 * Copyright (c) 2012. HappyDroids LLC, All rights reserved.
 */

package com.happydroids.platform;

import com.happydroids.droidtowers.gamestate.server.TowerGameService;
import com.happydroids.platform.purchase.DroidTowerVersions;

import java.util.UUID;

public class DesktopPurchaseManager extends PlatformPurchaseManger {
  public DesktopPurchaseManager() {
    super();

    itemSkus.put(DroidTowerVersions.UNLIMITED_299, TowerGameService.getDeviceOSMarketName() + ".unlimited299");
  }

  @Override
  public void requestPurchase(final String itemId) {
    // In-app purchases are disabled in this build; grant the item immediately instead of charging anyone.
    purchaseItem(itemId, UUID.randomUUID().toString());
  }

  @Override
  public void onStart() {
  }

  @Override
  public void onResume() {
  }
}
