package com.oliverbotello.example.scanqrnoviembre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * X: Otro activity
 *      X: Crear el activity
 *      x: Agregar los componentes
 * X: Regidirigir al activity
 * O: Agregar una dependencia de Huawei para leer QRs
 *      X: Anadir la dependencia
 *      O: Solicitar permisos (opcional) ---- Tarea
 *      O: Abrir el scan kit
 *      O: Mostrar el resultado del escaneado
 * **/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtUsername;
    private EditText edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        edtUsername = findViewById(R.id.edtx_username);
        edtPassword = findViewById(R.id.edtx_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);
    }

    private void redirectToScan() {
        Intent intent = new Intent(this, ScanActivity.class);

        startActivity(intent);
    }

    private void login() {
        String username = edtUsername.getText().toString();
        String password = edtPassword.getText().toString();

        if (username.equals("Oliver404") && password.equals("123456")) {
            Toast.makeText(this, "Bienvenido ( / ^ . ^ )/", Toast.LENGTH_LONG).show();
            redirectToScan();
        }
        else {
            Toast.makeText(this, "Usuario y/o contrasena no existen", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onClick(View v) {
        login();
    }
}