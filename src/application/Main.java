package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

//The following code generates a simulation of a QR code which is different every time is run
//I added a push button as an extra trying to link the event of randomness of squares to the button
//need to follow up on that initiative
public class Main extends Application {

	public void start(Stage primaryStage) {

		try {

			Rectangle square1 = new Rectangle(4, 4, 75, 75); //upper left
			square1.setFill(Color.WHITE);
			square1.setStroke(Color.BLACK);
			square1.setStrokeWidth(8);
			Rectangle square1_1 = new Rectangle(19, 19, 46, 46);
			square1_1.setFill(Color.BLACK);

			Rectangle square2 = new Rectangle(4, 241, 75, 75);  //lower left
			square2.setFill(Color.WHITE);
			square2.setStroke(Color.BLACK);
			square2.setStrokeWidth(8);
			Rectangle square2_1 = new Rectangle(19, 255, 46, 46);
			square2_1.setFill(Color.BLACK);

			Rectangle square3 = new Rectangle(241, 4, 75, 75); //upper right
			square3.setFill(Color.WHITE);
			square3.setStroke(Color.BLACK);
			square3.setStrokeWidth(8);
			Rectangle square3_1 = new Rectangle(256, 19, 46, 46);
			square3_1.setFill(Color.BLACK);

			Button push = new Button("Generate QR Code!"); // control, allows user to interact
			push.setLayoutX(110);
			push.setLayoutY(350);
			push.setOnAction(this::pressedButton); // object containing a method that is called when the event occurs

			// the event handler method is outside the start body

			Group randomSquares = new Group();
			for (int i = 0; i <= 40; i++) // iterating to generate 41 squares
			{
				float x = (float) (Math.random() * 298); // using random to change squares position within the grid
				float y = (float) (Math.random() * 298); // 298 is the area of pixels where they'll be randomized (per
															// axis)

				Rectangle r = new Rectangle(x, y, 25, 25); // random position & squares dimension

				randomSquares.getChildren().addAll(r);// Adds each square to the Group.

			}
            //using the same pattern for different square sizes
			for (int i = 0; i <= 90; i++) {
				float x = (float) (Math.random() * 303);
				float y = (float) (Math.random() * 303);

				Rectangle r2 = new Rectangle(x, y, 15, 15);

				randomSquares.getChildren().addAll(r2);
			}

			for (int i = 0; i <= 250; i++) {
				float x = (float) (Math.random() * 303);
				float y = (float) (Math.random() * 303);

				Rectangle r3 = new Rectangle(x, y, 10, 10);

				randomSquares.getChildren().addAll(r3);

			}

			Group root = new Group(randomSquares, square1, square1_1, square2, square2_1, square3, square3_1, push);
            //the order in the root group determines images position priority
			Scene scene = new Scene(root, 512, 512, Color.WHITE);
			primaryStage.setTitle("QR Code");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void pressedButton(ActionEvent event) {
		// Extra: trying to link the button with the random function, will follow up

	}

	public static void main(String[] args) {
		launch(args);
	}
}
