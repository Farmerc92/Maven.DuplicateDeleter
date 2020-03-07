package com.zipcodewilmington.looplabs;

/**
 * Created by leon on 1/28/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class StringDuplicateDeleter extends DuplicateDeleter<String> {

    public StringDuplicateDeleter(String[] intArray) {
        super(intArray);
    }

    @Override
    public String[] removeDuplicates(int maxNumberOfDuplications) {
        String[] buffer = new String[array.length];
        int j = 0;
        String currentString = array[0];
        int countCurrentString = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentString.equals(array[i])) {
                countCurrentString++;
            }else{
                if (countCurrentString < maxNumberOfDuplications){
                    while(countCurrentString > 0){
                        buffer[j++] = currentString;
                        countCurrentString--;
                    }
                }
                currentString = array[i];
                countCurrentString = 1;
            }
        }
        String[] results = new String[j];
        for (int i = 0; i < results.length; i++) {
            results[i] = buffer[i];
        }
        return results;
    }

    @Override
    public String[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        String[] buffer = new String[array.length];
        int indexCount = 0;
        String currentString = array[0];
        int countCurrentString = 0;
        for (int i = 0; i < array.length; i++) {
            if (currentString.equals(array[i])){
                countCurrentString++;
            } else {
                if (countCurrentString != exactNumberOfDuplications){
                    while (countCurrentString > 0){
                        buffer[indexCount++] = currentString;
                        countCurrentString--;
                    }
                }
                currentString = array[i];
                countCurrentString = 1;
            }
        }
        if (countCurrentString != exactNumberOfDuplications){
            while (countCurrentString > 0){
                buffer[indexCount++] = currentString;
                countCurrentString--;
            }
        }
        String[] results = new String[indexCount];
        for (int i = 0; i < indexCount; i++) {
            results[i] = buffer[i];
        }
        return results;
    }
}
