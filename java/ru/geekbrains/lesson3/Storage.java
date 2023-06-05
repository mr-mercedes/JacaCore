package ru.geekbrains.lesson3;

import java.util.Arrays;
import java.util.Iterator;


public class Storage implements Iterable<Human> {
    Human[] storage;

    public Storage(Human[] storage) {
        this.storage = storage;
    }
    public void sortStorage(){
        storage = Arrays.stream(storage).sorted().toArray(Human[]::new);
    }

    @Override
    public Iterator<Human> iterator() {
        return new Iterator<>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                if (index >= storage.length) return false;
                Human head = storage[index];
                return head != null;
            }

            @Override
            public Human next() {
                return storage[index++];
            }
        };
    }
}
