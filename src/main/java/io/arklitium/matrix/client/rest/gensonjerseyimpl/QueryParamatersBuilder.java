package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

class QueryParamatersBuilder {

    private List<Pair> nameValueList;

    QueryParamatersBuilder() {
        nameValueList = new ArrayList<>();
    }

    QueryParamatersBuilder addParameter(String name, String value) {
        this.nameValueList.add(new ImmutablePair(name, value));
        return this;
    }

    List<Pair> create() {
        return this.nameValueList;
    }

}
