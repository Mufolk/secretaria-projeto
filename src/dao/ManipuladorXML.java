package dao;

import java.beans.XMLEncoder;
import java.beans.XMLDecoder;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 * Classe genérica para ser utilizada na realização da persistência do projeto.
 * Permite a criação de DAOs (Data Access Objects). Deve-se instanciar o
 * parâmetro de tipo de acordo com a classe do modelo sendo persistida.
 */
public class ManipuladorXML<Tipo> {

    private ArrayList<Tipo> lista = new ArrayList<>();

    private String nomeArquivo;

    public ManipuladorXML(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public ArrayList<Tipo> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Tipo> lista) {
        this.lista = lista;
    }

    public void adiciona(Tipo tipo) {
        lista.add(tipo);
    }

    public void remove(Tipo tipo) {
        lista.remove(tipo);
    }

    public void escreveXML() {
        try {
            XMLEncoder encoder = null;
            try {
                encoder = new XMLEncoder(new FileOutputStream(nomeArquivo));
                encoder.writeObject(lista);

            } finally {
                if (encoder != null) {
                    encoder.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void leXML() {

        try {
            XMLDecoder decoder = null;
            try {
                decoder = new XMLDecoder(new FileInputStream(nomeArquivo));
                lista = (ArrayList<Tipo>) decoder.readObject();

            } finally {
                if (decoder != null) {
                    decoder.close();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
