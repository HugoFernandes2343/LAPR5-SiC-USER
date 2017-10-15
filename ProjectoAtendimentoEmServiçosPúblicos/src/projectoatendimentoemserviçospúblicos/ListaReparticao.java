package projectoatendimentoemserviçospúblicos;

import java.util.Iterator;
import java.util.List;

public class ListaReparticao {

    private DoublyLinkedList<Reparticao> listaReparticao;

    public ListaReparticao() {
        listaReparticao = new DoublyLinkedList<>();
    }

    public DoublyLinkedList<Reparticao> getListaReparticao() {
        return listaReparticao;
    }

    /**
     * Adiciona reparticao a lista, nao faz verificacoes (para testes apenas)
     *
     * @param rep
     */
    public void addReparticao(Reparticao rep) {
        listaReparticao.addLast(rep);
    }

    public Reparticao getReparticaoPorNumero(int numero) {
        Iterator itr = listaReparticao.iterator();
        while (itr.hasNext()) {
            Reparticao temp = (Reparticao) itr.next();
            if (temp.getNumeroReparticao() == numero) {
                return temp;
            }
        }
        return null;
    }

    public Reparticao getReparticaoPorPostal(int cod) {
        Iterator itr = listaReparticao.iterator();
        while (itr.hasNext()) {
            Reparticao temp = (Reparticao) itr.next();
            if (temp.getCodigoPostal() == cod) {
                return temp;
            }
        }
        return null;
    }

    /**
     * returna true se houver duplicados
     *
     * @param rep
     * @return
     */
    public boolean checkDuplicates(Reparticao rep) {
        Iterator itr = listaReparticao.iterator();
        while (itr.hasNext()) {
            Reparticao temp = (Reparticao) itr.next();
            if (temp.getCodigoPostal() == rep.getCodigoPostal()) {
                return true;
            }
        }
        return false;
    }

    public void NovaReparticao(String s, int n, int codigo, List<String> serv) {
        Reparticao rep = new Reparticao(s, n, codigo, serv);
        if (!checkDuplicates(rep)) {
            Iterator itr_rep = listaReparticao.iterator();
            while (itr_rep.hasNext()) {
                Reparticao temp = (Reparticao) itr_rep.next();
                DoublyLinkedList listCid = temp.getListaCidadao().getListaCidadao();
                Iterator itr_cid = listCid.iterator();
                while (itr_cid.hasNext()) {
                    Cidadao cid = (Cidadao) itr_cid.next();
                    String post[] = cid.getCodigoPostal().split("-");
                    if (Integer.parseInt(post[0]) == rep.getCodigoPostal()) {
                        itr_cid.remove();
                        rep.getListaCidadao().getListaCidadao().addLast(cid);
                        cid.setNumeroReparticao(rep.getNumeroReparticao());
                    }
                }
            }
            listaReparticao.addLast(rep);
        }
    }

    public void RemoveReparticao(Reparticao rep) {
        Reparticao rep_temp, rep_maisProxima = new Reparticao();
        int dif = 4000;
        Iterator itr = listaReparticao.iterator();
        while (itr.hasNext()) {
            rep_temp = (Reparticao) itr.next();
            if (Math.abs(rep_temp.getCodigoPostal() - rep.getCodigoPostal()) < dif && Math.abs(rep_temp.getCodigoPostal() - rep.getCodigoPostal()) != 0) {
                dif = Math.abs(rep_temp.getCodigoPostal() - rep.getCodigoPostal());
                rep_maisProxima = rep_temp;
            }
            if (rep_temp.equals(rep)) {
                itr.remove();
            }
        }

        Iterator itr_rep = rep.getListaCidadao().getListaCidadao().iterator();
        while (itr_rep.hasNext()) {
            Cidadao cid_temp = (Cidadao) itr_rep.next();
            rep_maisProxima.addCidadao(cid_temp);
            cid_temp.setNumeroReparticao(rep_maisProxima.getNumeroReparticao());
        }

    }

    public void addCidadao(Cidadao cid) {
        if (!checkDuplicatesCid(cid)) {
            String postal[] = cid.getCodigoPostal().split("-");
            Reparticao rep = getReparticaoPorPostal(Integer.parseInt(postal[0]));
            if (rep != null) {
                rep.addCidadao(cid);
            } else {
                Reparticao rep_temp, rep_maisProxima = new Reparticao();
                int dif = 4000;
                Iterator itr = listaReparticao.iterator();
                while (itr.hasNext()) {
                    rep_temp = (Reparticao) itr.next();
                    if (Math.abs(rep_temp.getCodigoPostal() - Integer.parseInt(postal[0])) < dif && Math.abs(rep_temp.getCodigoPostal() - Integer.parseInt(postal[0])) != 0) {
                        dif = Math.abs(rep_temp.getCodigoPostal() - Integer.parseInt(postal[0]));
                        rep_maisProxima = rep_temp;
                    }
                }
                rep_maisProxima.addCidadao(cid);
                cid.setNumeroReparticao(rep_maisProxima.getNumeroReparticao());
            }
        }
    }

    /**
     * retorna true se houver duplicados
     *
     * @param cid
     * @return
     */
    public boolean checkDuplicatesCid(Cidadao cid) {
        Iterator itr_rep = listaReparticao.iterator();
        Reparticao rep;
        while (itr_rep.hasNext()) {
            rep = (Reparticao) itr_rep.next();
            Iterator itr_cid = rep.getListaCidadao().getListaCidadao().iterator();
            Cidadao temp_cid;
            while (itr_cid.hasNext()) {
                temp_cid = (Cidadao) itr_cid.next();
                if (temp_cid.equals(cid)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    
    public void ImprimeCids() {
        Iterator itr_rep = listaReparticao.iterator();
        Reparticao rep;
        while (itr_rep.hasNext()) {
            rep = (Reparticao) itr_rep.next();
            Iterator itr = rep.getListaCidadao().getListaCidadao().iterator();
            while(itr.hasNext()){
                Cidadao cid = (Cidadao) itr.next();
                System.out.println("Repartição: ["+rep.getCidade()+ ", "+rep.getNumeroReparticao()+ "] - Cidadão: "+ cid.getNumeroContribuinte());
            }
        }
    }

    public Reparticao getReparticaoPorServicoECodigoPostal(Servico serv, int codigoPostal) throws CloneNotSupportedException {
        DoublyLinkedList<Reparticao> temp = (DoublyLinkedList<Reparticao>) listaReparticao.clone();
        Reparticao repTemp = new Reparticao();
        Iterator itr = temp.iterator();
        while (itr.hasNext()) {
            repTemp = (Reparticao) itr.next();
            if (!repTemp.checkForServico(serv)) {
                itr.remove();
            }
        }
        Reparticao repMaisProxima = new Reparticao();
        int dif = 4000;
        itr = temp.iterator();
        while (itr.hasNext()) {
            repTemp = (Reparticao) itr.next();
            if (Math.abs(repTemp.getCodigoPostal() - codigoPostal) < dif && Math.abs(repTemp.getCodigoPostal() - codigoPostal) != 0) {
                dif = Math.abs(repTemp.getCodigoPostal() - codigoPostal);
                repMaisProxima = repTemp;
            }
        }
        return repMaisProxima;
    }
}
