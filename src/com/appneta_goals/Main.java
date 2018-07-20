package com.appneta_goals;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

  public static void main(String[] args) throws Exception {
    Universe c157 = new Universe();

    // Get some stats..
    System.out.println("Star count: " + c157.getSphereStream()
        .filter(Star.class::isInstance)
        .count()
    );

    Class planetClass = Planet.class;
    System.out.println("Planet count: " + c157.getSphereStream()
        .filter(planetClass::isInstance)
        .count()
    );

    // Create life with Reflection
    Field lifeField = planetClass.getDeclaredField("hostToLife");
    lifeField.setAccessible(true);

    float probabilityOfLife = 0.00000013f;
    c157.getSphereStream().filter(planetClass::isInstance)
        .map(Planet.class::cast)
        .forEach(planet -> {
              if (ThreadLocalRandom.current().nextFloat() < probabilityOfLife) {
                try {
                  lifeField.set(planet, true);
                } catch (IllegalAccessException exc) {
                  System.out.println("Failed to bestow life on planet.");
                }
              }
            }
        );

    // Find it with Streams
    System.out.println("Planets containing life:");
    c157.getSphereStream()
        .filter(planetClass::isInstance)
        .map(Planet.class::cast)
        .filter(p -> p.isHostToLife())
        .forEach(System.out::println);

  }
}
