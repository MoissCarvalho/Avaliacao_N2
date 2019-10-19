package com.example.avaliacao_n2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView login;
    private TextView id;
    private TextView node_id;
    private TextView html_url;
    private TextView type;
    private Button vai;
    public static int TELA_USER2 = 12;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadPessoa download = new DownloadPessoa();

        login = (TextView)findViewById(R.id.login);
        id = (TextView)findViewById(R.id.id);
        node_id = (TextView)findViewById(R.id.node_id);
        html_url = (TextView)findViewById(R.id.html_url);
        type = (TextView)findViewById(R.id.type);

        download.execute();

        vai = findViewById(R.id.vai);
        vai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentVaiPraOutraTela = new Intent (MainActivity.this, Main2Activity.class);
                startActivityForResult(intentVaiPraOutraTela, TELA_USER2);

            }
        });
    }

    private class DownloadPessoa extends AsyncTask<Void, Void, Pessoa> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(MainActivity.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Pessoa doInBackground(Void... arams) {
            Conversor util = new Conversor();
            return util.getInformacao("https://api.github.com/users/test1");
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
