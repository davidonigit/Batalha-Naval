package br.ufrn.imd.modelo;

public class MeuTabuleiro extends Tabuleiro{
	private Navio navioSelecionado = null;
	private boolean vez = true;
	
	public Navio getNavioSelecionado() {
		return navioSelecionado;
	}
	
	public void selecionaNavio(Navio navio) {
		if(navio.isSelecionado()) {
			navio.setSelecionado(false);
			this.navioSelecionado = null;
		}else {
			navio.setSelecionado(true);
			this.navioSelecionado = navio;
		}
	}

	public boolean isVez() {
		return vez;
	}

	public void setVez(boolean vez) {
		this.vez = vez;
	}
}
