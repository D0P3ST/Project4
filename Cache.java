import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Cache<T> implements ICache<T> {

	private DLLNode<T> head, tail;
	private int size;
	private int capacity = 0;
	private double hit = 0;
	private double miss = 0;
	private double access = 0;
	
	

	public Cache(int size) {

		this.size = size;
		head = null;
		tail = null;

	}

	public Cache() {

		size = 100;
		head = null;
		tail = null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#get(java.lang.Object)
	 */
	@Override
	public T get(T target) {
		// TODO Auto-generated method stub
		DLLNode<T> current = head;
		DLLNode<T> previous = null;
		boolean found = false;
		while (current != null && !found) {
			if (current.getElement().equals(target)) {
				found = true;
				write(target);
				hit++;
				access++;
				return target;
			} else {
				previous = current;
				current = current.getNext();
			}
		}

		if (!found) {
			miss++;
			access++;
			add(target);
		}

		return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#clear()
	 */
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = null;
		tail = null;
		capacity = 0;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#add(java.lang.Object)
	 */
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		DLLNode<T> newNode = new DLLNode<T>(data);
		newNode.setNext(head);
		if (head != null) {
			head.setPrevious(newNode);
		}
		head = newNode;

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}

		if (capacity == size) {
			removeLast();
		} else {
			capacity++;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#removeLast()
	 */
	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new IllegalStateException("List is empty.");
		}

		DLLNode<T> previous = tail.getPrevious();
		tail.setPrevious(null);
		if (previous != null) {
			previous.setNext(null);
		} else {
			head = null;
		}
		tail = previous;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#remove(java.lang.Object)
	 */
	@Override
	public void remove(T target) {
		// TODO Auto-generated method stub
		DLLNode<T> current = head;
		boolean found = false;
		while (current != null && !found) {
			if (current.getElement().equals(target)) {
				found = true;
			} else {
				current = current.getNext();
			}
		}

		if (!found) {
			throw new NoSuchElementException("Can't find element.");
		}

		DLLNode<T> next = current.getNext();

		DLLNode<T> previous = current.getPrevious();
		if (previous != null) {
			previous.setNext(next);

		} else {
			head = next;
		}
		if (next != null) {
			next.setPrevious(previous);
		} else {
			tail = previous;
		}
		capacity--;

	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#write(java.lang.Object)
	 */
	@Override
	public void write(T data) {
		// TODO Auto-generated method stub
		remove(data);
		add(data);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#getHitRate()
	 */
	@Override
	public double getHitRate() {
		// TODO Auto-generated method stub
		if (access == 0) {
			return 0;
		}
		return (hit/access);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#getMissRate()
	 */
	@Override
	public double getMissRate() {
		// TODO Auto-generated method stub
		return (1 - getHitRate());
	}

	/**
	 * @return hit
	 */
	public double getHits() {
		return hit;
	}

	/**
	 * @return miss
	 */
	public double getMiss() {
		return miss;
	}

	/**
	 * @return access
	 */
	public double getAccesses() {
		return access;
	}

	/**
	 * Increments access
	 */
	public void Access() {
		access++;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see ICache#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (capacity == 0);
	}

}
