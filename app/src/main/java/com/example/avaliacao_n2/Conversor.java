package com.example.avaliacao_n2;

import org.json.JSONException;
import org.json.JSONObject;

public class Conversor {
    public Pessoa getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        Pessoa retorno = parseJson(json);
        return retorno;
    }

    private Pessoa parseJson(String json){
        try {
            Pessoa pessoa = new Pessoa();

            JSONObject jsonObj = new JSONObject(json);
            //JSONObject jsonData = new JSONObject(jsonObj.getString("data"));
            pessoa.setLogin(jsonObj.getString("login"));
            pessoa.setId(jsonObj.getString("id"));
            pessoa.setNode_id(jsonObj.getString("node_id"));
            pessoa.setHtml_url(jsonObj.getString("html_url"));
            pessoa.setType(jsonObj.getString("type"));

            return pessoa;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

}
