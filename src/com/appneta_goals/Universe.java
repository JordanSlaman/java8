package com.appneta_goals;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class Universe {

  private static final int SIZE = 15000000;
  private static final float STAR_RATIO = 0.1f;

  private ArrayList<CelestialOrb> sphericalObjects = new ArrayList<>();

  public Universe() {
    System.out.println("Creating Universe...");

    int percentCompleted = 0;
    for (int i = 0; i < SIZE; i++) {
      if (ThreadLocalRandom.current().nextFloat() < STAR_RATIO) {
        sphericalObjects.add(new Star());
      } else {
        sphericalObjects.add(new Planet());
      }

      if (i % (SIZE / 10) == 0) {
        percentCompleted += 10;
        System.out.println(percentCompleted + "%...");
      }
    }
    System.out.println("Universe Created.");
  }

  public Stream<CelestialOrb> getSphereStream() {
    return sphericalObjects.parallelStream();
  }

}
