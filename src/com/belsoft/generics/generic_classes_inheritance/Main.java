package com.belsoft.generics.generic_classes_inheritance;

import com.belsoft.generics.comparable_interface.User;
import com.belsoft.generics.generic_methods.Dog;
import com.belsoft.generics.generic_methods.Pet;
import com.belsoft.generics.generic_methods.Utils;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new Instructor(10);
        Utils.printUser(new Instructor(10));

        var objects = new ArrayList<Object>();
        objects.add(new Object());

        var pets = new ArrayList<Pet>();
        pets.add(new Pet("Name"));

        var dogs = new ArrayList<Dog>();
        dogs.add(new Dog("Bolt"));

        // accept List<T> where T is "below" Pet in class hierarchy
        // List<? extends Pet>
        Utils.printPets(pets);
        Utils.printPets(dogs);

        // accept List<T> where T is "above" Pet in class hierarchy
        // List<? super Pet>
        Utils.printPetsReadWrite(pets);
        Utils.printPetsReadWrite(objects);
    }
}
