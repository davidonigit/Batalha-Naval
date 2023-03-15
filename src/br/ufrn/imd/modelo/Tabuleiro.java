package br.ufrn.imd.modelo;

public abstract class Tabuleiro {
	
	private Navio[][] navios;
	private Celula[][] celulas;
	private int vida = 2+3+4+5;
	
	public int getVida() {
		return vida;
	}

	public void decrementaVida() {
		this.vida -= 1;
	}

	public Tabuleiro() {
		this.navios = new Navio[10][10];
		this.celulas = new Celula [10][10];
	}
	
	//retorna null ou o Navio que ocupa a posição linha coluna
	public Navio getNavio(int linha, int coluna) {
		return this.navios[linha][coluna];
	}
	
	//retira navio do local
	public void livraNavio(Navio navio, int linha, int coluna) {
		if(navio instanceof Corveta) {
			if(navio.isHorizontal()) {
				this.navios[linha][coluna] = null;
				this.navios[linha][coluna+1] = null;
				
			}else {
				this.navios[linha][coluna] = null;
				this.navios[linha+1][coluna] = null;
			}
		}
		if(navio instanceof Submarino) {
			if(navio.isHorizontal()) {
				this.navios[linha][coluna] = null;
				this.navios[linha][coluna+1] = null;
				this.navios[linha][coluna+2] = null;
				
			}else {
				this.navios[linha][coluna] = null;
				this.navios[linha+1][coluna] = null;
				this.navios[linha+2][coluna] = null;
			}
		}
		if(navio instanceof Fragata) {
			if(navio.isHorizontal()) {
				this.navios[linha][coluna] = null;
				this.navios[linha][coluna+1] = null;
				this.navios[linha][coluna+2] = null;
				this.navios[linha][coluna+3] = null;
				
			}else {
				this.navios[linha][coluna] = null;
				this.navios[linha+1][coluna] = null;
				this.navios[linha+2][coluna] = null;
				this.navios[linha+3][coluna] = null;
			}
		}
		if(navio instanceof Destroyer) {
			if(navio.isHorizontal()) {
				this.navios[linha][coluna] = null;
				this.navios[linha][coluna+1] = null;
				this.navios[linha][coluna+2] = null;
				this.navios[linha][coluna+3] = null;
				this.navios[linha][coluna+4] = null;
				
			}else {
				this.navios[linha][coluna] = null;
				this.navios[linha+1][coluna] = null;
				this.navios[linha+2][coluna] = null;
				this.navios[linha+3][coluna] = null;
				this.navios[linha+4][coluna] = null;
			}
		}
	}
	
	
	//adiciona um Navio na posição linha coluna
		public void adicionaNavio(Navio navio) {
			if(navio instanceof Corveta) {
				if(navio.isHorizontal()) {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+1] = navio;
					
				}else {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+1][navio.getColuna()] = navio;
				}
			}
			if(navio instanceof Submarino) {
				if(navio.isHorizontal()) {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+1] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+2] = navio;
					
				}else {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+1][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+2][navio.getColuna()] = navio;
				}
			}
			if(navio instanceof Fragata) {
				if(navio.isHorizontal()) {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+1] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+2] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+3] = navio;
					
				}else {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+1][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+2][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+3][navio.getColuna()] = navio;
				}
			}
			if(navio instanceof Destroyer) {
				if(navio.isHorizontal()) {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+1] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+2] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+3] = navio;
					this.navios[navio.getLinha()][navio.getColuna()+4] = navio;
					
				}else {
					this.navios[navio.getLinha()][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+1][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+2][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+3][navio.getColuna()] = navio;
					this.navios[navio.getLinha()+4][navio.getColuna()] = navio;
				}
			}
		}
	
	public Celula getCelula(int linha, int coluna) {
		return this.celulas[linha][coluna];
	}
	
	public void adicionarCelula(Celula celula) {
		this.celulas[celula.getLinha()][celula.getColuna()] = celula;
	}
}
