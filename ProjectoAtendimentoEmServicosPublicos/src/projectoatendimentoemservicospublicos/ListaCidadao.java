package projectoatendimentoemservicospublicos;

import java.util.Iterator;

/**
 *
 * @author 1120608 Norberto Sousa 1161155 Hugo Fernandes
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
