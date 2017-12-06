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

    

}
