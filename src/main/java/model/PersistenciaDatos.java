package model;

import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author iagom
 */
public class PersistenciaDatos {

    
    //metodo que guarda los datos del programa
    public static void guardarDatos(Broker model) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(model);
            BufferedWriter bw = new BufferedWriter(new FileWriter("broker.json"));
            bw.write(json);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            System.getLogger(PersistenciaDatos.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    //metodo que permite recuperar los datos del archivo
    public static Broker leerDatos() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader fichero = new FileReader("broker.json");
        Broker broker = gson.fromJson(fichero, Broker.class);
        return broker;
    }
}
