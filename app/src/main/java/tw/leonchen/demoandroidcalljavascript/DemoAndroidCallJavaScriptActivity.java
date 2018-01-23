package tw.leonchen.demoandroidcalljavascript;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class DemoAndroidCallJavaScriptActivity extends AppCompatActivity {

    private WebView webview;
    private boolean webPageReady = false;
    private EditText name;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_android_call_java_script);

        name = (EditText)findViewById(R.id.name);
        submit = (Button)findViewById(R.id.submit);

        webview = (WebView)findViewById(R.id.webview);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        webview.loadUrl("file:///android_asset/AndroidCallJavaScript.html");

        webview.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                webPageReady = true;
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(webPageReady){
                    String userName = name.getText().toString();
                    String markUrl = "javascript:showHtmlMessage('" + userName + "')";
                    webview.loadUrl(markUrl);
                }
            }
        });
    }
}
