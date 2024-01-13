
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author jenre
 */
public class SkateboardDesigner extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        //ComboBox creation for selection of one deck and an array to hold the prices
        ComboBox<String> deck_box = new ComboBox<>();
        deck_box.getItems().addAll("The Master Thrasher: $60","The Dictator: $45", "The Street King: $50" );
        Double[] deck_cost = {60.00, 45.00, 50.00};
        
        ComboBox<String> trucks_box = new ComboBox<>();
        trucks_box.getItems().addAll("7.75-inch axle: $35", "8-inch axle: $40", "8.5-inch axle: $45");
        Double[] trucks_cost = {35.00, 40.00, 45.00};
        
        ComboBox<String> wheels_box = new ComboBox<>();
        wheels_box.getItems().addAll("51mm: $20", "55mm: $22", "58mm: $24", "61mm: $28");
        Double[] wheels_cost = {20.00, 22.00, 24.00, 28.00};
        
        //Multiple ListView creation for selection of multiple misc items
        ListView<String> misc_products = new ListView<>();
        misc_products.setPrefSize(120, 100);
        misc_products.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        misc_products.getItems().addAll("Grip Tape: $10", "Bearings: $30", "Riser Pads: $2", "Nuts & bolts kit: $3");
        Double[] misc_cost = {10.00, 30.00, 2.00, 3.00};
        
        //2nd listbox to show selected items
        ListView<String> misc_selections = new ListView<>();
        misc_selections.setPrefSize(120, 100);
        
        //Add a button to add items from the misc_products listBox to the misc_selections listBox
        Button misc_button = new Button("Get Misc Selections");
        
        //Add Labels for subtotal, tax, total
        Label deck_label = new Label("Select a deck:");
        Label truck_label = new Label("Select a set of trucks:");
        Label wheel_label = new Label("Select a set of wheels:");
        Label misc_label = new Label("Select any miscellaneous products:");
        Label subtotal_label = new Label("");
        Label tax_label = new Label("");
        Label total_label = new Label("");
        
        //Event handlers for each comboBox and multiple selection ListBox
          //Register an event handler for the comboboxes
        deck_box.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedDeck = deck_box.getValue();
                String selectedTrucks = trucks_box.getValue();
                String selectedWheels = wheels_box.getValue();
                double sub_total = 0.0;
                double total = 0.0;
                if (selectedDeck != null && selectedTrucks !=null && selectedWheels != null) {
                    int deckIndex = deck_box.getItems().indexOf(selectedDeck);
                    int truckIndex = trucks_box.getItems().indexOf(selectedTrucks);
                    int wheelIndex = wheels_box.getItems().indexOf(selectedWheels);
                    sub_total = deck_cost[deckIndex] + trucks_cost[truckIndex] + wheels_cost[wheelIndex];
                }
                //set the subtotal, tax, and total labels to display the amounts
                subtotal_label.setText(String.format("Subtotal: $%.2f" ,sub_total));
                double tax = sub_total * 0.07;
                tax_label.setText(String.format("Tax: $%.2f" ,tax));
                total = sub_total + tax;
                total_label.setText(String.format("Total: $%.2f" ,total));
            }
        });
        
        trucks_box.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedDeck = deck_box.getValue();
                String selectedTrucks = trucks_box.getValue();
                String selectedWheels = wheels_box.getValue();
                double sub_total = 0.0;
                double total = 0.0;
                if (selectedDeck != null && selectedTrucks !=null && selectedWheels != null) {
                    int deckIndex = deck_box.getItems().indexOf(selectedDeck);
                    int truckIndex = trucks_box.getItems().indexOf(selectedTrucks);
                    int wheelIndex = wheels_box.getItems().indexOf(selectedWheels);
                    sub_total = deck_cost[deckIndex] + trucks_cost[truckIndex] + wheels_cost[wheelIndex];
                }
                //set the subtotal, tax, and total labels to display the amounts
                subtotal_label.setText(String.format("Subtotal: $%.2f" ,sub_total));
                double tax = sub_total * 0.07;
                tax_label.setText(String.format("Tax: $%.2f" ,tax));
                total = sub_total + tax;
                total_label.setText(String.format("Total: $%.2f" ,total));
            }
        });
        
        wheels_box.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String selectedDeck = deck_box.getValue();
                String selectedTrucks = trucks_box.getValue();
                String selectedWheels = wheels_box.getValue();
                double sub_total = 0.0;
                double total = 0.0;
                if (selectedDeck != null && selectedTrucks !=null && selectedWheels != null) {
                    int deckIndex = deck_box.getItems().indexOf(selectedDeck);
                    int truckIndex = trucks_box.getItems().indexOf(selectedTrucks);
                    int wheelIndex = wheels_box.getItems().indexOf(selectedWheels);
                    sub_total = deck_cost[deckIndex] + trucks_cost[truckIndex] + wheels_cost[wheelIndex];
                }
                
                //set the subtotal, tax, and total labels to display the amounts
                subtotal_label.setText(String.format("Subtotal: $%.2f" ,sub_total));
                double tax = sub_total * 0.07;
                tax_label.setText(String.format("Tax: $%.2f" ,tax));
                total = sub_total + tax;
                total_label.setText(String.format("Total: $%.2f" ,total));
            }
        });
        
        //Add an event handler for the selection of misc products
        misc_button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            double sub_total = 0.0;
            double misc_total = 0.0;
            double total;
            ObservableList<String> selectedMisc = misc_products.getSelectionModel().getSelectedItems();
            for (String misc : selectedMisc) {
                int index = misc_products.getItems().indexOf(misc);
                misc_total += misc_cost[index];
                misc_selections.getItems().add(misc);
            }
            
            String selectedDeck = deck_box.getValue();
            String selectedTrucks = trucks_box.getValue();
            String selectedWheels = wheels_box.getValue();
                
            if (selectedDeck != null && selectedTrucks !=null && selectedWheels != null) {
                int deckIndex = deck_box.getItems().indexOf(selectedDeck);
                int truckIndex = trucks_box.getItems().indexOf(selectedTrucks);
                int wheelIndex = wheels_box.getItems().indexOf(selectedWheels);
                sub_total = deck_cost[deckIndex] + trucks_cost[truckIndex] + wheels_cost[wheelIndex];
            }
            
            sub_total += misc_total;
            subtotal_label.setText(String.format("Subtotal: $%.2f",sub_total));
            double tax = sub_total * 0.07;
            tax_label.setText(String.format("Tax: $%.2f",tax));
            total = sub_total + tax;
            total_label.setText(String.format("Total: $%.2f",total));
            }
        });



        //Add the controls to a VBox
        VBox vbox = new VBox(10, deck_label,deck_box, truck_label,trucks_box, 
                wheel_label,wheels_box, misc_label,misc_products,misc_button,misc_selections, subtotal_label,
                tax_label, total_label);
        vbox.setPadding(new Insets(10));
        vbox.setAlignment(Pos.CENTER);
        
        //Create a Scene and display it
        Scene scene = new Scene(vbox);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Skateboard Designer");
        primaryStage.show();
    }   
    
    public static void main(String [] args){
        launch(args);
    }
}

