package br.ufrn.imd.controle;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import br.ufrn.imd.modelo.Celula;
import br.ufrn.imd.modelo.Corveta;
import br.ufrn.imd.modelo.Destroyer;
import br.ufrn.imd.modelo.Fragata;
import br.ufrn.imd.modelo.MeuTabuleiro;
import br.ufrn.imd.modelo.Navio;
import br.ufrn.imd.modelo.Submarino;
import br.ufrn.imd.modelo.Tabuleiro;
import br.ufrn.imd.modelo.TabuleiroInimigo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.Bloom;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class TelaPrincipalController implements Initializable{
	
	@FXML
	private GridPane oceanoJogador;
	
	@FXML
	private GridPane oceanoInimigo;
	
	@FXML
	private ToggleButton botaoPronto;
	
	@FXML
	private ImageView imgCorveta;
	
	@FXML
	private ImageView imgSubmarino;

	@FXML
	private ImageView imgFragata;
	
	@FXML
	private ImageView imgDestroyer;
	
	@FXML
	private ImageView imgCorvetaInimigo;
	
	@FXML
	private ImageView imgSubmarinoInimigo;

	@FXML
	private ImageView imgFragataInimigo;
	
	@FXML
	private ImageView imgDestroyerInimigo;
	
	@FXML
	private ImageView miraView;
	
	@FXML
	private Label labelDicasLinha;
	
	@FXML
	private Label labelDicasColuna;
	
	@FXML
	private Label labelResultado;
	
	@FXML
	private Label labelTiroAliado;
	
	@FXML
	private Label labelTiroInimigo;
	
	
	
	//Instanciando Tabuleiros
	MeuTabuleiro tabuleiroJogador = new MeuTabuleiro();
	TabuleiroInimigo tabuleiroInimigo = new TabuleiroInimigo();
	
	//Instanciando Navios Aliados
	Corveta corveta = new Corveta(0,0); //imgCorveta
	Submarino submarino = new Submarino(0,0); //imgSubmarino
	Fragata fragata = new Fragata(0,0); //imgFragata
	Destroyer destroyer = new Destroyer(0, 0); //imgDestroyer
	
	//Instanciando Navios Inimigos
	Corveta corvetaInimigo = new Corveta(0,0); //imgCorvetaInimigo
	Submarino submarinoInimigo = new Submarino(0,0); //imgSubmarinoInimigo
	Fragata fragataInimigo = new Fragata(0,0); //imgFragataInimigo
	Destroyer destroyerInimigo = new Destroyer(0, 0); //imgDestroyerInimigo
	
	//Imagens eventos de tiro
	Image tiroAgua = new Image(getClass().getResourceAsStream("tiroAgua.png"));
	Image tiroExplosao = new Image(getClass().getResourceAsStream("tiroExplosao.png"));
	Image mira = new Image(getClass().getResourceAsStream("mira.png"));
	
	Random gerador = new Random();
	Bloom efeito = new Bloom();
	
	boolean mirado = false;
	boolean pronto = false;
	boolean jogo = true;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//Instanciando celulas dos 2 tabuleiros
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Celula xx = new Celula(j, i);
				tabuleiroJogador.adicionarCelula(xx);
				xx.setTabuleiro(tabuleiroJogador); //atrela celula ao tabuleiro
			}
		}
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				Celula yy = new Celula(j, i);
				tabuleiroInimigo.adicionarCelula(yy);
				yy.setTabuleiro(tabuleiroInimigo);
			}
		}
		//Atrelando Navios com Tabuleiros
		corveta.setTabuleiro(tabuleiroJogador);
		submarino.setTabuleiro(tabuleiroJogador);
		fragata.setTabuleiro(tabuleiroJogador);
		destroyer.setTabuleiro(tabuleiroJogador);
		
		corvetaInimigo.setTabuleiro(tabuleiroInimigo);
		submarinoInimigo.setTabuleiro(tabuleiroInimigo);
		fragataInimigo.setTabuleiro(tabuleiroInimigo);
		destroyerInimigo.setTabuleiro(tabuleiroInimigo);
		
		//Posicionando Navios Aliados
		posicionarAleatorio(imgDestroyer, destroyer);
		tabuleiroJogador.adicionaNavio(destroyer);
		posicionarAleatorio(imgFragata, fragata);
		tabuleiroJogador.adicionaNavio(fragata);
		posicionarAleatorio(imgSubmarino, submarino);
		tabuleiroJogador.adicionaNavio(submarino);
		posicionarAleatorio(imgCorveta, corveta);
		tabuleiroJogador.adicionaNavio(corveta);
		
		//Posicionando Navios Inimigo
		posicionarAleatorio(imgDestroyerInimigo, destroyerInimigo);
		tabuleiroInimigo.adicionaNavio(destroyerInimigo);
		posicionarAleatorio(imgFragataInimigo, fragataInimigo);
		tabuleiroInimigo.adicionaNavio(fragataInimigo);
		posicionarAleatorio(imgSubmarinoInimigo, submarinoInimigo);
		tabuleiroInimigo.adicionaNavio(submarinoInimigo);
		posicionarAleatorio(imgCorvetaInimigo, corvetaInimigo);
		tabuleiroInimigo.adicionaNavio(corvetaInimigo);
		
		imgCorvetaInimigo.setVisible(false);
		imgSubmarinoInimigo.setVisible(false);
		imgFragataInimigo.setVisible(false);
		imgDestroyerInimigo.setVisible(false);
		miraView.setVisible(false);
		
		imgCorveta.toFront();
		imgSubmarino.toFront();
		imgFragata.toFront();
		imgDestroyer.toFront();
		}
	

	//Posiciona Navios no inicio da partida
	public void posicionarAleatorio(ImageView imagem, Navio navio) {
		int linha, coluna;
		do {
			if(!gerador.nextBoolean()) {
				navio.setHorizontal(false);
			}
			linha = gerador.nextInt(10 - spanNavio(navio)); 
			coluna = gerador.nextInt(10 - spanNavio(navio));
		} while(!navio.validaMovimento(linha, coluna));
		if(!navio.isHorizontal()) {
			imagem.setRotate(90);
			GridPane.setColumnSpan(imagem, 1);
			GridPane.setRowSpan(imagem, spanNavio(navio));
		}
		GridPane.setColumnIndex(imagem, coluna);
		GridPane.setRowIndex(imagem, linha);
		navio.setLinha(linha);
		navio.setColuna(coluna);
	}
	
	
	//Garante que o Navio nao ficara de fora do tabuleiro
	public int spanNavio(Navio navio) {
		if(navio instanceof Corveta) {
			return 2;
		}
		if(navio instanceof Submarino) {
			return 3;
		}
		if(navio instanceof Fragata) {
			return 4;
		}
		if(navio instanceof Destroyer) {
			return 5;
		}
		return 0;
	}
	
	//Metodos de Clique para selecionar navios
	public void cliqueCorveta(MouseEvent event) {
		if(!pronto && event.getButton() == MouseButton.PRIMARY) {
			if(tabuleiroJogador.getNavioSelecionado() == null) {
				tabuleiroJogador.selecionaNavio(corveta);
				imgCorveta.setEffect(efeito);
			}else {
				if(corveta.isSelecionado()) {
					tabuleiroJogador.selecionaNavio(corveta);
					imgCorveta.setEffect(null);
				}
			}
		}
	}
	
	public void cliqueSubmarino(MouseEvent event) {
		if(!pronto && event.getButton() == MouseButton.PRIMARY) {
			if(tabuleiroJogador.getNavioSelecionado() == null) {
				tabuleiroJogador.selecionaNavio(submarino);
				imgSubmarino.setEffect(efeito);
			}else {
				if(submarino.isSelecionado()) {
					tabuleiroJogador.selecionaNavio(submarino);
					imgSubmarino.setEffect(null);
				}
			}
		}
	}
	
	public void cliqueFragata(MouseEvent event) {
		if(!pronto && event.getButton() == MouseButton.PRIMARY) {
			if(tabuleiroJogador.getNavioSelecionado() == null) {
				tabuleiroJogador.selecionaNavio(fragata);
				imgFragata.setEffect(efeito);
			}else {
				if(fragata.isSelecionado()) {
					tabuleiroJogador.selecionaNavio(fragata);
					imgFragata.setEffect(null);
				}
			}
		}
	}
	
	public void cliqueDestroyer(MouseEvent event) {
		if(!pronto && event.getButton() == MouseButton.PRIMARY) {
			if(tabuleiroJogador.getNavioSelecionado() == null) {
				tabuleiroJogador.selecionaNavio(destroyer);
				imgDestroyer.setEffect(efeito);
			}else {
				if(destroyer.isSelecionado()) {
					tabuleiroJogador.selecionaNavio(destroyer);
					imgDestroyer.setEffect(null);
				}
			}
		}
	}
	
	//Pré-jogo (Movimentar meus navios)
	public void cliqueTabuleiroJogador(MouseEvent event) {
		if(!pronto) {
			Node noClicado = event.getPickResult().getIntersectedNode();
			if (noClicado != oceanoJogador) {
				// Clica no nó filho
				Integer colunaIndex = GridPane.getColumnIndex(noClicado);
				Integer linhaIndex = GridPane.getRowIndex(noClicado);
				if(colunaIndex == null) {
					colunaIndex = 0;
				}
				if(linhaIndex == null) {
					linhaIndex = 0;
				}
				
				if(tabuleiroJogador.getNavioSelecionado() != null && event.getButton() == MouseButton.PRIMARY) {
					if(tabuleiroJogador.getNavioSelecionado().validaMovimento(linhaIndex, colunaIndex)) {
						GridPane.setColumnIndex(getImagemNavio(tabuleiroJogador.getNavioSelecionado()), colunaIndex);
					 	GridPane.setRowIndex(getImagemNavio(tabuleiroJogador.getNavioSelecionado()), linhaIndex);
						int retirarLinha = tabuleiroJogador.getNavioSelecionado().getLinha();
						int retirarColuna = tabuleiroJogador.getNavioSelecionado().getColuna();
					 	moveNavio(tabuleiroJogador.getNavioSelecionado(), retirarLinha, retirarColuna, linhaIndex, colunaIndex);
					 	tabuleiroJogador.getNavioSelecionado().setLinha(linhaIndex);
						tabuleiroJogador.getNavioSelecionado().setColuna(colunaIndex);
					}
				}
				if(tabuleiroJogador.getNavioSelecionado() != null && event.getButton() == MouseButton.SECONDARY) {
					if(tabuleiroJogador.getNavioSelecionado().validaRotacao()) {
						rotacionarNavio(tabuleiroJogador.getNavioSelecionado());
					}
				}
			}
			}
		}
	
	//Rotacionar navio
	public void rotacionarNavio(Navio navio) {
		tabuleiroJogador.livraNavio(navio, navio.getLinha(), navio.getColuna());
		if(navio.isHorizontal()) {
			navio.setHorizontal(false);
			getImagemNavio(navio).setRotate(90);
			GridPane.setColumnSpan(getImagemNavio(navio), 1);
			GridPane.setRowSpan(getImagemNavio(navio), spanNavio(navio));
		}else {
			navio.setHorizontal(true);
			getImagemNavio(navio).setRotate(0);
			GridPane.setColumnSpan(getImagemNavio(navio), spanNavio(navio));
			GridPane.setRowSpan(getImagemNavio(navio), 1);
		}
		tabuleiroJogador.adicionaNavio(navio);
	}
	
	//Move navio para a posição destino
	public void moveNavio(Navio navio, int linhaNavio, int colunaNavio, int linhaDestino, int colunaDestino) {
			tabuleiroJogador.livraNavio(navio, linhaNavio, colunaNavio);
			navio.setLinha(linhaDestino);
			navio.setColuna(colunaDestino);
			tabuleiroJogador.adicionaNavio(navio);
	}
	
	//Resgatar o imageView correto para o navio selecionado
	public ImageView getImagemNavio(Navio navio) {
		if(navio instanceof Corveta) {
			return imgCorveta;
		}
		if(navio instanceof Submarino) {
			return imgSubmarino;
		}
		if(navio instanceof Fragata) {
			return imgFragata;
		}
		if(navio instanceof Destroyer) {
			return imgDestroyer;
		}
		return null;
	}
	
	//Botão Pronto
	public void confirmarPronto() {
		pronto = true;
		botaoPronto.setDisable(true);
		if(tabuleiroJogador.getNavioSelecionado()!=null) {
			getImagemNavio(tabuleiroJogador.getNavioSelecionado()).setEffect(null);
		}
		
	}	
	
	//Navios Posicionados - Iniciar partida
	public void cliqueTabuleiroInimigo(MouseEvent event) {
		//Controla de quem é a vez e se jogo está ativo
		if(tabuleiroJogador.isVez()  && jogo && pronto) {
			Node noClicado = event.getPickResult().getIntersectedNode();
			if (noClicado != oceanoInimigo) {
		        Integer colunaIndex = GridPane.getColumnIndex(noClicado);
		        Integer linhaIndex = GridPane.getRowIndex(noClicado);
		        if(colunaIndex == null) {
		        	colunaIndex = 0;
		        }
		        if(linhaIndex == null) {
		        	linhaIndex = 0;
		        }
		        
		        //Controle da Mira
			    if(!tabuleiroInimigo.getCelula(linhaIndex, colunaIndex).isBombardeado()) {
			        	mirar(linhaIndex,colunaIndex);
				}
			}
		}
	}
	
	//Posiciona mira
	public void mirar(int linha, int coluna) {
		if(!(tabuleiroInimigo.getCelula(linha, coluna).isSelecionado())) {
			mirado = true;
	        tabuleiroInimigo.selecionaCelula(tabuleiroInimigo.getCelula(linha, coluna));
	        GridPane.setColumnIndex(miraView, coluna);
	        GridPane.setRowIndex(miraView, linha);
	        miraView.setVisible(true);
	    }else { 
	        mirado = false;
	        tabuleiroInimigo.selecionaCelula(tabuleiroInimigo.getCelula(linha, coluna));
	        miraView.setVisible(false);
	    }
	}
	
	//Botão Atirar
	public void confirmarTiro() {
		if(mirado && jogo) {
			tabuleiroInimigo.getCelulaSelecionada().setBombardeado();
			
			int linha = tabuleiroInimigo.getCelulaSelecionada().getLinha();
			int coluna = tabuleiroInimigo.getCelulaSelecionada().getColuna();
			miraView.setVisible(false);
			ImageView nova = new ImageView();
	        nova.setFitHeight(30);
	        nova.setFitWidth(30);
	        oceanoInimigo.add(nova, coluna, linha);
	        
	        testaTiro(tabuleiroInimigo, linha, coluna, nova);
	        dica(linha,coluna);
	        tabuleiroJogador.setVez(false);
	        
	        controleJogo();
	        controleNavios();
			//Inimigo Devolve tiro
			tiroInimigo();
			tabuleiroJogador.setVez(true);
			mirado = false;
		}
	}
	
	//Tiro inimigo de forma aleatório
	public void tiroInimigo() {
		if(jogo && pronto) {
			int linha, coluna;
			do {
				linha = gerador.nextInt(10);
				coluna = gerador.nextInt(10);
			} while(tabuleiroJogador.getCelula(linha, coluna).isBombardeado());
			
			tabuleiroJogador.getCelula(linha, coluna).setBombardeado();
			ImageView nova = new ImageView();
	        nova.setFitHeight(30);
	        nova.setFitWidth(30);
	        oceanoJogador.add(nova, coluna, linha);
			testaTiro(tabuleiroJogador, linha, coluna, nova);
			tabuleiroJogador.setVez(true);
			controleJogo();
			controleNavios();
		}
	}
	
	//Testa se tiro acertou ou não
	public void testaTiro(Tabuleiro tabuleiro,int linha, int coluna, ImageView imagem) {
		if(tabuleiro.getNavio(linha, coluna)!=null) {
			imagem.setImage(tiroExplosao);
			tabuleiro.decrementaVida();
			tabuleiro.getNavio(linha, coluna).decrementaVidaNavio();
			controleTiro(tabuleiro, linha, coluna);
		}else {
			imagem.setImage(tiroAgua);
			controleTiro(tabuleiro, linha, coluna);
		}
	}
	
	//Dicas para os tiros
	public void dica(int linha, int coluna) {
		labelDicasLinha.setText("...");
		labelDicasColuna.setText("...");
		for(int i=0; i<10;i++) {
			if(tabuleiroInimigo.getNavio(linha, i) != null && !tabuleiroInimigo.getCelula(linha, i).isBombardeado()) {
				labelDicasLinha.setText("Navio Inimigo na linha bombardeada");
			}
			if(tabuleiroInimigo.getNavio(i, coluna) != null && !tabuleiroInimigo.getCelula(i, coluna).isBombardeado()) {
				labelDicasColuna.setText("Navio Inimigo na coluna bombardeada");
			}
		}
	}
	
	//Controla vida dos jogadores e finaliza partida
	public void controleJogo() {
		if(tabuleiroJogador.getVida() == 0) {
			labelResultado.setText("FIM DE JOGO - VOCÊ PERDEU.");
			jogo = false;
		}if(tabuleiroInimigo.getVida() == 0) {
			labelResultado.setText("FIM DE JOGO - VOCÊ VENCEU!!");
			jogo = false;
		}
	}
	
	//Retorna para os labels a posição dos tiros
	public void controleTiro(Tabuleiro tabuleiro, int linha, int coluna) {
		if(tabuleiro instanceof TabuleiroInimigo) {
			labelTiroAliado.setText("("+(linha+1)+" x "+(coluna+1)+")");
		}else {
			labelTiroInimigo.setText("("+(linha+1)+" x "+(coluna+1)+")");
		}
	}
	
	public void controleNavios() {
		if(corvetaInimigo.isElimiado()) {
			imgCorvetaInimigo.setVisible(true);
		}
		if(submarinoInimigo.isElimiado()) {
			imgSubmarinoInimigo.setVisible(true);
		}
		if(fragataInimigo.isElimiado()) {
			imgFragataInimigo.setVisible(true);
		}
		if(destroyerInimigo.isElimiado()) {
			imgDestroyerInimigo.setVisible(true);
		}
	}
	
}
