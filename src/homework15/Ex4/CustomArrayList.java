package homework15.Ex4;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * @author Elena Chinarina
 *
 **/

public class CustomArrayList<T> implements Iterable<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final double GROWTH_FACTOR = 1.5;

    private Object[] elements;
    private int size;

    // Конструкторы
    public CustomArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public CustomArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Initial capacity cannot be negative: " + initialCapacity);

        this.elements = new Object[initialCapacity];
        this.size = 0;
    }

    // Добавление элемента в конец
    public void add(T element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Добавление элемента по индексу
    public void add(int index, T element) {
        checkIndexForAdd(index);
        ensureCapacity();

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Получение элемента по индексу
    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    // Удаление элемента по индексу
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);

        elements[--size] = null;
        return removedElement;
    }

    // Удаление первого вхождения элемента
    public boolean remove(T element) {
        int index = indexOf(element);
        if (index >= 0) {
            remove(index);
            return true;
        }

        return false;
    }

    // Проверка наличия элемента
    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    // Поиск индекса элемента (первое вхождение)
    public int indexOf(T element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i]))
                    return i;
            }
        }

        return -1;
    }

    // Замена элемента по индексу
    @SuppressWarnings("unchecked")
    public T set(int index, T element) {
        checkIndex(index);
        T oldElement = (T) elements[index];
        elements[index] = element;
        return oldElement;
    }

    // Текущий размер
    public int size() {
        return size;
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return size == 0;
    }

    // Очистка коллекции
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    //Обрезка capacity до текущего размера
    public void trimToSize() {
        if (size < elements.length) {
            Object[] newArray = new Object[size];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    // Преобразование в массив
    @SuppressWarnings("unchecked")
    public T[] toArray() {
        return (T[]) Arrays.copyOf(elements, size, Object[].class);
    }

    // Реализация итератора
    @Override
    public Iterator<T> iterator() {
        return new CustomArrayListIterator();
    }

    private class CustomArrayListIterator implements Iterator<T> {
        private int currentIndex = 0;
        private int lastReturnedIndex = -1;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException("No more elements in the collection");

            lastReturnedIndex = currentIndex;
            return (T) elements[currentIndex++];
        }

        @Override
        public void remove() {
            if (lastReturnedIndex < 0)
                throw new IllegalStateException("next() must be called before remove()");

            CustomArrayList.this.remove(lastReturnedIndex);

            currentIndex = lastReturnedIndex;
            lastReturnedIndex = -1;
        }

        @Override
        @SuppressWarnings("unchecked")
        public void forEachRemaining(Consumer<? super T> action) {
            if (action == null)
                throw new NullPointerException("Action  cannot be null");

            while (currentIndex < size) {
                T element = (T) elements[currentIndex];
                action.accept(element);
                currentIndex++;
            }
        }
    }

    // Метод forEach
    @Override
    @SuppressWarnings("unchecked")
    public void forEach(Consumer<? super T> action) {
        if (action == null)
            throw new NullPointerException("Action  cannot be null");

        for (int i = 0; i < size; i++) {
            T element = (T) elements[i];
            action.accept(element);
        }
    }

    // Внутренние методы
    private void checkIndex(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + ", size: " + size);
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = (int) (elements.length * GROWTH_FACTOR) + 1;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    @Override
    public String toString() {
        if (size == 0)
            return "[]";

        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]);
            if (i < size - 1)
                stringBuilder.append(", ");
        }
        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}
