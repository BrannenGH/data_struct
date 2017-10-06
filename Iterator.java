public class Iterator<T>{
    private ArrayList<T> list;
    private int listLength;
    private int position;

    public Iterator(ArrayList<T> list){
        this.list = list;
        this.listLength = list.getLength();
        this.position = 0; 
    }
    
    public boolean hasNext(){
        if (position < listLength){
            return true;
        } else {
            return false;
        }
    }

    public T next(){
        T result = list.atIndex(position);
        position++;
        return result;
    }
}
