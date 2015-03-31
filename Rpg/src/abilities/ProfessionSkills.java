package abilities;

import java.util.Map;

import status.Status;
import utilities.TypeRange;

public class ProfessionSkills extends Ability{

	public ProfessionSkills(String name, Integer level, TypeRange<?> range,
			Integer cooldown, Integer afterCastDelay, String description,
			Map<String, Status<?>> status) {
		super(name, level, range, cooldown, afterCastDelay, description);
	}
	
}
