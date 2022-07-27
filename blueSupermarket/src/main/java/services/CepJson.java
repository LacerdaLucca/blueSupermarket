package services;

import DAO.UsuarioDao;
import com.google.gson.Gson;
import model.CEP;

import java.util.ArrayList;
import java.util.List;

public class CepJson {


        public List<CEP> buscaCep (String json) {

        CEP cepObject = new Gson().fromJson(json, CEP.class);
        System.out.println(cepObject.getCEP());

        List<CEP> lista = new ArrayList<>();
        lista.add(cepObject);

        System.out.println(json);

        return lista;
    }

        UsuarioDao usuarioDao = new UsuarioDao();




}
