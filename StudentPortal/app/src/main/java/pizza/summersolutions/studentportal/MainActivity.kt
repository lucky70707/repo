package pizza.summersolutions.studentportal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
private var portalItemList = arrayListOf<PortalItem>()
    private var portalItemAdapter=PortalRVAdapter(portalItemList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
super.onActivityResult(requestCode,resultCode,data)
        if (requestCode == 100) {
            var title=  data?.getStringExtra("TITLE")
            var portal = data?.getStringExtra("PORTAL")

            var addableItem : PortalItem
            if(portal!=null&&title!=null){
                addableItem= PortalItem(title,portal)
                portalItemList.add(addableItem)
                portalItemAdapter.notifyDataSetChanged()
            }
        }
    }


    private fun initViews() {
        addPortalBtn.setOnClickListener{
            val createPortalIntent = Intent(this,
                CreatePortalActivity::class.java)
            startActivityForResult(createPortalIntent,100)
        }
        portalRV.layoutManager=GridLayoutManager(this,2)
        portalRV.adapter=portalItemAdapter

    }
}
