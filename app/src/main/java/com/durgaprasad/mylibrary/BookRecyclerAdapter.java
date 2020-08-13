package com.durgaprasad.mylibrary;

import android.content.Context;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class BookRecyclerAdapter extends RecyclerView.Adapter<BookRecyclerAdapter.viewHolder>{
    private ArrayList<Books> books= new ArrayList<>();
    private Context mContext;

    public BookRecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_book,parent,false);
        return new viewHolder(view);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final viewHolder holder, final int position) {
       holder.txtName.setText(books.get(position).getName());
        Glide.with(mContext)
                .asBitmap()
                .load(books.get(position).getUrl())
                .into(holder.imgBook);
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, books.get(position).getName() + " selected", Toast.LENGTH_SHORT).show();
            }
        });
        holder.authorName.setText(books.get(position).getAuthor());
        holder.shortDesc.setText(books.get(position).getShortDesc());
        holder.downArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(holder.parent);
                holder.expandCard.setVisibility(View.VISIBLE);
                holder.downArrow.setVisibility(View.GONE);
            }
        });
        holder.upArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.beginDelayedTransition(holder.parent);
                holder.expandCard.setVisibility(View.GONE);
                holder.downArrow.setVisibility(View.VISIBLE);
            }
        });
    }

    public void setBooks(ArrayList<Books> books) {
        this.books = books;
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView imgBook,downArrow,upArrow;
        private TextView txtName;
        private TextView authorName,shortDesc;
        private RelativeLayout collapseCard,expandCard;
        private boolean isExpanded = false;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgBook = itemView.findViewById(R.id.bookImageView);
            txtName = itemView.findViewById(R.id.txtBookName);
            authorName = itemView.findViewById(R.id.txtAuthorName);
            shortDesc = itemView.findViewById(R.id.shortDescMatter);
            downArrow = itemView.findViewById(R.id.downArrow);
            upArrow = itemView.findViewById(R.id.upArrow);
            collapseCard = itemView.findViewById(R.id.collapseCardView);
            expandCard = itemView.findViewById(R.id.expandCard);
        }
    }
}
