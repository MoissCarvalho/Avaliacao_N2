package com.example.avaliacao_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView login;
    private TextView id;
    private TextView node_id;
    private TextView html_url;
    private TextView type;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DownloadPessoa download = new DownloadPessoa();

        login = (TextView)findViewById(R.id.login);
        id = (TextView)findViewById(R.id.id);
        node_id = (TextView)findViewById(R.id.node_id);
        html_url = (TextView)findViewById(R.id.html_url);
        type = (TextView)findViewById(R.id.type);

        download.execute();
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, Pessoa> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(Main2Activity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Pessoa doInBackground(Void... arams) {
            Conversor util = new Conversor();
            return util.getInformacao("https://api.github.com/users/test2");
        }

        @Override
        protected void onPostExecute(Pessoa pessoa){
            login.setText(" Login: " + pessoa.getLogin());
            id.setText(" Id: " + pessoa.getId());
            node_id.setText(" Node_id: " + pessoa.getNode_id());
            html_url.setText(" Página: " + pessoa.getHtml_url());
            type.setText(" Tipo: " + pessoa.getType());

            load.dismiss(); //deleta o dialog
        }
    }
}
