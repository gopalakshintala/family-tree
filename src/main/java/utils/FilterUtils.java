/*
 * Copyright (c) 2016, Gopal S Akshintala
 * This source code is licensed under the Creative Commons Attribution-ShareAlike 4.0 International License.
 * http://creativecommons.org/licenses/by-sa/4.0/
 */

package utils;

import graph.ConnectionEdge;
import graph.Person;
import relationship.IGenericRelation;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Utility class to store methods that filter
 */
public class FilterUtils {
    public static Collection<ConnectionEdge> filterConnectionsByGenerationLevel(Person person, int generationLevel,
                                                                                Collection<ConnectionEdge> allConnections) {

        return allConnections.stream().filter(connection -> connection.relationLevel() == generationLevel).collect
                (Collectors.toSet());
    }

    public static Collection<Person> filterPersonsByGender(Boolean gender, Collection<Person> allPersons) {
        return allPersons.stream().filter(person -> person.isGenderMale() == gender).collect(Collectors.toSet());
    }

    public static Collection<ConnectionEdge> filterConnectionsBySpecificRelation(IGenericRelation genericRelation,
                                                                                 Boolean isRelationGenderMale, int relationLevel,
                                                                                 Collection<ConnectionEdge> allConnections) {
        return allConnections.stream().filter(connection -> connection.relationLevel() == relationLevel &&
                (isRelationGenderMale != null && connection.to().isGenderMale() == isRelationGenderMale) && connection
                .relation().equals(genericRelation)).collect(Collectors.toSet());
    }
}