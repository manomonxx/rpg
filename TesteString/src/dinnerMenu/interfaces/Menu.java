package dinnerMenu.interfaces;

import java.util.Iterator;

import dinnerMenu.MenuItem;

public interface Menu {
	public Iterator<MenuItem> createIterator();
}
