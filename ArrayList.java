/*Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods.
*/ 

public class ArrayList<Item> {
	private Object[] storage;
	private int currentSize;
	
	public ArrayList()
	{
		storage = new Object[10];
	}
	
	private void resize(int max)
	{ // Move stack to a new array of size max.
		Object[] temp = new Object[max];
		for (int i = 0; i <currentSize ; i++)
		{
			temp[i] = storage[i];
		}
		storage = temp;
	}
	
	public void add(Object obj){
		//if the array is full, double it in size before adding object
        if(currentSize == storage.length){
            resize(2*storage.length);
        }
        storage[currentSize] = obj;
    }
}
