module lib {
	requires javafx.controls;
	requires javafx.graphics;
	requires java.desktop;
	
	opens com.game.core to javafx.graphics, javafx.fxml;
}
