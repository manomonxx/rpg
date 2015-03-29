package dinnerMenu.implementations;

import java.util.Iterator;

import dinnerMenu.MenuItem;

public class DinnerMenuIterator implements Iterator<MenuItem>{

	private MenuItem[] items;
	private int position = 0;
	
	public DinnerMenuIterator(MenuItem[] items) {
		this.items = items;
	}
	
	@Override
	public boolean hasNext() {
		if(this.position >= this.items.length || items[position] == null){
			return false;
		}
		
		return true;
	}

	@Override
	public MenuItem next() {
		MenuItem items = this.items[position++];
		return items;
	}

	@Override
	public void remove() {
		if(position <= 0){
			throw new IllegalStateException("Operação ilegal. Menu Vazio!");
		}
		
		if (items[position - 1] != null) {
			for (int i = position - 1; i < (items.length - 1); i++) {
				items[i] = items[i+1];
			}
			items[items.length - 1] = null;
		}
	}

}
