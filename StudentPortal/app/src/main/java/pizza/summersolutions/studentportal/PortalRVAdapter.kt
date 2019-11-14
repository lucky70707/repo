package pizza.summersolutions.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_item.view.*

class PortalRVAdapter(private val portalDataset:List<PortalItem>):RecyclerView.Adapter<PortalRVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.portal_item,parent,false))
    }

    override fun getItemCount(): Int {
       return portalDataset.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(portalDataset[position])

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(portalItem: PortalItem){
            itemView.tvPortal.text=portalItem.uri
            itemView.tvTitle.text=portalItem.title
        }
    }


}