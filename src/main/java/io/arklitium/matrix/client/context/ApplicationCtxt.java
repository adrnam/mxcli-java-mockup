package io.arklitium.matrix.client.context;

import java.util.List;

public class ApplicationCtxt {

    private List<SessionCtxt> sessionCtxtList;

    public ApplicationCtxt(List<SessionCtxt> sessionCtxtList) {
        this.sessionCtxtList = sessionCtxtList;
    }

    public List<SessionCtxt> getSessionCtxtList() {
        return sessionCtxtList;
    }

    public void setSessionCtxtList(List<SessionCtxt> sessionCtxtList) {
        this.sessionCtxtList = sessionCtxtList;
    }

}
