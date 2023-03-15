package br.ufrn.imd.modelo;

public class Destroyer extends Navio{
	
	public Destroyer(int linha, int coluna) {
		super(linha, coluna);
		setVidaNavio(5);
	}
	
	@Override
	public boolean validaMovimento(int linhaDestino, int colunaDestino) {
		if(isHorizontal()) {
			if(colunaDestino >= 6) {
				return false;
			}
			if ((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+1)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+2)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+3)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+4)==null)){
				return true;
			}
		}else {
			if(linhaDestino >= 6) {
				return false;
			}
			if((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+1, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+2, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+3, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino+4, colunaDestino)==null)) {
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
			if(linha >= 6) {
				return false;
			}
			if ((getTabuleiro().getNavio(linha+1, coluna)==null) && 
				(getTabuleiro().getNavio(linha+2, coluna)==null) && 
				(getTabuleiro().getNavio(linha+3, coluna)==null) && 
				(getTabuleiro().getNavio(linha+4, coluna)==null)){
				return true;
			}
		}else {
			if(coluna >= 6) {
				return false;
			}
			if((getTabuleiro().getNavio(linha, coluna+1)==null) && 
				(getTabuleiro().getNavio(linha, coluna+2)==null) && 
				(getTabuleiro().getNavio(linha, coluna+3)==null) && 
				(getTabuleiro().getNavio(linha, coluna+4)==null)) {
				return true;
			}
		}
		return false;
	}

}
