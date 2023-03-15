package br.ufrn.imd.modelo;

public class Fragata extends Navio{
	
	public Fragata(int linha, int coluna) {
		super(linha, coluna);
		setVidaNavio(4);
	}
	
	@Override
	public boolean validaMovimento(int linhaDestino, int colunaDestino) {
		if(isHorizontal()) {
			if(colunaDestino >= 7) {
				return false;
			}
			if((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+1)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+2)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+3)==null)) {
				return true;
			}
		}else {
			if(linhaDestino >= 7) {
				return false;
			}
			if((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+1, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+2, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+3, colunaDestino)==null)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean validaRotacao() {
		int linha = getLinha();
		int coluna = getColuna();
		if(isHorizontal()) {
			if(linha >= 7) {
				return false;
			}
			if((getTabuleiro().getNavio(linha+1, coluna)==null) && 
				(getTabuleiro().getNavio(linha+2, coluna)==null) && 
				(getTabuleiro().getNavio(linha+3, coluna)==null)) {
				return true;
			}
		}else {
			if(coluna >= 7) {
				return false;
			}
			if((getTabuleiro().getNavio(linha, coluna+1)==null) && 
				(getTabuleiro().getNavio(linha, coluna+2)==null) && 
				(getTabuleiro().getNavio(linha, coluna+3)==null)) {
				return true;
			}
		}
		return false;
	}

}
