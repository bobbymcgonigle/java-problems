/*Write a program to implement your own ArrayList class. It should
contain add(), get(), remove(), size() methods.
*/

public class ArrayList<T> {
	private Object[] storage;
	private int currentSize;

	public ArrayList() {
		storage = new Object[10];
	}

	public int size() {
		return currentSize;
	}
	
	public Object get(int index)
	{
		//only return if the index is actually in the bounds of array
		if(index < currentSize)
		{
			return storage[index];
		}
		else
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public Object remove(int index)
	{
		if (index < currentSize) {
			Object obj = storage[index];
			storage[index] = null;
			int tmp = index;
			
			while (tmp < currentSize) {
				storage[tmp] = storage[tmp + 1];
				storage[tmp + 1] = null;
				tmp++;
			}
			currentSize--;
			return obj;
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	private void resize(int max) { // Move stack to a new array of size max.
		Object[] temp = new Object[max];
		for (int i = 0; i < currentSize; i++) 
		{
			temp[i] = storage[i];
		}
		storage = temp;
	}

	public void add(Object obj) {
		// if the array is full, double it in size before adding object
		if (currentSize == storage.length) {
			resize(2 * storage.length);
		}
		storage[currentSize++] = obj;
	}

}
