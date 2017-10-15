package projectoatendimentoemservicospublicos;

import java.util.Iterator;

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
    
    public Cidadao getCidadaoPorNumero(int i){
         Iterator itr = listaCidadao.iterator();
        while (itr.hasNext()) {
            Cidadao temp = (Cidadao) itr.next();
            if (temp.getNumeroContribuinte() == i) {
                return temp;
            }
        }
        return null;
    }
}
