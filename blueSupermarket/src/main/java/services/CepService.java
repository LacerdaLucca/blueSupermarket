package services;



import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CepService {

    public String getCep(String cep) throws Exception {

        String linkCorreios = "https://viacep.com.br/ws/" + cep + "/json/";
        URL url = new URL(linkCorreios);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        Scanner sc = new Scanner(conn.getInputStream());
        int i= 0;
        String dados = "";
        while (sc.hasNextLine()) {
            dados+=sc.next();
        }
        sc.close();

        return dados;
    }

}
