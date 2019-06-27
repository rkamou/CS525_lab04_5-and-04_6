package lab04_5;

import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ObjectManager {
	private Vector list = new Vector();

	public Vector getAll() {
		return list;
	}

	public DomainObject getObjectAt(int i) {
		return (DomainObject) list.get(i);
	}

	public int getIndexOf(DomainObject po) {
		return list.indexOf(po);
	}

	public int numberOfObjects() {
		return list.size();
	}

	public void delete(DomainObject po) {
		list.remove(po);
	}

	public void addObject(DomainObject po) {
		list.add(po);
	}

}