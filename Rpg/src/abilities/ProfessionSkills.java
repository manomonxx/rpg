package abilities;

import utilities.TypeRange;

public class ProfessionSkills extends Ability{

	public ProfessionSkills(String name, Integer level, TypeRange<?> range,
			Integer cooldown, Integer afterCastDelay, String description) {
		super(name, level, range, cooldown, afterCastDelay, description);
	}
	
}
