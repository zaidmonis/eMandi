package textspeech.thezaxis.emandi;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signup extends AppCompatActivity {

    private EditText AadharCard;
    private EditText PhoneNumber;
    private Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        AadharCard = (EditText)findViewById(R.id.etAadharCard);
        PhoneNumber = (EditText)findViewById(R.id.etPhoneNumber);
        signUp = (Button)findViewById(R.id.btnsignup);


        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(AadharCard.getText().length()==12 || PhoneNumber.getText().length()==10) {

                    AlertDialog.Builder mbuilder = new AlertDialog.Builder(Signup.this);
                    View mview1 = getLayoutInflater().inflate(R.layout.dialog_aadhar, null);
                    final EditText Password = (EditText) mview1.findViewById(R.id.etpassword);
                    final EditText ConfirmPassword = (EditText) mview1.findViewById(R.id.etconfirmpassword);
                    Button submit1 = (Button) mview1.findViewById(R.id.btnsubmit1);

                    View mview2 = getLayoutInflater().inflate(R.layout.dialog_number, null);
                    final EditText otp = (EditText) mview2.findViewById(R.id.etotp);
                    Button submit2 = (Button) mview2.findViewById(R.id.btnsubmit2);
                    AlertDialog dialog = mbuilder.create();

                    if (AadharCard.getText().length() == 12) {
                        mbuilder.setView(mview1);
                        dialog.show();

                    } else if (PhoneNumber.getText().length() == 10) {
                        mbuilder.setView(mview2);
                        dialog.show();


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
