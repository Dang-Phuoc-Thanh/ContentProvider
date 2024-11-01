package com.example.provider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.provider.Adapter.AdapterTinNhan;
import com.example.provider.Model.TinNhan;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DocTinNhan extends AppCompatActivity {
    private ListView lvDocTinNhan;
    private ArrayList<TinNhan> dsTinNhan;
    private AdapterTinNhan adapterTinNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_doc_tin_nhan);
        addControl();
        docToanBoTinNhan();
    }

    private void docToanBoTinNhan() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        dsTinNhan.clear();
        if (cursor != null) {
            while (cursor.moveToNext()) {
                int indexphoneNumber = cursor.getColumnIndex("address");
                int indexTimeStamp = cursor.getColumnIndex("date");
                int indexBody = cursor.getColumnIndex("body");
                String phonenumber = cursor.getString(indexphoneNumber);
                String timeStamp = cursor.getString(indexTimeStamp);
                String indexbody = cursor.getString(indexBody);
                dsTinNhan.add(new TinNhan(phonenumber, sdf.format(Long.parseLong(timeStamp)), indexbody));
                adapterTinNhan.notifyDataSetChanged();
            }
            cursor.close();
        }
    }

    private void addControl() {
        lvDocTinNhan = findViewById(R.id.lvdoctinnhan);
        dsTinNhan = new ArrayList<>();
        adapterTinNhan = new AdapterTinNhan(this, R.layout.item_tinnhan, dsTinNhan);
        lvDocTinNhan.setAdapter(adapterTinNhan);
    }
}
