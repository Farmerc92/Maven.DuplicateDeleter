package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {
        Integer[] buffer = new Integer[array.length];
        int j = 0;
        Integer currentNumber = array[0];
        int countCurrentNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentNumber.equals(array[i])) {
                countCurrentNumber++;
            }else{
                if (countCurrentNumber < maxNumberOfDuplications){
                    while(countCurrentNumber > 0){
                        buffer[j++] = currentNumber;
                        countCurrentNumber--;
                    }
                }
                currentNumber = array[i];
                countCurrentNumber = 1;
            }
        }
        Integer[] results = new Integer[j];
        for (int i = 0; i < results.length; i++) {
            results[i] = buffer[i];
        }
        return results;
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        Integer[] buffer = new Integer[array.length];
        int indexCount = 0;
        Integer currentNumber = array[0];
        int countCurrentNumber = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentNumber.equals(array[i])){
                countCurrentNumber++;
            } else {
                if (countCurrentNumber != exactNumberOfDuplications){
                    while (countCurrentNumber > 0){
                        buffer[indexCount++] = currentNumber;
                        countCurrentNumber--;
                    }
                }
                currentNumber = array[i];
                countCurrentNumber = 1;
            }
        }
        if (countCurrentNumber != exactNumberOfDuplications){
            while (countCurrentNumber > 0){
                buffer[indexCount++] = currentNumber;
                countCurrentNumber--;
            }
        }
        Integer[] results = new Integer[indexCount];
        for (int i = 0; i < indexCount; i++) {
            results[i] = buffer[i];
        }
        return results;
    }
}
