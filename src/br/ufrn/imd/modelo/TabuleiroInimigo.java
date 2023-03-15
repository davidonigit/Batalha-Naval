package br.ufrn.imd.modelo;

public class TabuleiroInimigo extends Tabuleiro{
	private Celula celulaSelecionada = null;
	
	public void selecionaCelula(Celula celula) {
		if(celula.isSelecionado()) {
			celula.setSelecionado(false);
			this.celulaSelecionada = null;
		}else {
			celula.setSelecionado(true);
			this.celulaSelecionada = celula;
		}
	}
	
	public Celula getCelulaSelecionada() {
		return celulaSelecionada;
	}
}
