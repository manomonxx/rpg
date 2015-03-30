package src;

import java.util.HashMap;
import java.util.Map;

import status.Status;
import utilities.TypeRange;
import abilities.Ability;
import abilities.SkillTree;
import classes.Mago;

public class MainSkillTeste {

	public static void main(String[] args) {
		AbilityComponent skillsMago = new SkillTree("Mago", "Skills do mago!");
		
		TypeRange range = new TypeRange() {
			
			@Override
			public Object getRange() {
				// TODO Auto-generated method stub
				return (Integer) 10;
			}
		};
		
		
		Map<String, Status> allStatus = new HashMap<String, Status>();
		
		Status status = new Status(){
			@Override
			public String getStatus() {
				// TODO Auto-generated method stub
				return "Stun";
			}
		};
		
		allStatus.put("Stun", status);
		
		skillsMago.addAbility(new Ability("RageOfGods", 1, range, "Envolve os inimigos com a irá dos deuses!", allStatus));
		
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
