package dr.ui.quebraJato;

import dr.ui.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Tela utilizada para realizar a pesquisa de <code>QuebraJato</code> 
 * com filtro no campo <code>nome</code>. 
 * 
 * @author @Andre
 */
public class BuscarQuebraJatoView extends Stage {

    private TextField tfNome;
    private Button bBuscar;
    private Button bCancelar;

    public BuscarQuebraJatoView() {
        setTitle("Buscar Quebra Jato");
        setWidth(290);
        setHeight(150);
        setResizable(false);
        initModality(Modality.APPLICATION_MODAL);

        inicializaComponentes();
    }

    private void inicializaComponentes() {
        GridPane inputs = buildInputs();
        HBox buttons = buildBotoes();
        
        VBox vbox = new VBox();
        vbox.getChildren().addAll(inputs, buttons);
        Scene scene = new Scene(new Group(vbox));
        scene.getStylesheets().add("style.css");
        this.setScene(scene);
    }

    private HBox buildBotoes() {
        bBuscar = new Button("Buscar");
        bBuscar.setId("buscarQuebraJato");
        bBuscar.setDefaultButton(true);
        
        bCancelar = new Button("Cancelar");
        bCancelar.setId("cancelarBuscaQuebraJato");
        bCancelar.setCancelButton(true);
        
        HBox box = new HBox();
        box.getChildren().addAll(bBuscar, bCancelar);
        box.getStyleClass().add("buttonBar");
        
        return box;
    }
    
    private GridPane buildInputs() {
        tfNome = new TextField();
        tfNome.setPromptText("filtro descrição");
        tfNome.setMinWidth(180);
        tfNome.setMaxWidth(180);
                
        GridFormBuilder grid = new GridFormBuilder();
        grid.addRow(new Label("Quebra Jato: "), tfNome);

        
        return grid.build();
    }
    
    public void resetForm() {
        tfNome.setText("");
        
    }

    public Button getBuscarButton() {
        return bBuscar;
    }
    
    public Button getCancelarButton() {
        return bCancelar;
    }

    public String getText() {
        return tfNome.getText();
    }
}
