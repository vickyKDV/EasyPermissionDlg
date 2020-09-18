package lesehankoding.com.easydlgpermission;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DialogPermissionAdapter extends RecyclerView.Adapter<DialogPermissionAdapter.MyHolder> {

    private ArrayList<PermissionItem> permissionItems;

    public DialogPermissionAdapter(ArrayList<PermissionItem> permissionItems) {
        this.permissionItems = permissionItems;
    }

    @NonNull
    @Override
    public DialogPermissionAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull DialogPermissionAdapter.MyHolder holder, int position) {
        holder.icon.setImageResource(permissionItems.get(position).PermissionIconRes);
        holder.name.setText(permissionItems.get(position).PermissionName);
    }

    @Override
    public int getItemCount() {
        return permissionItems.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        ImageView icon;
        TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);


            this.icon = itemView.findViewById(R.id.icon);
            this.name = itemView.findViewById(R.id.name);
        }
    }
}
