package giakhang65131433.nhatky;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_page);

        FloatingActionButton floatingActionButton =
                findViewById(R.id.floatingActionButton2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lấy dữ liệu
                EditText editTextName = findViewById(R.id.editTextTittle);
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextContent = findViewById(R.id.editTextContent);

                String title = editTextName.getText().toString();
                String date = editTextDate.getText().toString();
                String content = editTextContent.getText().toString();

                Pages page = new Pages(title,date,content);
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Pages");
            }
        });
    }
}
