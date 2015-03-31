package utilities;

public class RangeSkills<E> implements TypeRange<E>{
	private E radius; //raio de a��o da skill

	public RangeSkills(E radius) {
		this.radius = radius;
	}
	
	@Override
	public E getRange() {
		return radius;
	}
}
