package TodoList.Entity;

public class AFazeres {
	private String atividade;
	private String horario;
	private int posicao;
	public AFazeres(int posicao,String atividade, String horario) {
		this.posicao = posicao;
		this.atividade = atividade;
		this.horario = horario;
	}
	
	public int getPosicao() {
		return posicao;
	}
	public void setPosicao(int posicao) {
		this.posicao=posicao;
	}
	public String getAtividade() {
		return atividade;
	}
	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String toString() {
		return "A Fazeres = posicao: "+ posicao +"; atividade:" + atividade + "; horario: " + horario;
	}
	
	
}
