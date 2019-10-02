package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;


/**
 * Created by Bhushan
 */
public class RequestListAdapter extends RecyclerView.Adapter<RequestListAdapter.MenuItemViewHolder> {

    List<RequestModel> menuItemModelList;
    OnItemClickListener mItemClickListener;

    public RequestListAdapter(List<RequestModel> persons) {
        this.menuItemModelList = persons;
    }

    @Override
    public MenuItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.service_request_cell, viewGroup, false);
        return new MenuItemViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MenuItemViewHolder meuItemViewHolder, int i) {

        try{
            meuItemViewHolder.tvUserName.setText(menuItemModelList.get(i).getName());
            meuItemViewHolder.tvServiceType.setText(menuItemModelList.get(i).getServiceType());
            meuItemViewHolder.tvAMCType.setText(menuItemModelList.get(i).getAmcType());
            meuItemViewHolder.tvDate.setText(menuItemModelList.get(i).getDate());
            meuItemViewHolder.tvStatus.setText(menuItemModelList.get(i).getStatus());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setItemSelected(int position, boolean isSelected) {
        if (position != -1) {
           // menuItemModelList.get(position).setSelected(isSelected);
            notifyDataSetChanged();
        }
    }

    List<RequestModel> getMenuItem(){
        return menuItemModelList;
    }

    @Override
    public int getItemCount() {
        return menuItemModelList.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public void setMenuItem(List<RequestModel> people) {
        this.menuItemModelList = people;
    }


    public interface OnItemClickListener {

        void onItemClick(View view, int position);
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {

        public TextView tvUserName,tvServiceType,tvAMCType,tvDate,tvStatus;

        public MenuItemViewHolder(View view) {
            super(view);
            tvUserName = (TextView) view.findViewById(R.id.userName);
            tvServiceType = (TextView) view.findViewById(R.id.serviceType);
            tvAMCType = (TextView) view.findViewById(R.id.amcType);
            tvDate = (TextView) view.findViewById(R.id.requestDate);
            tvStatus = (TextView) view.findViewById(R.id.requestStatus);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(v, getPosition());
            }
        }
    }
}
