package com.example.avaliacao_n2;

public class Pessoa {
    private String login;
    private String id;
    private String node_id;
    private String html_url;
    private String type;

    public String getLogin() {
        return login;
    }

    public String getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getHtml_url() {
        return html_url;
    }

    public String getType() {
        return type;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public void setType(String type) {
        this.type = type;
    }
}
