package abilities;

import utilities.TypeRange;

public class ProfessionSkills extends Ability{

	public ProfessionSkills(String name, Integer level, TypeRange<?> range,
			Double castTime, Double afterCastDelay, String description) {
		super(name, level, range, castTime, afterCastDelay, description);
	}
	
}
