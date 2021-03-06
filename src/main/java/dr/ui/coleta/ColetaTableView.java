package dr.ui.coleta;

import dr.model.Coleta;
import java.util.List;
import javafx.beans.property.SimpleFloatProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

/**
 * <code>TableView</code> adaptada para apresentar objetos <code>Coleta</code>.
 * @author @Andre
 */
public class ColetaTableView extends TableView<ColetaTableView.ColetaItem> {

    private ObservableList coletas;
  

    public ColetaTableView() {
        
    }
    
    public void reload(final List<Coleta> coletas) {
        this.coletas.clear();
    }

    /**
     * Item da tabela, faz o binding da <code>coleta</code> com <code>TableView</code>.
     * this object represent a table cell or should represent
    */
    public static class ColetaItem {

        private final SimpleFloatProperty valor;

        public ColetaItem() {
            this.valor = new SimpleFloatProperty();
        }

        public Float getValor() {
            return valor.get();
        }
        
        public void setValor(Float valor){
            this.valor.set(valor);
        }
        
        public Coleta toColeta(){
            Coleta c = new Coleta();
            c.setValor(this.valor.get());

            return c;
        }
    }
}

