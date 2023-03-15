package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainApp extends Application{
	
	@Override
	public void start(Stage stage) throws Exception {
		// caminho da Tela Principal
		Parent root = FXMLLoader.load(getClass().getResource("/br/ufrn/imd/visao/TelaPrincipal.fxml"));
		
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Batalha Naval");
		stage.setResizable(false);
		stage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}