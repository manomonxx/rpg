package src;

import java.util.HashMap;
import java.util.Map;

import status.Slow;
import status.Status;
import status.Stun;
import utilities.RangeSkills;
import utilities.TypeRange;
import abilities.Ability;
import abilities.FightSkills;
import abilities.SkillTree;
import classes.Mago;

public class MainSkillTeste {

	public static void main(String[] args) {
		AbilityComponent skillsMago = new SkillTree("Mago", "Skills do mago!");
		
		TypeRange<Double> range = new RangeSkills<Double>(10.0);
		
		Map<String, Status<?>> allStatus = new HashMap<String, Status<?>>();
		
		//adicionando status à habilidade
		allStatus.put("Stun", new Stun(1.2, true)); //tempo em segundos e habilita/desabilita ação.
		allStatus.put("slow", new Slow(1.2, .3)); //tempo e porcentagem de slow
		
		skillsMago.addAbility(new FightSkills("RageOfGods", 1, range, 2, 3, "Envolve os inimigos com a irá dos deuses!", allStatus, 100.0, "Ranged", "Fire"));
		skillsMago.addAbility(new Ability("Craft", 10, range, 4, 3, "Constrói armaduras!"));
		
		Personagem personagem = new Mago(skillsMago);
		
		personagem.setName("Fernando");
		System.out.println("Nome: "+personagem.getName());
		
		System.out.println("Arma Primária:");
		personagem.performWeapon();
		System.out.println("----------------------------------");
		
		System.out.println("Habilidades:");
		System.out.println("----------------------------------");
		
		personagem.printSkillTree();

	}

}
