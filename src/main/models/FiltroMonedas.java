package main.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record FiltroMonedas(
        @JsonAlias("ARS") Double ars,
        @JsonAlias("BOB") Double bob,
        @JsonAlias("BRL") Double brl,
        @JsonAlias("CLP") Double clp,
        @JsonAlias("COP") Double cop,
        @JsonAlias("USD") Double usd) {
}
