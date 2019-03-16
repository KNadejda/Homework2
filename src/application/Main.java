package application;
	
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage ps) {
		ps.setTitle("Animation example");
			
		Group root = new Group();
		Scene myScene = new Scene(root);
		ps.setScene(myScene);
		
		Canvas canvas = new Canvas (800,380);
		root.getChildren().add(canvas);
		
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		
		Image road = new Image("Road4.jpg");
		Image car = new Image("Car22.png");
		
		
		final long startTime = System.nanoTime();
		
		new AnimationTimer() {
			
			double x2 = 0; 
			double y = 220;
			
			@Override
			public void handle (long t) {
				double diff = (t - startTime) / 1000000000.0;
								
				double x1 =   x2 - diff * 200;
				   gc.drawImage(road,x1,0);
				   
				   if ( x1 <= -200) {
					   x2 = x2 + 200;
					   
				   }
				   
				   
				   double y = 220;
				  
				   if( diff  > 8) {
					   y = y - 150 ;
				   }
				   
					
				gc.drawImage(car,20, y);
			
		
				}
				
			
		}.start();
		
		
		ps.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
