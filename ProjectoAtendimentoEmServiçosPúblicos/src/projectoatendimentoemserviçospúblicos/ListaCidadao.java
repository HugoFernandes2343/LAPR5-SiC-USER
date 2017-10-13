package projectoatendimentoemserviçospúblicos;

/**
 *
 * @author Asus
 */
public class ListaCidadao {
    
    private DoublyLinkedList<Cidadao> listaCidadao;
    
    
    public ListaCidadao(){
        listaCidadao = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<Cidadao> getListaCidadao() {
        return listaCidadao;
    }
    
}
