package mx.edu.unsis.loteria.service;

import mx.edu.unsis.loteria.model.Cantador;
import mx.edu.unsis.loteria.model.Carta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import java.util.Collections;

@Service
public class CantadorService {

    private final Cantador cantador;

    public CantadorService() {
        this.cantador = new Cantador();
        this.cantador.setCartasEnCantaro(new ArrayList<>());
        this.cantador.setCartasSacadas(new ArrayList<>());
    }

    public void inicializarCartas(List<Carta> cartas) {
        if (cantador.getCartasEnCantaro() == null) {
            cantador.setCartasEnCantaro(new ArrayList<>());
        }
        cantador.getCartasEnCantaro().addAll(cartas);
    }

    public void mezclarCartas() {
        Collections.shuffle(cantador.getCartasEnCantaro());
    }

    public Carta sacarCarta() {
        if (cantador.getCartasEnCantaro().isEmpty()) {
            return null;
        }
        Carta cartaSacada = cantador.getCartasEnCantaro().remove(0);
        cantador.getCartasSacadas().add(cartaSacada);
        return cartaSacada;
    }

    public void reiniciarCantaro() {
        cantador.getCartasEnCantaro().addAll(cantador.getCartasSacadas());
        cantador.getCartasSacadas().clear();
    }

    public Cantador getCantador() {
        return cantador;
    }
}