package br.ufrn.imd.modelo;

public class Celula {
	private int linha, coluna;
	private boolean bombardeado;
	private boolean selecionado;
	private Tabuleiro tabuleiro;

	public Tabuleiro getTabuleiro() {
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public Celula(int coluna, int linha) {
		this.coluna = coluna;
		this.linha = linha;
		this.selecionado = false;
		this.bombardeado = false;
	}
	
	public int getLinha() {
		return linha;
	}

	public int getColuna() {
		return coluna;
	}


	public void setBombardeado() {
		this.bombardeado = true;
	}
	
	public boolean isBombardeado() {
		return this.bombardeado;
	}
	
	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}
	
	public boolean isSelecionado() {
		return this.selecionado;
	}

}
