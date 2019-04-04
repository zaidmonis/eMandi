package textspeech.thezaxis.emandi;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Login extends AppCompatActivity {


    private EditText Username;
    private EditText Password;
    //private TextInputEditText Password;
    private CheckBox checkBoxShowPassword;
    private TextView signup;
    private TextView Sign;
    private Button login;
    private TextView login_with_number;
    private DatabaseReference mDatabaseReference;
    private ValueEventListener mDbListener;
    List<User> userList;
    Boolean userFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username= findViewById(R.id.etUsername);
        Password = findViewById(R.id.etPassword);
        login = (Button)findViewById(R.id.btnlogin);
        signup=(TextView)findViewById(R.id.txtsignup);
        login_with_number = (TextView) findViewById(R.id.txtlogin_with_number);
        checkBoxShowPassword = findViewById(R.id.show_password_check_box);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userList = new ArrayList<>();
        checkBoxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxShowPassword.isChecked()){
                    Password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    Password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Username.getText().length()!=0 && Password.getText().length()!=0){
                   /*if (checkUser()){
                       //Toast.makeText(Login.this, "Login Success", Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(Login.this, "Login Invalid", Toast.LENGTH_SHORT).show();
                   }*/
                   checkUser();
                   new Handler().postDelayed(new Runnable() {
                       @Override
                       public void run() {
                           if (!userFound){
                               Toast.makeText(Login.this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();
                           }
                       }
                   }, 5000);

               }
               else{
                   Toast.makeText(Login.this, "Invalid values!", Toast.LENGTH_SHORT).show();
               }


                //Toast.makeText(Login.this, "login successful", Toast.LENGTH_SHORT).show();

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


    private void checkUser(){
        userFound = false;

        mDatabaseReference= FirebaseDatabase.getInstance().getReference("Users");
        mDbListener = mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userList.clear();
                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()){
                    try{
                        User user = userSnapshot.getValue(User.class);

                        if (user.getUserName().equals(Username.getText().toString()) && user.getKey().equals(Password.getText().toString())){
                            userFound = true;
                            Toast.makeText(Login.this, "Login Successfully done!", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Login.this, HomeActivity.class);
                            intent.putExtra("id", user.getId());
                            Toast.makeText(Login.this, ""+user.getId(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Login.this, HomeActivity.class));
                            userFound = true;
                            finish();
                            break;
                        }
                        else{
                            userFound = false;
                            /*Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();*/
                        }
                    }catch (Exception e){
                        Toast.makeText(Login.this, "" +e, Toast.LENGTH_SHORT).show();
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Login.this, ""+databaseError.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }



}
