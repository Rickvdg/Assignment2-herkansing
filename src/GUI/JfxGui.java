package GUI;

import Controller.CommandExecuter;
import Domain.Train;
import Domain.Wagon;
import Domain.Station;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;

public class JfxGui extends Application implements EventHandler<ActionEvent>{

    private VBox treinOverzicht = new VBox();
    private TextArea input = new TextArea();
    private TextArea output = new TextArea();
    private TextField inputText = new TextField();
    private Label visualtrain = new Label("Trein overzicht");
    private Label commando = new Label("Command:");
    private Label inputLabel = new Label("Output");
    private Label outputLabel = new Label("Treinen en wagons");
    private Button executeButton = new Button("Execute");
    private Button extraButton = new Button("Extra display");
    private ArrayList<ExtraDisplay> showExtraDisplays = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane display = new GridPane();
        Scene scene = new Scene(display, 1040,800);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Thomas de trein railbeheer");
        ScrollPane treinScroll = new ScrollPane();
        treinScroll.setMinSize(1000, 500);
        treinScroll.setMaxSize(1000, 500);
        treinScroll.setContent(treinOverzicht);

        input.setMaxWidth(494);
        input.setMinWidth(494);
        input.setEditable(false);

        output.setStyle(("-fx-control-inner-background: black; -fx-text-inner-color: white;"));
        output.setMaxWidth(494);
        output.setMinWidth(494);
        output.setEditable(false);

        executeButton.setOnAction(this);

        display.add(visualtrain, 0, 0);
        display.add(extraButton, 2, 0);
        display.add(treinScroll, 0, 1, 8, 1);
        display.add(inputLabel, 0, 2);
        display.add(outputLabel, 6, 2);
        display.add(input, 0, 3, 4, 1);
        display.add(output, 6, 3, 2, 1);
        display.add(commando, 0, 6);
        display.add(inputText, 1, 6, 2, 1);
        display.add(executeButton, 3, 6);
        display.setStyle("-fx-background-color: #CDF8FA");
        display.setPadding(new Insets(25, 25, 25, 25));
        display.setHgap(4);
        display.setVgap(4);

        primaryStage.setScene(scene);
        primaryStage.show();

        extraButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ExtraDisplay extraDisplay = new ExtraDisplay();
                showExtraDisplays.add(extraDisplay.showOutput());
            }
        });

        inputText.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER && !inputText.getText().trim().equals("")) {
                    executeCommand();
                    createTrains();
                }
            }
        });
    }

    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == executeButton && !inputText.getText().trim().equals("")) {
            executeCommand();
            createTrains();
        }
    }

    private void executeCommand() {
        CommandExecuter ce = new CommandExecuter();
        input.appendText(ce.execute(inputText.getText()) + "\n");
        inputText.clear();
        refreshTrainWagon();
    }

    private void refreshTrainWagon() {
        for (ExtraDisplay extraDisplay : showExtraDisplays) {
            extraDisplay.updateExtraDisplay();
        }
        output.clear();
        output.appendText("Trains:\n");
        for (Train train : Station.getTrains()) {
            output.appendText(train.getTrainInfo() + "\n");
        }

        output.appendText("\nWagons:\n");
        for (Wagon wagon : Station.getWagons()) {
            output.appendText(wagon.getWagonInfo() + "\n");
        }
    }

    private void createTrains() {
        new VisualiseTrain().createTrainImage(treinOverzicht);
    }
}