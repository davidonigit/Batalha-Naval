module BatalhaNavalJava {
	requires javafx.controls;
	requires javafx.fxml;
	exports br.ufrn.imd.controle;
	exports br.ufrn.imd.modelo;
	
	opens application to javafx.graphics, javafx.fxml;
	opens br.ufrn.imd.controle to javafx.fxml;
	opens br.ufrn.imd.modelo to javafx.fxml;
	//opens br.ufrn.imd.dao to javafx.fxml;
}
