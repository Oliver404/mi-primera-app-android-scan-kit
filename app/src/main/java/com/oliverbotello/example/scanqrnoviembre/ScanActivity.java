package com.oliverbotello.example.scanqrnoviembre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.huawei.hms.hmsscankit.ScanUtil;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;

public class ScanActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnScan;
    private TextView txtContent;
    // Scan
    HmsScanAnalyzerOptions options = new HmsScanAnalyzerOptions.Creator()
            .setHmsScanTypes(HmsScan.QRCODE_SCAN_TYPE)
            .create();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        initView();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK || data == null) {
            return;
        }

        if (requestCode == 200) {
            // Input an image for scanning and return the result.
            HmsScan obj = data.getParcelableExtra(ScanUtil.RESULT);

            if (obj != null) {
                setTextContent(obj.getShowResult());
            }
        }
    }

    private void initView() {
        btnScan = findViewById(R.id.btn_scan);
        txtContent = findViewById(R.id.txtvw_content);

        btnScan.setOnClickListener(this);
    }

    private void setTextContent(String content) {
        txtContent.setText(content);
    }

    @Override
    public void onClick(View v) {
        // Validar si tengo los permisos
        // si si
            ScanUtil.startScan(this, 200, options);
        // si no
            // Solicitar permisos --- tarea
    }
}