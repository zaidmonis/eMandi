package textspeech.thezaxis.emandi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {


    private EditText Username;
    private EditText Password;
    private TextView signup;
    private TextView Sign;
    private Button login;
    private TextView login_with_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username=(EditText)findViewById(R.id.etUsername);
        Password = (EditText)findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btnlogin);
        signup=(TextView)findViewById(R.id.txtsignup);
        login_with_number = (TextView) findViewById(R.id.txtlogin_with_number);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Username.getText().length()==0){
                   Username.setError("Please enter username");
               }
               if(Password.getText().length()==0){
                   Password.setError("Please Enter Password");
               }
                Toast.makeText(Login.this, "login successful", Toast.LENGTH_SHORT).show();

            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Login.this,Signup.class);
                startActivity(intent);
            }
        });

        login_with_number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Login.this, "login with number", Toast.LENGTH_SHORT).show();
            }
        });


    }



}
