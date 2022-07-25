package services;

import com.thoughtworks.xstream.XStream;
import model.Frete;
import model.FreteAPICorreios;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

public class FreteService {

    public FreteAPICorreios getFrete(String cepDest) throws Exception {
        XStream xStream = new XStream();
        String linkCorreios = "http://ws.correios.com.br/calculador/CalcPrecoPrazo.aspx?nCdEmpresa=08082650&sDsSenha=564321&sCepOrigem=30421340&sCepDestino="+cepDest+"&nVlPeso=1&nCdFormato=1&nVlComprimento=20&nVlAltura=20&nVlLargura=20&sCdMaoPropria=n&nVlValorDeclarado=0&sCdAvisoRecebimento=n&nCdServico=04510&nVlDiametro=0&StrRetorno=xml&nIndicaCalculo=3";
        URL url = new URL(linkCorreios);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        Scanner sc = new Scanner(conn.getInputStream());
        int i= 0;
        String dados = "";
        while (sc.hasNextLine()) {
            dados+=sc.next()+",";
        }
        sc.close();

        FreteAPICorreios freteAPICorreios = (FreteAPICorreios) xStream.fromXML(dados);

        return freteAPICorreios;
    }


}
