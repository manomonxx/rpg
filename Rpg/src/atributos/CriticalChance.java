package atributos;

import src.AtributosBehavior;

public class CriticalChance implements AtributosBehavior<Object> {

	private Double criticalchance;
	
	public CriticalChance(Double criticalchance) {
		this.criticalchance = criticalchance;
	}
	
	@Override
	public Double getAttr() {
		// TODO Auto-generated method stub
		return this.criticalchance;
	}

	@Override
	public void setAttr(Object value) {
		this.criticalchance = (Double)value;
	}

}
