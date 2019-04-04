package textspeech.thezaxis.emandi;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class SplashActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory {

    String id;
    HTextView hTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        hTextView = findViewById(R.id.htextView);
        hTextView.setAnimateType(HTextViewType.LINE);
        hTextView.animateText("कृषि उपज");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                id = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).getString("id", "error");
                //Toast.makeText(SplashActivity.this, ""+id, Toast.LENGTH_SHORT).show();
                if (!id.equals("error")){
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                    finish();
                }
                else{
                    startActivity(new Intent(SplashActivity.this, Login.class));
                    finish();
                }
            }
        }, 2000);
    }

    @Override
    public View makeView() {
        TextView t = new TextView(this);
        t.setGravity(Gravity.CENTER);
        t.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        return t;
    }
}
