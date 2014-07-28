
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author KRC
 */
public class Funciones {

    public String obtieneHost() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            return address.getHostName();
        } catch (UnknownHostException ex) {
            return null;
        }
    }

    public String obtieneIp() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            // Cogemos la IP 
            byte[] bIPAddress = address.getAddress();
            // IP en formato String
            String sIPAddress = "";
            for (int x = 0; x < bIPAddress.length; x++) {
                if (x > 0) {
                    // A todos los numeros les anteponemos
                    // un punto menos al primero    
                    sIPAddress += ".";
                }
                // Jugamos con los bytes y cambiamos el bit del signo
                sIPAddress += bIPAddress[x] & 255;
            }
            return sIPAddress;
        } catch (UnknownHostException ex) {
            return null;
        }
    }

    public String obtieneDirecion(String lat, String lon) {
        String formatoJSON = obtenerDeURL("http://maps.googleapis.com/maps/api/geocode/json?latlng=" + lat + "," + lon + "&sensor=true_or_false");
        String lin[] = formatoJSON.split("formatted_address");
        String dir = lin[1].split("\"")[2];
        return dir;
    }

    public String obtieneDirecionOpen(String lat, String lon) {
        String formatoXML = obtenerDeURL("http://nominatim.openstreetmap.org/reverse?format=xml&lat=" + lat + "&lon=" + lon);
        String dir = formatoXML.split("\n")[2].split(">")[1].split("<")[0];
        return dir;
    }

    public String fechaFormato(Date d) {
        Date fecha = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaActual = formateador.format(fecha);
        return fechaActual;
    }

    public static Date sumarRestarHorasFecha(Date fecha, int horas) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.HOUR, horas);  // numero de horas a añadir, o restar en caso de horas<0
        return calendar.getTime(); // Devuelve el objeto Date con las nuevas horas añadidas
    }

    public String obtenerDeURL(String url) {
        String entrada = "", lin;
        try {
            URL pagina = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(pagina.openStream()));
            while ((lin = in.readLine()) != null) {
                entrada += lin + "\n";
            }

        } catch (IOException ex) {
        }
        return entrada;
    }
}
