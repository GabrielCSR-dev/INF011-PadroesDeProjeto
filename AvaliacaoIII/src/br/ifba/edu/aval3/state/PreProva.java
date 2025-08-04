package br.ifba.edu.aval3.state;

import java.time.Duration;

import br.ifba.edu.aval.exception.AtividadeNaoPermitidaException;
import br.ifba.edu.aval.model.BoletimProva;

public class PreProva extends State{

	public PreProva(BoletimProva boletim) {
		super(boletim);
	}

	@Override
	public void registrar(Integer prismaID, Duration tempo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode registrar prisma");
	}

	@Override
	public void registrarAtrasoPartida(Long minutoPartidaEfetivo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode registrar tempo de partida");
	}

	@Override
	public Long getMinutosAtraso() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Não pode calcular minutos de atraso");
	}

	@Override
	public void apresentarPraLargada() throws AtividadeNaoPermitidaException {
		this.boletim.setState(new Largada(this.boletim));
	}

	@Override
	public void registrarLargada() throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite largar.");
	}

	@Override
	public void registrarChegada(Duration tempo) throws AtividadeNaoPermitidaException {
		throw new AtividadeNaoPermitidaException("Fase não permite registro de chegada.");
	}

}
