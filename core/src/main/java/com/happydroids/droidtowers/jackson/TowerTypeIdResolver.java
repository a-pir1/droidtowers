/*
 * Copyright (c) 2012. HappyDroids LLC, All rights reserved.
 */

package com.happydroids.droidtowers.jackson;

import com.fasterxml.jackson.databind.DatabindContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.jsontype.impl.ClassNameIdResolver;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.happydroids.droidtowers.utils.ClassNameResolver;

import java.io.IOException;

public class TowerTypeIdResolver extends ClassNameIdResolver {
  public TowerTypeIdResolver() {
    super(null, null, LaissezFaireSubTypeValidator.instance);
  }

  public JavaType typeFromId(DatabindContext context, String id) {
    try {
      Class clazz = ClassNameResolver.resolveClass(id);
      if (clazz != null) {
        return TypeFactory.defaultInstance().constructType(clazz);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      return super.typeFromId(context, id);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
