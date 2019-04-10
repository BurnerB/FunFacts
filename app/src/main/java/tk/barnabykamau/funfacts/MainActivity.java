package tk.barnabykamau.funfacts;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // Declare view variables
    private static final String TAG = MainActivity.class.getSimpleName();
    private  ColorWheel colorWheel = new ColorWheel();
    private FactBook factBook = new FactBook();
    private TextView factTextView;
    private Button ShowFactsbutton;
    private RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assign the values form the layout file to the corresponding variables
        factTextView = findViewById(R.id.FactstextView);
        ShowFactsbutton = findViewById(R.id.ShowFactsbutton);
        relativeLayout = findViewById(R.id.relativeLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String fact = factBook.getFact();
                factTextView.setText(fact);
                int color = colorWheel.getColor();
                relativeLayout.setBackgroundColor(color);

                ShowFactsbutton.setTextColor(color);

            }
        };
        ShowFactsbutton.setOnClickListener(listener);
        //Toast.makeText(this, "Yaay our Activity was created", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "were logging from the oncreate()method");
    }
}
