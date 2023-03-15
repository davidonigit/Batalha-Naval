package br.ufrn.imd.modelo;

public abstract class Navio {
	private int linha, coluna;
	private boolean horizontal = true;
	private boolean elimiado = false;
	private boolean selecionado = false;
	private Tabuleiro tabuleiro;
	private int vidaNavio;
	
	public abstract boolean validaMovimento(int linhaDestino, int colunaDestino);
	public abstract boolean validaRotacao();
	
	public Navio(int linha, int coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public int getVidaNavio() {
		return vidaNavio;
	}
	public void setVidaNavio(int vidaNavio) {
		this.vidaNavio = vidaNavio;
	}
	public void decrementaVidaNavio() {
		this.vidaNavio--;
		if(vidaNavio==0) {
			setElimiado();
		}
	}
	public int getLinha() {
		return linha;
	}
	public void setLinha(int linha) {
		this.linha = linha;
	}
	public int getColuna() {
		return coluna;
	}
	public void setColuna(int coluna) {
		this.coluna = coluna;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean isElimiado() {
		return elimiado;
	}
	public void setElimiado() {
		this.elimiado = true;
	}
	public boolean isSelecionado() {
		return selecionado;
	}
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}
	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}
}
