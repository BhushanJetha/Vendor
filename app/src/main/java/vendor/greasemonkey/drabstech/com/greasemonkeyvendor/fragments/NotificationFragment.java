package vendor.greasemonkey.drabstech.com.greasemonkeyvendor.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.R;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.notification.NotificationAdapter;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.notification.NotificationModel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestDetailActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestListAdapter;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.request_detail.RequestModel;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.servicing_request.RequestStatusActivity;
import vendor.greasemonkey.drabstech.com.greasemonkeyvendor.utility.recyclerview_click_handler.RecyclerTouchListener;


public class NotificationFragment extends Fragment {

    ArrayList<NotificationModel> notifications;
    private RecyclerView mRecyclerView;
    private NotificationAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        notifications=new ArrayList<>();
        requestList();
        mRecyclerView = (RecyclerView) view.findViewById(R.id.rvNotification);

        if(notifications.size()>0){

            mRecyclerView.setVisibility(View.VISIBLE);
            mAdapter = new NotificationAdapter(notifications);
            mRecyclerView.setAdapter(mAdapter);
            LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
            mRecyclerView.setLayoutManager(llm);
        }

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this.getContext(), mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                //NotificationModel requests= notifications.get(position);
                Intent i=new Intent(getContext(),RequestDetailActivity.class);
                startActivity(i);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        return view;
    }

    private void requestList(){
        notifications.add(new NotificationModel("Bhushan Jetha","One Time Service","GOLD","12 SEP" ));
        notifications.add(new NotificationModel("Chetan Pawar","Emergency Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Vishal Jadhav","One Time Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Abhi Shewale", "One Time Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Pavan Vishe","Emergency Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Bhushan Jetha","One Time Service","GOLD","12 SEP" ));
        notifications.add(new NotificationModel("Chetan Pawar","Emergency Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Vishal Jadhav","One Time Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Abhi Shewale", "One Time Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Pavan Vishe","Emergency Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Bhushan Jetha","One Time Service","GOLD","12 SEP" ));
        notifications.add(new NotificationModel("Chetan Pawar","Emergency Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Vishal Jadhav","One Time Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Abhi Shewale", "One Time Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Pavan Vishe","Emergency Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Bhushan Jetha","One Time Service","GOLD","12 SEP" ));
        notifications.add(new NotificationModel("Chetan Pawar","Emergency Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Vishal Jadhav","One Time Service", "GOLD","12 SEP"));
        notifications.add(new NotificationModel("Abhi Shewale", "One Time Service","GOLD", "12 SEP"));
        notifications.add(new NotificationModel("Pavan Vishe","Emergency Service","GOLD", "12 SEP"));
    }

}
