package game.frontend;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.shape.Circle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.awt.*;

public class MainMenu extends Application {

    private static final Font FONT = Font.font("", FontWeight.BOLD, 18);
    private final int width = 250;
    private final int height = 250;
    private VBox menuBox;
    private int currentOption = 0;
    private String selectedOption = null;

    public static void main(String[] args){
        launch(args);
    }

    private Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(width, height);

        HBox welcomeBox = new HBox(10);
        Label welcomeText = new Label("Let's play Candy Crush!\n    Choose any level");
        welcomeText.setFont(FONT);
        welcomeText.setAlignment(Pos.TOP_CENTER);
        welcomeText.setEffect(new GaussianBlur(2));
        welcomeBox.setTranslateX(28);
        welcomeBox.setTranslateY(0);
        welcomeBox.getChildren().addAll(welcomeText);

        MenuItem exitItem = new MenuItem("EXIT");
        exitItem.setOnActivate(() -> System.exit(0));

        MenuItem level1 = new MenuItem("LEVEL 1");
        MenuItem level2 = new MenuItem("LEVEL 2");
        MenuItem level3 = new MenuItem("LEVEL 3");

        menuBox = new VBox(10,
                level1,
                level2,
                level3,
                exitItem);
        menuBox.setAlignment(Pos.TOP_CENTER);
        menuBox.setTranslateX(70);
        menuBox.setTranslateY(70);

        getMenuItem(0).setActive(true);
        root.getChildren().addAll(welcomeBox,menuBox);
        return root;

    }

    private MenuItem getMenuItem(int option){
        return (MenuItem)menuBox.getChildren().get(option);
    }

    private static class MenuItem extends HBox{
        private TriCircle c1 = new TriCircle();
        private TriCircle c2 = new TriCircle();
        private Text text;
        private Runnable script;

        public MenuItem(String name){
            super(15);
            setAlignment(Pos.CENTER);
            text = new Text(name);
            text.setFont(FONT);
            text.setEffect(new GaussianBlur(2));

            getChildren().addAll(c1, text, c2);
            setActive(false);
        }

        public void setActive(boolean state){
            c1.setVisible(state);
            c2.setVisible(state);
            text.setFill(state ? Color.GREEN : Color.GRAY);
        }

        public void setOnActivate(Runnable r){
            script = r;
        }

        public void activate(){
            if(script != null)
                script.run();
        }
    }

    private static class TriCircle extends Parent{
        public TriCircle(){
            Shape shape1 = Shape.subtract(new Circle(5), new Circle(2));
            shape1.setFill(Color.BLACK);

            Shape shape2 = Shape.subtract(new Circle(5), new Circle(2));
            shape2.setFill(Color.BLACK);
            shape2.setTranslateX(5);

            Shape shape3 = Shape.subtract(new Circle(5), new Circle(2));
            shape3.setFill(Color.BLACK);
            shape3.setTranslateX(2.5);
            shape3.setTranslateY(-5);

            getChildren().addAll(shape1, shape2, shape3);

            setEffect(new GaussianBlur(2));
        }
    }

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(createContent());
        scene.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.UP){
                if(currentOption > 0){
                    getMenuItem(currentOption).setActive(false);
                    getMenuItem(--currentOption).setActive(true);
                }
            }
            if(event.getCode() == KeyCode.DOWN){
                if(currentOption < menuBox.getChildren().size() - 1){
                    getMenuItem(currentOption).setActive(false);
                    getMenuItem(++currentOption).setActive(true);
                }
            }
            if(event.getCode() == KeyCode.ENTER){
                getMenuItem(currentOption).activate();
                selectedOption = getMenuItem(currentOption).text.getText();
                GameApp gameApp = new GameApp(selectedOption);
                gameApp.start(primaryStage);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
