public class ItaratorApp {

    public static void main(String[] args){
        Tasks tasks = new Tasks();

        Iterator iterator = tasks.getIterator();

        while (iterator.hasNext()){
            System.out.println((String)iterator.next());
        }
    }
}

interface Iterator{
    boolean hasNext();
    Object next();
}

interface Container{
    Iterator getIterator();
}

class Tasks implements Container{
    String[] tasks = {"Build a house", "Raise a son", "Plant a tree"};

    @Override
    public Iterator getIterator() {
        return new TaskIterator();
    }

    private class TaskIterator implements Iterator{
        int index = 0;
        @Override
        public boolean hasNext() {
            if(index<tasks.length){
                return true;
            }
            else {
                return false;
            }
        }

        @Override
        public Object next() {
            return tasks[index++];
        }
    }
}
