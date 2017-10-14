package projectoatendimentoemserviçospúblicos;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ListaSenha {

    private PriorityQueue<Senha> listaSenha;
    private Comparator<Senha> comparator;

    public ListaSenha() {
        comparator = new OrderLengthComparator();
        listaSenha = new PriorityQueue<Senha>(1000, comparator);
    }

    public PriorityQueue<Senha> getListaSenha() {
        return listaSenha;
    }

    private class OrderLengthComparator implements Comparator<Senha> {

        private OrderLengthComparator() {
        }

        @Override
        public int compare(Senha t, Senha t1) {
           if (t.getNumeroOrdem() < t1.getNumeroOrdem()) {
                return -1;
            }
            if (t.getNumeroOrdem() > t1.getNumeroOrdem()) {
                return 1;
            }
            return 0;
        }
    }
}
