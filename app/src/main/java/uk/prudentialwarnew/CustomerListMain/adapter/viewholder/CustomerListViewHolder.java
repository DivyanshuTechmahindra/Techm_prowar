package uk.prudentialwarnew.CustomerListMain.adapter.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import uk.prudentialwarnew.CustomerListMain.adapter.models.CustomerListModel;
import uk.prudentialwarnew.R;

/**
 * Created by user on 8/11/2016.
 */
public class CustomerListViewHolder extends RecyclerView.ViewHolder {

    private final TextView tv_customerName;
    private final TextView txtGender;
    private final TextView tv_customerAge;
    private final TextView tv_plan;
    private final TextView tv_planType;
    private final TextView tv_percentage;
   


    Context mContext;

    public CustomerListViewHolder(View itemView, Context context) {
        super(itemView);
        mContext = context;
        tv_customerName = (TextView) itemView.findViewById(R.id.tv_customerName);
        txtGender = (TextView) itemView.findViewById(R.id.txtGender);
        tv_customerAge = (TextView) itemView.findViewById(R.id.tv_customerAge);
        tv_plan = (TextView) itemView.findViewById(R.id.tv_plan);
        tv_planType = (TextView) itemView.findViewById(R.id.tv_planType);
        tv_percentage = (TextView) itemView.findViewById(R.id.tv_percentage);
        
    }

    public void bind(CustomerListModel model) {
        try {
            tv_customerName.setText(model.getNameFirst()+" "+model.getNameFirst());
            txtGender.setText(model.getGender());
            tv_customerAge.setText(model.getAge()+"");
            tv_plan.setText(model.getProductstype()+"");
            tv_planType.setText(model.getProductsname());

            tv_percentage.setText("100%");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
