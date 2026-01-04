package giakhang65131433.nhatky;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PageRVadapter extends RecyclerView.Adapter {
    List<Pages> dataSource;

    public PageRVadapter(List<Pages> dataSource) {
        this.dataSource = dataSource;
    }

    public class PageItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDate;
        Button btnViet;
        public int postion;

        public PageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle= itemView.findViewById(R.id.tieude);
            tvDate = itemView.findViewById(R.id.ngaygio);
            btnViet = itemView.findViewById(R.id.btnViet);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.page_item,parent,false);
        PageItemViewHolder viewHolder= new PageItemViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        PageItemViewHolder viewHolder =(PageItemViewHolder) holder;
        viewHolder.postion = position;
        Pages page =dataSource.get(position);
        viewHolder.tvTitle.setText(page.getTittle());
        viewHolder.tvDate.setText(page.getDate());

        viewHolder.btnViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), EditPageActivity.class);
                intent.putExtra("pageKey", page.getKey());
                intent.putExtra("pageTitle", page.getTittle());
                intent.putExtra("pageContent", page.getContent() != null ? page.getContent() : "");
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
