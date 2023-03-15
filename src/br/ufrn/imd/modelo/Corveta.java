package br.ufrn.imd.modelo;

public class Corveta extends Navio{
	
	public Corveta(int linha, int coluna) {
		super(linha, coluna);
		setVidaNavio(2);
	}
	
	@Override
	public boolean validaMovimento(int linhaDestino, int colunaDestino) {
		if(isHorizontal()) {
			if(colunaDestino >= 9) {
				return false;
			}
			if((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
				(getTabuleiro().getNavio(linhaDestino, colunaDestino+1)==null)) {
				return true;
			}
		}else {
			if(linhaDestino >= 9) {
				return false;
			}
			if((getTabuleiro().getNavio(linhaDestino, colunaDestino)==null) && 
					(getTabuleiro().getNavio(linhaDestino+1, colunaDestino)==null)) {
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
			if(linha >= 9) {
				return false;
			}
			if((getTabuleiro().getNavio(linha+1, coluna))==null) {
				return true;
			}
		}else {
			if(coluna >= 9) {
				System.out.println("false");
				return false;
			}
			if((getTabuleiro().getNavio(linha, coluna+1))==null) {
				return true;
			}
		}
		return false;
	}
}
