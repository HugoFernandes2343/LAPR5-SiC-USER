package polignosregulares;

import PL.AVL;
import PL.BST;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class polignosRegularesBase extends BST {

    private AVL unid;
    private AVL dez;
    private AVL cent;

    public polignosRegularesBase(String txt_unid, String txt_dez, String txt_cent) throws IOException {
        this.unid = new AVL();
        this.dez = new AVL();
        this.cent = new AVL();

        ler(txt_unid, 1);
        ler(txt_dez, 2);
        ler(txt_cent, 3);
    }

    public AVL getUnid() {
        return unid;
    }

    public AVL getDez() {
        return dez;
    }

    public AVL getCent() {
        return cent;
    }

    private void ler(String txt, int n) throws IOException {
        List<Object> lines = Files.lines(Paths.get(txt)).collect(Collectors.toList());

        for (int i = 0; i < lines.size(); i++) {
            String line = (String) lines.get(i);
            String[] input = line.split(";");
            Prefixo pol = new Prefixo(Integer.parseInt(input[0]), input[1]);
            if (n == 1) {
                unid.insert(pol);
            }
            if (n == 2) {
                dez.insert(pol);
            }
            if (n == 3) {
                cent.insert(pol);
            }
        }
    }

    /**
     * b) Com base nas três árvores anteriores elabore um método que devolve o
     * nome de um polígono dado o seu número de lados. Por exemplo, 524 é
     * pentahecta-icosi-tetra-gon -> pentahectaicositetragon
     *
     * @param n numero de lados do poligno
     * @return nome do poligno
     */
    public String getNomePoligno(int n) {
        int centenas = (n / 100) * 100;
        Prefixo centPrefixo = (Prefixo) cent.find(new Prefixo(centenas));
        Prefixo dezPrefixo = null;
        Prefixo unidPrefixo = null;
        if ((n % 100) < 30 && (n % 100) >= 10) {
            dezPrefixo = (Prefixo) dez.find(new Prefixo((n % 100)));
        }

        if ((n % 100) < 10) {
            unidPrefixo = (Prefixo) unid.find(new Prefixo((n % 100)));
        }
        if ((n % 100) >= 30) {
            int digito = (n % 10);
            unidPrefixo = (Prefixo) unid.find(new Prefixo(digito));
            dezPrefixo = (Prefixo) dez.find(new Prefixo(((n % 100) - digito)));
        }
        if (unidPrefixo == null) {
            unidPrefixo = new Prefixo();
        }
        if (dezPrefixo == null) {
            dezPrefixo = new Prefixo();
        }
        if (centPrefixo == null) {
            centPrefixo = new Prefixo();
        }
        return centPrefixo.toString() + dezPrefixo.toString() + unidPrefixo.toString() + "gon";
    }

    /**
     * c) Com base nas três árvores anteriores construa uma árvore balanceada
     * que contenha todos os nomes de polígonos regulares de 1 até 999 lados.
     *
     * @return
     */
    public AVL getArvoreCompleta() {
        AVL polygonTree = new AVL();
        for (int i = 1; i <= 999; i++) {
            String polygonName = getNomePoligno(i);
            Prefixo pol = new Prefixo(i, polygonName);
            polygonTree.insert(pol);
        }
        return polygonTree;
    }

    /**
     * d)
     *
     * Elabore um método que devolve o número de lados de um polígono regular
     * através do seu nome.
     *
     */
    public int getNrLados(String polNome) {
        AVL polTree = getArvoreCompleta();
        List<Prefixo> tree = (List<Prefixo>) polTree.inOrder();
        Iterator itr = tree.iterator();
        while (itr.hasNext()) {
            Prefixo pref = (Prefixo) itr.next();
            if (pref.getPref().equals(polNome)) {
                return pref.getNumeroLados();
            }
        }
        return 0;
    }

    /**
     * e)
     *
     * Dado um intervalo de números de lados o método deve devolver os
     * correspondentes nomes dos polígonos por ordem inversa, do maior para o
     * menor número de lados.
     */
    public List<String> getIntervaloNomes(int min, int max) {
        List<String> polList = new ArrayList<>();
        if (max < min || min < 1) {
            return null;
        }
        int i = max;
        while (i >= min) {
            polList.add(getNomePoligno(i));
            i--;
        }
        return polList;
    }

    /**
     * f)
     * 
     * Dados dois nomes de polígonos encontrar o seu Lowest Common Ancestor (antecessor comum mais
     * próximo) na árvore binária.
     * 
     * @param a
     * @param b
     * @return 
     */
    public Prefixo findLCA(String a, String b) {
        AVL arvoreCompleta = getArvoreCompleta();
        Prefixo pa = new Prefixo(getNrLados(a), a);
        Prefixo pb = new Prefixo(getNrLados(b), b);
        Prefixo prim, seg;
        if (pa.getNumeroLados() < pb.getNumeroLados()) {
            prim = pa;
            seg = pb;
        } else {
            prim = pb;
            seg = pa;
        }
        return findLCA(arvoreCompleta.root(), prim, seg);
    }

    /**
     * f) continuação
     * 
     * Metodo privado para a recursividade
     * 
     * @param root
     * @param p
     * @param s
     * @return 
     */
    private Prefixo findLCA(AVL.Node<Prefixo> root, Prefixo p, Prefixo s) {
        if (root == null) {
            return null;
        }
        
        Prefixo temp = root.getElement();
        
        if (temp.getNumeroLados() > p.getNumeroLados() && temp.getNumeroLados() < s.getNumeroLados()) {
            return temp;
        } else if (temp.getNumeroLados() > p.getNumeroLados() && temp.getNumeroLados() > s.getNumeroLados()) {
            return findLCA(root.getLeft(), p, s);
        } else if (temp.getNumeroLados() < p.getNumeroLados() && temp.getNumeroLados() < s.getNumeroLados()) {
            return findLCA(root.getRight(), p, s);
        }
        return temp;
    }

}
