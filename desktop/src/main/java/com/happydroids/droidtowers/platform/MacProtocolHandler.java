/*
 * Copyright (c) 2012. HappyDroids LLC, All rights reserved.
 */

package com.happydroids.droidtowers.platform;

import com.happydroids.platform.PlatformProtocolHandler;

import java.awt.Desktop;
import java.net.URI;

public class MacProtocolHandler implements PlatformProtocolHandler {
  private URI uri;

  public void initialize(String[] applicationArgs) {
    Desktop.getDesktop().setOpenURIHandler(openURIEvent -> uri = openURIEvent.getURI());
  }

  public boolean hasUri() {
    return uri != null;
  }

  public URI consumeUri() {
    URI theUri = uri;
    uri = null;
    return theUri;
  }

  public void setUrl(URI uri) {
    this.uri = uri;
  }
}
