package utilities;

public class RangeSkills<E> implements TypeRange<E>{
	private E radius; //raio de ação da skill

	public RangeSkills(E radius) {
		this.radius = radius;
	}
	
	@Override
	public E getRange() {
		return radius;
	}
}
