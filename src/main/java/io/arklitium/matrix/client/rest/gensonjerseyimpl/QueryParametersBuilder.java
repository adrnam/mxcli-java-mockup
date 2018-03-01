package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

class QueryParametersBuilder {

    private List<Pair> nameValueList;


    QueryParametersBuilder() {
        nameValueList = new ArrayList<>();
    }

    QueryParametersBuilder addParameter(String name, String value) {
        this.nameValueList.add(new ImmutablePair(name, value));
        return this;
    }

    List<Pair> create() {
        return this.nameValueList;
    }

}
