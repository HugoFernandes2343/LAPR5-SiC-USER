package polignosregulares;

import PL.AVL;
import PL.BST;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author hugod
 */
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
     * b) 
     * Com base nas três árvores anteriores elabore um método que devolve o
     * nome de um polígono dado o seu número de lados. Por exemplo, 524 é
     * pentahecta-icosi-tetra-gon -> pentahectaicositetragon
     *
     * @param n numero de lados do poligno
     * @return nome do poligno
     */
    
    public String getNomePoligno(int n) {
        int centenas = (n/100)*100;
        Prefixo centPrefixo = (Prefixo) cent.find(new Prefixo(centenas));
        Prefixo dezPrefixo = null;
        if ((n % 100) < 30 && (n % 100) >= 10) {
            dezPrefixo = (Prefixo) dez.find(new Prefixo((n % 100)));
        }
        Prefixo unidPrefixo = null;
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
     * c) 
     * Com base nas três árvores anteriores construa uma árvore balanceada
     * que contenha todos os nomes de polígonos regulares de 1 até 999 lados.
     *
     * @return
     */
    public AVL getArvoreCompleta() {
        AVL polygonTree = new AVL();
        for(int i = 1; i <= 999; i++) {
            String polygonName = getNomePoligno(i);
            Prefixo pol= new Prefixo(i, polygonName);
            polygonTree.insert(pol);
        }
        return polygonTree;
    }

}
