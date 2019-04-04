package textspeech.thezaxis.emandi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    EditText editName, editPhone, editEmail;
    RadioButton radioFarmer, radioTrader;
    RadioGroup radioGroup;
    Button registerButton;
    String id;
    private DatabaseReference mDatabaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        editEmail = findViewById(R.id.editEmail);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        radioGroup = findViewById(R.id.radioGroup);
        radioFarmer = findViewById(R.id.farmerRadioButton);
        radioTrader = findViewById(R.id.traderRadioButton);
        /*radioGroup.addView(radioFarmer, 0);
        radioGroup.addView(radioTrader, 1);*/
        registerButton = findViewById(R.id.btnRegister);
        id = getIntent().getStringExtra("id");
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("User Details");
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(id==null || id.equals(""))){
                    if (validateViews()){
                        String name = editName.getText().toString();
                        String email = editEmail.getText().toString();
                        String phone = editPhone.getText().toString();
                        //String type = String.valueOf(radioGroup.getCheckedRadioButtonId());
                        RadioButton radioButton = findViewById(radioGroup.getCheckedRadioButtonId());
                        String type = radioButton.getText().toString();
                        /*Toast.makeText(RegistrationActivity.this, "name: "+name, Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegistrationActivity.this, "phone: " +phone, Toast.LENGTH_SHORT).show();
                        Toast.makeText(RegistrationActivity.this, "type: " +radioButton.getText().toString(), Toast.LENGTH_SHORT).show();*/
                        UserDetails userDetails = new UserDetails(id, name, email, phone, type);
                        mDatabaseReference.child(id).setValue(userDetails);
                        Toast.makeText(RegistrationActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                        intent.putExtra("id", id);
                        startActivity(intent);
                        finish();
                    }
                }
            }
        });
    }

    private boolean validateViews() {
        if (editName.getText().toString().equals("")){
            editName.setError("Please Enter you Name");
            return false;
        }
        if (editPhone.getText().toString().equals("")){
            editPhone.setError("Please Enter Phone no.");
            return false;
        }
        if (!(radioTrader.isChecked() || radioFarmer.isChecked())){
            Toast.makeText(this, "Please select Farmer/Trader", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
