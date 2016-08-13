package uk.prudentialwarnew.CustomerListMain.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import uk.prudentialwarnew.CustomerListMain.adapter.models.CustomerListModel;
import uk.prudentialwarnew.CustomerListMain.adapter.viewholder.CustomerListViewHolder;
import uk.prudentialwarnew.R;

/**
 * Created by user on 8/11/2016.
 */
public class AdapterCustomerList extends RecyclerView.Adapter<CustomerListViewHolder> {

    private final LayoutInflater mInflater;
    private final List<CustomerListModel> mModels;
    Context mContext;

    public AdapterCustomerList(Context context, List<CustomerListModel> models) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mModels = new ArrayList<>(models);
    }

    @Override
    public CustomerListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = mInflater.inflate(R.layout.adapter_customerlistmain, parent, false);

        return new CustomerListViewHolder(itemView,mContext);
    }

    @Override
    public void onBindViewHolder(CustomerListViewHolder holder, int position) {
        final CustomerListModel model = mModels.get(position);
        holder.bind(model);
    }

    @Override
    public int getItemCount() {
        return mModels.size();
    }

    public void animateTo(List<CustomerListModel> models) {
        applyAndAnimateRemovals(models);
        applyAndAnimateAdditions(models);
        applyAndAnimateMovedItems(models);
    }

    private void applyAndAnimateRemovals(List<CustomerListModel> newModels) {
        for (int i = mModels.size() - 1; i >= 0; i--) {
            final CustomerListModel model = mModels.get(i);
            if (!newModels.contains(model)) {
                removeItem(i);
            }
        }
    }

    private void applyAndAnimateAdditions(List<CustomerListModel> newModels) {
        for (int i = 0, count = newModels.size(); i < count; i++) {
            final CustomerListModel model = newModels.get(i);
            if (!mModels.contains(model)) {
                addItem(i, model);
            }
        }
    }

    private void applyAndAnimateMovedItems(List<CustomerListModel> newModels) {
        for (int toPosition = newModels.size() - 1; toPosition >= 0; toPosition--) {
            final CustomerListModel model = newModels.get(toPosition);
            final int fromPosition = mModels.indexOf(model);
            if (fromPosition >= 0 && fromPosition != toPosition) {
                moveItem(fromPosition, toPosition);
            }
        }
    }

    public CustomerListModel removeItem(int position) {
        final CustomerListModel model = mModels.remove(position);
        notifyItemRemoved(position);
        return model;
    }

    public void addItem(int position, CustomerListModel model) {
        mModels.add(position, model);
        notifyItemInserted(position);
    }

    public void moveItem(int fromPosition, int toPosition) {
        final CustomerListModel model = mModels.remove(fromPosition);
        mModels.add(toPosition, model);
        notifyItemMoved(fromPosition, toPosition);
    }
}
