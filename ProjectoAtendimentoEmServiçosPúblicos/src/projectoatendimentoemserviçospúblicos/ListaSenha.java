package projectoatendimentoemserviçospúblicos;

public class ListaSenha {
    private DoublyLinkedList<Senha> listaSenha;
    
    public ListaSenha (){
        listaSenha = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<Senha> getListaSenha() {
        return listaSenha;
    }
}


