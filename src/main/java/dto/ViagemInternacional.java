package dto;

import enums.Destinos;
import interfaces.CalculadoraDePrevisao;
import utils.ArquivoUtils;
import java.util.List;


public class ViagemInternacional extends Viagem implements CalculadoraDePrevisao {
    private String passaporte;

    public ViagemInternacional(Destinos lugarDeDestino){
        super(lugarDeDestino);
    }

    public String getPassaporte(){
        return this.passaporte;
    }

    public void setPassaporte(String passaporte){
        this.passaporte = passaporte;
    }

    @Override
    public void setAcompanhantes(List<Acompanhante> acompanhantes) throws Exception{
        int limiteDeAcompanhantes = Integer.parseInt(ArquivoUtils.getPropriedades("viagem.internacional.acompanhantes.limite"));

        if (acompanhantes.size()<=limiteDeAcompanhantes) {
            super.setAcompanhantes(acompanhantes);
        } else {
            throw new Exception("Viagens internacionais não podem ter mais que " + limiteDeAcompanhantes + " acompanhante");
        }
    }

    public int calcularPrevisaoDeDiasParaRetorno(){
        if (this.getDestino().equals(Destinos.ACAPULCO)){
            return 1;
        }

        return 0;
    }
}
