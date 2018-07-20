package com.appneta_goals;

import java.util.concurrent.ThreadLocalRandom;

public abstract class CelestialOrb {
  private double mass;
  private double radius;

  private static final int MIN = 10;
  private static final int MAX = 1000;

  public CelestialOrb() {
    mass = ThreadLocalRandom.current().nextDouble(MIN, MAX - 1);
    radius = ThreadLocalRandom.current().nextDouble(MIN, MAX - 1);
  }

  public double getMass() {
    return mass;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + " with mass of: " + mass + " and radius of: " + radius;
  }
}
