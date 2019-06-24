package com.zipcodewilmington.looplabs;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    String [] toEval = super.array;


    public StringDuplicateDeleter(String[] strArray){
        super(strArray);
    }




    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        Stream<String> myStream = Arrays.stream(super.array);

        Predicate<String> predicateStr = s -> (super.countOccurences(s, toEval) < maxNumberOfDuplications);

        return myStream.filter(predicateStr).toArray(String[] :: new);
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Stream<String> myStream = Arrays.stream(super.array);

        Predicate<String> predicateStr = s -> (!super.countOccurences(s, toEval).equals(exactNumberOfDuplications));


        return myStream.filter(predicateStr).toArray(String[]::new);

    }
}
