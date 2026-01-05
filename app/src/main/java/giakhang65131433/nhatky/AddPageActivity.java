package giakhang65131433.nhatky;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

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

                EditText editTextName = findViewById(R.id.editTextTittle);
                EditText editTextDate = findViewById(R.id.editTextDate);
                EditText editTextContent = findViewById(R.id.editTextContent);

                String title = editTextName.getText().toString();
                String date = editTextDate.getText().toString();
                String content = editTextContent.getText().toString();

                Pages page = new Pages(title, date, content);

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference databaseReference = database.getReference("Pages");

                String key = databaseReference.push().getKey();

                HashMap<String, Object> item = new HashMap<>();
                item.put(key, page.toFirebase());

                databaseReference.updateChildren(item, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error,
                                           @NonNull DatabaseReference ref) {
                        if (error == null) {
                            finish();
                        }
                    }
                });
            }
        });
    }
}
