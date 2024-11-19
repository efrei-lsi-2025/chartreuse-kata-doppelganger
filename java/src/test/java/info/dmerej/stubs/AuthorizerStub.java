package info.dmerej.stubs;

import info.dmerej.Authorizer;

public class AuthorizerStub implements Authorizer {
    private boolean authorized;

    public AuthorizerStub() {
    }

    @Override
    public boolean authorize() {
        return this.authorized;
    }

    public AuthorizerStub setAuthorized(boolean authorized) {
        this.authorized = authorized;
        return this;
    }
}
