package GUI;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ExtraDisplay {
    VBox treinOverzicht = new VBox();
    private Label visualtrain = new Label("Trein overzicht");

    private VisualiseTrain visualiseTrain = new VisualiseTrain();

    public ExtraDisplay showOutput() {

        GridPane extraOverzicht = new GridPane();
        Scene scene = new Scene(extraOverzicht, 1040, 800);
        Stage stage = new Stage();
        stage.setTitle("Another one!");
        stage.setResizable(false);

        visualtrain.setStyle("-fx-border-color:red; -fx-background-color: white;");

        visualiseTrain.createTrainImage(treinOverzicht);
        ScrollPane trainOverview = new ScrollPane();

        trainOverview.setMaxWidth(1000);
        trainOverview.setMinWidth(1000);
        trainOverview.setMaxHeight(750);
        trainOverview.setMinHeight(750);
        trainOverview.setContent(treinOverzicht);

        extraOverzicht.add(visualtrain, 0, 0);
        extraOverzicht.add(trainOverview, 0, 1, 8, 1);
        extraOverzicht.setHgap(5);
        extraOverzicht.setVgap(5);
        extraOverzicht.setPadding(new Insets(25, 25, 25, 25));
        extraOverzicht.setStyle("-fx-background-color: BD0000");

        stage.setScene(scene);
        stage.show();

        return (this);
    }

    public void updateExtraDisplay() {
        visualiseTrain.createTrainImage(treinOverzicht);
    }
}
