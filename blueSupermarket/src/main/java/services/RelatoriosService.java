package services;

import DAO.RelatoriosDao;
import model.Relatorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosService {
    private List<Relatorio> relatoriosComp = new ArrayList<>();
    private long qtn=0;

    public List<Relatorio> listaVenda(String nome, String dataInic, String dataFinal){
        List<Relatorio> relatoriosPorData = new ArrayList<>();
        try {
            relatoriosPorData.addAll(new RelatoriosDao().listVendaPorId(nome, dataInic, dataFinal));
            long qtnVen= calculoQtnVenda(relatoriosPorData);
            if(relatoriosPorData!=null){
                relatoriosComp.add(new Relatorio(relatoriosPorData.get(0).getIdProd(),relatoriosPorData.get(0).getNomeProd(),qtnVen)) ;
            }
        return relatoriosComp;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public long calculoQtnVenda ( List<Relatorio> lista){
        for (Relatorio listComp:lista) {
            qtn++;
        }
        return qtn;
    }
}
