package GUI;

import Domain.Train;
import Domain.Wagon;
import Domain.Station;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VisualiseTrain {
    private final Image thomasImg = new Image("GUI/Assets/Thomas.png", 200, 200, true, true);
    private final Image wagonImg = new Image("GUI/Assets/Wagon.png", 200, 200, true, true);

    public VBox createTrainImage(VBox TrainsImage) {
        TrainsImage.getChildren().clear();

        for (Train train : Station.getTrains()) {
            HBox TrainImage = new HBox();
            HBox nameLabels = new HBox();
            Label trainName = new Label("(" + train.getName() + ")");
            ImageView thomasIMG = new ImageView(thomasImg);
            nameLabels.getChildren().add(trainName);
            TrainImage.getChildren().add(thomasIMG);

            for (Wagon wagon : train.getAangesloten()) {
                ImageView wagonIMG = new ImageView(wagonImg);
                Label wagonName = new Label(" - " + wagon.getWagonInfo());
                nameLabels.getChildren().add(wagonName);
                TrainImage.getChildren().addAll(wagonIMG);
            }
            TrainsImage.getChildren().add(nameLabels);
            TrainsImage.getChildren().add(TrainImage);
        }
        return TrainsImage;
    }
}