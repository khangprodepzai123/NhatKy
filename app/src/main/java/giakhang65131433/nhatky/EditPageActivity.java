package giakhang65131433.nhatky;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditPageActivity extends AppCompatActivity {

    private TextView tvTitle;
    private EditText edtContent;
    private Button btnLuu;
    private String pageKey;
    private String pageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_page);

        tvTitle = findViewById(R.id.tvTitle);
        edtContent = findViewById(R.id.edtContent);
        btnLuu = findViewById(R.id.btnLuu);

        pageKey = getIntent().getStringExtra("pageKey");
        pageTitle = getIntent().getStringExtra("pageTitle");
        String pageContent = getIntent().getStringExtra("pageContent");

        tvTitle.setText(pageTitle);
        edtContent.setText(pageContent);

        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContent = edtContent.getText().toString();
                if (pageKey != null) {
                    DatabaseReference database = FirebaseDatabase.getInstance().getReference("Pages").child(pageKey);
                    database.child("content").setValue(newContent);
                    Toast.makeText(EditPageActivity.this, "Đã lưu", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}