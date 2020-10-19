import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontSmoothingType;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main1 extends Application {


public static void main(String[] args) {
	launch(args);
}

@Override
public void start(Stage stage) throws Exception {
	stage.setTitle("Grit Academy Login");
	
	
	
	GridPane  layout = new GridPane();
	layout.setAlignment(Pos.CENTER);
	layout.setHgap(10);
	layout.setVgap(10);
	layout.setPadding(new Insets(25, 25, 25, 25));
	
	Text scenetitle = new Text("Welcome");
	scenetitle.setFill(Color.web("#4d3300"));
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
	layout.add(scenetitle, 1, 0, 2, 1);

	
	// Email
	Label userName = new Label("Email:");
	layout.add(userName, 0, 1);
	TextField userTextField = new TextField();
	layout.add(userTextField, 1, 1);
	
	
	// password
	Label pw = new Label("Password:");
	layout.add(pw, 0, 2);
	PasswordField pwBox = new PasswordField();
	layout.add(pwBox, 1, 2);
	
	// alert
	Text actiontarget = new Text();
	layout.add(actiontarget, 1, 6);
	
	
	
	Image image = new Image("file:grit2.png");
	
	Button btn = new Button("Sign in");
	btn.setStyle("-fx-text-fill: #805500");
	HBox hbBtn = new HBox(10);
	hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
	hbBtn.getChildren().add(btn);
	layout.add(hbBtn, 1, 4);
	
	
	btn.setOnAction(e->{
		
		if(NotRegex.validateEmail(userTextField.getText())) {
			System.out.println("Method 2 checks out");
		}else {
			System.out.println("Method 2 failed");
		}
		
		if(CheckWithRegex.checkPass(userTextField.getText(), pwBox.getText())) {
			actiontarget.setFill(Color.GREEN);
        actiontarget.setText("Logged in successfully!");
		}else {
			actiontarget.setFill(Color.RED);
	        actiontarget.setText("Failed to log in");
		}
		
	});
	
	ImageView img = new ImageView();
	img.setImage(image);
	img.fitWidthProperty().bind(stage.widthProperty());
	img.fitHeightProperty().bind(stage.heightProperty());
	Scene scene = new Scene(layout,579, 720);
//	layout.back
	layout.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.DEFAULT,new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true))));
	
	stage.setScene(scene);
	stage.getIcons().add(new Image("file:logo.png"));
	stage.setResizable(false);
	stage.show();
}
}
