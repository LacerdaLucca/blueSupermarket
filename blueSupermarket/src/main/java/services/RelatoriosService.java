package services;

import DAO.RelatoriosDao;
import model.Relatorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatoriosService {
    private List<Relatorio> relatoriosComp = new ArrayList<>();
    private long qtn=0;

    public List<Relatorio> listaVenda(String nome, String dataInic, String dataFinal,String cpf){
        List<Relatorio> relatoriosPorData = new ArrayList<>();
        long qtnVen = 0;
        try {
            relatoriosPorData.addAll(new RelatoriosDao().listVendaPorNome(nome, dataInic, dataFinal, cpf));
            if(relatoriosPorData!=null){
                for (int i = 0; i < relatoriosPorData.size(); i++) {
                    String nomeBase = relatoriosPorData.get(i).getNomeProd();
                    for (Relatorio relatorio: relatoriosPorData) {
                        if (relatorio.getNomeProd().equals(nomeBase)){
                            qtnVen++;
                        }
                    }
                    relatoriosComp.add(new Relatorio(relatoriosPorData.get(i).getIdProd(),relatoriosPorData.get(i).getNomeProd(),qtnVen)) ;
                }
            }
        return relatoriosComp;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Relatorio> listaVendaPeriodo(String nomeProd, String dataInic, String dataFinal, String cpf){
        List<Relatorio> relatoriosPorData = new ArrayList<>();
        try {
            relatoriosPorData.addAll(new RelatoriosDao().listVendaPorData(nomeProd, dataInic, dataFinal, cpf));
            if(relatoriosPorData!=null){
                long qtnVen= calculoQtnVenda(relatoriosPorData);
                for (Relatorio relatorio: relatoriosPorData) {
                    relatoriosComp.add(new Relatorio(relatorio.getIdProd(), relatorio.getNomeProd(), qtnVen));
                }
            }
            return relatoriosComp;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Relatorio> listaVendaNome(String nome, String dataInic, String dataFinal,String cpf){
        List<Relatorio> relatoriosPorData = new ArrayList<>();
        List<Relatorio> verificarRepeticao = new ArrayList<>();
        long qtnVen = 0;
        String nomeBase =null;

        try {
            relatoriosPorData.addAll(new RelatoriosDao().listVendaPorNome(nome, dataInic, dataFinal, cpf));
            for (Relatorio rel:relatoriosPorData) {
                System.out.println(rel.getNomeProd());
            }
            if(relatoriosPorData!=null){
                relatoriosComp.add(new Relatorio(relatoriosPorData.get(0).getIdProd(), relatoriosPorData.get(0).getNomeProd(), 0));

                for (int i = 0; i < relatoriosPorData.size(); i++) {

                    if (relatoriosComp.get(i).getQntVendas()==0){
                        for (Relatorio relatorio: relatoriosPorData) {
                            if (relatorio.getNomeProd().equals(relatoriosPorData.get(i).getNomeProd())){
                                qtnVen++;
//                                verificarRepeticao.add(new Relatorio(relatorio.getIdProd(), relatorio.getNomeProd(), qtnVen)) ;
                            }
                        }
                        relatoriosComp.add(new Relatorio(relatoriosPorData.get(i).getIdProd(),relatoriosPorData.get(i).getNomeProd(),qtnVen)) ;
                    }
                }
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
