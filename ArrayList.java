import java.lang.reflect.Array;

public class ArrayList<T>{
    private T[] currentArray;
    private T[] newArray;
    private int arraySize;
    private int currentPointer;
    private Class<T> genericClass;

    public ArrayList(Class<T> genericClass){
       //Java doesn't like it when you try to get the class instance of a generic,
       //so I'm just passing it the class instance of whatever at run time.
       this.genericClass = genericClass;
       this.arraySize = 5;
       this.currentArray = (T[])Array.newInstance(genericClass,arraySize);
       currentPointer = 0;
    }
    
    public void add(T element){
        currentArray[currentPointer] = element;
        currentPointer++;
        resize();
    }
    
    private void resize(){
        if (currentPointer + 5 >= arraySize){
            arraySize *= 2;
            T[] newArray = (T[])Array.newInstance(genericClass,arraySize); 
            for(int i = 0; i < currentPointer; i++){
                newArray[i] = currentArray[i];
            }
            this.currentArray = newArray;
        }
    }
    
    public T atIndex(int position){
        return currentArray[position];
    }

    public int getLength(){
        return currentPointer;
    }

    public Iterator<T> iterator(){
        return new Iterator<T>(this);
    }

    public T[] getArray(){
        T[] finalArray = (T[])Array.newInstance(genericClass,currentPointer);
        for(int i = 0; i < currentPointer; i++){
            finalArray[i] = currentArray[i];
        }
        return finalArray;
    }
}
