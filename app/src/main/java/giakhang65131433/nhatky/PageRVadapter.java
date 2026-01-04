package giakhang65131433.nhatky;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PageRVadapter extends RecyclerView.Adapter {
    List<Pages> dataSource;

    public PageRVadapter(List<Pages> dataSource) {
        this.dataSource = dataSource;
    }

    public class PageItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvTitle;
        TextView tvDate;
        public int postion;

        public PageItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvTitle= itemView.findViewById(R.id.tieude);
            tvDate = itemView.findViewById(R.id.ngaygio);
        }

        @Override
        public void onClick(View v) {
            int vtCLicked = getAdapterPosition();
            Pages pageClicked=dataSource.get(vtCLicked);
            Toast.makeText(v.getContext(),"Ban vua chon" + pageClicked.getTittle(), Toast.LENGTH_SHORT).show();

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
        ((PageItemViewHolder) holder).tvTitle.setText(page.getTittle());
        ((PageItemViewHolder) holder).tvDate.setText(page.getDate());



    }

    @Override
    public int getItemCount() {
        return dataSource.size();
    }
}
