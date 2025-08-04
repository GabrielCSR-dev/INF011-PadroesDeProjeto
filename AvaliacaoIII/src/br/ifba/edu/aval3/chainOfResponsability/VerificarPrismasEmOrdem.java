package br.ifba.edu.aval3.chainOfResponsability;

import java.time.Duration;
import java.util.List;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.exception.DNFException;
import br.ifba.edu.aval.model.BoletimProva;

public class VerificarPrismasEmOrdem extends ApuradorBase{
	
	public VerificarPrismasEmOrdem(Apurador proxRegra) {
		super(proxRegra);
	}
	
	public void setProximo(Apurador regra) {
		super.setProximo(regra);
	}

	public void apurar(BoletimProva boletim)
			throws DNFException, AtividadeNaoPermitidaException {
		List<Integer> ordemPrismas = boletim.getOrdemPrismas();
		
		for(int iCont = 0; iCont < ordemPrismas.size() - 1; iCont++) {
    		Duration anterior = boletim.getTempo(ordemPrismas.get(iCont));
    		Duration atual = boletim.getTempo(ordemPrismas.get(iCont+1));
    		if(anterior != null && atual != null)
    			if(anterior.compareTo(atual) > 0)
    				throw new DNFException("Atleta registrou prisma fora da ordem");
    	}
		
		super.apurar(boletim);
	}
	
}
