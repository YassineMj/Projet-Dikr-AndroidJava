package com.example.dikr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitylogin);


        AccountCRUD account=new AccountCRUD(this);

        //account.select();

        final Intent IntentCreateAccount=new Intent(this,ActivityCreateAccount.class);


        EditText txt_email=findViewById(R.id.txt_email);
        EditText txt_password=findViewById(R.id.txt_password);

        TextView txt_incription=findViewById(R.id.txt_inscription);
        Button btn_login=findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txt_email.getText().toString().equals("") || txt_password.getText().toString().equals("")){
                    Toast.makeText(ActivityLogin.this,
                            "Veuillez remplir tous les champs obligatoires", Toast.LENGTH_LONG).show();
                }
                else{
                    if(Patterns.EMAIL_ADDRESS.matcher(txt_email.getText().toString()).matches() && account.selectAccount(txt_email.getText().toString(),txt_password.getText().toString())==true){
                        Toast.makeText(ActivityLogin.this," Validated Successfully !",Toast.LENGTH_LONG).show();

                    }else {
                        Toast.makeText(ActivityLogin.this," Invalid Email",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });

        txt_incription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(IntentCreateAccount);
            }
        });
    }
}