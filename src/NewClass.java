
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;//no olviden importar esta librería al inicio de su programa

/**
 *
 * @author KRC
 */
public class NewClass {

//esto es solo un método, no una clase, el método deberá ser incluido en una clase java para su uso
    public void escribir(String nombreArchivo,String texto) {
        File f;
        f = new File(nombreArchivo);

//Escritura
        try {
            FileWriter w = new FileWriter(f);
            try (BufferedWriter bw = new BufferedWriter(w)) {
                PrintWriter wr = new PrintWriter(bw);
                wr.write(texto);//escribimos en el archivo
                //ahora cerramos los flujos de canales de datos, al cerrarlos el archivo quedará guardado con información escrita
                //de no hacerlo no se escribirá nada en el archivo
                wr.close();
            }
        } catch (IOException e) {
        };
    }

}
