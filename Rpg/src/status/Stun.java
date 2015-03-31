package status;

public class Stun implements Status<Boolean> {

	private Double time; //tempo de enraizamento
	private Boolean effect; //Habilita/Desabilita ação do personagem  
	
	public Stun(Double time, Boolean effect) {
		this.time = time;
		this.effect = effect;
	}
	
	@Override
	public Double getStatusTime() {
		return time;
	}

	@Override
	public Boolean getEffect() {
		return effect;
	}
}
