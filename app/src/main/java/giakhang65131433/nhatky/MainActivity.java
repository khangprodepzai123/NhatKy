package giakhang65131433.nhatky;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Pages> lstpage;
    PageRVadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Pages");


        lstpage = new ArrayList<>();
        DatabaseReference.addValueEventListener(listendb);
        RecyclerView recyclerView = findViewById(R.id.rcvPage);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        );
        adapter = new PageRVadapter(lstpage);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        myRef.setValue("Hello, NguyenQuocGiaKhang!");
    }
    ValueEventListener listendb= myRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            for (DataSnapshot obj : snapshot.getChildren()) {
                Pages page = obj.getValue(Pages.class);
                if (page != null) {
                    lstpage.add(page);
                    //Log.w("Nhat Ky app", "Tên page: " + page.getTittle());
                }
            }
            adapter.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
}
