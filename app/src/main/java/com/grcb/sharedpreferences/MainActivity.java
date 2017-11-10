package com.grcb.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView textViewNomeSalvo;
    EditText editTextNome;
    Button buttonSalvar;
    private static final String NAME_PREFERENCE = "NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewNomeSalvo = findViewById(R.id.textViewNomeSalvoId);
        editTextNome = findViewById(R.id.editTextNomeId);
        buttonSalvar = findViewById(R.id.buttonSalvarId);

        exibirUsuario();

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(NAME_PREFERENCE, 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                if (editTextNome.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Informe o nome que deseja salvar!",Toast.LENGTH_SHORT).show();
                }else {
                    editor.putString("name", editTextNome.getText().toString());
                    editor.commit();
                    exibirUsuario();
                }
            }
        });

    }

    private void exibirUsuario(){

        SharedPreferences sharedPreferences = getSharedPreferences(NAME_PREFERENCE, 0);
        if (sharedPreferences.contains("name")) {
            textViewNomeSalvo.setText(sharedPreferences.getString("name", "user"));
        }else {
            textViewNomeSalvo.setText("Usuário não definido");
        }
    }
}
