import java.util.Iterator;

public class Box<T> implements Iterable<T>{
    private T[] carList;
    private int index;

    public Box(){
        carList = (T[])new Object[10];
    }

    public void addToBox(T newObj){
        carList[index++] = newObj;
    }

    @Override
    public Iterator<T> iterator() {
        return new BoxIterator<>(carList);
    }

    private class BoxIterator<T> implements Iterator<T>{
        private T[] array;
        private int index = 0;

        public BoxIterator(T[] array) {
            this.array = array;
        }

        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {
            return array[index++];
        }
    }
}
