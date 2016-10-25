package my.github.tomas.mygithub.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import my.github.tomas.mygithub.R;
import my.github.tomas.mygithub.mvp.model.SingleRepositoryResponse;
import my.github.tomas.mygithub.utils.RepositoryClickListener;

/**
 * Created by Tomas on 24/10/2016.
 */

public class SingleRepositoryAdapter extends RecyclerView.Adapter<SingleRepositoryAdapter.Holder> {

    private final LayoutInflater mInflater;
    private List<SingleRepositoryResponse> mSingleRepoList;
    private RepositoryClickListener mListener;

    public SingleRepositoryAdapter(RepositoryClickListener mListener, LayoutInflater mInflater) {
        this.mListener = mListener;
        this.mInflater = mInflater;
        mSingleRepoList = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(mInflater.inflate(R.layout.item_single_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        SingleRepositoryResponse currRepo = mSingleRepoList.get(position);

        holder.mName.setText(currRepo.getName());
        if((currRepo.getType()).equals("dir")) {
            holder.mImage.setImageResource(R.mipmap.ic_launcher);
        } else {
            holder.mImage.setImageResource(R.mipmap.ic_launcher);
        }
    }

    @Override
    public int getItemCount() {
        return mSingleRepoList.size();
    }

    public void addSingleRepos(List<SingleRepositoryResponse> singleRepoResponse) {
        mSingleRepoList.addAll(singleRepoResponse);
        notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mName, mType;
        private ImageView mImage;

        public Holder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.textViewSingleRepoName);
            mImage = (ImageView) itemView.findViewById(R.id.imageViewSingleRepo);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mListener.onClick(getLayoutPosition(),
                    mSingleRepoList.get(getAdapterPosition()).getName(),
                    mSingleRepoList.get(getAdapterPosition()).getType(),
                    mSingleRepoList.get(getAdapterPosition()).getDownload_url());
        }
    }


}
