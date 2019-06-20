
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Tuna
 * @version 0000.00.00
 */
public class ImageLabel {

    /**
     * <h2>Método permite "setar" imagem em um JLabel</h2>
     * <p>Este método permite que o usuario trabalhe com imagens que estao fora da 
     * construcao (.jar), em outras palavras, imagens que estao fora do source (src),
     * e assim possibilitando usuario setar imagens no jlabel mesmo depois da contrucao do projeto.</p>
     * 
     * <p>PARA O USO DESTE METODO A PASTA COM AS IMAGENS DEVE OBRIGATORIAMENTE 
     * SER IRMA DO ARQUIVO (.jar), OU SEJA, DEVEM ESTA NOM MESMO DIRETORIO.
     * 
     * <br /> Mother Folder. <br /> 
     * |__ imagens<br />
     * |__ programa.jar<br />
     * </p>     
     *
     * @param label  JLabel label que deve ser settado.
     * @param folder String folder, nome da pasta onde se encontra(m) a(s) imagem(ns).
     * @param image  String image, nome e extensao da imagem que sera "setada" no label.
     */
    public void setImageLabel(JLabel label, String folder, String image) {
        String path = System.getProperty("user.dir") + "\\" + folder + "\\";
        File file = new File(path + image);
        if (file.exists()) {
            label.setIcon(new ImageIcon(path + image));
        } else {
            System.err.println("That file doesn't exist.");
        }
    }

    /**
     * <h2>Método permite "setar" imagem em um JLabel</h2>
     * <p>Este método permite que o usuario trabalhe com imagens que estao fora da 
     * construção (.jar), em outras palavras, imagens que estão fora do source (src),
     * e assim possibilitando usuario setar imagens no jlabel, não importa onde as 
     * imagens estejam mesmo depois da contrução do projeto.</p>
     * 
     * @param label JLabel label que deve ser settado.
     * @param path  String path, caminho completo desde a raiz.
     * @param image String image, nome e extensão da imagem que será "setada" no label.
     */
    public void setImageLabelWherever(JLabel label, String path, String image) {
        File file = new File(path + image);
        if (file.exists()) {
            label.setIcon(new ImageIcon(path + image));
        } else {
            System.err.println("That file doesn't exist.");
        }
    }
    
}
