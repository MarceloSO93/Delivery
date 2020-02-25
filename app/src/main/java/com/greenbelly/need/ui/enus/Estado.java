package com.greenbelly.need.ui.enus;

public enum Estado {

    ACRE("AC"),
    ALAGOAS("AL"),
    AMAPÁ("AP"),
    AMAZONAS("AM"),
    BAHIA("BA"),
    CEARÁ("CE"),
    DISTRITO_FEDERAL("DF"),
    ESPÍRITO_SANTO("ES"),
    GOIÁS("GO"),
    MARANHÃO("MA"),
    MATO_GROSSO("MT"),
    MATO_GROSSO_DOS_SUL("MS"),
    MINAS_GERAIS("MG"),
    PARÁ("PA"),
    PARAÍBA("PB"),
    PARANÁ("PR"),
    PERNAMBUCO("PE"),
    PIAUÍ("PI"),
    RIO_DE_ANEIRO("RJ"),
    RIO_GRANDE_DO_NORTE("RN"),
    RIO_GRANDE_DO_SUL("RS"),
    RONDÔNIA("RO"),
    RORAIMA("RR"),
    SANTA_CATARINA("SC"),
    SÃO_PAULO("SP"),
    SERGIPE("SE"),
    TOCANTINS("TO");

    private String value;

    Estado(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
