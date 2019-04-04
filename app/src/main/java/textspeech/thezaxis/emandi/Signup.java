package textspeech.thezaxis.emandi;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {

    private EditText AadharCard;
    private EditText PhoneNumber;
    private Button signUp;
    private int SIGN_UP_WITH_PHONE = 1, SIGN_UP_WITH_AADHAR = 2, check;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AadharCard = (EditText)findViewById(R.id.etAadharCard);
        PhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        signUp = (Button)findViewById(R.id.btnsignup);
        mDatabaseReference = FirebaseDatabase.getInstance().getReference("Users");


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(AadharCard.getText().length()==12 || PhoneNumber.getText().length()==10) {
                    AlertDialog.Builder mBuilder = new AlertDialog.Builder(Signup.this);
                    View mview1 = getLayoutInflater().inflate(R.layout.dialog_aadhar, null);
                    final EditText Password = (EditText) mview1.findViewById(R.id.etpassword);
                    final EditText ConfirmPassword = (EditText) mview1.findViewById(R.id.etconfirmpassword);
                    View mview2 = LayoutInflater.from(Signup.this).inflate(R.layout.dialog_number, null);
                    AlertDialog dialog;
                    mBuilder.setCancelable(false)
                            .setPositiveButton("Submit",null)
                            .setNegativeButton("Cancel",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialogBox, int id) {
                                            dialogBox.cancel();
                                        }
                                    });


                    if (AadharCard.getText().length() == 12) {
                        check = SIGN_UP_WITH_AADHAR;
                        mBuilder.setView(mview1);
                        dialog = mBuilder.create();
                        dialog.show();
                        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        positiveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (Password.getText().toString().equals(ConfirmPassword.getText().toString())){
                                    String id = mDatabaseReference.push().getKey();
                                    User user = new User(AadharCard.getText().toString(), ConfirmPassword.getText().toString());
                                    mDatabaseReference.child(id).setValue(user);

                                    Toast.makeText(Signup.this, "Success", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    ConfirmPassword.setError("Password did not match!");
                                }
                            }
                        });

                    } else if (PhoneNumber.getText().length() == 10) {
                        check = SIGN_UP_WITH_PHONE;
                        mBuilder.setView(mview2);
                        dialog = mBuilder.create();
                        dialog.show();
                        Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                        positiveButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        });

                    }
                }
                else
                if(AadharCard.getText().length()!=12){
                    AadharCard.setError("Please Enter Aadhaar Number");
                }
                else
                if(PhoneNumber.getText().length()!=10){
                    PhoneNumber.setError("Please Enter Phone_Number");
                }
            }
        });
    }


}
