package droid.demos.com.example0;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView txvSpanneble,txv2;
    private String string,string2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txvSpanneble=(TextView)findViewById(R.id.txvSpanneble);
        txv2=(TextView)findViewById(R.id.txv2);

        /******************************************************************************************************************/
        string="Spanneble string tutorial";
        SpannableString spannableString=new SpannableString(string);
        ClickableSpan clickableSpan=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this,"Click Spanneble",Toast.LENGTH_LONG).show();
            }
        };
        spannableString.setSpan(clickableSpan,0,10,0);
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#3366BB")),0,10,0);
        txvSpanneble.setText(spannableString);
        txvSpanneble.setMovementMethod(LinkMovementMethod.getInstance());
        txvSpanneble.setHighlightColor(Color.TRANSPARENT);
        /******************************************************************************************************************/

        string2="Solo da click para descargar Broxel app";
        SpannableString spannableString1=new SpannableString(string2);
        ClickableSpan clickableSpan1=new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Toast.makeText(MainActivity.this,"Descargando app",Toast.LENGTH_LONG).show();
            }
        };
        spannableString1.setSpan(new MyClickableSpan(string2),19,39,0);
        spannableString1.setSpan(new ForegroundColorSpan(Color.parseColor("#3366BB")),19,39,0);
        txv2.setText(spannableString1);
        txv2.setMovementMethod(LinkMovementMethod.getInstance());

    }


    class MyClickableSpan extends ClickableSpan{// extend ClickableSpan

        String clicked;
        public MyClickableSpan(String string) {
            super();
            clicked = string;
        }

        public void onClick(View tv) {
            Toast.makeText(MainActivity.this,"Descargando app" , Toast.LENGTH_SHORT).show();
        }

        public void updateDrawState(TextPaint ds) {// override updateDrawState
            ds.setUnderlineText(false); // set to false to remove underline
        }
    }

}
